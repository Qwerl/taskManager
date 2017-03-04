package com.taskmanager.web;

import java.util.List;

import com.taskmanager.entities.Task;
import com.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/task")
public class TaskController {

  @Autowired
  private TaskService taskService;

  @PostMapping
  public List<Task> list() {
    return taskService.getTasks();
  }

}
