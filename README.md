# Documentation de l'API

## Contexte

Le but de l'API est de répondre aux besoins d'une application de CE.
Elle doit permettre d'intéragir avec des produits, des catalogues et des utilisateurs.

## Docker compose

Deux docker-compose sont fournis pour lancer l'application en local.

### docker-compose.yml

Le premier docker-compose permet de lancer l'application en local base de données Mysql et l'application Spring Boot.

Pour lancer l'application, il suffit de lancer la commande suivante :

```bash
docker-compose -f docker-compose.yml up
```

### docker-compose-dev.yml

Le deuxième docker-compose permet de lancer juste la base de données Mysql en local.

Pour lancer la base de données, il suffit de lancer la commande suivante :

```bash
docker-compose -f docker-compose-dev.yml up
```

## Les routes disponibles de l'API

### Utilisateurs

__Ajouter__ un nouvel utilisateur :
```
[POST] /nouveau-utilisateur
```
Exemple de json :
```json
{
  "nom": "string",
  "login": "string",
  "prenom": "string",
  "mail": "string",
  "password": "string",
  "roles": "string"
}
```
Ajoute un nouvel utilisateur à la base de données.

__Modifier__ un utilisateur
```
[PUT] /modifie-utilisateur
```
Exemple de json :
```json
{
  "id": 0,
  "nom": "string",
  "login": "string",
  "prenom": "string",
  "mail": "string",
  "password": "string",
  "roles": "string"
}
```
Met à jour les informations d'un utilisateur existant

__Récupérer__ un utilisateur par son __id__
```
[GET] /get-utilisateur-by-id/{id}
```
Récupère un seul utilisateur par son ID.

__Récupérer__ tous les utilisateurs
```
[GET] /get-all-utilisateurs
```
Récupère la liste de tous les utilisateurs disponibles.

__Supprimer__ un utilisateur
```
[DELETE] /supprimer-utilisateur/{id}
```
Supprime un utilisateur de la base de données.

### Catalogues

__Ajouter__ un nouveau catalogue :
```
[POST] /nouveau-catalogue
```
Exemple de json :
```json
{
  "nom": "string",
  "produits": [
    {
		"id": 1,
		"nom": "ProduitA",
		"description": "Premier produit",
		"quantite": 5,
		"prix": 15
	}
  ]
}
```
Ajoute un nouveau catalogue à la base de données.

__Modifier__ un catalogue
```
[PUT] /modifie-catalogue
```
Exemple de json :
```json
{
  "id": 0,
  "nom": "string",
  "produits": [
    {
		"id": 1,
		"nom": "ProduitA",
		"description": "Premier produit",
		"quantite": 5,
		"prix": 15
	}
  ]
}
```
Met à jour les informations d'un catalogue existant

__Récupérer__ un catalogue par son __id__
```
[GET] /get-catalogue-by-id/{id}
```
Récupère un seul catalogue par son ID.

__Récupérer__ tous les catalogues
```
[GET] /get-all-catalogues
```
Récupère la liste de tous les catalogues disponibles.

__Supprimer__ un catalogue
```
[DELETE] /supprimer-catalogue/{id}
```
Supprime un catalogue de la base de données.

### Produits

__Ajouter__ un nouveau produit :
```
[POST] /nouveau-produit
```
Exemple de json :
```json
{
  "nom": "ProduitA",
  "description": "Premier produit",
  "quantite": 5,
  "prix": 10
}
```
Ajoute un nouveau produit à la base de données.

__Modifier__ un produit
```
[PUT] /modifie-produit
```
Exemple de json : 
```json
{
  "id": 1,
  "nom": "ProduitA",
  "description": "Premier produit",
  "quantite": 5,
  "prix": 15
}
```
Met à jour les informations d'un produit existant

__Récupérer__ un produit par son __id__
```
[GET] /get-produit-by-id/{id}
```
Récupère un seul produit par son ID.

__Récupérer__ tous les produits
```
[GET] /get-all-produits
```
Récupère la liste de tous les produits disponibles.

__Supprimer__ un produit
```
[DELETE] /supprimer-produit/{id}
```
Supprime un produit de la base de données.

## Diagramme des classes

![Diagramme des classes](https://github.com/Hackathon-M1-AL/Api-CRUD/blob/main/class_diagram.jpg)