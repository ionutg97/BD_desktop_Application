create table Sali (id_sala int, nume_sala varchar(50));
alter table Sali add constraint id_sala_pk primary key (id_sala);
alter table Sali add constraint nume_sala_nn unique (nume_sala);

create table AnStudii (id_an int, nume_an varchar(50));
alter table AnStudii add constraint id_an_pk primary key (id_an);
alter table AnStudii add constraint nume_an_nn unique (nume_an);

create table Profesori (id_profesor int, nume_profesor varchar(50));
alter table Profesori add constraint id_profesor_pk primary key (id_profesor);

create table Grupe (id_grupa int, nume_grupa varchar(50));
alter table Grupe add constraint id_grupa_pk primary key (id_grupa);
alter table Grupe add constraint nume_grupa_nn unique (nume_grupa);

create table Studenti (id_student int, nume_student varchar(50), id_an int, id_grupa int);
alter table Studenti add constraint id_student_pk primary key (id_student);
alter table Studenti add constraint id_an_fk foreign key (id_an) references AnStudii(id_an);
alter table Studenti add constraint id_grupa_fk foreign key (id_grupa) references Grupe(id_grupa);

create table Cursuri (id_curs int, nume_curs varchar(50) Not null);
alter table Cursuri add constraint id_curs_pk primary key (id_curs);

create table Laboratoare (id_laborator int, nume_laborator varchar(50) Not null);
alter table Laboratoare add constraint id_laborator_pk primary key (id_laborator);

create table Orar (id_orar int,  interval_start timestamp(0) not null, interval_final timestamp(0) not null ,
    id_grupa int ,id_sala int,id_profesor int, id_laborator int, id_curs int);
alter table Orar add constraint id_orar_pk primary key (id_orar);
alter table  Orar add constraint id_grupa_Orar_fk foreign key (id_grupa) references Grupe(id_grupa);  
alter table  Orar add constraint id_sala_fk foreign key (id_sala) references Sali(id_sala); 
alter table  Orar add constraint id_profesor_fk foreign key (id_profesor) references Profesori(id_profesor);   
alter table  Orar add constraint id_laborator_fk foreign key (id_laborator) references Laboratoare(id_laborator);  
alter table  Orar add constraint id_curs_fk foreign key (id_curs) references Cursuri(id_curs);   

--create table Liste_Prezenta(id_liste_prezenta int , nume_liste_prezenta varchar(50) );
--alter table Liste_Prezenta add constraint id_liste_prezenta_pk primary key (id_liste_prezenta);
CREATE TABLE liste_prezenta (
    id_liste_prezenta     NUMBER(5) NOT NULL,
    nume_liste_prezenta   VARCHAR2(50)
);
ALTER TABLE liste_prezenta ADD CONSTRAINT liste_prezenta_pk PRIMARY KEY ( id_liste_prezenta );
alter table liste_prezenta add (id_grupa int , saptamana number check (saptamana>0 and saptamana <15));
alter table  liste_prezenta add constraint id_grup_liste_prezenta_fk foreign key (id_grupa) references Grupe(id_grupa); 
alter table liste_prezenta add (id_curs int,id_laborator int );
alter table  liste_prezenta add constraint id_curs_liste_prezenta_fk foreign key (id_curs) references Cursuri(id_curs); 
alter table  liste_prezenta add constraint id_laborator_liste_prezenta_fk foreign key (id_laborator) references Laboratoare(id_laborator); 


-- creare tabela prezenta
create table Prezenta (id_prezenta Number(5) not null, nota number Check(nota > 1 and nota < 11),observatii varchar(255),
    id_student int,id_profesor int,id_curs int,id_laborator int, id_liste_prezenta int);
alter table Prezenta add constraint id_prezenta_pk primary key (id_prezenta);
alter table  Prezenta add constraint id_student_Prezenta_fk foreign key (id_student) references Studenti(id_student);
alter table  Prezenta add constraint id_profesor_Prezenta_fk foreign key (id_profesor) references Profesori(id_profesor);
alter table  Prezenta add constraint id_curs_Prezenta_fk foreign key (id_curs) references Cursuri(id_curs);
alter table  Prezenta add constraint id_laborator_Prezenta_fk foreign key (id_laborator) references Laboratoare(id_laborator);
alter table  Prezenta add constraint id_Prezenta_fk foreign key (id_liste_prezenta) references Liste_Prezenta(id_liste_prezenta);

CREATE SEQUENCE prezenta_seq1 START WITH 300 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER prezenta_trg1 BEFORE
    INSERT ON Prezenta
    FOR EACH ROW
    WHEN ( new.id_prezenta IS NULL )
BEGIN
    :new.id_prezenta := prezenta_seq1.nextval;
END;
/


CREATE SEQUENCE liste_prezenta_seq START WITH 200 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER liste_prezenta_trg BEFORE
    INSERT ON liste_prezenta
    FOR EACH ROW
    WHEN ( new.id_liste_prezenta IS NULL )
BEGIN
    :new.id_liste_prezenta := liste_prezenta_seq.nextval;
END;
/   



