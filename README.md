# Projeto DSLIST | DSLIST Project 🍃

### Ideia do projeto é uma API seguindo padrões REST, onde terá apenas 4 endpoints, para buscar dados de games, já alimentados no banco de dados, foi feito o deploy desse projeto na nuvem, usando o [Railway](https://railway.app). O projeto também conta com conceito de CI/CD usando o repositório no Github, onde qual push na branch main, ele entra na esteira para build e deploy!
### The project idea is to create a RESTful API with only 4 endpoints to fetch game data that is already stored in a database. The project has been deployed in the cloud using Railway. It also incorporates the concept of CI/CD using a Github repository, where any push to the main branch triggers the pipeline for build and deployment!

#### Versões usadas no projeto | Project Versions Used
###### - java - 11
###### - Spring Boot - 2.6.7 🍃

==================================================================================================================================================================



DEPENDÊNCIAS -  DEPENDENCIES | REFERÊNCIA - REFERENCE
------------ | ---------------
SPRING WEB | https://mvnrepository.com/artifact/org.springframework/spring-web/
LOMBOK | https://mvnrepository.com/artifact/org.projectlombok/lombok/
JPA | https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa/
DEV TOOLS | https://spring.io/blog/2015/06/17/devtools-in-spring-boot-1-3
H2 DATABASE | http://www.h2database.com/html/build.html

==================================================================================================================================================================




```````mermaid
---
title: DSLIST DIAGRAM - ER | DSLIST DIAGRAMA - ER
---
erDiagram
GAME ||..|{ BELONGING : IS
GAME_LIST }|..|{ BELONGING : IS

GAME {
Long id
String title
Double score
Integer year
String genre
String platforms
String imgUrl
String shortDescription
String longDescription
}

GAME_LIST {
Long id
String name
}

BELONGING {
Long game_id FK
Long game_list_id
}


````````
==================================================================================================================================================================


````mermaid
---
title: DSLIST FLOW OF REQUESTS | DSLIST FLUXO DAS REQUISIÇÕES
---

flowchart TD
    userWeb[User web] --> searchGame{Search game}
    searchGame -->|click| getAll[Get List of all games]
    searchGame -->|click| getOnClick[Get games by click on  image]
    userWeb[User web] --> byListOfGame{Search lists of games}
    byListOfGame --> |click| byGameGender[Get list by gender]
    byListOfGame --> |click| gameInsideList[Get games of list by gender]
    

````

==================================================================================================================================================================




### Contratos e endpoints para consumo da API localmente ou de produção.
### Contracts and endpoints for on-premise or production API consumption.

RESPOSTA - RESPONSE | END POINT                                                                                                            | MÉTODO / METHOD HTTP | DETALHES / DETAILS
-------- |----------------------------------------------------------------------------------------------------------------------|----------------------| -------
JSON - 1  | LOCAL http://localhost:8080/games/{uuid} PROD https://dslist-production-df92.up.railway.app/games/{uuid}             | GET                 | Busca um game por uuid / Search game by uuid.
JSON - 2  | LOCAL http://localhost:8080/games PROD https://dslist-production-df92.up.railway.app/games                           | GET                  | Traz a lista de games / Bring the list of games.
JSON - 3  | LOCAL http://localhost:8080/lists PROD https://dslist-production-df92.up.railway.app/lists                           | GET                  | Traz a lista de listas de games / Brings the list of game lists.
JSON - 4  | LOCAL http://localhost:8080/lists/{uuid}/games PROD https://dslist-production-df92.up.railway.app/lists/{uuid}/games | GET               | Recebe o uuid de uma lista de games e traz todos os games dessa lista especificada / Receives the uuid of a list of games and brings all the games from that specified list



