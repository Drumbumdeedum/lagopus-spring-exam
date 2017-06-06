package com.example.exam.spring.repository;

import com.example.exam.spring.model.RandomQuestionsList;
import org.springframework.data.repository.CrudRepository;

public interface RandomQuestionRepo extends CrudRepository<RandomQuestionsList, Long>{

}
