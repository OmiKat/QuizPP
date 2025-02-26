package com.example.SpringQuizApp.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int slno;
    private String question_field;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String correct_ans;

    public Questions() {
    }

    public String getCorrect_ans() {
        return correct_ans;
    }

    public void setCorrect_ans(String correct_ans) {
        this.correct_ans = correct_ans;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion_field() {
        return question_field;
    }

    public void setQuestion_field(String question_field) {
        this.question_field = question_field;
    }

    public int getSlno() {
        return slno;
    }

    public void setSlno(int slno) {
        this.slno = slno;
    }

    public Questions(int slno , String question_field, String question, String option1, String option2, String option3, String option4 , String correct_ans) {
        this.slno = slno;
        this.question_field = question_field;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.correct_ans = correct_ans;



    }
}
