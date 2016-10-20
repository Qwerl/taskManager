package com.taskmanager.entities;

import java.awt.*;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name = "dic_priority_type")
public class PriorityType {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "dic_priority_type_id")
  private long id;

  private Color color;
  private String comment;

  public PriorityType(Color color, String comment) {
    this.color = color;
    this.comment = comment;
  }

}
