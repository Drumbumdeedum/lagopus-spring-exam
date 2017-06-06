package com.example.exam.spring.model;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RandomQuestionsList {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  ArrayList<RandomQuestion> questions;

  public RandomQuestionsList(ArrayList<RandomQuestion> questionList) {
    this.questions = questionList;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public ArrayList<RandomQuestion> getQuestions() {
    return questions;
  }

  public void setQuestions(
      ArrayList<RandomQuestion> questions) {
    this.questions = questions;
  }

  public int getQuestionListSize() {
    return questions.size();
  }

  public String getQuestion(int index) {
    return questions.get(index).getQuestion();
  }

  public void addQuestion(RandomQuestion randomQuestion) {
    questions.add(randomQuestion);
  }
}
