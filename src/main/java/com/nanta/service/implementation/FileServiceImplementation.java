package com.nanta.service.implementation;

import java.io.File;

import org.apache.tomcat.util.http.fileupload.FileUploadBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nanta.service.FileService;
import com.nanta.util.NantaUtils;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;

@Service
@Slf4j
public class FileServiceImplementation implements FileService {
  @Value("${nanta.file.path}")
  private String filePath;
  @Autowired
  private NantaUtils nantaUtils;

  private static String getFileExtension(File file) {
    String fileName = file.getName();
    if ((fileName.lastIndexOf(".") != -1) && (fileName.lastIndexOf(".") != 0)) {
      return fileName.substring(fileName.lastIndexOf(".") + 1);
    } else {
      return "";
    }
  }

  @Override
  public String getFilePath() {
    return this.filePath;
  }

  @Override
  public String uploadFile(MultipartFile file, String path, String name) throws Exception {
    String fileType = file.getContentType().toString().toLowerCase();
    this.nantaUtils.getFileExtension(file.getOriginalFilename());
    long fileSize = file.getSize();

    File directory = new File(this.filePath + path);
    log.info(directory.getPath());
    directory.mkdirs();

    if (this.nantaUtils.isValidContentType(fileType)) {
      if (this.nantaUtils.belowMaxFileSize(fileSize)) {
        String srcFolder = directory.getAbsolutePath() + "/" + name + ".jpg";
        log.info(srcFolder);
        File destFile = new File(srcFolder);
        file.transferTo(destFile);
        return destFile.getAbsolutePath();
      } else {
        throw new FileUploadBase.FileSizeLimitExceededException("File size must below 2 MB",
            fileSize, NantaUtils.MAX_FILE_SIZE);
      }
    } else {
      throw new FileUploadBase.InvalidContentTypeException("File type not valid (image only)");
    }
  }

  @Override
  public void deleteFile(String path, String fileName) throws Exception {
    File file = new File(this.filePath + path + fileName);
    file.delete();
  }

  @Override
  public void resizeImage(String sourcePath, int width, int height, String destination)
      throws Exception {
    File file = new File(sourcePath);
    String fileExtention = getFileExtension(file);

    if (this.nantaUtils.isValidExtension(fileExtention)) {
      Thumbnails.of(sourcePath).forceSize(width, height).outputFormat("jpg").toFile(destination);
    } else {
      throw new FileUploadBase.InvalidContentTypeException("File type not valid (image only)");
    }

  }

}
