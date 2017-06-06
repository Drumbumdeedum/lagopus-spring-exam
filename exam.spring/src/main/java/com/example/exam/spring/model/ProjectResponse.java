package com.example.exam.spring.model;

import java.util.ArrayList;

public class ProjectResponse {
  ArrayList<Project> projectList;

  public ProjectResponse() {
  }

  public ProjectResponse(ArrayList<Project> projectList) {
    this.projectList = projectList;
  }

  public ArrayList<Project> getProjectList() {
    return projectList;
  }

  public void setProjectList(ArrayList<Project> projectList) {
    this.projectList = projectList;
  }
}
