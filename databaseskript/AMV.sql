DROP DATABASE Amv;
CREATE DATABASE Amv;
USE Amv;

-- Tabellstruktur for ansatte

CREATE TABLE ansatt
(
    ansatt_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    password VARCHAR(60) NOT NULL,
    fornavn VARCHAR(30) NOT NULL,
    etternavn VARCHAR(60) NOT NULL,
    email VARCHAR(40) NOT NULL,
    adresse VARCHAR(40) NOT NULL,
    mobil VARCHAR(30) NOT NULL,
    administrator TINYINT(1),
    unionn TINYINT(1),
        CONSTRAINT constraint_email UNIQUE (email)
);

INSERT INTO ansatt (ansatt_id, password, fornavn, etternavn, email, adresse, mobil, administrator, unionn)
values

       (24, '48010FF8F278613AF9B6D4D9EC79050A', 'Mahmoud', 'Kasem', 'mahmoud@mail.no', ' Stavanger', '99778866', 1, 1),
       (10, '48010FF8F278613AF9B6D4D9EC79050A', 'Kari', 'Karlsen', 'kari@mail.no', 'Veiengata 2', '66774499', 0, 1);

-- Tabellstruktur for utstyr type

CREATE TABLE utstyr_type
(
    utstyr_type_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    utstyr_type_navn VARCHAR(40) NOT NULL
);
INSERT INTO utstyr_type (utstyr_type_navn)
values
    ('Lastebil'),
    ('Spikerpistol Milwuakee'),
    ('Strømaggregat'),
    ('Personløfter'),
    ('Skruautomat'),
    ('Fein Multimaskin'),
    ('Eksentersliper 230 VAC'),
    ('9" Vinkelsliper, stein'),
    ('Flisekutter'),
    ('Vinkelsliper'),
    ('Båndsliper 230 VAC');

-- Tabellstruktur for utstyr

CREATE TABLE utstyr
(
    utstyr_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL ,
    utstyr_type_id INT NOT NULL,
    utstyr_navn VARCHAR(40) NOT NULL ,
    leie_kostnad DECIMAL(6,2),
    status BOOLEAN NOT NULL ,
    bruk_info VARCHAR(100),
    CONSTRAINT FK_utstyr_utstyr_type
        FOREIGN KEY (utstyr_type_id) REFERENCES utstyr_type(utstyr_type_id)
);
INSERT INTO utstyr (utstyr_type_id, utstyr_navn, leie_kostnad, status, bruk_info)
VALUES (2, 'Spikerpistol Milwaukee liten', 30, false, ''),
       (2, 'Spikerpistol Milwaukee mellom', 200, false, ''),
       (2, 'Spikerpistol Milwaukee stor', 700, false, ''),
       (1, 'Volvo', 700, false, 'Krever Lastebil førerkort'),
       (3, 'Strømaggregat 3,7 kW', 650, false, ''),
       (4, 'Personløfter 230 VAC (12m)', 207, false, 'Krever sikkerhetsopplæring'),
       (5,'Skruautomat',150,false,'ingen opplæring'),
       (6,'Fein Multimaskin',360,false,'ingen opplæring'),
       (7,'Eksentersliper 230 VAC',75,false,''),
       (8,' Flisekutter, keramiske fliser, stein',900,false,''),
       (9,' Vinkelsliper, stein',20,true,''),
       (10,'Båndsliper 230 VAC',20,true,'');

-- Tabellstruktur for leiekontrakt

CREATE TABLE leie_kontrakt
(
    leie_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    ansatt_id INT NOT NULL ,
    utstyr_id INT NOT NULL ,
    start_leie_dato DATE NOT NULL ,
    tilbake_dato DATE NOT NULL,
    betalt boolean NOT NULL,
    total_kostnad DECIMAL(5,2),
    tilstandsvurdering VARCHAR(60) DEFAULT 'null',
    CONSTRAINT FK_ansatt_leie_kontrakt
        FOREIGN KEY (ansatt_id) REFERENCES ansatt(ansatt_id),

    CONSTRAINT FK_utstyr_leie_kontrakt
        FOREIGN KEY (utstyr_id) REFERENCES utstyr(utstyr_id) ON DELETE CASCADE
);
INSERT INTO leie_kontrakt (ansatt_id, utstyr_id, start_leie_dato, tilbake_dato, betalt, total_kostnad, tilstandsvurdering)
VALUES
    (1,2,'2021,10,22','2021,10,23',true,0,'bra tilstand '),
    (2,5,'2021,10,15','2021,10,25',true,254.50,'bra tilstand '),
    (3,4,'2021,10,28','2021,11,01',false,40,'bra tilstand '),
    (4,10,'2021,10,18','2021,10,22',true,70,'bra tilstand '),
    (5,1,'2021,10,15','2021,10,28',true,254.50,'bra tilstand '),
    (6,2,'2021,11,15','2021,12,22',false,254.50,'bra tilstand '),
    (7,7,'2021,10,15','2021,10,22',true,254.50,'bra tilstand '),
    (8,8,'2021,10,15','2021,10,27',true,254.50,'bra tilstand '),
    (9,6,'2021,10,27','2021,11,04',true,254.50,'bra tilstand '),
    (1,1,'2021,10,24','2021,11,03',true,0,'bra tilstand '),
    (3,1,'2021,12,13','2021,12,15',true,254.50,'bra tilstand '),
    (10,9,'2021,10,15','2021,10,22',true,254.50,'bra tilstand ');


create table lease
(
    leaseId varchar (10) not null ,
    leaseContent MEDIUMBLOB,
    Primary key (leaseId)
);

select * from lease;

-- Listing the 5 first rows of the 5 most important tables (your judgement), sorted FIRST_NAME.
SELECT * FROM ansatt ORDER BY fornavn limit 5 ;

-- sorted start_leie_dato.
SELECT * FROM leie_kontrakt ORDER BY start_leie_dato;

SELECT tilbake_dato - start_leie_dato,utstyr_navn AS total_dager FROM leie_kontrakt,utstyr WHERE utstyr.utstyr_id=leie_kontrakt.utstyr_id;

 -- List all equipment in the system with their type. two methods below
SELECT utstyr.utstyr_navn,utstyr_type.utstyr_type_navn AS Utstyrer from utstyr,utstyr_type
        where utstyr.utstyr_type_id = utstyr_type.utstyr_type_id;
SELECT utstyr.utstyr_navn,utstyr_type.utstyr_type_navn FROM utstyr
        INNER JOIN utstyr_type  ON utstyr.utstyr_type_id = utstyr_type.utstyr_type_id;

-- List all the available (at the moment – not already borrowed) equipment
SELECT status, utstyr_navn FROM utstyr WHERE  status  =1;

-- List all equipment that is borrowed at the moment
SELECT utstyr.utstyr_id,utstyr_navn,start_leie_dato,tilbake_dato,ansatt_id AS utleiet_idag FROM  leie_kontrakt,utstyr
          WHERE start_leie_dato= CURRENT_DATE AND utstyr.utstyr_id=leie_kontrakt.utstyr_id ;


SELECT leie_kontrakt.ansatt_id, leie_kontrakt.utstyr_id,tilbake_dato , utstyr.utstyr_navn FROM leie_kontrakt
          INNER JOIN utstyr  ON utstyr.utstyr_id = leie_kontrakt.utstyr_id WHERE status=0 AND tilbake_dato<CURRENT_DATE;



SELECT * FROM leie_kontrakt;
SELECT * FROM utstyr;
SELECT * FROM ansatt;

select *  from utstyr where status=0;


