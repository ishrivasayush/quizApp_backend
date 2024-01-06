package com.narainox.quizappbackend.services.impl;

import com.narainox.quizappbackend.exception.ResourceNotFoundException;
import com.narainox.quizappbackend.models.Question;
import com.narainox.quizappbackend.repository.QuestionRepo;
import com.narainox.quizappbackend.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepo questionRepository;

    @Override
    public List<Question> getAllQuestion() {
        return questionRepository.findAll();
    }

    @Override
    public List<Question> getAllQuestionByCategory(String category) {
        return questionRepository.findByCategory(category);
    }

    @Override
    public Question createQuestion(Question question) {
        Question save = questionRepository.save(question);
        return save;
    }

    @Override
    public Question updateQuestion(Integer questionId, Question question) {
        Question ques = questionRepository.findById(questionId).orElseThrow(() -> new ResourceNotFoundException("Question", "questionId", questionId));
        ques.setQuestion(question.getQuestion());
        ques.setCategory(question.getCategory());
        ques.setOptions2(question.getOptions2());
        ques.setOptions1(question.getOptions1());
        ques.setOptions4(question.getOptions4());
        ques.setOptions3(question.getOptions3());
        ques.setDifficulty(question.getDifficulty());
        ques.setRightAnswer(question.getRightAnswer());
        Question save = questionRepository.save(question);
        return save;
    }

    @Override
    public void deleteQuestion(Integer questionId) {
        Question question = questionRepository.findById(questionId).orElseThrow(() -> new ResourceNotFoundException("Question", "questionId", questionId));
        questionRepository.delete(question);
    }

    @Override
    public Question getQuestionById(Integer questionId) {
        return questionRepository.findById(questionId).orElseThrow(() -> new ResourceNotFoundException("Question", "questionId", questionId));
    }

}
