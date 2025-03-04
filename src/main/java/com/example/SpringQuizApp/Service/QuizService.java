package com.example.SpringQuizApp.Service;

import com.example.SpringQuizApp.Model.QuestionWrapper;
import com.example.SpringQuizApp.Model.Questions;
import com.example.SpringQuizApp.Model.Quiz;
import com.example.SpringQuizApp.Model.Response;
import com.example.SpringQuizApp.Repo.QuestionDao;
import com.example.SpringQuizApp.Repo.QuizDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;



    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Questions> que = questionDao.FindRandomQuestionsByCategory(category,numQ);

        Quiz quiz = new Quiz();

        quiz.setTitle(title);
        quiz.setQuestionsList(que);

        quizDao.save(quiz);

        return new ResponseEntity<>("QUIZ CREATED", HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuiz(int id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Questions> questionsFromDB = quiz.get().getQuestionsList();
        List<QuestionWrapper> QuestionsForUsers = new ArrayList<>();
        for (Questions q : questionsFromDB){
            QuestionWrapper qw = new QuestionWrapper(q.getQuestion(),q.getOption1(),q.getOption2(),q.getOption3(), q.getOption4(),q.getSlno());
            QuestionsForUsers.add(qw);
        }

        return new ResponseEntity<>(QuestionsForUsers,HttpStatus.OK);

    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quizDao.findById(id).get();

        List<Questions> questions = quiz.getQuestionsList();
        int right = 0;
        int i = 0;
        for(Response response : responses) {
            if(response.getResponse().equals(questions.get(i).getCorrect_ans())) {
                right++;
            }
            i++;
        }
        return new ResponseEntity<>(right,HttpStatus.OK);
    }
}
