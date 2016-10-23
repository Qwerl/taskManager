package com.taskmanager.entities;

import java.sql.Timestamp;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "task")
@Data
@NoArgsConstructor
public class Task {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "task_id")
  private long id;

  @OneToOne
  @JoinColumn(name = "creator_account_id", foreignKey = @ForeignKey(name = "fk_task1"))
  private Account creator;
  @OneToOne
  @JoinColumn(name = "owner_account_id", foreignKey = @ForeignKey(name = "fk_task2"))
  private Account owner;

  private String name;
  private String comment;

  private Timestamp createTime;
  private Timestamp deadlineTime;
  private Timestamp finishTime;
  private Timestamp updateTime;

  private boolean isDone;

  @OneToOne
  @JoinColumn(name = "dic_priority_type_id", foreignKey = @ForeignKey(name = "fk_task3"))
  private PriorityType priorityType;

  @Enumerated(EnumType.STRING)
  private TaskType taskType;

//  private List<Observable> listeners;

  public Task(Account creator, PriorityType priorityType, Timestamp deadlineTime) {
    this.creator = creator;
    this.priorityType = priorityType;
    this.deadlineTime = deadlineTime;
    createTime = new Timestamp(System.nanoTime());
  }

  public Task(Account creator, Account owner, PriorityType priorityType, Timestamp deadlineTime) {
    this(creator, priorityType, deadlineTime);
    this.owner = owner;
    owner.addTask(this);
  }

}