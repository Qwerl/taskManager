package com.taskmanager.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private Image image;
  private String username;

  private List<PreSet> preSets;

  public Account(Image image, String username) {
    this.image = image;
    this.username = username;
  }

  public void addTask(Task task) {
    PreSet defaultSet = preSets.get(0);
    defaultSet.add(task);
  }

}