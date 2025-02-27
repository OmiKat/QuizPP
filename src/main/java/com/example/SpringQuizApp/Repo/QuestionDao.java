package com.example.SpringQuizApp.Repo;

import com.example.SpringQuizApp.Model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Questions, Integer> {


    List<Questions> findBycategory(String category);
}
