package com.example.construire.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.construire.entites.Client;
import com.example.construire.entites.Sentiment;
import com.example.construire.enums.TypeSentiment;
import com.example.construire.service.SentimentService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "sentiment", produces = MediaType.APPLICATION_JSON_VALUE)
public class SentimentController {

    private SentimentService sentimentService;

    public SentimentController(SentimentService sentimentService) {
        this.sentimentService = sentimentService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void creer(@RequestBody Sentiment sentiment) {
        this.sentimentService.creer(sentiment);
    }

    @GetMapping
    public @ResponseBody List<Sentiment> rechercher(@RequestParam(required = false) TypeSentiment type) {
        return this.sentimentService.rechercher(type);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(path = "{id}", consumes = "application/json")
    public void modifier(@PathVariable int id, @RequestBody Sentiment sentiment) {
        this.sentimentService.modifier(id, sentiment);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "{id}")
    public void supprimer(@PathVariable int id) {
        this.sentimentService.supprimer(id);
    }

}
