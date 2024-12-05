# Gestion des Sentiments et des Clients - Angular -  API Spring Boot 

## Description

Ce projet est une API REST développée avec **Spring Boot**, permettant de gérer les entités **Sentiment** et **Client**. Les fonctionnalités incluent la création, la lecture, la mise à jour et la suppression (CRUD) pour ces deux entités.

---

## Technologies Utilisées

- **Backend** : Spring Boot
- **Langage** : Java
- **Base de Données** : MariaDB
- **Gestion des dépendances** : Maven
- **Format des données** : JSON

---

## Endpoints de l'API

### **SentimentController**

#### 1. **Créer un sentiment**
- **Méthode** : `POST`
- **Endpoint** : `/sentiment`
- **Body (JSON)** :
  ```json
  {
    "type": "POSITIF",
    "description": "Exemple de description"
  }
Statut HTTP : 201 Created
2. Rechercher les sentiments
Méthode : GET
Endpoint : /sentiment
Paramètre optionnel : type (filtrer par type)
Statut HTTP : 200 OK
3. Modifier un sentiment
Méthode : PUT
Endpoint : /sentiment/{id}
Body (JSON) :
json
Copier le code
{
  "type": "NEGATIF",
  "description": "Nouvelle description"
}
Statut HTTP : 200 OK
4. Supprimer un sentiment
Méthode : DELETE
Endpoint : /sentiment/{id}
Statut HTTP : 204 No Content
ClientController
1. Créer un client
Méthode : POST
Endpoint : /client
Body (JSON) :
json
Copier le code
{
  "nom": "Dupont",
  "prenom": "Jean",
  "email": "jean.dupont@example.com"
}
Statut HTTP : 201 Created
2. Rechercher tous les clients
Méthode : GET
Endpoint : /client
Statut HTTP : 200 OK
3. Lire un client spécifique
Méthode : GET
Endpoint : /client/{id}
Statut HTTP : 200 OK
4. Modifier un client
Méthode : PUT
Endpoint : /client/{id}
Body (JSON) :
json
Copier le code
{
  "nom": "Durand",
  "prenom": "Marie",
  "email": "marie.durand@example.com"
}
Statut HTTP : 200 OK
5. Supprimer un client
Méthode : DELETE
Endpoint : /client/{id}
Statut HTTP : 204 No Content

