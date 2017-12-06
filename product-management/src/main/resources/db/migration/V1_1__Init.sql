CREATE TABLE Products(
	id bigint not null auto_increment,
	name varchar(255),
	price double,
	primary key(id)
);

INSERT INTO Products(name,price) VALUES('Product1', 25.12);

