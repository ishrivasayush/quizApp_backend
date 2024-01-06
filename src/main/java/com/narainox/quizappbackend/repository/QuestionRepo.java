package com.narainox.quizappbackend.repository;

import com.narainox.quizappbackend.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question,Integer> {
    List<Question> findByCategory(String category);

    @Query( value = "SELECT * FROM questions q WHERE q.category=:category ORDER BY RAND() LIMIT :numQues",nativeQuery = true)
    List<Question> randomQuestion(String category, int numQues);
}
