package com.narainox.quizappbackend.services.impl;

import com.narainox.quizappbackend.models.Question;
import com.narainox.quizappbackend.models.Quiz;
import com.narainox.quizappbackend.repository.QuestionRepository;
import com.narainox.quizappbackend.repository.QuizRepository;
import com.narainox.quizappbackend.services.QuizService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    private QuestionRepository questionRepository;
    private QuizRepository quizRepository;

    public QuizServiceImpl(QuestionRepository questionRepository, QuizRepository quizRepository) {
        this.questionRepository = questionRepository;
        this.quizRepository = quizRepository;
    }

    @Override
    public String create(String category, int numQues, String title) {
        List<Question> questions=questionRepository.findRandomQuestionBycategory(category,numQues);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        return null;
    }
}
