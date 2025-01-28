-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;


INSERT INTO Fruta (Id, nome, qtd) VALUES (1, 'Uva', 5);
INSERT INTO Fruta (Id, nome, qtd) VALUES (2, 'Pera', 4);
INSERT INTO Fruta (Id, nome, qtd) VALUES (3, 'Banana', 3);
INSERT INTO Fruta (Id, nome, qtd) VALUES (4, 'Jaca', 2);
alter sequence Fruta_seq restart with 5;