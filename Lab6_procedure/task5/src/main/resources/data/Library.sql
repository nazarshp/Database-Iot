CREATE SCHEMA IF NOT EXISTS hotel_model;
USE hotel_model;

create table if not exists client
(
    id           int auto_increment
    primary key,
    name         varchar(45) not null,
    surname      varchar(45) not null,
    phone_number varchar(12) not null,
    email        varchar(45) null,
    birthday     date        null,
    gender       varchar(25) null
);

create table if not exists hotel
(
    id         int auto_increment
    primary key,
    name       varchar(45) not null,
    phone      varchar(12) not null,
    hotel_code varchar(45) null
);

create table if not exists location
(
    id       int auto_increment
    primary key,
    street   varchar(45) not null,
    city     varchar(45) not null,
    hotel_id int         not null,
    constraint FK_location_hotel
    foreign key (hotel_id) references hotel (id)
);

create table if not exists reserved
(
    id        int auto_increment
    primary key,
    from_date date not null,
    to_date   date not null,
    client_id int  not null,
    constraint FK_reserved_client
    foreign key (client_id) references client (id)
);

create table if not exists payment
(
    id          int auto_increment
    primary key,
    date        date  not null,
    suma        float not null,
    reserved_id int   not null,
    constraint FK_payment_reserved
    foreign key (reserved_id) references reserved (id)
);

create table if not exists review
(
    id          int auto_increment
    primary key,
    raiting     varchar(45)  null,
    description varchar(200) null,
    date        date         not null,
    client_id   int          not null,
    hotel_id    int          not null,
    constraint FK_review_client
    foreign key (client_id) references client (id),
    constraint FK_review_hotel
    foreign key (hotel_id) references hotel (id)
);

create table if not exists room
(
    id          int auto_increment
    primary key,
    hotel_id    int           not null,
    number      varchar(1000) not null,
    type        varchar(45)   not null,
    floor       int           null,
    reserved_id int           not null,
    price       decimal       not null,
    constraint FK_room_hotel
    foreign key (hotel_id) references hotel (id),
    constraint FK_room_reserved
    foreign key (reserved_id) references reserved (id)
);
