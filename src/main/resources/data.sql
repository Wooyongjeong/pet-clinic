insert into owner(name, address, phone) values('홍길동', '경기 성남시 분당구 불정로 6', '01012345678');
insert into owner(name, address, phone) values('John Doe', '경기 성남시 분당구 판교역로 235 에이치스퀘어 엔동', '01056781234');

insert into pet(name, birth_date, type, owner_id) values('솜이', '2020-11-11', '강아지', '1');
insert into pet(name, birth_date, type, owner_id) values('치즈', '2020-08-22', '고양이', '2');

insert into visit(visit_date, description, pet_id) values('2020-11-18', '예방접종', '1');
insert into visit(visit_date, description, pet_id) values('2020-08-23', '혈액검사 등', '2');

insert into vet(name, specialty) values('James Carter', 'none');
insert into vet(name, specialty) values('Helen Leary', 'radiology');
insert into vet(name, specialty) values('Linda Douglas', 'dentistry surgery');
insert into vet(name, specialty) values('Rafael Ortega', 'surgery');
insert into vet(name, specialty) values('Henry Stevens', 'radiology');
insert into vet(name, specialty) values('Sharon Jenkins', 'none');
