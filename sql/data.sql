--drop table if exists owner CASCADE;
--create table owner
--(
-- id bigint generated by default as identity,
-- name varchar(255),
-- address varchar(255),
-- phone varchar(10),
-- primary key (id)
--);
--
--drop table if exists vet CASCADE;
--create table vet
--(
-- id bigint generated by default as identity,
-- name varchar(255),
-- specialty varchar(255),
-- primary key (id)
--);

insert into vet(name, specialty) values('James Carter', 'none');
insert into vet(name, specialty) values('Helen Leary', 'radiology');
insert into vet(name, specialty) values('Linda Douglas', 'dentistry surgery');
insert into vet(name, specialty) values('Rafael Ortega', 'surgery');
insert into vet(name, specialty) values('Henry Stevens', 'radiology');
insert into vet(name, specialty) values('Sharon Jenkins', 'none');
