package com.example.exam.spring.model;

import java.util.ArrayList;

public class AnswerList {
  long id;
  ArrayList<Answer> answers;

  public AnswerList() {
  }

  public AnswerList(long id, ArrayList<Answer> answers) {
    this.id = id;
    this.answers = answers;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public ArrayList<Answer> getAnswers() {
    return answers;
  }

  public void setAnswers(ArrayList<Answer> answers) {
    this.answers = answers;
  }
}
