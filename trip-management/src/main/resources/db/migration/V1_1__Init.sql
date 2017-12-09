create table trip (id bigint not null auto_increment, destination varchar(255), driver_id integer, name varchar(255), source varchar(255), trip_id bigint, user_id integer, primary key (id));

insert into trip(user_id, driver_id, name, trip_id, source, destination) 
VALUES(27, 82, 'trip 1', 11, 'Bandra','Worli');