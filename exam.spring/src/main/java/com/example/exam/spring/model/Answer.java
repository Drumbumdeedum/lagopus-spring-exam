package com.example.exam.spring.model;

public class Answer {
  private long id;
  private String answer;

  public Answer() {
  }

  public Answer(long id, String answer) {
    this.id = id;
    this.answer = answer;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }
}
