package com.nanta.service.implementation;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.nanta.converter.ProjectConverter;
import com.nanta.dto.ProjectDto;
import com.nanta.entity.Project;
import com.nanta.repository.ProjectRepository;
import com.nanta.service.FileService;
import com.nanta.service.ProjectService;

@Service
@Transactional(readOnly = true)
public class ProjectServiceImplementation implements ProjectService {
  @Autowired
  private ProjectRepository projectRepository;
  @Autowired
  private FileService fileService;
  private Logger log = Logger.getLogger(this.getClass());

  @Override
  @Transactional(readOnly = false, rollbackFor = Exception.class)
  public void save(MultipartFile file, ProjectDto projectDto) throws Exception {
    String source = fileService.uploadFile(file, "/web/", projectDto.getName());
    log.info(fileService.getFilePath());
    String destination =
        fileService.getFilePath() + "/web/" + projectDto.getName() + "_thumbnail";
    log.info(destination);
    fileService.resizeImage(source, 401, 250, destination);
    projectDto.setImage("/resource/web/" + projectDto.getName() + "_thumbnail.jpg");
    projectRepository.save(ProjectConverter.toEntity(projectDto));
  }

  @Override
  public List<ProjectDto> findAll() throws Exception {
    return ProjectConverter.toDtos(projectRepository.findAll());
  }

  @Override
  @Transactional(readOnly = false, rollbackFor = Exception.class)
  public void delete(String path, String id) throws Exception {
    Project project = projectRepository.findOne(id);
    fileService.deleteFile(path, project.getName()+".jpg");
    fileService.deleteFile(path, project.getName()+"_thumbnail.jpg");
    projectRepository.delete(id);
  }

}
