package com.example.construire.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.construire.entites.Client;
import com.example.construire.entites.Sentiment;
import com.example.construire.enums.TypeSentiment;
import com.example.construire.repository.SentimentRepository;

@Service
public class SentimentService {

    private ClientService clientService;
    private SentimentRepository sentimentRepository;

    public SentimentService(ClientService clientService, SentimentRepository sentimentRepository) {
        this.clientService = clientService;
        this.sentimentRepository = sentimentRepository;
    }

    public void creer(Sentiment sentiment) {
        Client client = this.clientService.lireOuCreer(sentiment.getClient());
        sentiment.setClient(client);

        // Analyse
        if (sentiment.getTexte().contains("pas")) {
            sentiment.setType(TypeSentiment.NEGATIF);
        } else {
            sentiment.setType(TypeSentiment.POSITIF);
        }

        this.sentimentRepository.save(sentiment);

    }

    public List<Sentiment> rechercher(TypeSentiment type) {
        if (type == null) {
            return this.sentimentRepository.findAll();
        } else {
            return this.sentimentRepository.findByType(type);
        }

    }

    public void modifier(int id, Sentiment sentiment) {
        Sentiment sentimentDanslaBdd = sentimentRepository.findById(id);
        if (sentimentDanslaBdd.getId() == sentiment.getId()) {
            sentimentDanslaBdd.setTexte(sentiment.getTexte());

            this.sentimentRepository.save(sentimentDanslaBdd);
        }

    }

    public void supprimer(int id) {
        this.sentimentRepository.deleteById(id);
    }

}
