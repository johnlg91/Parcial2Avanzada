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

-- insert driver 1
insert into driver (dni, first_name, last_name, cellphone)
values (1, 'Homero', 'Simpsons', 1);

-- insert driver 2
insert into driver (dni, first_name, last_name, cellphone)
values (2, 'Marge', 'Simpsons', 2)
