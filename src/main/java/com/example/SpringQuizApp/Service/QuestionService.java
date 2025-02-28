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

    public List<Questions> getquestionByCategory(String category) {
        return repo.findBycategory(category);
    }

    public String addQuestion(Questions question) {
        repo.saveAndFlush(question);
        return "SUCCESS";
    }

    public String deleteQue(int id) {
        repo.deleteById(id);
        return "DELETED";
    }

    public String updateQue(Questions questions) {
        repo.save(questions);
        return "UPDATED";
    }
}
