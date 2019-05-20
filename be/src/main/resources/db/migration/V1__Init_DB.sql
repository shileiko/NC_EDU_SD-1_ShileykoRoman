create table hibernate_sequence (next_val bigint);

insert into hibernate_sequence values ( 1 );

insert into hibernate_sequence values ( 1 );

insert into hibernate_sequence values ( 1 );

create table flights (
    id integer not null auto_increment,
    arrival_time datetime not null,
    aviaoperator varchar(255) not null,
    departure_time datetime not null,
    from_place varchar(255) not null,
    to_place varchar(255) not null,
    transfers bit,
    ticketskol integer not null,
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

insert into roles (id, rolename)
    values (1, 'ADMIN'), (2, 'USER');

insert into flights (
    id,
    arrival_time,
    aviaoperator,
    departure_time,
    from_place,
    to_place,
    transfers,
    ticketskol) values
        (1, '2019-07-09 23:30:00', 'Belavia', '2019-07-09 19:00:00', 'Minsk', 'Milan', 0, 10),
        (2, '2019-08-09 10:30:00', 'Aeroflot', '2019-08-10 19:30:00', 'Moscow', 'LosAngeles', 0, 10),
        (3, '2019-07-15 10:10:00', 'Turkish Airlines', '2019-07-15 05:30:00', 'Stanbul', 'Minsk', 0, 10),
        (4, '2019-07-15 06:10:00', 'Belavia', '2019-07-15 01:25:00', 'Milan', 'Minsk', 0, 10),
        (5, '2019-08-03 18:30:00', 'Polish Airlines', '2019-08-03 15:00:00', 'Warsaw', 'Madrid', 0, 10),
        (6, '2019-09-16 14:02:00', 'Aeroflot', '2019-09-16 04:30:00', 'Moscow', 'Tokyo', 0, 10),
        (7, '2019-07-25 09:50:00', 'Aeroflot', '2019-07-26 07:22:00', 'New-York', 'Moscow', 0, 10),
        (8, '2019-10-03 14:15:00', 'Ryanair', '2019-10-03 11:30:00', 'Vilnius', 'Tenerife', 0, 10),
        (9, '2019-08-13 10:17:00', 'SpainAir', '2019-08-13 22:30:00', 'Madrid', 'Warsaw', 0, 10),
        (10, '2019-10-05 04:50:00', 'Ryanair', '2019-10-06 23:25:00', 'Tenerife', 'Vilnius', 0, 10);
