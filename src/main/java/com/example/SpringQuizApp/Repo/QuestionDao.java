package com.example.SpringQuizApp.Repo;

import com.example.SpringQuizApp.Model.Questions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Questions, Integer> {


    List<Questions> findBycategory(String category);


    @Query(value = "SELECT * FROM  questions q Where q.category=:category ORDER BY RANDOM() LIMIT :numQ",nativeQuery = true)
    List<Questions> FindRandomQuestionsByCategory(String category, int numQ);
}
