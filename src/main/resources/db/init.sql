use camionero;

-- insert an admin user
insert into user (user_name, password, admin, dni)
values ('juanma', 'password', true, 0);

-- insert driver user 1
insert into user (user_name, password, dni)
values ('driver1', 'password', 1);

-- insert driver user 2
insert into user (user_name, password, dni)
values ('driver2', 'password', 2);


INSERT INTO camionero.driver (dni, first_name, last_name, birth_date, license_category, cellphone) VALUES (1, 'Homero', 'Simpsons', '2020-10-22', 'HEAVY', '1');
INSERT INTO camionero.driver (dni, first_name, last_name, birth_date, license_category, cellphone) VALUES (2, 'Marge', 'Simpsons', '2020-10-01', 'MEDIUM', '2');
INSERT INTO camionero.driver (dni, first_name, last_name, birth_date, license_category, cellphone) VALUES (3, 'Bart', 'Simpsons', '2020-10-16', 'LIGHT', '3');
INSERT INTO camionero.driver (dni, first_name, last_name, birth_date, license_category, cellphone) VALUES (4, 'lisa', 'Simpsons', '2020-10-16', 'LIGHT', '4');

INSERT INTO truck (plate_number, brand, model, max_tons, tank_capacity, consumption)
VALUES (1, 'fiat', null, 0, 0, 0);
INSERT INTO truck (plate_number, brand, model, max_tons, tank_capacity, consumption)
VALUES (2, 'fiat', null, 0, 0, 0);

INSERT INTO camionero.truck_drivers (driver_dni, truck_plate_number) VALUES (1, 1);
INSERT INTO camionero.truck_drivers (driver_dni, truck_plate_number) VALUES (1, 2);
INSERT INTO camionero.truck_drivers (driver_dni, truck_plate_number) VALUES (1, 3);
INSERT INTO camionero.truck_drivers (driver_dni, truck_plate_number) VALUES (2, 1);
INSERT INTO camionero.truck_drivers (driver_dni, truck_plate_number) VALUES (2, 2);
INSERT INTO camionero.truck_drivers (driver_dni, truck_plate_number) VALUES (3, 3);
INSERT INTO camionero.truck_drivers (driver_dni, truck_plate_number) VALUES (4, 4);

INSERT INTO camionero.trip (trip_id, driver_dni, truck_plate_number, from_location, to_location, start, end) VALUES (53, 2, 2, 'CABA', 'CORDOBA', '2020-10-01', '2020-10-09');
INSERT INTO camionero.trip (trip_id, driver_dni, truck_plate_number, from_location, to_location, start, end) VALUES (52, 2, 1, 'LARIOJA', 'CORDOBA', '2020-10-05', '2020-10-23');
INSERT INTO camionero.trip (trip_id, driver_dni, truck_plate_number, from_location, to_location, start, end) VALUES (51, 1, 2, 'FOTMOSA', 'CORDOBA', '2020-06-09', '2020-10-01');
INSERT INTO camionero.trip (trip_id, driver_dni, truck_plate_number, from_location, to_location, start, end) VALUES (50, 1, 1, 'CABA', 'CORDOBA', '2020-10-05', '2020-10-06');

