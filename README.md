# Projeto DSLIST | DSLIST Project 🍃

### O objetivo do projeto é desenvolver uma API baseada em padrões REST, que oferece quatro endpoints para buscar dados de jogos previamente armazenados em um banco de dados. Para o deployment do projeto, foi utilizado o serviço [Railway](https://railway.app) na nuvem. Além disso, o projeto foi configurado com um fluxo de integração e entrega contínua (CI/CD) através de um repositório no Github.
### Com o conceito de CI/CD, cada push realizado na branch main do repositório desencadeia automaticamente uma esteira de construção e deployment. Isso significa que, sempre que houver uma atualização no código-fonte, o sistema entrará em ação, construindo a aplicação e implantando-a no ambiente configurado.
### O CI/CD permite automatizar e agilizar o processo de desenvolvimento, garantindo a qualidade do software por meio de testes automatizados e assegurando que as mudanças no código sejam entregues ao ambiente de produção de forma rápida e confiável. Com essa abordagem, é possível evitar erros e inconsistências, além de facilitar a manutenção e a evolução do projeto ao longo do tempo.


###### English

### The project's goal is to develop an API based on REST standards, which offers four endpoints to fetch game data previously stored in a database. For the deployment of the project, the Railway service in the cloud was used. In addition, the project was configured with a continuous integration and delivery (CI/CD) flow through a Github repository. The project's goal is to develop an API based on REST standards, which offers four endpoints to fetch game data previously stored in a database. For the deployment of the project, the Railway service in the cloud was used. In addition, the project was configured with a continuous integration and delivery (CI/CD) flow through a Github repository.
### With the CI/CD concept, each push performed on the main branch of the repository automatically triggers a build and deployment treadmill. This means that whenever there is an update to the source code, the system will jump into action, building the application and deploying it to the configured environment.
### CI/CD allows you to automate and streamline the development process, ensuring software quality through automated testing and ensuring that code changes are delivered to the production environment quickly and reliably. With this approach, it is possible to avoid errors and inconsistencies, in addition to facilitating the maintenance and evolution of the project over time.




#### Versões usadas no projeto | Project Versions Used
###### - java - 11
###### - Spring Boot - 2.6.7 🍃

===========================================================================

### Para rodar o projeto localmente sem estar em ambiente docker, faça o seguinte: 
### To run the project locally without being in a docker environment, do the following:

#### Certifique-se de ter os seguintes pré-requisitos instalados:
#### Make sure you have the following prerequisites installed:


