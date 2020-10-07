create database camionero;
use camionero;

create table driver
(
    dni              int         not null primary key unique,
    first_name       varchar(30) not null,
    last_name        varchar(30) not null,
    birth_date       date        null,
    license_category varchar(30) null,
    cellphone        varchar(30) null unique
)
    comment 'Tabla de choferes';

create table truck
(
    plate_number  int         not null
        primary key,
    brand         varchar(30) null,
    model         varchar(30) null,
    max_tons      int         null,
    tank_capacity int         null
        comment 'Capacidad el tanque en litros',
    consumption   int         null
        comment 'Consummo de nafta en km/L'
)
    comment 'Tabla de camiones';

create table truck_drivers
(
    driver_dni         int not null
        references driver (dni),
    truck_plate_number int not null
        references truck (plate_number)
)
    comment 'Relacion entre camiones y choferes';

create index truck_drivers_index
    on truck_drivers (driver_dni, truck_plate_number);

create table trip
(
    trip_id            serial
        primary key,
    driver_dni         int         not null,
    truck_plate_number int         not null,
    from_location      varchar(30) not null,
    to_location        varchar(30) not null,
    start              date,
    end                date,
    constraint trip_truck_drivers_fk
        foreign key (driver_dni, truck_plate_number) references truck_drivers (driver_dni, truck_plate_number)
)
    comment 'Tabla de viajes';

create index trip_truck_plate_number_index
    on trip (truck_plate_number);

create index trip_driver_dni_index
    on trip (driver_dni);

create table user
(
    user_name varchar(30) not null
        primary key,
    password  varchar(30) not null,
    dni       int unique  not null,
    admin     boolean     not null default false
)

