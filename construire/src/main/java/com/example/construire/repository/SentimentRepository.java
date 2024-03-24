package com.example.construire.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.construire.entites.Sentiment;
import com.example.construire.enums.TypeSentiment;
import java.util.List;

public interface SentimentRepository extends JpaRepository<Sentiment, Integer> {

    List<Sentiment> findByType(TypeSentiment type);

    Sentiment findById(int id);
}
