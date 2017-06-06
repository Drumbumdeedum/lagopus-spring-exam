package com.example.exam.spring.repository;

import com.example.exam.spring.model.QuizQuestion;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface QuizQuestionRepo extends CrudRepository<QuizQuestion, Long> {
  List<QuizQuestion> findOneByQuestionEquals(String question);
  List<QuizQuestion> findOneByAnswerEquals(String answer);
}
