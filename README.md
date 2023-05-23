# Projeto DSLIST 🍃

###### ENGLISH VERSION - [README_EN](https://github.com/brunoonofre64/dslist/blob/master/README_EN.md)

### Em resumo, o projeto consiste em uma API cujo objetivo é buscar informações sobre jogos no sistema. A API oferece funcionalidades como a busca de jogos por ID, a obtenção de uma lista completa de jogos e a recuperação de todos os jogos pertencentes a uma lista específica.

##### O objetivo do projeto é desenvolver uma API baseada em padrões REST, que oferece quatro endpoints para buscar dados de jogos previamente armazenados em um banco de dados. Para o deployment do projeto, foi utilizado o serviço [Railway](https://railway.app) na nuvem. Além disso, o projeto foi configurado com um fluxo de integração e entrega contínua (CI/CD) através de um repositório no Github.
##### Com o conceito de CI/CD, cada push realizado na branch main do repositório desencadeia automaticamente uma esteira de construção e deployment. Isso significa que, sempre que houver uma atualização no código-fonte, o sistema entrará em ação, construindo a aplicação e implantando-a no ambiente configurado.
##### O CI/CD permite automatizar e agilizar o processo de desenvolvimento, garantindo a qualidade do software por meio de testes automatizados e assegurando que as mudanças no código sejam entregues ao ambiente de produção de forma rápida e confiável. Com essa abordagem, é possível evitar erros e inconsistências, além de facilitar a manutenção e a evolução do projeto ao longo do tempo.


#### Versões usadas no projeto 
###### - java - 11
###### - Spring Boot - 2.6.7 🍃

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




```````mermaid
---
title: DSLIST DIAGRAMA - ER
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
title: DSLIST FLUXO DAS REQUISIÇÕES
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




### Contratos e endpoints para consumo da API localmente ou de produção usando interface do swagger - OpenAPI.

* *****LOCAL*****
* *****http://localhost:8080/swagger-ui/index.html*****
* *****PROD*****
* *****https://dslist-production-df92.up.railway.app/swagger-ui/index.html*****



