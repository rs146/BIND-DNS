DROP DATABASE IF EXISTS BIND_DB_Web;

create database BIND_DB_Web;

use BIND_DB_Web;

CREATE TABLE roles (
     id int NOT NULL AUTO_INCREMENT,
     role varchar(25) NOT NULL,
     PRIMARY KEY(id)
);

CREATE TABLE users (
    id int not null auto_increment,
    login varchar(20) not null,
    password varchar(30) not null,
    primary key(id)
);

create table user_roles (
    user_id int not null,
    role_id int not null,
    foreign key (user_id) references users(id),
    foreign key (role_id) references roles(id)
);

INSERT INTO roles(role) VALUES ('ROLE_ADMIN');
INSERT INTO roles(role) VALUES ('ROLE_USER');

insert into users (login, password) VALUES ('User', SHA1('test'));
insert into users (login, password) VALUES ('Admin', SHA1('admin'));

insert into user_roles VALUES (1, 2), (2, 1);
