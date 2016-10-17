package com.taskmanager.entities;

import java.awt.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class PriorityType {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private Color color;
  private String comment;

  public PriorityType(Color color, String comment) {
    this.color = color;
    this.comment = comment;
  }

}
