package com.narainox.quizappbackend.repository;

import com.narainox.quizappbackend.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Integer> {

    List<Question> findByCategory(String category);
}
