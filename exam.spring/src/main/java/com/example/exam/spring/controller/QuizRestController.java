package com.example.exam.spring.controller;

import com.example.exam.spring.model.AnswerList;
import com.example.exam.spring.model.ProjectResponse;
import com.example.exam.spring.model.QuizQuestion;
import com.example.exam.spring.model.RandomQuestion;
import com.example.exam.spring.model.RandomQuestionsList;
import com.example.exam.spring.repository.QuizQuestionRepo;
import com.example.exam.spring.repository.RandomQuestionRepo;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuizRestController {

  private static final String urlString = "https://springexamserver.herokuapp.com/projects/eagles";

  @Autowired
  QuizQuestionRepo questionRepo;

  @Autowired
  RandomQuestionRepo randomQuestionsRepo;

  @PostMapping("/addquestion")
  public String addQuestion(@RequestBody QuizQuestion questionToAdd) {
    questionRepo.save(new QuizQuestion(questionToAdd.getQuestion(), questionToAdd.getAnswer()));
    return "Question added";
  }

  @GetMapping("/questions")
  public RandomQuestionsList questionsList() {

    ArrayList<RandomQuestion> questionsForList = new ArrayList<>();

    while (questionsForList.size() < 5) {

      int repoSize = (int)questionRepo.count();
      System.out.println(repoSize);
      int newId = 1;

      if (questionsForList.size() == 0) {
        QuizQuestion firstQuestion = questionRepo.findOne((long) (Math.random() * repoSize));
        questionsForList.add(new RandomQuestion(newId, firstQuestion.getQuestion()));
        newId++;
      } else {
        for (int i = 0; i < questionsForList.size(); i++) {
          QuizQuestion questionToAdd = questionRepo.findOne((long) (Math.random() * repoSize));
          if (!questionToAdd.getQuestion().equals(questionsForList.get(i).getQuestion())) {
            questionsForList.add(new RandomQuestion(newId, questionToAdd.getQuestion()));
            newId++;
          }
        }
      }
    }

    RandomQuestionsList fiveRandomQuestions = new RandomQuestionsList(questionsForList);
    randomQuestionsRepo.save(fiveRandomQuestions);

    return fiveRandomQuestions;
  }

  @PostMapping("/answers")
  public ProjectResponse answers(@RequestBody AnswerList answerList) {

    RandomQuestionsList questions = randomQuestionsRepo.findOne(answerList.getId());

    boolean answersAreCorrect = true;

    for (int i=1; i <= 5; i++) {
      String correctAnswer = questionRepo.findOneByQuestionEquals(questions.getQuestion(i)).get(0).getAnswer();
      String receivedAnswer = answerList.getAnswerByIndex(i);
      
      if (!correctAnswer.equals(receivedAnswer)) {
        answersAreCorrect = false;
      }
    }

    if (answersAreCorrect) {
      return new ProjectResponse();
    }
    return new ProjectResponse();
  }
}
