package com.taskmanager.web;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("request")
@RequestMapping(value = "/")
public class MainController {

  @GetMapping
  public String index() {
    return "index";
  }

}