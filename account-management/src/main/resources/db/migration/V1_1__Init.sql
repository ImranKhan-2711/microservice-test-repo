create table account (id bigint not null auto_increment, account_number decimal(19,2), name varchar(255), user_id bigint, primary key (id));

insert into account(user_id, account_number, name) VALUES(27, 211456,'TestData');