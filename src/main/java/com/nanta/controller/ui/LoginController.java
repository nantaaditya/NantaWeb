package com.nanta.controller.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nanta.base.UiPath;

@Controller
public class LoginController {
  @RequestMapping(value = UiPath.LOGIN, method = RequestMethod.GET)
  public ModelAndView loginPage() {
    return new ModelAndView("/login");
  }
}
