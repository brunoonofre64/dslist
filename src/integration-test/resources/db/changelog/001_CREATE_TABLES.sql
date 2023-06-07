--SCRIPTS QUE VAO RODAR APENAS EM MEMORIA USANDO H2 DATABASE, PARA RODAR TESTES DE INTEGRACAO

DROP SEQUENCE if EXISTS sq_game;
DROP SEQUENCE if EXISTS sq_game_list;
DROP SEQUENCE if EXISTS sq_user;
DROP SEQUENCE if EXISTS sq_role;

CREATE SEQUENCE sq_game START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE sq_game_list START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE sq_user START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE sq_role START WITH 1 INCREMENT BY 1;

DROP TABLE IF EXISTS tb_game;
DROP TABLE IF EXISTS tb_game_list;
DROP TABLE IF EXISTS tb_belonging;
DROP TABLE IF EXISTS tb_user;
DROP TABLE IF EXISTS tb_role;
DROP TABLE IF EXISTS tb_user_roles;

CREATE TABLE tb_game
(
    id                VARCHAR(36),
    title             VARCHAR(255),
    score             DOUBLE,
    game_year         INTEGER,
    genre             VARCHAR(255),
    platforms         VARCHAR(255),
    img_url           VARCHAR(255),
    short_description TEXT,
    long_description  TEXT,
    PRIMARY KEY (id)
);


CREATE TABLE tb_game_list
(
    id   VARCHAR(36),
    name VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE tb_belonging
(
    game_id  VARCHAR(36),
    list_id  VARCHAR(36),
    position INTEGER,
    PRIMARY KEY (game_id, list_id),
    FOREIGN KEY (game_id) REFERENCES tb_game (id),
    FOREIGN KEY (list_id) REFERENCES tb_game_list (id)
);

CREATE TABLE tb_role
(
    id        VARCHAR(36),
    role_name VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE tb_user
(
    id       VARCHAR(36),
    email    VARCHAR(50),
    password VARCHAR(120),
    PRIMARY KEY (id)
);

CREATE TABLE tb_user_roles
(
    user_id VARCHAR(36),
    role_id VARCHAR(36),
    FOREIGN KEY (user_id) REFERENCES tb_user (id),
    FOREIGN KEY (role_id) REFERENCES tb_role (id)
);