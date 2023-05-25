# DSLIST Project 🍃

### In summary, the project consists of an API whose objective is to fetch information about games in the system. The API offers functionality such as searching for games by ID, obtaining a complete list of games and retrieving all games belonging to a specific list.

##### The project's goal is to develop an API based on REST standards, which offers four endpoints to fetch game data previously stored in a database. For the deployment of the project, [Railway](https://railway.app) service in the cloud was used. In addition, the project was configured with a continuous integration and delivery (CI/CD) flow through a Github repository. The project's goal is to develop an API based on REST standards, which offers four endpoints to fetch game data previously stored in a database. For the deployment of the project, the Railway service in the cloud was used. In addition, the project was configured with a continuous integration and delivery (CI/CD) flow through a Github repository.
##### With the CI/CD concept, each push performed on the main branch of the repository automatically triggers a build and deployment treadmill. This means that whenever there is an update to the source code, the system will jump into action, building the application and deploying it to the configured environment.
##### CI/CD allows you to automate and streamline the development process, ensuring software quality through automated testing and ensuring that code changes are delivered to the production environment quickly and reliably. With this approach, it is possible to avoid errors and inconsistencies, in addition to facilitating the maintenance and evolution of the project over time.

#### Project Versions Used
###### - java : 11
###### - Spring Boot : 2.6.7 🍃

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
MOCK MVC| https://mvnrepository.com/artifact/io.rest-assured/spring-mock-mvc
LIQUIBASE| https://mvnrepository.com/artifact/org.liquibase/liquibase-core

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

#### You can also access the class diagram below by clicking here [MERMAID_DIAGRAM](https://mermaid.live/edit#pako:eNrtWG1P4zgQ_iuW9wt7UARLSyGqKgFld3u3BUSLTnuqhEziltwmdmQ7sF2O_35jJ00c17S9lw_34UCCZGaeefeM2xcc8ojiAIcJkXIQk7kg6ZQh-DEU9Imk9JKpWC3QS0HXPy0URwEaKxGzuU0FuYT6GDLkAhgDnj8k1GYsKBEBGjJF51TYjDllwqsqS4iacZFKHzNO53ci8XrwyIUaUBmKOFMxZz6ZhLP5myKvU-Ym5kss1fbJYYBYq_KcageAe_NLU9_cIOtSuDztR-B4tN6Cz-uH2nxg-9JIPpdxkZpGyTy5GUyu_-8Yb8dsmZmN7aL1jWL2TxP9Zj7_bmYcN3_OyC01fcNFo-N6vRiMihkJab9fk2-g4HGIUqoeeSSR4igDISgfIuji9m7wZi7-kpVdJCHu8PF8oUuyk8CfYZW39wHS1F6Z4RvBf6ehDrShYBaz6HwxjHZiG-ieUuNoswGajjoOWvLVGdwWsOKvR3wXzgmEuvO-fJzovqjevkJSqpehaYDqdexUXTMc42MqnuKQarNFfs4SwDezCf3aX7L96QMJC19UCOTW1qjQ6kn2RpfKI9n3luuCMyV4klDxX4ppG6_eDOtSCC5uqcw4kyYtLUQ1qT7EelikVCqSZqCQhyQZEEUnQNM8pG8MY0VUDvMUWsvQQFySuTNfvCf1AtCjQrp5TCnLUyqIOWbWObsc3Uy-3n8Zjic17dPZ6PL-6npy__H67mpQ09-hJ5LkvqlZhv49pKZ1PxMWldkrHmWRAxg3j4I_M_SwgCeKzm6GECIMHhhBkjOSxD9ohJ7JolGW25zphFXal3F95AKJgleqb8Au00yZPnCB7-p0WtkyLHMQS4Iud7rkOV1yxdVHnrPoX1Y9kLphz7IMJrSpVBlpr2fR-v2y8rsoJbE7JkoL57lOOzTyLJ6jSkvxnje7YBfRZRTQtjwXYYkuVY0NSbt8CwOTRAQuDGsEg4Y742cyh723pSMki7WdAQ-_UVUQW5o4ZDOuGWfFY8PCr_RhK-0tOFhCXosYJr5zU9k1rCWKCm0K1I6ewppW2rTu663WH_3m9g3gBCjKIlnIWWvFyNZYuA-kWUJTypRcarUuuxs1O1uu0l7rcC24N9O1JnyL0QAcLb4wfG41dqZuI5ULViGWG6QSt30aMg2ro14RbqaiBhQQa5JXiFLFqm6fsGXT1V27stxAVmgegWLjODLNmOw77EqeylsPPpziVmuKD_b3f5ric_tDxWci3V4y4midvFPTSv-hT3jKVmZ8q9V3VrmWNUN_jXQz3xYCMI0FqgGuFvj4lMdJZFaIVCIPIU_UQFdHvsa7C8Q5TavDfAPIa6gH5Vt1tIrLb2gD6M2IrOXiNJQ_GL88TL-VjYPq3rfro59h2cgNELesNUz_-naT9m5Fo_58TADQ3B5rRes1sFYM72G4BcHejHCAzcKYYmgjuHrhAB4jIr5NMcx6kCO54uMFC3EALUb3cJ5FcE0rv8PBwYwkEqgZYTh4wd9xcNjdPz44Pjk-6Zyenh6fdtp7eIGDk6P99tFBu_2hc9TuHH_onL7u4R-cg4KD_W73oNPptNvdk6NOp9vuGm2_GWZhkkZ6qo3Kr5D0v9c_AfZ7Kyk)