* JDK 11 [Dowload JDK](https://www.oracle.com/java/technologies/downloads/#java11)
* Clone o repositório do projeto: | Clone the project repository:
* Clone HTTPS: https://github.com/brunoonofre64/dslist.git
* Abra o projeto em sua IDE favorita (por exemplo, IntelliJ IDEA, Eclipse) | Open the project in your favorite IDE (e.g. IntelliJ IDEA, Eclipse) 
* Certifique-se de que o JDK 11 esteja configurado como o JDK do projeto | Make sure JDK 11 is set as the project's JDK

#### Executando o projeto | running the project
* No diretório raiz do projeto, compile e construa o projeto usando o seguinte comando: | In the root directory of the project, compile and build the project using the following command:

 *****./mvnw clean install*****

* Após a conclusão bem-sucedida do comando acima, você pode executar o projeto usando o seguinte comando: | After successful completion of the above command, you can run the project using the following command: 

*****./mvnw spring-boot:run*****

* Isso iniciará o projeto Spring Boot e ele estará acessível localmente. | This will launch the Spring Boot project and it will be locally accessible.

*****http://localhost:8080*****

* O projeto está configurado para usar o banco de dados H2 incorporado. Durante a execução, você pode acessar o console do H2 para visualizar e gerenciar o banco de dados. | The project is configured to use the embedded H2 database. While running, you can access the H2 console to view and manage the database.
  
URL do Console do H2: *****http://localhost:8080/h2-console*****

===========================================================================

### Para rodar o projeto em container local, usando DOCKER | To run the project in local container, using DOCKER

* No diretório raiz do projeto, abra um terminal e execute o seguinte comando cd docker para acessar o diretorio raiz do docker-compose.yml após entrar no diretório execute o seguinte comando: | In the root directory of the project, open a terminal and run the following command cd docker to access the root directory of docker-compose.yml after entering the directory run the following command:

*****docker-compose***** *****up*****

* Isso iniciará o projeto Spring Boot e ele estará acessível localmente. | This will launch the Spring Boot project and it will be locally accessible.

*****http://localhost:8080*****

### Aqui está um tutorial para acessar o banco de dados PostgreSQL via navegador usando o PgAdmin:
### Here is a tutorial to access PostgreSQL database via browser using PgAdmin:

* Aguarde até que os contêineres sejam iniciados com êxito. Verifique se os contêineres dev-postgresql e dev-pgadmin estão em execução usando o seguinte comando: | Wait until the containers start successfully. Check that the dev-postgresql and dev-pgadmin containers are running using the following command:

*****docker***** *****ps*****

* Abra um navegador da web e acesse a seguinte URL para acessar o PgAdmin: | Open a web browser and go to the following URL to access PgAdmin:

*****http://localhost:5050*****

* Faça login usando as seguintes credenciais: | Log in using the following credentials:

*****Email:***** *****me@example.com*****

*****Password:***** *****1234567*****

* Após fazer login no PgAdmin, você precisará adicionar um servidor para conectar-se ao banco de dados PostgreSQL. Siga as etapas abaixo: | After logging into PgAdmin, you will need to add a server to connect to the PostgreSQL database. Follow the steps below:

1. Clique em "Add New Server" (Adicionar novo servidor) no painel do PgAdmin. | Click "Add New Server" in the PgAdmin panel.
2. Na guia "General" (Geral), defina um nome para o servidor (por exemplo, "My PostgreSQL Server"). | In the "General" tab, define a name for the server (eg "My PostgreSQL Server").
3. Na guia "Connection" (Conexão), configure as seguintes informações: | On the "Connection" tab, configure the following information:

* Host name/address (Nome do host/endereço): dev-postgresql | Host name/address: dev-postgresql
* Port: 5432
* Nome de usuário (username): postgres
* Senha (password): 1234567
* Clique em "Save" (Salvar) | Clico on save

### Agora você pode explorar o banco de dados PostgreSQL usando o PgAdmin por meio do navegador. Certifique-se de que os contêineres estejam em execução sempre que desejar acessar o PgAdmin.
### You can now explore the PostgreSQL database using PgAdmin through the browser. Make sure the containers are running whenever you want to access PgAdmin.

===========================================================================

DEPENDÊNCIAS -  DEPENDENCIES | REFERÊNCIA - REFERENCE
------------ | ---------------
SPRING WEB | https://mvnrepository.com/artifact/org.springframework/spring-web/
LOMBOK | https://mvnrepository.com/artifact/org.projectlombok/lombok/
JPA | https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa/
DEV TOOLS | https://spring.io/blog/2015/06/17/devtools-in-spring-boot-1-3
H2 DATABASE | http://www.h2database.com/html/build.html

===========================================================================




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
===========================================================================


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

===========================================================================




### Contratos e endpoints para consumo da API localmente ou de produção.
### Contracts and endpoints for on-premise or production API consumption.

RESPOSTA - RESPONSE | END POINT                                                                                                            | MÉTODO / METHOD HTTP | DETALHES / DETAILS
-------- |----------------------------------------------------------------------------------------------------------------------|----------------------| -------
JSON - 1  | LOCAL http://localhost:8080/games/{uuid} PROD https://dslist-production-df92.up.railway.app/games/{uuid}             | GET                 | Busca um game por uuid / Search game by uuid.
JSON - 2  | LOCAL http://localhost:8080/games PROD https://dslist-production-df92.up.railway.app/games                           | GET                  | Traz a lista de games / Bring the list of games.
JSON - 3  | LOCAL http://localhost:8080/lists PROD https://dslist-production-df92.up.railway.app/lists                           | GET                  | Traz a lista de listas de games / Brings the list of game lists.
JSON - 4  | LOCAL http://localhost:8080/lists/{uuid}/games PROD https://dslist-production-df92.up.railway.app/lists/{uuid}/games | GET               | Recebe o uuid de uma lista de games e traz todos os games dessa lista especificada / Receives the uuid of a list of games and brings all the games from that specified list

#### json 1

![JSON - 1](images/JSON1.png)

#### json 2
![JSON - 2](images/JSON2.png)

#### json 3 
![JSON - 3](images/JSON3.png)

#### json 4
![JSON - 4](images/JSON4.png)



