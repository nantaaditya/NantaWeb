package com.nanta.validator;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.nanta.base.RegexType;
import com.nanta.dto.CaptchaResponse;
import com.nanta.dto.PictureDto;
import com.nanta.dto.PostDto;
import com.nanta.dto.ProjectDto;
import com.nanta.util.Precondition;
import com.nanta.util.RegexMatchers;

public class Validator {
  private static final String MUST_NOT_BE_BLANK = " is required";
  private static final String URL_NOT_VALID = "url is not valid";

  public static final String RECAPTCHA_VERIFY_URL =
      "https://www.google.com/recaptcha/api/siteverify";

  public static CaptchaResponse checkReCaptcha(String secret, String response) {
    MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
    map.add("secret", secret);
    map.add("response", response);
    RestTemplate restTemplate = new RestTemplate();
    return restTemplate.postForObject(RECAPTCHA_VERIFY_URL, map, CaptchaResponse.class);
  }

  private static String errorMessage(String field) {
    return String.format("field {} is required", field);
  }

  public static void checkId(String id) throws Exception {
    Precondition.checkArgument(StringUtils.isEmpty(id), errorMessage("id"));
  }

  public static void checkSaveProject(ProjectDto projectDto) throws Exception {
    Precondition.checkArgument(StringUtils.isEmpty(projectDto.getName()), errorMessage("name"));
    Precondition.checkArgument(StringUtils.isEmpty(projectDto.getSite()), errorMessage("site"));
    Precondition.checkArgument(!RegexMatchers.isValid(RegexType.URL, projectDto.getSite()),
        URL_NOT_VALID);
  }

  public static void checkSavePicture(PictureDto pictureDto) throws Exception {
    Precondition.checkArgument(StringUtils.isEmpty(pictureDto.getTitle()), errorMessage("title"));
  }

  public static void checkSaveBlog(PostDto postDto) throws Exception {
    Precondition.checkArgument(StringUtils.isEmpty(postDto.getTitle()),
        "title" + MUST_NOT_BE_BLANK);
    Precondition.checkArgument(StringUtils.isEmpty(postDto.getPost()), "post" + MUST_NOT_BE_BLANK);
  }

  public static boolean isAvailable(Object object) {
    return (object != null) ? true : false;
  }
}
