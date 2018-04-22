package com.nanta.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.nanta.converter.ProjectConverter;
import com.nanta.dto.ProjectDto;
import com.nanta.entity.Project;
import com.nanta.repository.ProjectRepository;
import com.nanta.service.FileService;
import com.nanta.service.ProjectService;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional(readOnly = true)
@Slf4j
public class ProjectServiceImplementation implements ProjectService {
  @Autowired
  private ProjectRepository projectRepository;
  @Autowired
  private FileService fileService;

  private static final String WEB_PATH = "/web/";
  private static final String WEB_FILE_PATH = "/resource/web/";
  private static final String FILE_NAME_POSTFIX = "_thumbnail";
  private static final String JPG_POSTFIX = FILE_NAME_POSTFIX.concat(".jpg");

  private String generateImageFilePath(String imageName) {
    return this.fileService.getFilePath().concat(WEB_PATH).concat(imageName.replace(" ", "-"))
        .concat(FILE_NAME_POSTFIX);
  }

  private String generateImageUri(String imageName) {
    return WEB_FILE_PATH.concat(imageName.replace(" ", "-")).concat(JPG_POSTFIX);
  }

  @Override
  @Transactional(readOnly = false, rollbackFor = Exception.class)
  @Cacheable(value = "project")
  public void save(MultipartFile file, ProjectDto projectDto) throws Exception {
    String source = this.fileService.uploadFile(file, WEB_PATH, projectDto.getName());
    String destination = generateImageFilePath(projectDto.getName());
    log.info(destination);
    this.fileService.resizeImage(source, 401, 250, destination);
    projectDto.setImage(generateImageUri(projectDto.getName()));
    this.projectRepository.save(ProjectConverter.toEntity(projectDto));
  }

  @Override
  @Cacheable(value = "project")
  public List<ProjectDto> findAll() throws Exception {
    return ProjectConverter.toDtos(this.projectRepository.findAll());
  }

  @Override
  @Transactional(readOnly = false, rollbackFor = Exception.class)
  @CacheEvict(value = "project", allEntries = true)
  public void delete(String path, String id) throws Exception {
    Project project = this.projectRepository.findOne(id);
    this.fileService.deleteFile(path, project.getName().concat(".jpg"));
    this.fileService.deleteFile(path, project.getName().concat(JPG_POSTFIX));
    this.projectRepository.delete(id);
  }

}
