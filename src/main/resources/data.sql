insert into owner(name, address, phone) values('Jane Smith', 'Seoul', '01012345678');
insert into owner(name, address, phone) values('John Doe', 'Busan', '01056781234');

insert into pet(name, birth_date, type, owner_id) values('Choco', '2020-11-11', 'Dog', '1');
insert into pet(name, birth_date, type, owner_id) values('Vanilla', '2020-11-11', 'Dog', '1');
insert into pet(name, birth_date, type, owner_id) values('Cheese', '2020-08-22', 'Cat', '2');
insert into pet(name, birth_date, type, owner_id) values('Oreo', '2020-08-22', 'Cat', '2');

insert into visit(visit_date, description, pet_id) values('2020-11-18', 'Vaccination', '1');
insert into visit(visit_date, description, pet_id) values('2020-11-18', 'Vaccination', '2');
insert into visit(visit_date, description, pet_id) values('2020-08-30', 'Blood test', '3');
insert into visit(visit_date, description, pet_id) values('2020-08-30', 'Blood test', '4');

insert into vet(name, specialty) values('James Carter', 'none');
insert into vet(name, specialty) values('Helen Leary', 'radiology');
insert into vet(name, specialty) values('Linda Douglas', 'dentistry surgery');
insert into vet(name, specialty) values('Rafael Ortega', 'surgery');
insert into vet(name, specialty) values('Henry Stevens', 'radiology');
insert into vet(name, specialty) values('Sharon Jenkins', 'none');
