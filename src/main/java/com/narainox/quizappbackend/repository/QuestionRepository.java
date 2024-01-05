package com.narainox.quizappbackend.repository;

import com.narainox.quizappbackend.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Integer> {

    List<Question> findByCategory(String category);

    @Query(,nativeQuery = true)
    List<Question> findRandomQuestionBycategory(String category, int numQues);
}
