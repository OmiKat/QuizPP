package com.example.SpringQuizApp.Service;

import com.example.SpringQuizApp.Model.Questions;
import com.example.SpringQuizApp.Model.Quiz;
import com.example.SpringQuizApp.Repo.QuestionDao;
import com.example.SpringQuizApp.Repo.QuizDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;



    public ResponseEntity<String> getQuiz(String category, int numQ, String title) {

        List<Questions> que = questionDao.FindRandomQuestionsByCategory(category,numQ);

        Quiz quiz = new Quiz();

        quiz.setTitle(title);
        quiz.setQuestionsList(que);

        quizDao.save(quiz);

        return new ResponseEntity<>("QUIZ CREATED", HttpStatus.CREATED);




    }
}
