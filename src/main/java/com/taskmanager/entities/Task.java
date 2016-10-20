package com.taskmanager.entities;

import java.sql.Date;
import java.util.List;
import java.util.Observable;
import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name = "task")
public class Task {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "task_id")
  private long id;

  @OneToOne
  private Account creator;
  @OneToOne
  private Account owner;

  private String name;
  private String comment;

  private Date createTime;
  private Date deadlineTime;
  private Date finishTime;
  private Date updateTime;

  private boolean isDone;

  @OneToOne
  private PriorityType priorityType;

  @Enumerated(EnumType.STRING)
  private TaskType taskType;

//  private List<Observable> listeners;

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