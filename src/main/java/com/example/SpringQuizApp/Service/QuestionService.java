package com.example.SpringQuizApp.Service;

import com.example.SpringQuizApp.Model.Questions;
import com.example.SpringQuizApp.Repo.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao repo;

    public List<Questions> getallquestions() {
        return repo.findAll();
    }
}