````mermaid
---
title: CLASS DIAGRAM
---

classDiagram
    class GameEntity {
        - id: String
        - title: String
        - score: Double
        - year: Integer
        - genre: String
        - platforms: String
        - imgUrl: String
        - shortDescription: String
        - longDescription: String
    }

    class GameListEntity {
        - id: String
        - name: String
    }

    class BelongingPK {
        - game: GameEntity
        - gameList: GameListEntity
    }

    class BelongingEntity {
        - belongingPK: BelongingPK
        - position: Integer
    }

    class GameDTO {
        - id: String
        - title: String
        - score: Double
        - year: Integer
        - genre: String
        - platforms: String
        - imgUrl: String
        - shortDescription: String
        - longDescription: String
    }

    class GameListDTO {
        - id: String
        - name: String
    }

    class GameMinDTO {
        - id: String
        - title: String
        - year: Integer
        - imgUrl: String
        - shortDescription: String
    }

    class JpaRepository {
        <<interface>>
        Public methods to perform a CRUD
    }

    class GameRepository {
        <<interface>>
        + searchByList(listId: String): List<GameMinProjection>
        + findById(id: String): GameEntity
    }

class GameListRepository {
<<interface>>
}

class BelongingRepository {
<<interface>>
}

class GameMinProjection {
<<interface>>
+ getId()
+ getTitle()
+ getYear()
+ getImgUrl()
+ getShortDescription()
}

class GameService {
+ findAll(): List<GameMinDTO>
+ findById(id: String): GameDTO
+ findAllByListId(listId: String): List<GameMinDTO>
}

class GameListService {
+ findAll(): List<GameListDTO>
    }

class GameController {
+ findAll(): List<GameMinDTO>
+ findById(id: String): GameDTO
+ findAllByListId(listId: String): List<GameMinDTO>
}

class GameListController {
+ findAll(): List<GameListDTO>
    }

class ErrorResponse {
- error: String
- timestamp: LocalDateTime
-  codeStatus: int
-  message: String
    
    }

class CodeMessage {
<<enumeration>>
EMPTY_LIST
GAME_NOT_FOUND
# value: String
}

class ExceptionHandler {
Handles errors thrown by the API in a personalized way
}

class RuntimeException {
For runtime errors
}

class EmptyListException {
# message: CodeMessage
+ getMessage(): message
}

class GameNotFoundException {
# message: CodeMessage
+ getMessage(): message
}

class DslistApplication{
<<Application>>
+ main()
}

class MessageBundleConfig {
<<Configuration>>
+ exceptionResourceBundleMessageSource(): ReloadableResourceBundleMessageSource:
}

class SwaggerConfig {
<<Configuration>>
+ api(): Docket
- apiInfo(): ApiInfo
}

class WebConfig {
<<Configuration>>
- corsOrigins: String
+ corsConfigurer(): WebMvcConfigurer
}

GameEntity --|> JpaRepository: Extends
GameRepository --|> GameEntity: Implements

GameListEntity --|> JpaRepository: Extends
GameListRepository --|> GameListEntity: Implements

BelongingEntity --|> JpaRepository: Extends
BelongingRepository --|> BelongingEntity: Implements

GameRepository --|> GameMinProjection: Returns

GameService --|> GameRepository: Inject
GameListService --|> GameListRepository: Inject

GameController --|> GameService: Inject
GameListController --|> GameListService: Inject

GameService -- GameDTO: Returns
GameService -- GameMinDTO: Returns
GameListService -- GameListDTO: Returns

GameEntity"1"--"0..*"BelongingPK: Has
GameListEntity"1" --"0..*"BelongingPK: Has
BelongingEntity"1"--"1"BelongingPK: Has

ExceptionHandler --> GameController: Handles
ExceptionHandler --> GameListController: Handles

ErrorResponse --> ExceptionHandler: Build the structure

EmptyListException --> RuntimeException: Extends
GameNotFoundException --> RuntimeException: Extends

EmptyListException <-- ExceptionHandler: Handles
GameNotFoundException <-- ExceptionHandler: Handles

EmptyListException --> CodeMessage: Returns
GameNotFoundException --> CodeMessage: Returns

DslistApplication  --|> GameController: Contains
DslistApplication  --|> GameListController: Contains


MessageBundleConfig --> DslistApplication: Bean
SwaggerConfig --> DslistApplication: Bean
WebConfig --> DslistApplication: Bean



````

===========================================================================


### Contracts and endpoints for on-premise or production API consumption using interface of swagger - OpenAPI.

* *****LOCAL*****
* *****http://localhost:8080/swagger-ui/index.html*****
* *****PROD*****
* *****https://dslist-production-df92.up.railway.app/swagger-ui/index.html*****



