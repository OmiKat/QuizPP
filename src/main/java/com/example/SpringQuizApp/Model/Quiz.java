package com.example.SpringQuizApp.Model;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    @ManyToMany
    private List<Questions> questionsList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Questions> getQuestionsList() {
        return questionsList;
    }

    public void setQuestionsList(List<Questions> questionsList) {
        this.questionsList = questionsList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Quiz(Integer id, List<Questions> questionsList, String title) {
        this.id = id;
        this.questionsList = questionsList;
        this.title = title;
    }

    public Quiz() {
    }
}
