# DSLIST Project 🍃

### The project's goal is to develop an API based on REST standards, which offers four endpoints to fetch game data previously stored in a database. For the deployment of the project, [Railway](https://railway.app) service in the cloud was used. In addition, the project was configured with a continuous integration and delivery (CI/CD) flow through a Github repository. The project's goal is to develop an API based on REST standards, which offers four endpoints to fetch game data previously stored in a database. For the deployment of the project, the Railway service in the cloud was used. In addition, the project was configured with a continuous integration and delivery (CI/CD) flow through a Github repository.
### With the CI/CD concept, each push performed on the main branch of the repository automatically triggers a build and deployment treadmill. This means that whenever there is an update to the source code, the system will jump into action, building the application and deploying it to the configured environment.
### CI/CD allows you to automate and streamline the development process, ensuring software quality through automated testing and ensuring that code changes are delivered to the production environment quickly and reliably. With this approach, it is possible to avoid errors and inconsistencies, in addition to facilitating the maintenance and evolution of the project over time.




#### Project Versions Used
###### - java - 11
###### - Spring Boot - 2.6.7 🍃

===========================================================================

### Para rodar o projeto localmente sem estar em ambiente docker, faça o seguinte:
### To run the project locally without being in a docker environment, do the following:

#### Certifique-se de ter os seguintes pré-requisitos instalados:
#### Make sure you have the following prerequisites installed:


* JDK 11 [Dowload JDK](https://www.oracle.com/java/technologies/downloads/#java11)
* Clone the project repository:
* Clone HTTPS: https://github.com/brunoonofre64/dslist.git
* Open the project in your favorite IDE (e.g. IntelliJ IDEA, Eclipse)
* Make sure JDK 11 is set as the project's JDK

####  running the project
*  In the root directory of the project, compile and build the project using the following command:

*****./mvnw clean install*****

* After successful completion of the above command, you can run the project using the following command:

*****./mvnw spring-boot:run*****

* This will launch the Spring Boot project and it will be locally accessible.

*****http://localhost:8080*****

* The project is configured to use the embedded H2 database. While running, you can access the H2 console to view and manage the database.

URL Console of H2: *****http://localhost:8080/h2-console*****

===========================================================================

### To run the project in local container, using DOCKER

* In the root directory of the project, open a terminal and run the following command cd docker to access the root directory of docker-compose.yml after entering the directory run the following command:

*****docker-compose***** *****up*****

* This will launch the Spring Boot project and it will be locally accessible.

*****http://localhost:8080*****

### Here is a tutorial to access PostgreSQL database via browser using PgAdmin:

* Wait until the containers start successfully. Check that the dev-postgresql and dev-pgadmin containers are running using the following command:

*****docker***** *****ps*****

* Open a web browser and go to the following URL to access PgAdmin:

*****http://localhost:5050*****

* Log in using the following credentials:

*****Email:***** *****me@example.com*****

*****Password:***** *****1234567*****

* After logging into PgAdmin, you will need to add a server to connect to the PostgreSQL database. Follow the steps below:

1. Click "Add New Server" in the PgAdmin panel.
2. In the "General" tab, define a name for the server (eg "My PostgreSQL Server").
3. On the "Connection" tab, configure the following information:

* Host name/address: dev-postgresql
* Port: 5432
* Nome de usuário (username): postgres
* Senha (password): 1234567
* Click on save

### You can now explore the PostgreSQL database using PgAdmin through the browser. Make sure the containers are running whenever you want to access PgAdmin.

### But you also have the option to consume the public endpoints that are published in the railway, you can check the endpoints at the bottom of this documentation.

===========================================================================

DEPENDENCIES | REFERENCE
------------ | ---------------
SPRING WEB | https://mvnrepository.com/artifact/org.springframework/spring-web/
LOMBOK | https://mvnrepository.com/artifact/org.projectlombok/lombok/
JPA | https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa/
DEV TOOLS | https://spring.io/blog/2015/06/17/devtools-in-spring-boot-1-3
H2 DATABASE | http://www.h2database.com/html/build.html
SWAGGER - OPENAPI | https://mvnrepository.com/artifact/io.springfox/springfox-boot-starter/3.0.0 && https://mvnrepository.com/artifact/io.springfox/springfox-swagger-ui

===========================================================================




```````mermaid
---
title: DSLIST DIAGRAM - ER 
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
===========================================================================


````mermaid
---
title: DSLIST FLOW OF REQUESTS 
---

flowchart TD
    userWeb[User web] --> searchGame{Search game}
    searchGame -->|click| getAll[Get List of all games]
    searchGame -->|click| getOnClick[Get games by click on  image]
    userWeb[User web] --> byListOfGame{Search lists of games}
    byListOfGame --> |click| byGameGender[Get list by gender]
    byListOfGame --> |click| gameInsideList[Get games of list by gender]
    

````

===========================================================================




### Contracts and endpoints for on-premise or production API consumption using interface of swagger - OpenAPI.

* *****LOCAL*****
* *****http://localhost:8080/swagger-ui/index.html*****
* *****PROD*****
* *****https://dslist-production-df92.up.railway.app/swagger-ui/index.html*****



