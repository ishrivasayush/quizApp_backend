package com.narainox.quizappbackend.services.impl;

import com.narainox.quizappbackend.models.Question;
import com.narainox.quizappbackend.models.QuestionWrapper;
import com.narainox.quizappbackend.models.Quiz;
import com.narainox.quizappbackend.models.Response;
import com.narainox.quizappbackend.repository.QuestionRepo;
import com.narainox.quizappbackend.repository.QuizRepository;
import com.narainox.quizappbackend.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public List<QuestionWrapper> getQuizQuestion(Integer quizId) {
        Optional<Quiz> quiz = quizRepository.findById(quizId);
        List<Question> questions = quiz.get().getQuestions();
        List<QuestionWrapper> questionWrappers=new ArrayList<>();
        for (Question q:questions)
        {
            QuestionWrapper questionWrapper=new QuestionWrapper(q.getId(),q.getQuestion(),q.getOptions1(),q.getOptions2(),q.getOptions3(),q.getOptions4());
            questionWrappers.add(questionWrapper);
        }
        return questionWrappers;
    }

    @Override
    public Integer resultCount(Integer quizId, List<Response> submitResponse) {
        Quiz quiz = quizRepository.findById(quizId).get();
        List<Question> questions = quiz.getQuestions();
        int right = 0;
        int i = 0;
        for(Response response : submitResponse){
            if(response.getResponse().equals(questions.get(i).getRightAnswer()))
                right++;

            i++;
        }
        return right;
    }
}
