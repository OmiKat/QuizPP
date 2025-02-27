package com.example.SpringQuizApp.Controller;

import com.example.SpringQuizApp.Model.Questions;
import com.example.SpringQuizApp.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("category/{category}")
    public List<Questions> getQuestionByCategory(@PathVariable String category){
        return service.getquestionByCategory(category);
    }

    @PostMapping("add")
    public String addQuestion(@RequestBody Questions question){
        return service.addQuestion(question);

    }


}
