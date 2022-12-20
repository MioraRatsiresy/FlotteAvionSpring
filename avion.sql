create user avion with PASSWORD 'avion';

create database avion;

CREATE TABLE Compagnie (id serial primary key, nom varchar(50) NOT NULL, siege varchar(50) NOT NULL, contact varchar(50) NOT NULL, email varchar(50), pwd varchar(50));
CREATE TABLE Constructeur (id SERIAL NOT NULL, constructeur varchar(50) NOT NULL, PRIMARY KEY (id));
CREATE TABLE Avion (id SERIAL NOT NULL, nom varchar(50) NOT NULL UNIQUE, photo varchar(255), longueur float8 NOT NULL, hauteur float8 NOT NULL, Constructeurid int4 NOT NULL, PRIMARY KEY (id));
CREATE TABLE Kilometrage (Avionid int4 NOT NULL, dateDecolage timestamp NOT NULL, dateAtterrissage timestamp NOT NULL,kilometreDebut float8 NOT NULL, kmFin float8 NOT NULL);
ALTER TABLE Avion ADD CONSTRAINT FKAvion779185 FOREIGN KEY (Constructeurid) REFERENCES Constructeur (id);
ALTER TABLE Kilometrage ADD CONSTRAINT FKKilometrag289279 FOREIGN KEY (Avionid) REFERENCES Avion (id);
INSERT INTO Compagnie(nom, siege, contact,email,pwd) VALUES ('Mada Sky', 'Ivato', '034 91 893 15', 'mada.sky@gmail.com','f4918978935c7e6560d9149473da0dab');
INSERT INTO Constructeur(id, constructeur) VALUES (1, 'Airbus');
INSERT INTO Constructeur(id, constructeur) VALUES (2, 'Boeing');
INSERT INTO Constructeur(id, constructeur) VALUES (3, 'Antonov');
INSERT INTO Avion(id, nom, photo, longueur, hauteur, Constructeurid) VALUES (1, 'Atlas', 'http://localhost:6942/images/atlas.jpg', 37.57, 11.76 , 1);
INSERT INTO Avion(id, nom, photo, longueur, hauteur, Constructeurid) VALUES (2, 'Cotam Unite', 'http://localhost:6942/images/unite.jpg', 40, 12, 1);
INSERT INTO Avion(id, nom, photo, longueur, hauteur, Constructeurid) VALUES (3, 'Ocean Sentry', 'http://localhost:6942/images/ocean.jpg', 32, 10, 1);
INSERT INTO Avion(id, nom, photo, longueur, hauteur, Constructeurid) VALUES (4, 'Bird of Prey', 'http://localhost:6942/images/bird.jpg', 40, 13, 2);
INSERT INTO Avion(id, nom, photo, longueur, hauteur, Constructeurid) VALUES (5, 'Blackjack', 'http://localhost:6942/images/bird.jpg', 35, 11, 2);
INSERT INTO Avion(id, nom, photo, longueur, hauteur, Constructeurid) VALUES (6, 'Antey', 'http://localhost:6942/images/antey.jpg', 31, 14, 3);
INSERT INTO Avion(id, nom, photo, longueur, hauteur, Constructeurid) VALUES (7, 'Mriya', 'http://localhost:6942/images/mriya.jpg', 29, 10, 3);
INSERT INTO Kilometrage(Avionid, dateDecolage, dateAtterrissage, kilometreDebut, kmFin) VALUES (1, '2022-11-17 14:00', '2022-11-17 15:00', 1000, 1200);
INSERT INTO Kilometrage(Avionid, dateDecolage, dateAtterrissage, kilometreDebut, kmFin) VALUES (2, '2022-11-17 15:00', '2022-11-17 16:00', 800, 1000);
INSERT INTO Kilometrage(Avionid, dateDecolage, dateAtterrissage, kilometreDebut, kmFin) VALUES (3, '2022-11-18 7:00', '2022-11-18 9:00', 1500, 1700);
INSERT INTO Kilometrage(Avionid, dateDecolage, dateAtterrissage, kilometreDebut, kmFin) VALUES (4, '2022-11-18 10:00', '2022-11-18 11:00', 600, 700);
INSERT INTO Kilometrage(Avionid, dateDecolage, dateAtterrissage, kilometreDebut, kmFin) VALUES (5, '2022-11-19 7:00', '2022-11-19 9:00', 200, 400);
INSERT INTO Kilometrage(Avionid, dateDecolage, dateAtterrissage, kilometreDebut, kmFin) VALUES (6, '2022-11-19 19:00', '2022-11-19 20:00', 300, 400);
INSERT INTO Kilometrage(Avionid, dateDecolage, dateAtterrissage, kilometreDebut, kmFin) VALUES (7, '2022-11-20 7:00', '2022-11-19 10:00', 1500, 1600);

create or replace view v_avion as 
select a.*, c.constructeur from avion a 
join constructeur c on a.Constructeurid=c.id;

create table assurance(
    id serial primary key,
    idAvion int,
    dateAssurance date,
    dateExpiration date,
    foreign key(idAvion) REFERENCES avion(id)
);

insert into assurance VALUES
(default,1,'2022-12-23','2023-01-01'),
(default,2,'2022-12-04','2023-01-06'),
(default,3,'2022-12-09','2023-03-09'),
(default,4,'2022-11-12','2023-02-12');

create view v_assurance as 
select v.*, a.id as idAssurance, a.dateAssurance, a.dateExpiration from v_avion v join assurance a on v.id=a.idAvion;


CREATE VIEW AssuranceMax AS select max(dateassurance) as dateassurancedernier,idavion from assurance group by idavion;

create or replace view v_avionExpire3Mois as 
SELECT *,age(dateexpiration,NOW()) AS ecart 
from v_assurance where EXTRACT(YEAR FROM age(dateexpiration,NOW())) * 12 + EXTRACT(MONTH FROM age(dateexpiration,NOW())) + (EXTRACT(DAY FROM age(dateexpiration,NOW()))/30)::integer=3 and dateAssurance=(select dateassurancedernier from AssuranceMax where idavion=id);


create or replace view v_avionExpire1Mois as 
SELECT *,age(dateexpiration,NOW()) AS ecart 
from v_assurance where EXTRACT(YEAR FROM age(dateexpiration,NOW())) * 12 + EXTRACT(MONTH FROM age(dateexpiration,NOW())) + (EXTRACT(DAY FROM age(dateexpiration,NOW()))/30)::integer=1 and dateAssurance=(select dateassurancedernier from AssuranceMax where idavion=id);


