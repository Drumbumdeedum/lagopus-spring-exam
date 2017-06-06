package com.example.exam.spring.model;

import java.io.Serializable;

public class RandomQuestion implements Serializable {
  private long id;
  private String question;

  public RandomQuestion() {
  }

  public RandomQuestion(long id, String question) {
    this.id = id;
    this.question = question;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }
}
