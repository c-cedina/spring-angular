package com.example.construire.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.construire.entites.Client;
import com.example.construire.repository.ClientRepository;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void creer(Client client) {
        Client clientDansLaBDD = this.clientRepository.findByEmail(client.getEmail());
        if (clientDansLaBDD == null) {
            this.clientRepository.save(client);
        }

    }

    public List<Client> rechercher() {

        return this.clientRepository.findAll();
    }

    public Client lire(int id) {
        Optional<Client> optionalClient = this.clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            return optionalClient.get();
        }
        return null;
    }

    public Client lireOuCreer(Client clientAcreer) {
        Client clientDansLaBDD = this.clientRepository.findByEmail(clientAcreer.getEmail());
        if (clientDansLaBDD == null) {
            clientDansLaBDD = this.clientRepository.save(clientAcreer);

        }
        return clientDansLaBDD;
    }

    public void modifier(int id, Client client) {
        Client clientDanslaBdd = this.lire(id);
        if (clientDanslaBdd.getId() == client.getId()) {
            clientDanslaBdd.setEmail(client.getEmail());
            clientDanslaBdd.setTelephone(client.getTelephone());
            this.clientRepository.save(clientDanslaBdd);
        }

    }

    public void supprimer(int id) {
        this.clientRepository.deleteById(id);
    }

}
