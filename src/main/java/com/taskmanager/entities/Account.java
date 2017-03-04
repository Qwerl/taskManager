package com.taskmanager.entities;

import java.util.List;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "account")
@Data
@NoArgsConstructor
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "account_id")
  private Long id;

  @OneToOne
  @JoinColumn(name = "image_id", foreignKey = @ForeignKey(name = "fk_account1"))
  private Image image;

  private String username;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
      name = "account_task",
      joinColumns = @JoinColumn(name = "account_id"),
      inverseJoinColumns = @JoinColumn(name = "task_id"),
      foreignKey = @ForeignKey(name = "fk_account_task1"),
      inverseForeignKey = @ForeignKey(name = "fk_account_task2")
  )
  private List<Task> tasks;

  @OneToMany(mappedBy = "owner")
  private List<TaskContainer> taskContainers;

}