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

#### Executando o projeto | running the project
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

### Agora você pode explorar o banco de dados PostgreSQL usando o PgAdmin por meio do navegador. Certifique-se de que os contêineres estejam em execução sempre que desejar acessar o PgAdmin.

### Mas você também tem a opção de consumir os endpoints públicos que estão puclidados no railway, pode verificar os endpoints logo mais a baixo desta documentação.

===========================================================================

DEPENDÊNCIAS  | REFERÊNCIA
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

##### Voce também pode acessar o diagrama de classes abaixo clicando aqui [MERMAID_DIAGRAM](https://mermaid.live/edit#pako:eNrtWG1P4zgQ_iuW9wt7UARLSyGqKgFld3u3BUSLTnuqhEziltwmdmQ7sF2O_35jJ00c17S9lw_34UCCZGaeefeM2xcc8ojiAIcJkXIQk7kg6ZQh-DEU9Imk9JKpWC3QS0HXPy0URwEaKxGzuU0FuYT6GDLkAhgDnj8k1GYsKBEBGjJF51TYjDllwqsqS4iacZFKHzNO53ci8XrwyIUaUBmKOFMxZz6ZhLP5myKvU-Ym5kss1fbJYYBYq_KcageAe_NLU9_cIOtSuDztR-B4tN6Cz-uH2nxg-9JIPpdxkZpGyTy5GUyu_-8Yb8dsmZmN7aL1jWL2TxP9Zj7_bmYcN3_OyC01fcNFo-N6vRiMihkJab9fk2-g4HGIUqoeeSSR4igDISgfIuji9m7wZi7-kpVdJCHu8PF8oUuyk8CfYZW39wHS1F6Z4RvBf6ehDrShYBaz6HwxjHZiG-ieUuNoswGajjoOWvLVGdwWsOKvR3wXzgmEuvO-fJzovqjevkJSqpehaYDqdexUXTMc42MqnuKQarNFfs4SwDezCf3aX7L96QMJC19UCOTW1qjQ6kn2RpfKI9n3luuCMyV4klDxX4ppG6_eDOtSCC5uqcw4kyYtLUQ1qT7EelikVCqSZqCQhyQZEEUnQNM8pG8MY0VUDvMUWsvQQFySuTNfvCf1AtCjQrp5TCnLUyqIOWbWObsc3Uy-3n8Zjic17dPZ6PL-6npy__H67mpQ09-hJ5LkvqlZhv49pKZ1PxMWldkrHmWRAxg3j4I_M_SwgCeKzm6GECIMHhhBkjOSxD9ohJ7JolGW25zphFXal3F95AKJgleqb8Au00yZPnCB7-p0WtkyLHMQS4Iud7rkOV1yxdVHnrPoX1Y9kLphz7IMJrSpVBlpr2fR-v2y8rsoJbE7JkoL57lOOzTyLJ6jSkvxnje7YBfRZRTQtjwXYYkuVY0NSbt8CwOTRAQuDGsEg4Y742cyh723pSMki7WdAQ-_UVUQW5o4ZDOuGWfFY8PCr_RhK-0tOFhCXosYJr5zU9k1rCWKCm0K1I6ewppW2rTu663WH_3m9g3gBCjKIlnIWWvFyNZYuA-kWUJTypRcarUuuxs1O1uu0l7rcC24N9O1JnyL0QAcLb4wfG41dqZuI5ULViGWG6QSt30aMg2ro14RbqaiBhQQa5JXiFLFqm6fsGXT1V27stxAVmgegWLjODLNmOw77EqeylsPPpziVmuKD_b3f5ric_tDxWci3V4y4midvFPTSv-hT3jKVmZ8q9V3VrmWNUN_jXQz3xYCMI0FqgGuFvj4lMdJZFaIVCIPIU_UQFdHvsa7C8Q5TavDfAPIa6gH5Vt1tIrLb2gD6M2IrOXiNJQ_GL88TL-VjYPq3rfro59h2cgNELesNUz_-naT9m5Fo_58TADQ3B5rRes1sFYM72G4BcHejHCAzcKYYmgjuHrhAB4jIr5NMcx6kCO54uMFC3EALUb3cJ5FcE0rv8PBwYwkEqgZYTh4wd9xcNjdPz44Pjk-6Zyenh6fdtp7eIGDk6P99tFBu_2hc9TuHH_onL7u4R-cg4KD_W73oNPptNvdk6NOp9vuGm2_GWZhkkZ6qo3Kr5D0v9c_AfZ7Kyk)

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



### Contratos e endpoints para consumo da API localmente ou de produção usando interface do swagger - OpenAPI.

* *****LOCAL*****
* *****http://localhost:8080/swagger-ui/index.html*****
* *****PROD*****
* *****https://dslist-production-df92.up.railway.app/swagger-ui/index.html*****



