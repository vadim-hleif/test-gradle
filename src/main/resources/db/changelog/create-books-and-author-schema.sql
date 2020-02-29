--liquibase formatted sql

--changeset vgleyf:2
create table test2 (
    id int primary key,
    name varchar(255)
);