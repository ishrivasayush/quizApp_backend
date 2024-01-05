package com.narainox.quizappbackend.controllers;

import com.narainox.quizappbackend.models.Question;
import com.narainox.quizappbackend.payloads.ApiResponse;
import com.narainox.quizappbackend.services.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private QuestionService questionService;
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getAllQuestionByCategory(@PathVariable String category)
    {
        return new ResponseEntity<>(questionService.getAllQuestionByCategory(category), HttpStatus.OK);
    }
    @GetMapping("/allQuestion")
    public ResponseEntity<List<Question>> getAllQuestion()
    {
        return new ResponseEntity<>(questionService.getAllQuestion(), HttpStatus.OK);
    }
    @GetMapping("/{questionId}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Integer questionId)
    {
        return new ResponseEntity<>(questionService.getQuestionById(questionId),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Question> createQuestion(@RequestBody Question question)
    {
        return new ResponseEntity<>(questionService.createQuestion(question),HttpStatus.CREATED);
    }

    @PostMapping("/{questionId}")
    public ResponseEntity<Question> updateQuestion(@PathVariable Integer questionId,@RequestBody Question question)
    {
        return new ResponseEntity<>(questionService.updateQuestion(questionId,question),HttpStatus.OK);
    }

    @DeleteMapping("/{questionId}")
    public ResponseEntity<ApiResponse> deleteQuestion(@PathVariable Integer questionId)
    {
        questionService.deleteQuestion(questionId);
        return new ResponseEntity<>(new ApiResponse("Question Deleted Successfully",true,HttpStatus.OK),HttpStatus.OK);
    }



}
