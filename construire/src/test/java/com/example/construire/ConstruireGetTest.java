package com.example.construire;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.http.MediaType;

@SpringBootTest
@AutoConfigureMockMvc
public class ConstruireGetTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createClientTest() throws Exception {
        String clientJson = "{\"email\":\"Create email\"}";
        mockMvc.perform(post("/client")
                .contentType(MediaType.APPLICATION_JSON)
                .content(clientJson))
                .andExpect(status().isCreated()); // Supposons que votre API renvoie un statut 201 pour une création
                                                  // réussie
    }

    @Test
    public void getClientbyidTest() throws Exception {
        this.mockMvc.perform(get("/client/2"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
        // Vous pouvez ajouter plus d'assertions ici pour vérifier le contenu de la
        // réponse
    }

    @Test
    public void updateClientTest() throws Exception {
        String updatedclientJson = "{\"id\":\"5\",\"email\":\"Updated email\"}";
        mockMvc.perform(put("/client/5") // Supposant que vous mettez à jour l'entité avec l'ID 1
                .contentType(MediaType.APPLICATION_JSON)
                .content(updatedclientJson))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteClientTest() throws Exception {
        mockMvc.perform(delete("/client/1")) // Supposant que vous supprimez l'entité avec l'ID 1
                .andExpect(status().isNoContent()); // Supposons que votre API renvoie un statut 204 pour une
                                                    // suppression réussie
    }

    @Test
    public void createSentimentTest() throws Exception {
        String sentimentJson = "{\"texte\":\"un sentiment positif\",\"client\":{\"email\":\"c@c.gmail\"}}";
        mockMvc.perform(post("/sentiment")
                .contentType(MediaType.APPLICATION_JSON)
                .content(sentimentJson))
                .andExpect(status().isCreated()); // Supposons que votre API renvoie un statut 201 pour une création
                                                  // réussie
    }

    @Test
    public void getSentimentTest() throws Exception {
        this.mockMvc.perform(get("/sentiment"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
        // Vous pouvez ajouter plus d'assertions ici pour vérifier le contenu de la
        // réponse
    }

    @Test
    public void updateSentimentTest() throws Exception {
        String updatedSentimentJson = "{\"id\":\"5\",\"texte\":\"Updated Sentiment\"}";
        mockMvc.perform(put("/sentiment/5") // Supposant que vous mettez à jour l'entité avec l'ID 1
                .contentType(MediaType.APPLICATION_JSON)
                .content(updatedSentimentJson))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteSentimentTest() throws Exception {
        mockMvc.perform(delete("/sentiment/1")) // Supposant que vous supprimez l'entité avec l'ID 1
                .andExpect(status().isNoContent()); // Supposons que votre API renvoie un statut 204 pour une
                                                    // suppression réussie
    }

}
