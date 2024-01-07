package com.narainox.quizappbackend.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionWrapper {
    private Integer id;
    String question;
    String options1;
    String options2;
    String options3;
    String options4;
}
