package com.narainox.quizappbackend.repository;

import com.narainox.quizappbackend.models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz,Integer> {
}
