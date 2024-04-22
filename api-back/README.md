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