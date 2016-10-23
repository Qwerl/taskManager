package com.taskmanager.entities;

import java.util.Set;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
    name = "preset",
    uniqueConstraints = @UniqueConstraint(name = "uni_account1", columnNames = {"account_id", "preset_id"}))
@Data
@NoArgsConstructor
public class PreSet {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "preset_id")
  private long id;

  @Column(nullable = false)
  private String name;

  @ManyToOne
  @JoinColumn(name = "account_id", nullable = false, foreignKey = @ForeignKey(name = "fk_preset1"))
  private Account owner;

  @ManyToMany
  @JoinTable(foreignKey = @ForeignKey(name = "fk_preset_task1"),
      inverseForeignKey = @ForeignKey(name = "fk_preset_task2"))
  private Set<Task> tasks;

  public void add(Task task) {
    tasks.add(task);
  }

}