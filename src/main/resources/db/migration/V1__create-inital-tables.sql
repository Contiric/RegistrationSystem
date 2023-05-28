create table address (
    address_id serial primary key,
    street varchar(255),
    city varchar(50),
    state varchar(50),
    country varchar(50)
);

create table dog (
    dog_id serial primary key,
    name varchar(255),
    birthdate date,
    breed varchar(255),
    size varchar(10),
    personality varchar(10),
    gender varchar(6)
);

create table person (
    person_id serial primary key,
    name varchar(255),
    birthdate date,
    email varchar(255),
    phone varchar(50),
    location varchar(255),
    gender varchar(10),
    address_id serial,
    dog_id serial,
    constraint FK_person_address foreign key (address_id) references address(address_id),
    constraint FK_person_dog foreign key (dog_id) references dog(dog_id)
);