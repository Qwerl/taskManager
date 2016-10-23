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
  private long id;

  @OneToOne
  @JoinColumn(name = "image_id", foreignKey = @ForeignKey(name = "fk_account1"))
  private Image image;

  private String username;

  @OneToMany(mappedBy = "owner")
  private List<PreSet> preSets;

  public void addTask(Task task) {
    PreSet defaultSet = preSets.get(0);
    defaultSet.add(task);
  }

}