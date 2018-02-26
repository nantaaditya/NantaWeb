package com.nanta.util;

import java.util.Arrays;

import org.apache.commons.io.FilenameUtils;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Component;

@Component
public class NantaUtils {
  private static final String[] ALLOWED_FILE_TYPES = {"image/jpeg", "image/png", "image/gif"};
  private static final String[] ALLOWED_EXTENSION = {"jpg", "jpeg", "png"};
  public static final long MAX_FILE_SIZE = 5 * 1024 * 1024;

  public boolean isValidContentType(String contentType) throws Exception {
    if (!Arrays.asList(ALLOWED_FILE_TYPES).contains(contentType))
      return false;
    return true;
  }

  public boolean isValidExtension(String extension) throws Exception {
    if (!Arrays.asList(ALLOWED_EXTENSION).contains(extension))
      return false;
    return true;
  }

  public boolean belowMaxFileSize(long fileSize) throws Exception {
    if (fileSize > MAX_FILE_SIZE)
      return false;
    return true;
  }

  public String getFileExtension(String fileName) throws Exception {
    return FilenameUtils.getExtension(fileName);
  }

  public static String html2text(String html) throws Exception {
    return Jsoup.parse(html).text();
  }
}
