insert into Sali values ('01','AC01');
insert into Sali values ('02','AC02');
insert into Sali values ('03','AC03');
insert into Sali values ('04','C01');
insert into Sali values ('05','C02');

insert into AnStudii values ('11','Anul 1 Licienta');
insert into AnStudii values ('12','Anul 2 Licienta');
insert into AnStudii values ('13','Anul 3 Licienta');
insert into AnStudii values ('14','Anul 4 Licienta');
insert into AnStudii values ('15','Anul 1 Master');

insert into Profesori values ('20','Butincu');
insert into Profesori values ('21','Alexandrescu');
insert into Profesori values ('22','Zaharia');
insert into Profesori values ('23','Botezat');

insert into Grupe values ('60','1310A');
insert into Grupe values ('61','1308B');
insert into Grupe values ('62','1307A');
insert into Grupe values ('63','1409A');

insert into Studenti values ('30','Galan Ionut','13','60');
insert into Studenti values ('31','Vrabie Vasile','13','60');
insert into Studenti values ('32','Arteni Denisia','13','60');
insert into Studenti values ('33','Manolache Theona','13','61');
insert into Studenti values ('34','Lehutcu Anca','13','61');
insert into Studenti values ('35','Zaharii Evelina','13','61');
insert into Studenti values ('36','Halip Vasile','13','62');
insert into Studenti values ('37','Andrisan Ionut','13','62');
insert into Studenti values ('38','Grigoras Alexandru','14','63');

insert into Laboratoare values('80','Tehnologi Web Proiect');
insert into Laboratoare values('81','Baze de Date');
insert into Laboratoare values('82','Sisteme Distribuite');
insert into Laboratoare values('83','Retele de Calculatoare');

insert into Cursuri values('90','Baze de Date');
insert into Cursuri values('91','Sisteme Distribuite');
insert into Cursuri values('92','Retele de Calculatoare');


insert into Orar values('100','13-may-2019 10:00:00 AM','13-may-2019 12:00:00 AM','61','04','21','80',null);
insert into Orar values('101','13-may-2019 08:00:00 AM','13-may-2019 10:00:00 AM','60','04','21','80',null);
insert into Orar values('102','15-may-2019 12:00:00 AM','15-may-2019 2:00:00 PM','60','01','22',null,'91');
insert into Orar values('103','15-may-2019 12:00:00 AM','15-may-2019 2:00:00 PM','61','01','22',null,'91');
insert into Orar values('104','15-may-2019 12:00:00 AM','15-may-2019 2:00:00 PM','62','01','22',null,'91');
    
insert into Liste_prezenta values('200','prezenta Tehnologii web proiect sapt 12','60','12',null,'80'); 
insert into Liste_prezenta values('201','prezenta RC sapt 12',null,10,'92',null); 
insert into Liste_prezenta values('202','prezenta Tehnologii web proiect sapt 11','61','11',null,'80'); 


--la inserare trebuie facut un check daca studentul este din grupa lui
insert into Prezenta values('300','5',null,'30','21',null,'80','200');
insert into Prezenta values('301','5',null,'31','21',null,'80','200');
insert into Prezenta values('302','5',null,'32','21',null,'80','200');
insert into Prezenta values('303','2',null,'30','23','92',null,'201');
insert into Prezenta values('304','2',null,'33','23','92',null,'201');
insert into Prezenta values('305','2',null,'34','23','92',null,'201');
insert into Prezenta values('306','2',null,'35','23','92',null,'201');
insert into Prezenta values('307','2',null,'37','23','92',null,'201');
insert into Prezenta values('308','5',null,'33','21',null,'80','202');
insert into Prezenta values('309','5',null,'34','21',null,'80','202');
insert into Prezenta values('310','5',null,'35','21',null,'80','202');





    
