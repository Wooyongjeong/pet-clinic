drop table if exists owner CASCADE;
create table owner
(
 id bigint generated by default as identity,
 name varchar(255),
 address varchar(255),
 phone varchar(10),
 primary key (id)
);

drop table if exists vets CASCADE;
create table vets
(
 id bigint generated by default as identity,
 name varchar(255),
 specialty varchar(255),
 primary key (id)
);