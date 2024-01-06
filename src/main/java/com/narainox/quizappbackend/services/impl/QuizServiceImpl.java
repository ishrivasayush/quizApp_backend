package com.narainox.quizappbackend.services.impl;

import com.narainox.quizappbackend.models.Question;
import com.narainox.quizappbackend.models.Quiz;
import com.narainox.quizappbackend.repository.QuestionRepo;
import com.narainox.quizappbackend.repository.QuizRepository;
import com.narainox.quizappbackend.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {


    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private QuestionRepo questionRepo;



    @Override
    public String create(String category, int numQues, String title) {
        List<Question> questions = questionRepo.randomQuestion(category, numQues);
        Quiz quiz=new Quiz();
        quiz.setQuestions(questions);
        quiz.setTitle(title);
        quizRepository.save(quiz);
        return "Success";
    }
}
