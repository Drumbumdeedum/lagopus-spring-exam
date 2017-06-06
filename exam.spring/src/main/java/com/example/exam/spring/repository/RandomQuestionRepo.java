package com.example.exam.spring.repository;

import com.example.exam.spring.model.RandomQuestion;
import com.example.exam.spring.model.RandomQuestionsList;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface RandomQuestionRepo extends CrudRepository<RandomQuestionsList, Long>{
  List<RandomQuestion> findOneByQuestionEquals(String question);
  List<RandomQuestion> findOneByAnswerEquals(String answer);
}
