package com.nanta.base;

public interface UiPath {
  String LOGIN = "/login";

  String ADMINISTRATOR = "/administrator";
  String DASHBOARD = ADMINISTRATOR + "/dashboard";
  String HOME_DASHBOARD = ADMINISTRATOR + "/home-dashboard";
  String BLOG_DASHBOARD = ADMINISTRATOR + "/blog-dashboard";
  String GALLERY_DASHBOARD = ADMINISTRATOR + "/gallery-dashboard";
  String CONTACT_DASHBOARD = ADMINISTRATOR + "/contact-dashboard";

  String HOME = "/home";
  String BLOG = "/blog";
  String GALLERY = "/gallery";
  String ABOUT = "/about";
}
