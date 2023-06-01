create table address (
    address_id serial primary key,
    street varchar(255),
    city varchar(50),
    state varchar(50),
    country varchar(50),
    person_id serial
);

create table dog (
    dog_id serial primary key,
    name varchar(255),
    birth_date date,
    breed varchar(255),
    size varchar(10),
    personality varchar(10),
    gender varchar(6),
    person_id serial
);

create table person (
    person_id serial primary key,
    name varchar(255),
    birthdate date,
    email varchar(255),
    phone varchar(50),
    location varchar(255),
    gender varchar(10)
);