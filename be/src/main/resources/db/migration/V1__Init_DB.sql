create table hibernate_sequence (next_val bigint);

insert into hibernate_sequence values ( 1 );

insert into hibernate_sequence values ( 1 );

insert into hibernate_sequence values ( 1 );

create table flights (
    id integer not null,
    arrival_time datetime not null,
    aviaoperator varchar(255) not null,
    departure_time datetime not null,
    from_place varchar(255) not null,
    to_place varchar(255) not null,
    transfers bit,
    primary key (id)
);

create table roles (
    id integer not null,
    rolename varchar(255) not null,
    primary key (id)
);

create table tickets (
    id integer not null auto_increment,
    luggage bit,
    price decimal(19,2) not null,
    type_of_seat varchar(255) not null,
    flight_id integer,
    user_id integer,
    primary key (id)
);

create table users (
    id integer not null,
    email varchar(255) not null,
    firstname varchar(255) not null,
    password varchar(255) not null,
    surname varchar(255) not null,
    username varchar(255) not null,
    role_id integer,
    primary key (id)
);

alter table tickets
    add constraint tickets_flights_fk
    foreign key (flight_id) references flights (id);

alter table tickets
    add constraint tickets_users_fk
    foreign key (user_id) references users (id);

alter table users
    add constraint users_roles_fk
    foreign key (role_id) references roles (id);