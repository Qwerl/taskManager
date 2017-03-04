package com.taskmanager.entities;

import java.util.Set;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
    name = "task_container",
    uniqueConstraints = @UniqueConstraint(name = "uni_account1", columnNames = {"account_id", "task_container_id"})
)
@Data
@NoArgsConstructor
public class TaskContainer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "task_container_id")
  private long id;

  @Column(nullable = false)
  private String name;

  @ManyToOne
  @JoinColumn(
      name = "account_id",
      nullable = false,
      foreignKey = @ForeignKey(name = "fk_task_container1")
  )
  private Account owner;

  @ManyToMany
  @JoinTable(
      name = "task_container_task",
      foreignKey = @ForeignKey(name = "fk_task_container_task1"),
      inverseForeignKey = @ForeignKey(name = "fk_task_container_task2")
  )
  private Set<Task> tasks;

  public void add(Task task) {
    tasks.add(task);
  }

}