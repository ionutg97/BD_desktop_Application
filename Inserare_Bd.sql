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
insert into Laboratoare values('81','Baze de date');
insert into Laboratoare values('82','Sisteme Distrubuite');
insert into Laboratoare values('83','Retele de Calculatoare');

insert into Cursuri values('90','Baze de date');
insert into Cursuri values('91','Sisteme Distribuite');
insert into Cursuri values('92','Retele de Calculatoare');


insert into Orar values('100','13-may-2019 10:00:00 AM','13-may-2019 12:00:00 AM','61','04','21','80',null);
insert into Orar values('101','13-may-2019 08:00:00 AM','13-may-2019 10:00:00 AM','60','04','21','80',null);
insert into Orar values('102','15-may-2019 12:00:00 AM','15-may-2019 2:00:00 PM','60','01','22',null,'91');
insert into Orar values('103','15-may-2019 12:00:00 AM','15-may-2019 2:00:00 PM','61','01','22',null,'91');
insert into Orar values('104','15-may-2019 12:00:00 AM','15-may-2019 2:00:00 PM','62','01','22',null,'91');

select o.interval_start, o.interval_final, c.nume_curs,p.nume_profesor from orar o, cursuri c, profesori p
    where c.id_curs = o.id_curs and p.id_profesor=o.id_profesor;
    

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


select pl.nume_liste_prezenta, s.nume_student,g.nume_grupa, p.nota, p.observatii
    from liste_prezenta pl,studenti s, prezenta p, grupe g 
    where p.id_liste_prezenta=pl.id_liste_prezenta and p.id_student=s.id_student and s.id_grupa = g.id_grupa;

--stergere din listele de prezenta + prezenta
delete from prezenta where id_prezenta>=300;
delete from prezenta where id_liste_prezenta>205;
delete  from liste_prezenta where id_liste_prezenta > 205;

-- inserare lista prezenta pentru laborator
insert into liste_prezenta(nume_liste_prezenta,id_grupa,saptamana,id_laborator) values ('Prezenta SD 1310A 6',(select id_grupa from Grupe where nume_grupa = '1310A'),6,
    (select id_laborator from Laboratoare where nume_laborator='Sisteme Distrubuite'));

-- vizualizare lista laboratoare
select l.nume_laborator,t.nume_profesor,s.nume_student, lp.saptamana
    from liste_prezenta lp, profesori t, prezenta p, studenti s, laboratoare l
    where lp.id_liste_prezenta=p.id_liste_prezenta 
    and p.id_liste_prezenta=(select lp.id_liste_prezenta from liste_prezenta lp where
    lp.saptamana=6 and lp.id_grupa = (select id_grupa from grupe where nume_grupa = '1310A')
    and lp.id_laborator= (select id_laborator from laboratoare where nume_laborator = 'Sisteme Distrubuite'))
    and p.id_student=s.id_student 
    and p.id_profesor= t.id_profesor
    and p.id_laborator=l.id_laborator
    order by lp.saptamana asc;
       
--vizualizare lista cursuri
select c.nume_curs,t.nume_profesor,s.nume_student, lp.saptamana,p.nota,p.observatii
    from liste_prezenta lp, profesori t, prezenta p, studenti s, cursuri c
    where lp.id_liste_prezenta=p.id_liste_prezenta 
    and p.id_liste_prezenta=(select lp.id_liste_prezenta from liste_prezenta lp where
    lp.saptamana=6 and lp.id_curs= (select id_curs from cursuri where nume_curs = 'Retele de Calculatoare'))
    and p.id_student=s.id_student 
    and p.id_profesor= t.id_profesor
    and p.id_curs=c.id_curs
    order by lp.saptamana asc;
  
 
--insesare prezenta curs   
insert into liste_prezenta values('204','Prezenta curs RC sapt 5',null,'5','92',null);
insert into liste_prezenta values('205','Prezenta curs RC sapt 6',null,'6','92',null);
insert into Prezenta values('312','2',null,'36','23','92',null,'204');
insert into Prezenta values('313','2',null,'37','23','92',null,'204');
insert into Prezenta values('314','2',null,'37','23','92',null,'205');
insert into Prezenta values('315','2',null,'38','23','92',null,'205');
insert into Prezenta values('316','2',null,'36','23','92',null,'205');
insert into Prezenta values('317','2',null,'35','23','92',null,'205');
    

-- stergerea unei liste de prezenta laborator
select * from prezenta;
select * from liste_prezenta;
insert into liste_prezenta values('207','Prezenta laborator RC sapt 7','60','7',null,'83');
insert into Prezenta values('319','5',null,'37','23',null,'83','207');


delete  from prezenta where id_liste_prezenta= ( select lp.id_liste_prezenta from liste_prezenta lp where
    lp.saptamana=7 and lp.id_grupa = (select id_grupa from grupe where nume_grupa = '1310A')
    and lp.id_laborator= (select id_laborator from laboratoare where nume_laborator = 'Retele de Calculatoare')); 
    
