package com.nanta.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

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

  @Override
  @Transactional(readOnly = false, rollbackFor = Exception.class)
  public void save(MultipartFile file, PictureDto pictureDto) throws Exception {
    String source = fileService.uploadFile(file, "/gallery/", pictureDto.getTitle());
    String destination =
        fileService.getFilePath() + "/gallery/" + pictureDto.getTitle() + "_thumbnail";
    fileService.resizeImage(source, 255, 170, destination);
    pictureDto.setImage("/resource/gallery/" + pictureDto.getTitle() + "_thumbnail.jpg");
    pictureRepository.save(PictureConverter.toEntity(pictureDto));
  }

  @Override
  public List<PictureDto> findAll() throws Exception {
    return PictureConverter.toDtos(pictureRepository.findAll());
  }

  @Override
  @Transactional(readOnly = false, rollbackFor = Exception.class)
  public void delete(String path, String id) throws Exception {
    Picture picture = pictureRepository.findOne(id);
    fileService.deleteFile(path, picture.getTitle() + ".jpg");
    fileService.deleteFile(path, picture.getTitle() + "_thumbnail.jpg");
    pictureRepository.delete(id);
  }

  @Override
  @Transactional(readOnly = false, rollbackFor = Exception.class)
  public void toggle(String id, boolean status) throws Exception {
    Picture picture = pictureRepository.findOne(id);
    picture.setStatus(status);
    pictureRepository.save(picture);
  }

  @Override
  public List<PictureDto> findAllActive() throws Exception {
    return PictureConverter.toDtos(pictureRepository.findByStatusTrue());
  }

}
