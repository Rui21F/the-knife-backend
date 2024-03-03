/*DROP DATABASE IF EXISTS theknife;
CREATE DATABASE theknife;
USE theknife;

CREATE TABLE owner (
    id   INTEGER AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE restaurant_type (
    type VARCHAR(20),
    PRIMARY KEY (type)
);

CREATE TABLE city (
    name VARCHAR(20),
    PRIMARY KEY (name)
);

CREATE TABLE restaurant (
    id              INTEGER AUTO_INCREMENT,
    owner_id        INTEGER     NOT NULL,
    name            VARCHAR(20) NOT NULL,
    city        VARCHAR(20) NOT NULL,
    restaurant_type VARCHAR(20) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (owner_id) REFERENCES owner (id),
    FOREIGN KEY (restaurant_type) REFERENCES restaurant_type (type),
    FOREIGN KEY (city) REFERENCES city (name)
);

CREATE TABLE client (
    id    INTEGER AUTO_INCREMENT,
    name  VARCHAR(20) NOT NULL,
    email VARCHAR(20) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

CREATE TABLE reservation (
    client_id     INTEGER   NOT NULL,
    restaurant_id INTEGER   NOT NULL,
    time_slot     TIMESTAMP NOT NULL,
    PRIMARY KEY (client_id, time_slot),
    FOREIGN KEY (client_id) REFERENCES client (id),
    FOREIGN KEY (restaurant_id) REFERENCES restaurant (id)
);*/
/*INSERT INTO restaurant_type (type)
VALUES ('Mexicano'),
       ('Fast Food'),
       ('Italian'),
       ('Chinese'),
       ('Mexican');

INSERT INTO city (name)
VALUES ('Porto'),
       ('Lisbon'),
       ('Faro'),
       ('Guimaraes'),
       ('Coimbra');*/
INSERT INTO client (name, email)
VALUES ('Rui', 'rui@gmail.com'),
       ('Mekie', 'meekie@gmail.com'),
       ('Silvestres Estalonge', 'silvas@example.com'),
       ('Hermenegildo Jesus', 'hermes@example.com'),
       ('Ze Naifas', 'naifas@example.com'),
       ('Fernando Mendes', 'mendes@precocerto.pt');


INSERT INTO owner (name)
VALUES ('Mafalda'),
       ('John Smith'),
       ('Sarah Johnson'),
       ('Michael Davis');


INSERT INTO restaurant (owner_id, name)
VALUES (1, 'Nachos'),
       (1, 'Burger Palace'),
       (2, 'Pasta Paradise'),
       (3, 'Golden Wok');

