package com.nanta.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.nanta.base.CacheTopics;
import com.nanta.converter.PictureConverter;
import com.nanta.dto.PictureDto;
import com.nanta.entity.Picture;
import com.nanta.repository.PictureRepository;
import com.nanta.service.FileService;
import com.nanta.service.PictureService;

@Service
@Transactional(readOnly = true)
public class PictureServiceImplementation implements PictureService {
  @Autowired
  private PictureRepository pictureRepository;
  @Autowired
  private FileService fileService;

  private static final String GALLERY_PATH = "/gallery/";
  private static final String GALLERY_FILE_PATH = "/resource/gallery/";
  private static final String FILE_NAME_POSTFIX = "_thumbnail";
  private static final String JPG_POSTFIX = FILE_NAME_POSTFIX.concat(".jpg");

  private String generateImageFilePath(String imageName) {
    return this.fileService.getFilePath().concat(GALLERY_PATH).concat(imageName.replace(" ", "-"))
        .concat(FILE_NAME_POSTFIX);
  }

  private String generateImageUri(String imageName) {
    return GALLERY_FILE_PATH.concat(imageName.replace(" ", "-")).concat(JPG_POSTFIX);
  }

  @Override
  @Transactional(readOnly = false, rollbackFor = Exception.class)
  @Cacheable(value = CacheTopics.IMAGE)
  public void save(MultipartFile file, PictureDto pictureDto) throws Exception {
    String source = this.fileService.uploadFile(file, GALLERY_PATH, pictureDto.getTitle());
    String destination = generateImageFilePath(pictureDto.getTitle());
    this.fileService.resizeImage(source, 255, 170, destination);
    pictureDto.setImage(generateImageUri(pictureDto.getTitle()));
    this.pictureRepository.save(PictureConverter.toEntity(pictureDto));
  }

  @Override
  @Cacheable(value = CacheTopics.IMAGE, condition = "#result!=null")
  public List<PictureDto> findAll() throws Exception {
    return PictureConverter.toDtos(this.pictureRepository.findAll());
  }

  @Override
  @Transactional(readOnly = false, rollbackFor = Exception.class)
  @CacheEvict(value = CacheTopics.IMAGE, allEntries = true)
  public void delete(String path, String id) throws Exception {
    Picture picture = this.pictureRepository.findOne(id);
    this.fileService.deleteFile(path, picture.getTitle().concat(".jpg"));
    this.fileService.deleteFile(path, picture.getTitle().concat(JPG_POSTFIX));
    this.pictureRepository.delete(id);
  }

  @Override
  @Transactional(readOnly = false, rollbackFor = Exception.class)
  @Cacheable(value = CacheTopics.IMAGE)
  public void toggle(String id, boolean status) throws Exception {
    Picture picture = this.pictureRepository.findOne(id);
    picture.setStatus(status);
    this.pictureRepository.save(picture);
  }

  @Override
  @Cacheable(value = CacheTopics.IMAGE, condition = "#result!=null")
  public List<PictureDto> findAllActive() throws Exception {
    return PictureConverter.toDtos(this.pictureRepository.findByStatusTrue());
  }

}
