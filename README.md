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

##### Voce também pode acessar o diagrama de classes abaixo clicando aqui [MERMAID_DIAGRAM](https://mermaid.live/view#pako:eNrtWG1P4zgQ_iuW9wt7UNTeLtwSVZWAwm7vtoBo0WlPlZBJTMltYke2A9vl-O83dtLEdk3be_lwHw4kSGbmmXfPuH3GMU8ojnCcESmHKZkLks8Ygh9DQR9JTs-YStUCPVd0_dNBaRKhiRIpm9tUkMtoiCFjLoAx5OVdRm3GghIRoRFTdE6FzZhTJoKqioyoey5yGWKm-fxGZEEPHrhQQypjkRYq5Swkk3E2f1XkZcb8xHxOpdo-OQwQa1WeUO0AcK9-cfXNDbIthc_TfkSeR-sthLy-a81Hti9O8rlMq9Q4JQvkZji9_L9jgh2zZWY2tovWN07ZP030q_n8u5nx3Py5INfU9A0XTsf1-ykYFfckpoNBS76Cgqcxyql64IlEiqMChKB8iKDT65vhq7n4S1Z2kYS444eThS7JTgZ_Rk3e3kZIU_t1hq8E_53GOlBHwX3KkpPFKNlJbaB_So2jbgO4jnoOWvLNGdwWsOJvQHwXzgmEuvO2fpzqvmjevkBSmpeRaYDmdeJVXTM84xMqHtOYarNVfo4zwLvZhH4dLNnh9IGEha8qBHJra1RpDSR7o0v1kRwEy3XKmRI8y6j4L8W0jVevhnUmBBfXVBacSZOWDqKa1B5iPSxyKhXJC1DIY5INiaJToGke0jeGiSKqhHkKrWVoIC7J3JsvwZN6CuhxJe0eU8rKnApijpl1zs7GV9Mvt59Hk2lL-3g8Pru9uJzenl_eXAxb-hv0SLIyNDXr0L_F1LTuJ8KSOnvVo6xyAOPmQfAnhu4W8ETR8dUIQoTBAyNIckay9DtN0BNZOGW5LplOWKN9Gdc5F0hUvFq9AzvLC2X6wAe-adNpZcuwzEGsCbrc-ZLndckFV-e8ZMm_rHoodcMeFwVMaFOpOtJ-36INBnXld1FOUn9M1BZOSp12aOT7dI4aLdV76XbBLqLLKKBteSniGl2rmhiSdvkaBiZJCFwY1ghGjjuTJzKHvbelI6RItZ0hj79SVRE7mjhi91wzjqtHx8Kv9G4r7R04WEJeihQmvndT2TWsJYoKbQrUjh_jllbbtO7rnc4fA3f7RnACFGWJrOSstWJkWyzcB_IiozllSi61WpfdjZq9Lddob3X4Fvyb6VoTocVoAJ6WUBght5ydqdtIlYI1iOUGacRtn0ZMw9qoV4TdVLSACmJN8gZRq1jVHRK2bPq6W1eWG8gKLSBQbRxPxo3JvsOu5Km-9eDeDHc6M9zd3_9hhk_sDxWfiPR7yYijdfJeTRv9vZDwjK3M-E5n4K1yLWuG_hppN98WAjDOAtUAXwt8fCrTLDErRCpRxpAnaqCrI1_j_QXinabVYb4BFDTUh_KtOtrEFTa0AfRqRNZy8RoqHExYHqbfysZBbe_b9dHPsGzkBohf1hamf0O7SXu3olF_PiYAcLfHWtF2DawVw3sYbkGwNxMcYbMwZhjaCK5eOILHhIivMwyzHuRIqfhkwWIcQYvRPVwWCVzT6u9wlsSCMBw94284Ojw83D86PHj37t373k8fDnp7eIGj3o_d_aPeUfeo23t_cNA9-nD4soe_cw747v6Bgf9m3iptNNFTbFx_ZaT_vfwJno8nqQ)

````mermaid
---
title: DIAGRAMA DE CLASSES
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