delete from liste_prezenta where id_liste_prezenta= ( select lp.id_liste_prezenta from liste_prezenta lp where
    lp.saptamana=7 and lp.id_grupa = (select id_grupa from grupe where nume_grupa = '1310A')
    and lp.id_laborator= (select id_laborator from laboratoare where nume_laborator = 'Retele de Calculatoare'));     

--stergerea unei liste de curs
select * from prezenta;
select * from liste_prezenta;
insert into liste_prezenta values('206','Prezenta curs RC sapt 7',null,'7','92',null);
insert into Prezenta values('318','2',null,'35','23','92',null,'206');


delete  from prezenta where id_liste_prezenta= ( select lp.id_liste_prezenta from liste_prezenta lp where
    lp.saptamana=7 and lp.id_curs= (select id_curs from cursuri where nume_curs = 'Retele de Calculatoare')); 

delete  from liste_prezenta where id_liste_prezenta= ( select lp.id_liste_prezenta from liste_prezenta lp where lp.saptamana= 7 
and lp.id_curs= (select id_curs from cursuri where nume_curs = 'Retele de Calculatoare'));

delete from prezenta where id_liste_prezenta= ( select lp.id_liste_prezenta from liste_prezenta lp where lp.saptamana= 7 
    and lp.id_curs= (select id_curs from cursuri where nume_curs = 'Retele de Calculatoare')); 
    
delete from liste_prezenta where id_liste_prezenta= (  select lp.id_liste_prezenta from liste_prezenta lp where
    lp.saptamana=7 and lp.id_curs= (select id_curs from cursuri where nume_curs = 'Retele de Calculatoare'));     

--adaugarea unui student in prezenta
--verificare in liste_prezenta daca a fost creata lista si ce id are
-- apoi se face adaugarea

select lp.id_liste_prezenta from liste_prezenta lp where
    lp.saptamana=7 and lp.id_grupa = (select id_grupa from grupe where nume_grupa = '1310A')
    and lp.id_laborator= (select id_laborator from laboratoare where nume_laborator = 'Retele de Calculatoare');
    
select lp.id_liste_prezenta from liste_prezenta lp where
    lp.saptamana=7 and lp.id_curs= (select id_curs from cursuri where nume_curs = 'Retele de Calculatoare');  

 --inserare prezenta curs      
insert into prezenta values (320,'5',null,
    (select id_student from studenti where nume_student='Galan Ionut'),(select id_profesor from profesori where nume_profesor='Botezat'),
    (select id_curs from cursuri where nume_curs='Retele de Calculatoare'),null,(select lp.id_liste_prezenta from liste_prezenta lp where
    lp.saptamana=7 and lp.id_curs= (select id_curs from cursuri where nume_curs = 'Retele de Calculatoare')));

--inserare prezenta laborator
insert into prezenta values (321,'2',null,
    (select id_student from studenti where nume_student='Galan Ionut'),
    (select id_profesor from profesori where nume_profesor='Botezat'),
    null,(select id_laborator from laboratoare where nume_laborator = 'Retele de Calculatoare'),
    (select lp.id_liste_prezenta from liste_prezenta lp where lp.saptamana=7 
    and lp.id_grupa = (select id_grupa from grupe where nume_grupa = '1310A')
         and lp.id_laborator= (select id_laborator from laboratoare where nume_laborator = 'Retele de Calculatoare')));


select * from prezenta;

----------------------------------------------------------UPdate observatii--------------------------------------------------------------------
--selectez id_lista_prezenta dupa saptamana si curs sau laborator (avand in vedere faptul ca prezenta se poate face si in cadrul altor grupe)

select id_liste_prezenta from liste_prezenta where saptamana= 7 and id_curs=(select id_curs from cursuri where nume_curs='Retele de Calculatoare');

update  prezenta set observatii='2 raspunsuri' where id_liste_prezenta=
    (select id_liste_prezenta from liste_prezenta where saptamana= 7 and id_curs=(select id_curs from cursuri where nume_curs='Retele de Calculatoare'))
    and id_student=(select id_student from studenti where nume_student='Galan Ionut');

select * from prezenta;

-- update observatii laborator

update  prezenta set observatii=' +Tema facuta' where id_liste_prezenta=
    (select id_liste_prezenta from liste_prezenta where saptamana= 7 and id_laborator= (select id_laborator from laboratoare where nume_laborator = 'Retele de Calculatoare'))
    and id_student=(select id_student from studenti where nume_student='Galan Ionut');
    
-- update nota laborator +(validare din interfata note<10 si note >2)
update  prezenta set nota=10 where id_liste_prezenta=
    (select id_liste_prezenta from liste_prezenta where saptamana= 7 and id_laborator= (select id_laborator from laboratoare where nume_laborator = 'Retele de Calculatoare'))
    and id_student=(select id_student from studenti where nume_student='Galan Ionut');


    
