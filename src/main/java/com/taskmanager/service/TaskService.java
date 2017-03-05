package com.taskmanager.service;

import java.util.List;

import com.taskmanager.entities.Task;
import com.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

  @Autowired
  private TaskRepository taskRepository;

  public List<Task> getTasks() {
    return taskRepository.findAll();
  }

  public List<Task> getTasksByAccountId(Long accountId) {
    return taskRepository.findAllTasksByAccountId(accountId);
  }

}
