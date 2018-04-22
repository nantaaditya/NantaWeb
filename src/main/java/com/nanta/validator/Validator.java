package com.nanta.validator;

import org.springframework.util.StringUtils;

import com.nanta.dto.AboutDto;
import com.nanta.dto.ContactCaptchaDto;
import com.nanta.dto.EducationDto;
import com.nanta.dto.PictureDto;
import com.nanta.dto.PostDto;
import com.nanta.dto.ProjectDto;
import com.nanta.dto.SkillDto;
import com.nanta.util.Precondition;

public class Validator {
  private static final String MUST_NOT_BE_BLANK = " must not be blank";

  public static void checkAbout(AboutDto aboutDto) throws Exception {
    Precondition.checkArgument(StringUtils.isEmpty(aboutDto.getDescription()),
        "description" + MUST_NOT_BE_BLANK);
  }

  public static void checkSaveEducation(EducationDto educationDto) throws Exception {
    Precondition.checkArgument(StringUtils.isEmpty(educationDto.getName()),
        "name" + MUST_NOT_BE_BLANK);
    Precondition.checkArgument(StringUtils.isEmpty(educationDto.getYear()),
        "year" + MUST_NOT_BE_BLANK);
  }

  public static void checkDelete(String id) throws Exception {
    Precondition.checkArgument(id.isEmpty(), "please select education to delete");
  }

  public static void checkSaveSkill(SkillDto skillDto) throws Exception {
    Precondition.checkArgument(StringUtils.isEmpty(skillDto.getName()),
        "skill" + MUST_NOT_BE_BLANK);
    Precondition.checkArgument(skillDto.getPercentage() < 0, "skill must not be negative value");
  }

  public static void checkSaveProject(ProjectDto projectDto) throws Exception {
    Precondition.checkArgument(StringUtils.isEmpty(projectDto.getName()),
        "image name" + MUST_NOT_BE_BLANK);
    Precondition.checkArgument(StringUtils.isEmpty(projectDto.getSite()),
        "site url" + MUST_NOT_BE_BLANK);
  }

  public static void checkSavePicture(PictureDto pictureDto) throws Exception {
    Precondition.checkArgument(StringUtils.isEmpty(pictureDto.getTitle()),
        "image name" + MUST_NOT_BE_BLANK);
  }

  public static void checkSaveContact(ContactCaptchaDto contactCaptchaDto) throws Exception {
    Precondition.checkArgument(StringUtils.isEmpty(contactCaptchaDto.getName()),
        "name" + MUST_NOT_BE_BLANK);
    Precondition.checkArgument(StringUtils.isEmpty(contactCaptchaDto.getEmail()),
        "email" + MUST_NOT_BE_BLANK);
    Precondition.checkArgument(StringUtils.isEmpty(contactCaptchaDto.getMessage()),
        "message" + MUST_NOT_BE_BLANK);
    Precondition.checkArgument(StringUtils.isEmpty(contactCaptchaDto.getCaptchaResponse()),
        "please verify you're human.");
  }

  public static void checkSaveBlog(PostDto postDto) throws Exception {
    Precondition.checkArgument(StringUtils.isEmpty(postDto.getTitle()),
        "title" + MUST_NOT_BE_BLANK);
    Precondition.checkArgument(StringUtils.isEmpty(postDto.getPost()), "post" + MUST_NOT_BE_BLANK);
  }

  public static boolean isAvailable(Object object) {
    if (object != null) {
      return true;
    } else {
      return false;
    }
  }
}
