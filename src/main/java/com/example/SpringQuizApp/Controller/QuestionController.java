package com.example.SpringQuizApp.Controller;

import com.example.SpringQuizApp.Model.Questions;
import com.example.SpringQuizApp.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService service;

    @GetMapping("allQuestions")
    public List<Questions> getAllQuestions(){
        return service.getallquestions();
    }


}
