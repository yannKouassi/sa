# API Sentiment – Spring Boot

## Description
Ce projet est une mini‑API REST développée avec Spring Boot qui permet de gérer des sentiments (avis, ressentis) associés à des clients.  
Il illustre l’utilisation de Spring Data JPA, des DTOs, et d’un service métier pour assurer une séparation propre des responsabilités.  

## Architecture
- Backend : Spring Boot 3.5.14
- Base de données : MySQL
- ORM : Hibernate / JPA
- Gestion des dépendances : Maven

### Entités
- Client : représente un utilisateur identifié par son email.
- Sentiment : avis ou ressenti, lié à un client (ManyToOne).

### DTOs
- SentimentInputDTO : données reçues lors de la création (texte, type).
- SentimentOutputDTO : données renvoyées (id, texte, type, emailClient).

### Services
- ClientService : méthode LireOuCreer → vérifie si un client existe par email, sinon le crée.
- SentimentService : méthode creer → crée un sentiment lié à un client existant ou nouvellement créé.
- SentimentService.rechercher → retourne la liste des sentiments en DTO.

### Contrôleurs
- SentimentController :
  - POST /sentiment/creer → crée un sentiment (renvoie 201 Created sans body).
  - GET /sentiment → renvoie la liste des sentiments en JSON.

## Endpoints

### 1. Créer un sentiment
Requête :
POST http://localhost:2121/api/sentiment/creer?emailClient=yann@example.com
Content-Type: application/json

Body :
{
  "texte": "Super service !",
  "type": "POSITIF"
}

Réponse :
201 Created

### 2. Rechercher tous les sentiments
Requête :
GET http://localhost:2121/api/sentiment

Réponse :
[
  {
    "id": 1,
    "texte": "Super service !",
    "type": "POSITIF",
    "emailClient": "yann@example.com"
  },
  {
    "id": 2,
    "texte": "Peut mieux faire",
    "type": "NEGATIF",
    "emailClient": "kazama@example.com"
  }
]

## Objectifs pédagogiques
- Comprendre la séparation Controller
