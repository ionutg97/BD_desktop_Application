
-- inserare lista prezenta pentru laborator
insert into liste_prezenta(nume_liste_prezenta,id_grupa,saptamana,id_laborator) values ('Prezenta SD 1310A 6',(select id_grupa from Grupe where nume_grupa = '1310A'),6,
    (select id_laborator from Laboratoare where nume_laborator='Sisteme Distribuite'));
    
--inserare lista prezenta pentru curs
insert into liste_prezenta(nume_liste_prezenta,id_grupa,saptamana,id_curs) values ('Prezenta SD 1310A 10',(select id_grupa from Grupe where nume_grupa = '1310A'),10,
    (select id_curs from cursuri where nume_curs='Sisteme Distribuite'));
    
--insesare prezenta curs   
insert into liste_prezenta values('204','Prezenta curs RC sapt 5',null,'5','92',null);
insert into liste_prezenta values('205','Prezenta curs RC sapt 6',null,'6','92',null);
insert into Prezenta values('312','2',null,'36','23','92',null,'204');
insert into Prezenta values('313','2',null,'37','23','92',null,'204');
insert into Prezenta values('314','2',null,'37','23','92',null,'205');
insert into Prezenta values('315','2',null,'38','23','92',null,'205');
insert into Prezenta values('316','2',null,'36','23','92',null,'205');
insert into Prezenta values('317','2',null,'35','23','92',null,'205');    

       
--vizualizare lista cursuri
select c.nume_curs,t.nume_profesor,s.nume_student, lp.saptamana,p.nota,p.observatii
    from liste_prezenta lp, profesori t, prezenta p, studenti s, cursuri c
    where lp.id_liste_prezenta=p.id_liste_prezenta 
    and p.id_liste_prezenta=(select lp.id_liste_prezenta from liste_prezenta lp where
    lp.saptamana=10 and lp.id_curs= (select id_curs from cursuri where nume_curs = 'Retele de Calculatoare'))
    and p.id_student=s.id_student 
    and p.id_profesor= t.id_profesor
    and p.id_curs=c.id_curs
    order by lp.saptamana asc;
    
--inserare prezenta laborator
select * from liste_prezenta;
select * from prezenta;

delete prezenta where id_liste_prezenta=206;
delete liste_prezenta where id_liste_prezenta=206;

insert into liste_prezenta values('206','Prezenta laborator SD sapt 6','60','1',null,'82');
insert into Prezenta values('318','5',null,'30','22',null,'82','206');
insert into Prezenta values('319','5',null,'31','22',null,'82','206');
insert into Prezenta values('320','5',null,'32','22',null,'82','206');
    
-- vizualizare lista laboratoare
select l.nume_laborator,t.nume_profesor,s.nume_student, lp.saptamana,p.nota,p.observatii
    from liste_prezenta lp, profesori t, prezenta p, studenti s, laboratoare l
    where lp.id_liste_prezenta=p.id_liste_prezenta 
    and p.id_liste_prezenta=(select lp.id_liste_prezenta from liste_prezenta lp where
    lp.saptamana=1 and lp.id_grupa = (select id_grupa from grupe where nume_grupa = '1310A')
    and lp.id_laborator= (select id_laborator from laboratoare where nume_laborator = 'Sisteme Distribuite'))
    and p.id_student=s.id_student 
    and p.id_profesor= t.id_profesor
    and p.id_laborator=l.id_laborator
    order by lp.saptamana asc;    
       
select lp.id_liste_prezenta from liste_prezenta lp where
    lp.saptamana=6 and lp.id_grupa = (select id_grupa from grupe where nume_grupa = '1310A')
    and lp.id_laborator= (select id_laborator from laboratoare where nume_laborator = 'Sisteme Distribuite');
    
    
-- stergerea unei liste de prezenta laborator
select * from prezenta;
select * from liste_prezenta;
insert into liste_prezenta values('207','Prezenta laborator RC sapt 7','60','7',null,'83');
insert into Prezenta values('321','5',null,'37','23',null,'83','207');


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
    (select id_liste_prezenta from liste_prezenta where saptamana= 7 
    and id_laborator= (select id_laborator from laboratoare where nume_laborator = 'Retele de Calculatoare'))
    and id_student=(select id_student from studenti where nume_student='Galan Ionut');
    
-- update nota laborator +(validare din interfata note<10 si note >2)
update  prezenta set nota=10 where id_liste_prezenta=
    (select id_liste_prezenta from liste_prezenta where saptamana= 7 and id_laborator= (select id_laborator from laboratoare where nume_laborator = 'Retele de Calculatoare'))
    and id_student=(select id_student from studenti where nume_student='Galan Ionut');