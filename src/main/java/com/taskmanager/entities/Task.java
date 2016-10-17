package com.taskmanager.entities;

import java.sql.Date;
import java.util.List;
import java.util.Observable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Task {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private Account creator;
  private Account owner;

  private String name;
  private String comment;

  private Date createTime;
  private Date deadlineTime;
  private Date finishTime;
  private Date updateTime;

  private boolean isDone;
  private PriorityType priorityType;
  private TaskType taskType;

  private List<Observable> listeners;

  public Task(Account creator, PriorityType priorityType, Date deadlineTime) {
    this.creator = creator;
    this.priorityType = priorityType;
    this.deadlineTime = deadlineTime;
    createTime = new Date(System.nanoTime());
  }

  public Task(Account creator, Account owner, PriorityType priorityType, Date deadlineTime) {
    this(creator, priorityType, deadlineTime);
    this.owner = owner;
    owner.addTask(this);
  }

}