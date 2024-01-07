package com.narainox.quizappbackend.controllers;

import com.narainox.quizappbackend.models.Question;
import com.narainox.quizappbackend.models.QuestionWrapper;
import com.narainox.quizappbackend.models.Response;
import com.narainox.quizappbackend.services.QuizService;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    // http://localhost:8081/quiz/create?category=java&NumQues=5&title=javaQUiz
    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestParam String category,
                                         @RequestParam int NumQues,
                                         @RequestParam String title)
    {
        return new ResponseEntity<>(quizService.create(category,NumQues,title), HttpStatus.CREATED);
    }

    @GetMapping("/get/{quizId}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer quizId)
    {
        return new ResponseEntity<>(quizService.getQuizQuestion(quizId),HttpStatus.OK);
    }

    @PostMapping("/submit/{quizId}")
    public ResponseEntity<Integer> submitResponse(@PathVariable Integer quizId,@RequestBody List<Response> submitResponse)
    {
        return new ResponseEntity<>(quizService.resultCount(quizId,submitResponse),HttpStatus.OK);
    }
}
