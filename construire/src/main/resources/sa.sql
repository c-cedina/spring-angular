create database SA;
create TABLE CLIENT (
    ID integer primary key not null AUTO_INCREMENT,
    Email varchar(50) UNIQUE
);

create TABLE SENTIMENT (
    ID integer primary key not null AUTO_INCREMENT,
    Texte varchar(50),
    TYPE varchar(10),
    CLIENT_ID integer,
    constraint client_fk FOREIGN KEY (CLIENT_ID) REFERENCES CLIENT(ID)
);
