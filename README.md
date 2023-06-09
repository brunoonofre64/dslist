# Projeto DSLIST 🍃

###### ENGLISH VERSION - [README_EN](https://github.com/brunoonofre64/dslist/blob/master/README_EN.md)

### Em resumo, o projeto consiste em uma API cujo objetivo é buscar informações sobre jogos no sistema. A API oferece funcionalidades como a busca de jogos por ID, a obtenção de uma lista completa de jogos e a recuperação de todos os jogos pertencentes a uma lista específica.

##### O objetivo do projeto é desenvolver uma API baseada em padrões REST, que oferece quatro endpoints para buscar dados de jogos previamente armazenados em um banco de dados. Para o deployment do projeto, foi utilizado o serviço [Railway](https://railway.app) na nuvem. Além disso, o projeto foi configurado com um fluxo de integração e entrega contínua (CI/CD) através de um repositório no Github.
##### Com o conceito de CI/CD, cada push realizado na branch main do repositório desencadeia automaticamente uma esteira de construção e deployment. Isso significa que, sempre que houver uma atualização no código-fonte, o sistema entrará em ação, construindo a aplicação e implantando-a no ambiente configurado.
##### O CI/CD permite automatizar e agilizar o processo de desenvolvimento, garantindo a qualidade do software por meio de testes automatizados e assegurando que as mudanças no código sejam entregues ao ambiente de produção de forma rápida e confiável. Com essa abordagem, é possível evitar erros e inconsistências, além de facilitar a manutenção e a evolução do projeto ao longo do tempo.


#### Versões usadas no projeto 
###### - java : 11
###### - Spring Boot : 2.6.7 🍃

===========================================================================

### Para rodar o projeto localmente sem estar em ambiente docker, faça o seguinte:

#### Certifique-se de ter os seguintes pré-requisitos instalados:

