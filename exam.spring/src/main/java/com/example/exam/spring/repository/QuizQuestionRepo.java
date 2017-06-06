package com.example.exam.spring.repository;

import com.example.exam.spring.model.QuizQuestion;
import org.springframework.data.repository.CrudRepository;

public interface QuizQuestionRepo extends CrudRepository<QuizQuestion, Long> {
}
