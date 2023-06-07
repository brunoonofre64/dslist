create table tb_belonging (position int4, list_id VARCHAR(36) not null, game_id varchar(36) not null, primary key (game_id, list_id));
create table tb_game (id varchar(36) not null, genre varchar(255), img_url varchar(255), long_description TEXT, platforms varchar(255), score float8, short_description TEXT, title varchar(255), game_year int4, primary key (id));
create table tb_game_list (id VARCHAR(36) not null, name varchar(255), primary key (id));
create table tb_role (id VARCHAR(36) not null, role_name varchar(255), primary key (id));
create table tb_user (id varchar(36) not null, email varchar(50), password varchar(120), primary key (id));
create table tb_user_roles (user_id varchar(36) not null, role_id VARCHAR(36) not null);
alter table tb_belonging add constraint FKrchwdikeu66uky1hf75ym1kh foreign key (list_id) references tb_game_list;
alter table tb_belonging add constraint FK2slybclee7wdfxhfltbvqkgpg foreign key (game_id) references tb_game;
alter table tb_user_roles add constraint FKft1jmfcluls775jqp5142wvl8 foreign key (role_id) references tb_role;
alter table tb_user_roles add constraint FK19t64ocsol5x06fy2cytp7gey foreign key (user_id) references tb_user;
INSERT INTO tb_game_list (id,name) VALUES ('6ba7b810-9dad-11d1-80b4-00c04fd430c8', 'Aventura e RPG');
INSERT INTO tb_game_list (id, name) VALUES ('e902893a-9e23-4314-a63b-6207b5dce5a0','Jogos de plataforma');
INSERT INTO tb_game (id, title, score, game_year, genre, platforms, img_url, short_description, long_description) VALUES ('401edbe8-f5ca-11ed-b67e-0242ac120002','Mass Effect Trilogy', 4.8, 2012, 'Role-playing (RPG), Shooter', 'XBox, Playstation, PC', 'https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/1.png', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Delectus dolorum illum placeat eligendi, quis maiores veniam. Incidunt dolorum, nisi deleniti dicta odit voluptatem nam provident temporibus reprehenderit blanditiis consectetur tenetur. Dignissimos blanditiis quod corporis iste, aliquid perspiciatis architecto quasi tempore ipsam voluptates ea ad distinctio, sapiente qui, amet quidem culpa.');
INSERT INTO tb_game (id, title, score, game_year, genre, platforms, img_url, short_description, long_description) VALUES ('9ca44380-fa7e-4ac0-abd3-8bd00aed3afc','Red Dead Redemption 2', 4.7, 2018, 'Role-playing (RPG), Adventure', 'XBox, Playstation, PC', 'https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/2.png', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Delectus dolorum illum placeat eligendi, quis maiores veniam. Incidunt dolorum, nisi deleniti dicta odit voluptatem nam provident temporibus reprehenderit blanditiis consectetur tenetur. Dignissimos blanditiis quod corporis iste, aliquid perspiciatis architecto quasi tempore ipsam voluptates ea ad distinctio, sapiente qui, amet quidem culpa.');
INSERT INTO tb_game (id, title, score, game_year, genre, platforms, img_url, short_description, long_description) VALUES ('18481bfc-369f-4ea9-b8f3-c08f90e5ef6b','The Witcher 3: Wild Hunt', 4.7, 2014, 'Role-playing (RPG), Adventure', 'XBox, Playstation, PC', 'https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/3.png', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Delectus dolorum illum placeat eligendi, quis maiores veniam. Incidunt dolorum, nisi deleniti dicta odit voluptatem nam provident temporibus reprehenderit blanditiis consectetur tenetur. Dignissimos blanditiis quod corporis iste, aliquid perspiciatis architecto quasi tempore ipsam voluptates ea ad distinctio, sapiente qui, amet quidem culpa.');
INSERT INTO tb_game (id, title, score, game_year, genre, platforms, img_url, short_description, long_description) VALUES ('6931e835-6305-4066-84ea-06d5bcabfd55','Sekiro: Shadows Die Twice', 3.8, 2019, 'Role-playing (RPG), Adventure', 'XBox, Playstation, PC', 'https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/4.png', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Delectus dolorum illum placeat eligendi, quis maiores veniam. Incidunt dolorum, nisi deleniti dicta odit voluptatem nam provident temporibus reprehenderit blanditiis consectetur tenetur. Dignissimos blanditiis quod corporis iste, aliquid perspiciatis architecto quasi tempore ipsam voluptates ea ad distinctio, sapiente qui, amet quidem culpa.');
INSERT INTO tb_game (id, title, score, game_year, genre, platforms, img_url, short_description, long_description) VALUES ('d3960f4b-81e8-4624-b470-0f04a2cfa3ca','Ghost of Tsushima', 4.6, 2012, 'Role-playing (RPG), Adventure', 'XBox, Playstation, PC', 'https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/5.png', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Delectus dolorum illum placeat eligendi, quis maiores veniam. Incidunt dolorum, nisi deleniti dicta odit voluptatem nam provident temporibus reprehenderit blanditiis consectetur tenetur. Dignissimos blanditiis quod corporis iste, aliquid perspiciatis architecto quasi tempore ipsam voluptates ea ad distinctio, sapiente qui, amet quidem culpa.');
INSERT INTO tb_game (id, title, score, game_year, genre, platforms, img_url, short_description, long_description) VALUES ('142f3c6d-3b80-4268-9ecf-c715f4e787af','Super Mario World', 4.7, 1990, 'Platform', 'Super Ness, PC', 'https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/6.png', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Delectus dolorum illum placeat eligendi, quis maiores veniam. Incidunt dolorum, nisi deleniti dicta odit voluptatem nam provident temporibus reprehenderit blanditiis consectetur tenetur. Dignissimos blanditiis quod corporis iste, aliquid perspiciatis architecto quasi tempore ipsam voluptates ea ad distinctio, sapiente qui, amet quidem culpa.');
INSERT INTO tb_game (id, title, score, game_year, genre, platforms, img_url, short_description, long_description) VALUES ('99088ebf-c9de-4e84-9924-50977f935e5e','Hollow Knight', 4.6, 2017, 'Platform', 'XBox, Playstation, PC', 'https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/7.png', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Delectus dolorum illum placeat eligendi, quis maiores veniam. Incidunt dolorum, nisi deleniti dicta odit voluptatem nam provident temporibus reprehenderit blanditiis consectetur tenetur. Dignissimos blanditiis quod corporis iste, aliquid perspiciatis architecto quasi tempore ipsam voluptates ea ad distinctio, sapiente qui, amet quidem culpa.');
INSERT INTO tb_game (id, title, score, game_year, genre, platforms, img_url, short_description, long_description) VALUES ('76aca6b0-222c-4ff8-8f2d-613dfcd557f6','Ori and the Blind Forest', 4, 2015, 'Platform', 'XBox, Playstation, PC', 'https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/8.png', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Delectus dolorum illum placeat eligendi, quis maiores veniam. Incidunt dolorum, nisi deleniti dicta odit voluptatem nam provident temporibus reprehenderit blanditiis consectetur tenetur. Dignissimos blanditiis quod corporis iste, aliquid perspiciatis architecto quasi tempore ipsam voluptates ea ad distinctio, sapiente qui, amet quidem culpa.');
INSERT INTO tb_game (id, title, score, game_year, genre, platforms, img_url, short_description, long_description) VALUES ('33ca655f-a8c9-447e-b58a-1d101c6c9ba1','Cuphead', 4.6, 2017, 'Platform', 'XBox, Playstation, PC', 'https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/9.png', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Delectus dolorum illum placeat eligendi, quis maiores veniam. Incidunt dolorum, nisi deleniti dicta odit voluptatem nam provident temporibus reprehenderit blanditiis consectetur tenetur. Dignissimos blanditiis quod corporis iste, aliquid perspiciatis architecto quasi tempore ipsam voluptates ea ad distinctio, sapiente qui, amet quidem culpa.');
INSERT INTO tb_game (id, title, score, game_year, genre, platforms, img_url, short_description, long_description) VALUES ('134fa957-71dd-4d02-9adb-fa19e2660f3e','Sonic CD', 4, 1993, 'Platform', 'Sega CD, PC', 'https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/10.png', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Delectus dolorum illum placeat eligendi, quis maiores veniam. Incidunt dolorum, nisi deleniti dicta odit voluptatem nam provident temporibus reprehenderit blanditiis consectetur tenetur. Dignissimos blanditiis quod corporis iste, aliquid perspiciatis architecto quasi tempore ipsam voluptates ea ad distinctio, sapiente qui, amet quidem culpa.');
INSERT INTO tb_belonging (list_id, game_id, position) VALUES ('6ba7b810-9dad-11d1-80b4-00c04fd430c8', '401edbe8-f5ca-11ed-b67e-0242ac120002', 0);
INSERT INTO tb_belonging (list_id, game_id, position) VALUES ('6ba7b810-9dad-11d1-80b4-00c04fd430c8', '9ca44380-fa7e-4ac0-abd3-8bd00aed3afc', 1);
INSERT INTO tb_belonging (list_id, game_id, position) VALUES ('6ba7b810-9dad-11d1-80b4-00c04fd430c8', '18481bfc-369f-4ea9-b8f3-c08f90e5ef6b', 2);
INSERT INTO tb_belonging (list_id, game_id, position) VALUES ('6ba7b810-9dad-11d1-80b4-00c04fd430c8', '6931e835-6305-4066-84ea-06d5bcabfd55', 3);
INSERT INTO tb_belonging (list_id, game_id, position) VALUES ('6ba7b810-9dad-11d1-80b4-00c04fd430c8', 'd3960f4b-81e8-4624-b470-0f04a2cfa3ca', 4);
INSERT INTO tb_belonging (list_id, game_id, position) VALUES ('e902893a-9e23-4314-a63b-6207b5dce5a0', '142f3c6d-3b80-4268-9ecf-c715f4e787af', 0);
INSERT INTO tb_belonging (list_id, game_id, position) VALUES ('e902893a-9e23-4314-a63b-6207b5dce5a0', '99088ebf-c9de-4e84-9924-50977f935e5e', 1);
INSERT INTO tb_belonging (list_id, game_id, position) VALUES ('e902893a-9e23-4314-a63b-6207b5dce5a0', '76aca6b0-222c-4ff8-8f2d-613dfcd557f6', 2);
INSERT INTO tb_belonging (list_id, game_id, position) VALUES ('e902893a-9e23-4314-a63b-6207b5dce5a0', '33ca655f-a8c9-447e-b58a-1d101c6c9ba1', 3);
INSERT INTO tb_belonging (list_id, game_id, position) VALUES ('e902893a-9e23-4314-a63b-6207b5dce5a0', '134fa957-71dd-4d02-9adb-fa19e2660f3e', 4);
INSERT INTO tb_user (id ,email, password) VALUES ('b3023e37-a798-44af-b0f5-242d7f6203a5', 'admin@admin', '$2a$12$YBiMBRZIBIyvuS/.N0ArrebyPCoUfgUBtzIn31cp84f77odNj7KDS');
INSERT INTO tb_user (id ,email, password) VALUES ('f0117312-0577-4e66-8cee-9ae09b072a59', 'guest@guest', '$2a$12$w5.ClXkJqT8RAExDWFd01Or/S9AyIIytgHfWZDloA5clWqXPxoHqi');
INSERT INTO tb_role (id ,role_name) VALUES ('abf7e5e1-623a-4d74-b3dc-d8c440504dd2', 'ROLE_ADMIN');
INSERT INTO tb_role (id ,role_name) VALUES ('2067e2de-8b13-450a-a8ea-7a614d64f68d', 'ROLE_USER');
INSERT INTO tb_user_roles (user_id ,role_id) VALUES ('b3023e37-a798-44af-b0f5-242d7f6203a5', 'abf7e5e1-623a-4d74-b3dc-d8c440504dd2');
INSERT INTO tb_user_roles (user_id ,role_id) VALUES ('f0117312-0577-4e66-8cee-9ae09b072a59', '2067e2de-8b13-450a-a8ea-7a614d64f68d');
