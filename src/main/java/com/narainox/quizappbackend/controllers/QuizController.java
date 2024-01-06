package com.narainox.quizappbackend.controllers;

import com.narainox.quizappbackend.services.QuizService;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
