package com.narainox.quizappbackend.services;

import com.narainox.quizappbackend.models.QuestionWrapper;
import com.narainox.quizappbackend.models.Response;

import java.util.List;

public interface QuizService {


    String create(String category, int numQues, String title);

    List<QuestionWrapper> getQuizQuestion(Integer quizId);

    Integer resultCount(Integer quizId, List<Response> submitResponse);
}
