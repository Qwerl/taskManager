package com.taskmanager.entities;

import java.util.Set;
import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name = "preset")
public class PreSet {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "preset_id")
  private long id;

  @OneToMany
  private Set<Task> tasks;

  public void add(Task task) {
    tasks.add(task);
  }

}