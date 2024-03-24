package com.example.construire.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.example.construire.entites.Client;
import com.example.construire.service.ClientService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "client")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = "application/json")
    public void creer(@RequestBody Client client) {
        this.clientService.creer(client);
    }

    @GetMapping(produces = "application/json")
    public List<Client> rechercher() {
        return this.clientService.rechercher();
    }

    @GetMapping(path = "{id}", produces = "application/json")
    public Client lire(@PathVariable int id) {
        return this.clientService.lire(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(path = "{id}", consumes = "application/json")
    public void modifier(@PathVariable int id, @RequestBody Client client) {
        this.clientService.modifier(id, client);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "{id}")
    public void supprimer(@PathVariable int id) {
        this.clientService.supprimer(id);
    }

}
