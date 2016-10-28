package com.taskmanager.web;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Scope("request")
@RequestMapping(value = "/")
public class MainController {

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index() {
    return "index";
  }

}