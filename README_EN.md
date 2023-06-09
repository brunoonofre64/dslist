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

#### You can now explore the PostgreSQL database using PgAdmin through the browser. Run the SQL script to create the tables [SCRIPT](https://github.com/brunoonofre64/dslist/blob/master/create.sql). Make sure the containers are running whenever you want to access PgAdmin.

#### But you also have the option to consume the public endpoints that are published in the railway, you can check the endpoints at the bottom of this documentation.

===========================================================================

DEPENDENCIES | REFERENCE
------------ | ---------------
SPRING WEB | [SPRING WEB](https://mvnrepository.com/artifact/org.springframework/spring-web/)
LOMBOK | [LOMBOK](https://mvnrepository.com/artifact/org.projectlombok/lombok/)
JPA | [JPA](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa/)
DEV TOOLS | [DEV TOOLS](https://spring.io/blog/2015/06/17/devtools-in-spring-boot-1-3)
H2 DATABASE | [H2 DATABASE](http://www.h2database.com/html/build.html)
SWAGGER - OPENAPI | [SWAGGER](https://mvnrepository.com/artifact/io.springfox/springfox-boot-starter/3.0.0) - [OPENAPI](https://mvnrepository.com/artifact/io.springfox/springfox-swagger-ui)
MOCK MVC| [MOCK MVC](https://mvnrepository.com/artifact/io.rest-assured/spring-mock-mvc)
LIQUIBASE| [LIQUIBASE](https://mvnrepository.com/artifact/org.liquibase/liquibase-core)
BEAN VALIDATION| [BEAN VALIDATION](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-validation)
STARTER SPRING SECURITY | [STARTER SPRING SECURITY](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-security)
JWT | [JWT](https://mvnrepository.com/artifact/com.auth0/java-jwt)


===========================================================================

##### You can also access the class diagram below by clicking here [MERMAID_DIAGRAM](https://mermaid.live/view#pako:eNrlWW1v2zYQ_iuC9iVd48BJ8yoEBuw4ad3mxbAdDB0MBIzEOFplUqOkpG6X_7476o2kaNnbpwFLAEcin-d4d7w7Hp2frs8D6nquH5EkGYZkIchyzhz4CUJB_TTkzLme5CP5p0Q6H8mSXrI0TFfOz3wcfzpOGHjONBUhW6ijgIuobSLxuYCJIc8eI6pOrCgRnjNiKV1QoU4sKBNWUXFE0iculoltMlwu7kVk1eCZi3RIE1-EMVprw0ScLdZC3ubMdMx1mKTbO4cBo1XkgKICMDv-ostbSGa9FeYc6uEZGrWvYNP6sV7eU3XRnM-TMHeNtmXGMhMelUHjbOMZAfjbTd65T6jY3tl0SUJrHMQg65WLtXpAWKETz2sbelZ1Zo8PGWj0IDmmRnK0XMFzrr4Y08hsTssV8LeOsOHsDmXrVjbyrJFfjbxq5JM1j5r505Y3LfnypluBDl1jyZqkqLk3IdvWCQ2b_4k1hvMx2qp1jWCqoCX4c0wmVKYGFzI6z89D0EI8EZ_2IHzGsCuh7yxp-syDxEm5E8Mk-N4hzsXkfthwWKu0904ChvrPgxX6dSeCj1HlmHdF-BauGwv-R17dJfEpZMFgNQp2QpWgFhbLzrUqo-CrkrEtAX28wdJc4Uv0_462C6D2ndxBEp3XlUFy6HdQOlnHeuSQmoRpimCub1CkFDopStWOWbNU0bWjR0wCcX_ktuTY3jtbkWkGfr17Vp0WFDZ-513xOMN0qN6-QohULyOZB9Xr1EgCnDAWn1LxEvoUl82N6UfA12ML0mNDUAFC4efxCrjWiM2lWsJwo0pFlelpxbSONI0fcRLg4GCFn1iEGoEiKwBNYTCROUde6E4mI_bPjMqVvCKCy_eSlFudxQFJDbG7Dkq4lzOVgOpV5wc0ok1-eXxJ9rh-Ae4LDwObbwqZPaxkLyQKcbUBhfJD69V32vTKtS7O3jrZqiWNTNIcLd0mZH7Vbpto77ocddsvOEuBG1HxXwrEbbTaEIumiP9nOBpxYzrlX4fOpRAc_JDEnCW0OMFxSG8eliCCLGPQivskGoLNMxjDOQfvStOUpBn0RlBz5RjAE7IwepVGx3IBzJscmZdsyrIlFUSewGDy5c149vXhejSdzdnH_s3lw-3d7OHq7v4WeoBfMDszau2iLr_7VNbqT4QFhYfyxyS3DbqKZ8FfmfO4gifq9McjUB36C-g0Ejwlwx80cF6JfsRPMoaOqKSj2CsuHJGPF6I1CmxlfxxWDNn6wphD4hAOyXJUowwTTLR-HEMTJD0hPaO858cZRJZ5FBWuHGRoKcTHU7jI3Zo_Z0KhV4vDzvNM-AWrEDGVQxiEE4rZRh4xjtYCPU2N6StZLGTWtikAHkD5Q-5_ozJmYGDEnjgO9vNHTepv9LFVYgfiUCR3IoSeSmnS38vhEk0FigdRNy9-PVaso1zeO52_enqf6kFQpZQFSY5T-h-JrbnQUi_jiC4pS5NSqnLz3SjZ6CEr6bUMcwXzmtq6hK3tlARDirmIcp9slW90qRJbc02pytW3VarRckpszbW53OZCrUfE0E4zwSpGeRBXcFWTEUNavUMNsL5tNUHtpSpn2IBqL1DZZwPmSijlv9KhoDe1tYEVK3RtTbBiga6tCVQsMLWtDSsbDMX9FkDeUBgY3e_qVVkB6v4uj2Rtsy0OXKOVgtmoWYVt102D2bVTK9Hc3Z-7nc7c7e7t_Tp3B-qXTp9IYpYXCXfa8EaaV_L3beA6cQ09tK9zCnCdj1uA4Ww3z-hOp2e0sYiVh3YLWg9vhQEcrbFBginFcwZZGAWyBUhSkfmwCxSpjWMb2ebxr9QnC-Mc9re5nqreMk5la133E7iK0hMZUXbL0ysOh-82-DlrtBFOnfuqw_AZWomknWG6uWbhr63xQN0aEvGbUrzy6y1CK7Q-99slUj8TEHsFFr0PTH0Uz_p-QOIULaj2zmC2rjK4EKs43Qb5-TW9T8NoHeiCLyEsKXbLF1mS8mU_gyCE-MoBV2GUVu45LyoFXnTKS4MNrti0USaqpRsury8BNMQqm4vwh12hO-bTcXV_alHALqJ1_Tlzd124B0CLG7ieK78tnrtgC1w4XA8eAyK-zV1o2wBHspRPV8x3PUhguuvmN7fifzblYEyY6_10v7te5-hg76zbPTk9ODk77B4eHR7vuivXO_qwd3zaPTw7-HB8sN_tdk_fdt0fnIOA_b3uydnJyfHB6QmwTo9ODqW43-VkLp0GeETfFP8ywj9vfwNnwj3Q)

````mermaid
---
title: CLASS DIAGRAM
---

classDiagram
    direction LR
    
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

    class RoleEntity   {
        - id: String
        - roleName: String
    }

    class UserEntity {
        - id: String
        - email: String
        - password: String
        - roles: List<RoleEntity>
    }

    class Tb_user_roles {
        - id_role: String: FK
        - id_user: String: FK
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



class UserDTO {
- email: String
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

class UserRepository {
<<interface>>
+ findByEmail(email: String): Optional<UserEntity>
+ existsByEmail(email: String): boolean
}

class RoleRepository {
<<interface>>
+ existsByRoleName(roleName: String): boolean
+ findByIdIn(roleId: List<String>): List<RoleEntity>
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


class UserService {
+ loadUserByUsername(email: String): UserDetails
+ save(userRequestDTO: UserRequestDTO): UserDTO
+ update(email: String, userUpdateDTO: UserUpdateDTO): UserDTO
+ delete(email: String, passwordDTO: PasswordDTO): void
+ findAll(): List<UserDTO>
- validateBeforeUserUpdate(userUpdateDTO: UserUpdateDTO, userEntity UserEntity): void
}

class RoleService {
+ save(roleRequestDTO: RoleRequestDTO): void
}


class GameController {
+ findAll(): List<GameMinDTO>
+ findById(id: String): GameDTO
+ findAllByListId(listId: String): List<GameMinDTO>
}

class GameListController {
+ findAll(): List<GameListDTO>
    }


class UserController {
+ loadUserByUsername(email: String): UserDetails
+ save(userRequestDTO: UserRequestDTO): UserDTO
+ update(email: String, userUpdateDTO: UserUpdateDTO): UserDTO
+ delete(email: String, passwordDTO: PasswordDTO): void
+ findAll(): List<UserDTO>
}

class RoleController {
+ save(roleRequestDTO: RoleRequestDTO): void
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

class AllAPiExceptions {
All api exceptions
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

UserEntity --|> JpaRepository: Extends
UserRepository --|> UserEntity: Implements

RoleEntity --|> JpaRepository: Extends
RoleRepository --|> RoleEntity: Implements

GameRepository --|> GameMinProjection: Returns

GameService --|> GameRepository: Inject
GameListService --|> GameListRepository: Inject
UserService --|> UserRepository: Inject
RoleService --|> RoleRepository: Inject

GameController --|> GameService: Inject
GameListController --|> GameListService: Inject
UserController --|> UserService: Inject
RoleController --|> RoleService: Inject

GameService -- GameDTO: Returns
GameService -- GameMinDTO: Returns
GameListService -- GameListDTO: Returns
UserService -- UserDTO: Returns


GameController -- GameDTO: Returns
GameController  -- GameMinDTO: Returns
GameListControlle -- GameListDTO: Returns
UserControlle -- UserDTO: Returns



GameEntity"1"--"0..*"BelongingPK: Has
GameListEntity"1" --"0..*"BelongingPK: Has
BelongingEntity"1"--"1"BelongingPK: Has
UserEntity"1"--"0..*"Tb_user_roles: Has
RoleEntity"1"--"0..*"Tb_user_roles: Has

ExceptionHandler --> GameController: Handles
ExceptionHandler --> GameListController: Handles

ErrorResponse --> ExceptionHandler: Build the structure

AllAPiExceptions --> RuntimeException: Extends

AllAPiExceptions <-- ExceptionHandler: Handles

EmptyListException --> CodeMessage: Returns
GameNotFoundException --> CodeMessage: Returns

DslistApplication  --|> GameController: Contains
DslistApplication  --|> GameListController: Contains


MessageBundleConfig --> DslistApplication: Bean
SwaggerConfig --> DslistApplication: Bean
WebConfig --> DslistApplication: Bean
SecurityConfig <-- WebSecurityConfigurerAdapter: Extends
SecurityConfig --> DslistApplication: Bean
BCryptConfig --> DslistApplication: Bean
JwtUtil --> DslistApplication: Component
CustomAuthenticationFilterConfig <-- UsernamePasswordAuthenticationFilter: Extends
CustomAuthenticationFilterConfig --> SecurityConfig: Used by
CustomAuthorizationFilterConfig <-- OncePerRequestFilter: Extends
CustomAuthorizationFilterConfig --> SecurityConfig: Used by


````

===========================================================================

[MERMAID_DIAGRAM](https://mermaid.live/view#pako:eNqNVG1PgzAQ_ivkPmmyGRjihG_qFjXxJZnTGENCunGyRqCkLdHJ9t-lBQPMYdZPvT7PPb273rWAJQsRPEA-oSTiJPFTo1xyEUQkQWOzGQ5ZocwFxiyNaBoZnuGDAgMa-tChBzEVstdHgV2fXCBv0ZUZcBaj0HxtdvgK6-erXc3vJlFUplo0NF4uZlc3F7Mj--y4OZdUltK_0MhxWphYMo7G5PH58m7anOp810i4cfswn15PZy0IU94nlsVEvjOeiB6cJlGQ87gvlBXjMghRLDnNJGWpMZ--zhtclbsH3u5UpXqrA0qTqhL-Daet17xzsVOgPtG6F_aDGRNUR9-pbPtC3QgHxK5b4oAEdCMeoIcJoc3bOGY7aCLEJ-ONozUye26qe7Z1X93q_ySxDyx1YQAJ8jKqsJxhLeiDXGGCPqiRCAn_UPOwLXkkl-xpnS7BkzzHAeRZSCTWU_97mJEUvAK-wDMHsAbPMu0Tx3bdsTu2Rue2dTbeDuCbsdLBPHGrdWrarmM7jqXd3zRYqWFIJeP31Q-jP5rtD8SYS7A)

````mermaid
erDiagram
    tb_game ||--o{ tb_belonging : "game_id"
    tb_game_list ||--o{ tb_belonging : "list_id"
    tb_user ||--o{ tb_user_roles : "user_id"
    tb_role ||--o{ tb_user_roles : "role_id"

    tb_game {
        id VARCHAR(36)
        title VARCHAR(255)
        score DOUBLE
        game_year INTEGER
        genre VARCHAR(255)
        platforms VARCHAR(255)
        img_url VARCHAR(255)
        short_description TEXT
        long_description TEXT
    }

    tb_game_list {
        id VARCHAR(36)
        name VARCHAR(255)
    }

    tb_belonging {
        game_id VARCHAR(36)
        list_id VARCHAR(36)
        position INTEGER
    }

    tb_role {
        id VARCHAR(36)
        role_name VARCHAR(255)
    }

    tb_user {
        id VARCHAR(36)
        email VARCHAR(50)
        password VARCHAR(120)
    }

    tb_user_roles {
        user_id VARCHAR(36)
        role_id VARCHAR(36)
    }


````

===========================================================================


### Contracts and endpoints for on-premise or production API consumption using interface of swagger - OpenAPI.

* *****LOCAL*****
* *****http://localhost:8080/swagger-ui/index.html*****
* *****PROD*****
* *****https://dslist-production-df92.up.railway.app/swagger-ui/index.html*****


#### A API está protegida por autenticação e autorização via JWT, que tenha autorização de realizar operações de entrada de dados, é necessário que usando o postman, você no endpoint ***/login*** envie um método POST, onde selecionando o ***Body*** e a opção ***x-www-form-urlencoded*** você insira ***email*** e ***senha*** de acesso, como mostra o exemplo abaixo:
#### The API is protected by authentication and authorization via JWT. To have the authorization to carry out data entry operations, it is necessary that, using Postman, you send a POST method to the ***login*** endpoint. By selecting the ***Body*** and the ***x-www-form-urlencoded*** option, you must enter your access ***email*** and ***password***, as shown in the example below:


Key  | Value
------------ | ---------------
email | guest@guest
password | guest

#### Now use the generated ***access_token*** to access via ***Bearer*** ***Token.***




