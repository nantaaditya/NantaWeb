package com.nanta.controller.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nanta.base.UiPath;

@Controller
public class AdministratorController {
  @RequestMapping(value = UiPath.DASHBOARD, method = RequestMethod.GET)
  public ModelAndView dashboardPage() {
    return new ModelAndView("/administrator/dashboard");
  }

  @RequestMapping(value = UiPath.HOME_DASHBOARD, method = RequestMethod.GET)
  public ModelAndView homePage() {
    return new ModelAndView("/administrator/home-dashboard");
  }

  @RequestMapping(value = UiPath.GALLERY_DASHBOARD, method = RequestMethod.GET)
  public ModelAndView galleryPage() {
    return new ModelAndView("/administrator/gallery-dashboard");
  }

  @RequestMapping(value = UiPath.CONTACT_DASHBOARD, method = RequestMethod.GET)
  public ModelAndView contactPage() {
    return new ModelAndView("/administrator/contact-dashboard");
  }

  @RequestMapping(value = UiPath.BLOG_DASHBOARD, method = RequestMethod.GET)
  public ModelAndView blogPage() {
    return new ModelAndView("/administrator/blog-dashboard");
  }
}
