package com.taskmanager.entities;

import java.awt.*;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "dic_priority_type")
@Data
@NoArgsConstructor
public class PriorityType {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "dic_priority_type_id")
  private long id;

  private Color color;
  private String comment;

}
