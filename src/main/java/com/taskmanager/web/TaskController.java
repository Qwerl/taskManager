package com.taskmanager.web;

import java.util.List;

import com.taskmanager.entities.Task;
import com.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

  @Autowired
  private TaskService taskService;

  @PostMapping(value = "/task")
  public List<Task> list() {
    return taskService.getTasks();
  }

  @PostMapping(value = "account/{accountId}/task")
  public List<Task> listByAccountId(@PathVariable Long accountId) {
    return taskService.getTasksByAccountId(accountId);
  }

}
