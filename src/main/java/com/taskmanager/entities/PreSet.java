package com.taskmanager.entities;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class PreSet {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private Set<Task> tasks;

  public void add(Task task) {
    tasks.add(task);
  }

}