* JDK 11 [Dowload JDK](https://www.oracle.com/java/technologies/downloads/#java11)
* Clone o repositório do projeto:
* Clone HTTPS: https://github.com/brunoonofre64/dslist.git
* Abra o projeto em sua IDE favorita (por exemplo, IntelliJ IDEA, Eclipse)
* Certifique-se de que o JDK 11 esteja configurado como o JDK do projeto 

#### Executando o projeto 
* No diretório raiz do projeto, compile e construa o projeto usando o seguinte comando: 

 *****./mvnw clean install*****

* Após a conclusão bem-sucedida do comando acima, você pode executar o projeto usando o seguinte comando: 

*****./mvnw spring-boot:run*****

* Isso iniciará o projeto Spring Boot e ele estará acessível localmente.

*****http://localhost:8080*****

* O projeto está configurado para usar o banco de dados H2 incorporado. Durante a execução, você pode acessar o console do H2 para visualizar e gerenciar o banco de dados. 
  
URL do Console do H2: *****http://localhost:8080/h2-console*****

===========================================================================

### Para rodar o projeto em container local, usando DOCKER

* No diretório raiz do projeto, abra um terminal e execute o seguinte comando cd docker para acessar o diretorio raiz do docker-compose.yml após entrar no diretório execute o seguinte comando: 

*****docker-compose***** *****up*****

* Isso iniciará o projeto Spring Boot e ele estará acessível localmente. 

*****http://localhost:8080*****

### Aqui está um tutorial para acessar o banco de dados PostgreSQL via navegador usando o PgAdmin:

* Aguarde até que os contêineres sejam iniciados com êxito. Verifique se os contêineres dev-postgresql e dev-pgadmin estão em execução usando o seguinte comando: 

*****docker***** *****ps*****

* Abra um navegador da web e acesse a seguinte URL para acessar o PgAdmin: 

*****http://localhost:5050*****

* Faça login usando as seguintes credenciais:

*****Email:***** *****me@example.com*****

*****Password:***** *****1234567*****

* Após fazer login no PgAdmin, você precisará adicionar um servidor para conectar-se ao banco de dados PostgreSQL. Siga as etapas abaixo: 

1. Clique em "Add New Server" (Adicionar novo servidor) no painel do PgAdmin. 
2. Na guia "General" (Geral), defina um nome para o servidor (por exemplo, "My PostgreSQL Server").
3. Na guia "Connection" (Conexão), configure as seguintes informações: 

* Host name/address (Nome do host/endereço):
* Port: 5432
* Nome de usuário (username): postgres
* Senha (password): 1234567
* Clique em "Save" (Salvar)

#### Agora você pode explorar o banco de dados PostgreSQL usando o PgAdmin por meio do navegador. Rode o script SQL de criação das tabelas [SCRIPT](https://github.com/brunoonofre64/dslist/blob/master/create.sql). Certifique-se de que os contêineres estejam em execução sempre que desejar acessar o PgAdmin.

#### Mas você também tem a opção de consumir os endpoints públicos que estão puclidados no railway, pode verificar os endpoints logo mais a baixo desta documentação.

===========================================================================

DEPENDÊNCIAS  | REFERÊNCIA
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

##### Voce também pode acessar o diagrama de classes abaixo clicando aqui [MERMAID_DIAGRAM](https://mermaid.live/view#pako:eNrlWW1v2zYQ_iuC9iVd48BJ8yoEBuw4ad3mxbAdDB0MBIzEOFplUqOkpG6X_7476o2kaNnbpwFLAEcin-d4d7w7Hp2frs8D6nquH5EkGYZkIchyzhz4CUJB_TTkzLme5CP5p0Q6H8mSXrI0TFfOz3wcfzpOGHjONBUhW6ijgIuobSLxuYCJIc8eI6pOrCgRnjNiKV1QoU4sKBNWUXFE0iculoltMlwu7kVk1eCZi3RIE1-EMVprw0ScLdZC3ubMdMx1mKTbO4cBo1XkgKICMDv-ostbSGa9FeYc6uEZGrWvYNP6sV7eU3XRnM-TMHeNtmXGMhMelUHjbOMZAfjbTd65T6jY3tl0SUJrHMQg65WLtXpAWKETz2sbelZ1Zo8PGWj0IDmmRnK0XMFzrr4Y08hsTssV8LeOsOHsDmXrVjbyrJFfjbxq5JM1j5r505Y3LfnypluBDl1jyZqkqLk3IdvWCQ2b_4k1hvMx2qp1jWCqoCX4c0wmVKYGFzI6z89D0EI8EZ_2IHzGsCuh7yxp-syDxEm5E8Mk-N4hzsXkfthwWKu0904ChvrPgxX6dSeCj1HlmHdF-BauGwv-R17dJfEpZMFgNQp2QpWgFhbLzrUqo-CrkrEtAX28wdJc4Uv0_462C6D2ndxBEp3XlUFy6HdQOlnHeuSQmoRpimCub1CkFDopStWOWbNU0bWjR0wCcX_ktuTY3jtbkWkGfr17Vp0WFDZ-513xOMN0qN6-QohULyOZB9Xr1EgCnDAWn1LxEvoUl82N6UfA12ML0mNDUAFC4efxCrjWiM2lWsJwo0pFlelpxbSONI0fcRLg4GCFn1iEGoEiKwBNYTCROUde6E4mI_bPjMqVvCKCy_eSlFudxQFJDbG7Dkq4lzOVgOpV5wc0ok1-eXxJ9rh-Ae4LDwObbwqZPaxkLyQKcbUBhfJD69V32vTKtS7O3jrZqiWNTNIcLd0mZH7Vbpto77ocddsvOEuBG1HxXwrEbbTaEIumiP9nOBpxYzrlX4fOpRAc_JDEnCW0OMFxSG8eliCCLGPQivskGoLNMxjDOQfvStOUpBn0RlBz5RjAE7IwepVGx3IBzJscmZdsyrIlFUSewGDy5c149vXhejSdzdnH_s3lw-3d7OHq7v4WeoBfMDszau2iLr_7VNbqT4QFhYfyxyS3DbqKZ8FfmfO4gifq9McjUB36C-g0Ejwlwx80cF6JfsRPMoaOqKSj2CsuHJGPF6I1CmxlfxxWDNn6wphD4hAOyXJUowwTTLR-HEMTJD0hPaO858cZRJZ5FBWuHGRoKcTHU7jI3Zo_Z0KhV4vDzvNM-AWrEDGVQxiEE4rZRh4xjtYCPU2N6StZLGTWtikAHkD5Q-5_ozJmYGDEnjgO9vNHTepv9LFVYgfiUCR3IoSeSmnS38vhEk0FigdRNy9-PVaso1zeO52_enqf6kFQpZQFSY5T-h-JrbnQUi_jiC4pS5NSqnLz3SjZ6CEr6bUMcwXzmtq6hK3tlARDirmIcp9slW90qRJbc02pytW3VarRckpszbW53OZCrUfE0E4zwSpGeRBXcFWTEUNavUMNsL5tNUHtpSpn2IBqL1DZZwPmSijlv9KhoDe1tYEVK3RtTbBiga6tCVQsMLWtDSsbDMX9FkDeUBgY3e_qVVkB6v4uj2Rtsy0OXKOVgtmoWYVt102D2bVTK9Hc3Z-7nc7c7e7t_Tp3B-qXTp9IYpYXCXfa8EaaV_L3beA6cQ09tK9zCnCdj1uA4Ww3z-hOp2e0sYiVh3YLWg9vhQEcrbFBginFcwZZGAWyBUhSkfmwCxSpjWMb2ebxr9QnC-Mc9re5nqreMk5la133E7iK0hMZUXbL0ysOh-82-DlrtBFOnfuqw_AZWomknWG6uWbhr63xQN0aEvGbUrzy6y1CK7Q-99slUj8TEHsFFr0PTH0Uz_p-QOIULaj2zmC2rjK4EKs43Qb5-TW9T8NoHeiCLyEsKXbLF1mS8mU_gyCE-MoBV2GUVu45LyoFXnTKS4MNrti0USaqpRsury8BNMQqm4vwh12hO-bTcXV_alHALqJ1_Tlzd124B0CLG7ieK78tnrtgC1w4XA8eAyK-zV1o2wBHspRPV8x3PUhguuvmN7fifzblYEyY6_10v7te5-hg76zbPTk9ODk77B4eHR7vuivXO_qwd3zaPTw7-HB8sN_tdk_fdt0fnIOA_b3uydnJyfHB6QmwTo9ODqW43-VkLp0GeETfFP8ywj9vfwNnwj3Q)


````mermaid
---
title: DIAGRAMA DE CLASSES
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

[MERMAID_DIAGRAM](https://mermaid.live/view#pako:eNrlWW1v2zYQ_iuC9sXd4iLt1gUVAgN2nLRum8SwHQwdDASMxDhaJVKjqKRul_--O-qNpGjZ26cBi4FEIp_n3nhHHp3vfsgj6gd-mJA8n8ZkI0i6Zh78qBHvHUnpOZOx3Hrfy3H8GXpxFHhLKWK20UcBl1DXRB5yARNTXtwlVJ_YUiICb8Yk3VChT2woE05RWULkPRdp7pqM082NSJwWPHAhpzQPRZzJmDMXJuFssxPyvGZ2YD7FuTw8OAwYvSInFA2A2flHU95GMdulsOfQjsCyqF-Dy-q7Vn2g22IEn-dxGRpjySw1C57USeMdEhkB-Kt90bnJqTg82DQlsTMPMpD1xMVOOyCtMIinrQ8jpzmru9sCLLpVHNsiNVprCLyLj9Y0MrvTSgN-2gybrq5Rtullp8469dWpq049OeuoWz99ddNTL8-mFxjQHZ7sKIqWexmzQ4PQ8fmfeGMFH7Ot0WslUwOtwR8ysqCqNLhQ2Xl6GoMV4p6EdATpM4dViUMvpfKBR7knuZfBJMTeI97Z4mbaCVivtJ-8HBwNHyZbjOsggV-zJjAvqvStQjcX_A8aoqeKeB-zaLKdRYNYJ-gbi2Pleo3R8M2WcSgBY7zH09Lgc4z_wFgFMPtarSBJTtudQXHoVzA638W641CahBmGYK3vMaQWuqi2qoG9Z-mi20DPmALi-qhlKbGjF65Nppv47eo5bdpQWPjBi-pxheXQvH2GFGleZqoOmtelVQQ4YSlfUvEYhxTVls6ME-CbuQXlsSepAKHxy3wFXG_GllIdabjXpGqXGRmbaZtpBj_hJMLByRZ_4ybUSRS1A1AJg7mqOfJIB4XK2D8LqjQFVQbX7zWp9LrIIiItsUceSrhRM42A5tXkRzShXX59fCn2vH0B7iOPI1dsKpkj3MkeSRKjtgmF7Ye22gd9dpVWV2dvW2yNSquSjECrsAlVX23YFsa7KUdf9jPOJHATKv5LiXiIVXty0Rbx_0xHK2_soPzr1DkXgkMc8oyznFYnOA6ZzUMKIkiagVU8JMkUfF7BGM55eCdaSiIL6I1gz1VjAM_JxupVOh3LGTAvS2S5ZVNWpFQQdQKDy-eX89Xn20-z5WrN3o0vz2-vrle3F9c3V9AD_IDVWVBnF3X-NaRqr35PWFRFqHzMS9-gq3gQ_Il5d1t4ot54PgPTob-ATiPHUzL-RiPviZhH_KJgGIhGOoq94MIT5Xgl2qDAUo7nccNQrS-MeSSL4ZCsRw3KNMdCG2cZNEEqEioy2nt5nEFm2UdRFcpJgZ5CftzHmzKs5XMhNHqjHFaeFyKsWJWIpRrCJFxQrDZyh3m0ExgYZiyfyGajqrbPAIgAyp_y8AtVOQMDM3bPcXBcPhpSf6N3vRKHkIcivxYx9FRak_6TGq7RVKB4EHX5GLZjlR7t8j4c_jUy-9QAkkpSFuUlTut_FLblQkudZglNKZN5LVW7-e6VbPWQjfRWhq3Bvqb2qnC1nYpgSbGVaPfJXvlWl6qwLdeWql19e6VaLafCtlxXyF0hNHpETG1ZCNYw6oO4geuWzBjS2hXqgM1lawl6L9UEwwXUe4HGPxewNELb_hsbKnrXWhdY88K01gZrHpjW2kDNA9va1rG6wdDC7wCUDYWFMeOuX5U1oBnv-kg2FtsRwB1WaZi9ljXYftsMmNs6fSda-6_W_nC49o9fvvxx7U_0L53ek9zeXhTc68NbZd7If-UCt4Vr2WF8nVOB23o8AAxnu31GD4cjq41FrDq0e9BmemsM4BiNDRJsKYE3KeIkUi1ALkURwipQpHaObWTbx7-2PzkYp7C-XX26eWkmVWvd9hOoReuJrCy74vKCw-F7CH7NOm2E19a-HjB8hlYi72fYYW5Z-HE1HmhbRyJ-U4pXfrNF6IW2536_RBoWAnKvwmL0gWmO4lk_jkgm0YNm7Sxmr5bJmdhm8hDkhyd5I-NkF-iMp5CWFLvlsyKXPB0XkISQXyXgIk5kE57TaqfAi059aXDBNZ_2ykSzTMfV9SWChlhncxF_cxt0zUI6b-5PPQa4RfTq9498uAVAgxv5ga--K1774AlcN_wAHiMivqx9aNoARwrJl1sW-gGULz3yy3tb9Z-ZejAjzA---1_94OTty19-_vXNycnJ6-PXb47fnhz5Wz84fj7yv3EO-FcK_Lt6Lrk0wuP3svq3D_55_htAMi8N)

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

### Contratos e endpoints para consumo da API localmente ou de produção usando interface do swagger - OpenAPI.

* *****LOCAL*****
* *****http://localhost:8080/swagger-ui/index.html*****
* *****PROD*****
* *****https://dslist-production-df92.up.railway.app/swagger-ui/index.html*****

#### A API está protegida por autenticação e autorização via JWT, que tenha autorização de realizar operações de entrada de dados, é necessário que usando o postman, você no endpoint ***/login*** envie um método POST, onde selecionando o ***Body*** e a opção ***x-www-form-urlencoded*** você insira ***email*** e ***senha*** de acesso, como mostra o exemplo abaixo:


Key  | Value
------------ | ---------------
email | guest@guest
password | guest

#### Agora use o ***access_token*** gerado para acessar via ***Bearer*** ***Token.***


