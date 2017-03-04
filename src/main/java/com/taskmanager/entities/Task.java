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
  private Long id;

  private String name;
  private String comment;

  private Timestamp createTime;
  private Timestamp deadlineTime;
  private Timestamp finishTime;
  private Timestamp updateTime;

  private boolean isDone;

  @OneToOne
  @JoinColumn(name = "dic_priority_type_id", foreignKey = @ForeignKey(name = "fk_task1"))
  private PriorityType priorityType;

  @Enumerated(EnumType.STRING)
  private TaskType taskType;

  public Task(PriorityType priorityType, Timestamp deadlineTime) {
    this.priorityType = priorityType;
    this.deadlineTime = deadlineTime;
    createTime = new Timestamp(System.nanoTime());
  }

}