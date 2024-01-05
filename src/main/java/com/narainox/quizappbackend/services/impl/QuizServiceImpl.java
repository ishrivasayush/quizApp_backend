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


    private QuizRepository quizRepository;
    private QuestionRepository questionRepository;

    public QuizServiceImpl(QuizRepository quizRepository, QuestionRepository questionRepository) {
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public String create(String category, int numQues, String title) {
        List<Question> questions=questionRepository.findRandomQuestionByCategory(category,numQues);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepository.save(quiz);
        return "Success";
    }
}
