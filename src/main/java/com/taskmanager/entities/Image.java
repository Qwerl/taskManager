package com.taskmanager.entities;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name = "image") //todo: dic_image maybe?
public class Image {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "image_id")
  private long id;

  private String name;
  private byte[] file;

  public Image(String name, byte[] file) {
    this.name = name;
    this.file = file;
  }

}