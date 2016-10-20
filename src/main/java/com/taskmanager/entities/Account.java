package com.taskmanager.entities;

import java.util.List;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "account")
@NoArgsConstructor
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "account_id")
  private long id;

  @OneToOne
  private Image image;

  @Column(name = "username")
  private String username;

  @OneToMany
  private List<PreSet> preSets;

  public void addTask(Task task) {
    PreSet defaultSet = preSets.get(0);
    defaultSet.add(task);
  }

}