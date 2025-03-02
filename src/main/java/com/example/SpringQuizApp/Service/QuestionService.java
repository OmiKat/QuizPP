package com.example.SpringQuizApp.Service;

import com.example.SpringQuizApp.Model.Questions;
import com.example.SpringQuizApp.Repo.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao repo;

    public ResponseEntity<List<Questions>> getallquestions() {
        try {
            return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
        }
        catch (Exception e){
            e.getStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public List<Questions> getquestionByCategory(String category) {
        return repo.findBycategory(category);
    }

    public ResponseEntity<String> addQuestion(Questions question) {
        try{
            repo.saveAndFlush(question);
            return new ResponseEntity<>("SUCCESS",HttpStatus.CREATED);
        }
        catch (Exception e){
            e.getStackTrace();
        }
        return new ResponseEntity<>("BAD REQUEST" , HttpStatus.BAD_REQUEST);
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
