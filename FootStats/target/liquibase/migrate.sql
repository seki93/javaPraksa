--  *********************************************************************
--  Update Database Script
--  *********************************************************************
--  Change Log: src/main/resources/liquibase-changeLog.xml
--  Ran at: 4/18/18 2:05 PM
--  Against: root@localhost@jdbc:mysql://localhost:3306/footstats
--  Liquibase version: 3.4.1
--  *********************************************************************

--  Create Database Lock Table
CREATE TABLE DATABASECHANGELOGLOCK (ID INT NOT NULL, LOCKED BIT(1) NOT NULL, LOCKGRANTED datetime NULL, LOCKEDBY VARCHAR(255) NULL, CONSTRAINT PK_DATABASECHANGELOGLOCK PRIMARY KEY (ID));

--  Initialize Database Lock Table
DELETE FROM DATABASECHANGELOGLOCK;

INSERT INTO DATABASECHANGELOGLOCK (ID, LOCKED) VALUES (1, 0);

--  Lock Database
UPDATE DATABASECHANGELOGLOCK SET LOCKED = 1, LOCKEDBY = 'INTERN-STEFANS (192.168.52.61)', LOCKGRANTED = '2018-04-18 14:05:18.329' WHERE ID = 1 AND LOCKED = 0;

--  Create Database Change Log Table
CREATE TABLE DATABASECHANGELOG (ID VARCHAR(255) NOT NULL, AUTHOR VARCHAR(255) NOT NULL, FILENAME VARCHAR(255) NOT NULL, DATEEXECUTED datetime NOT NULL, ORDEREXECUTED INT NOT NULL, EXECTYPE VARCHAR(10) NOT NULL, MD5SUM VARCHAR(35) NULL, DESCRIPTION VARCHAR(255) NULL, COMMENTS VARCHAR(255) NULL, TAG VARCHAR(255) NULL, LIQUIBASE VARCHAR(20) NULL, CONTEXTS VARCHAR(255) NULL, LABELS VARCHAR(255) NULL);

--  Changeset db.changelog-master.xml::1524043055147-1::rajko.jegdic (generated)
CREATE TABLE City (id INT AUTO_INCREMENT NOT NULL, name VARCHAR(255) NULL, country_id INT NULL, CONSTRAINT CityPK PRIMARY KEY (id));

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1524043055147-1', 'rajko.jegdic (generated)', 'db.changelog-master.xml', NOW(), 1, '7:a4694a0d3fc5d0cedaf81d5426aad914', 'createTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset db.changelog-master.xml::1524043055147-2::rajko.jegdic (generated)
CREATE TABLE Club (id INT AUTO_INCREMENT NOT NULL, name VARCHAR(255) NULL, city_id INT NULL, competition_id INT NULL, stadium_id INT NULL, CONSTRAINT ClubPK PRIMARY KEY (id));

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1524043055147-2', 'rajko.jegdic (generated)', 'db.changelog-master.xml', NOW(), 2, '7:a88f4ed3bea299dfff89cead97b3e1a3', 'createTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset db.changelog-master.xml::1524043055147-3::rajko.jegdic (generated)
CREATE TABLE Competition (id INT AUTO_INCREMENT NOT NULL, name VARCHAR(255) NULL, country_id INT NULL, rank_id INT NULL, CONSTRAINT CompetitionPK PRIMARY KEY (id));

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1524043055147-3', 'rajko.jegdic (generated)', 'db.changelog-master.xml', NOW(), 3, '7:7a4e11451ffbba5f958ab4cea4d19ee1', 'createTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset db.changelog-master.xml::1524043055147-4::rajko.jegdic (generated)
CREATE TABLE Country (id INT AUTO_INCREMENT NOT NULL, name VARCHAR(255) NULL, CONSTRAINT CountryPK PRIMARY KEY (id));

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1524043055147-4', 'rajko.jegdic (generated)', 'db.changelog-master.xml', NOW(), 4, '7:20dcc5b904d77964e7ff43041e3af0fc', 'createTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset db.changelog-master.xml::1524043055147-5::rajko.jegdic (generated)
CREATE TABLE Person (id INT AUTO_INCREMENT NOT NULL, dateofbirth date NULL, firstname VARCHAR(255) NULL, lastname VARCHAR(255) NULL, cityofbirth_id INT NULL, CONSTRAINT PersonPK PRIMARY KEY (id));

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1524043055147-5', 'rajko.jegdic (generated)', 'db.changelog-master.xml', NOW(), 5, '7:02b1e485e245d0857c9df9a6f5722443', 'createTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset db.changelog-master.xml::1524043055147-6::rajko.jegdic (generated)
CREATE TABLE Player (id INT AUTO_INCREMENT NOT NULL, club_id INT NULL, nationalteam_id INT NULL, person_id INT NULL, playerstats_id INT NULL, position_id INT NULL, CONSTRAINT PlayerPK PRIMARY KEY (id));

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1524043055147-6', 'rajko.jegdic (generated)', 'db.changelog-master.xml', NOW(), 6, '7:dacb2203025badeadef45a610711be3f', 'createTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset db.changelog-master.xml::1524043055147-7::rajko.jegdic (generated)
CREATE TABLE Position (id INT AUTO_INCREMENT NOT NULL, name VARCHAR(255) NULL, CONSTRAINT PositionPK PRIMARY KEY (id));

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1524043055147-7', 'rajko.jegdic (generated)', 'db.changelog-master.xml', NOW(), 7, '7:7a296949c9b1e1132ce2c45373008d36', 'createTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset db.changelog-master.xml::1524043055147-8::rajko.jegdic (generated)
CREATE TABLE Rank (id INT AUTO_INCREMENT NOT NULL, name VARCHAR(255) NULL, CONSTRAINT RankPK PRIMARY KEY (id));

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1524043055147-8', 'rajko.jegdic (generated)', 'db.changelog-master.xml', NOW(), 8, '7:66f0c053f2c0d7cd1df47797ab8947e7', 'createTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset db.changelog-master.xml::1524043055147-9::rajko.jegdic (generated)
CREATE TABLE Referee (id INT AUTO_INCREMENT NOT NULL, person_id INT NULL, CONSTRAINT RefereePK PRIMARY KEY (id));

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1524043055147-9', 'rajko.jegdic (generated)', 'db.changelog-master.xml', NOW(), 9, '7:db97b155381f4bf98ef8ae3c63d94dd2', 'createTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset db.changelog-master.xml::1524043055147-10::rajko.jegdic (generated)
CREATE TABLE Stadium (id INT AUTO_INCREMENT NOT NULL, name VARCHAR(255) NULL, CONSTRAINT StadiumPK PRIMARY KEY (id));

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1524043055147-10', 'rajko.jegdic (generated)', 'db.changelog-master.xml', NOW(), 10, '7:0453e769e5b9b8b57732316d4c1b693f', 'createTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset db.changelog-master.xml::1524043055147-11::rajko.jegdic (generated)
CREATE TABLE clubhistory (id INT AUTO_INCREMENT NOT NULL, player_id INT NULL, CONSTRAINT clubhistoryPK PRIMARY KEY (id));

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1524043055147-11', 'rajko.jegdic (generated)', 'db.changelog-master.xml', NOW(), 11, '7:9dc173d03d741dd7737f2f0f042a6fc5', 'createTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset db.changelog-master.xml::1524043055147-12::rajko.jegdic (generated)
CREATE TABLE `match` (id INT AUTO_INCREMENT NOT NULL, awayclub_id INT NULL, homeclub_id INT NULL, matchstats_id INT NULL, referee_id INT NULL, CONSTRAINT matchPK PRIMARY KEY (id));

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1524043055147-12', 'rajko.jegdic (generated)', 'db.changelog-master.xml', NOW(), 12, '7:b2eb6a22b369723fe7b03268aa9b43e3', 'createTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset db.changelog-master.xml::1524043055147-13::rajko.jegdic (generated)
CREATE TABLE matchstats (id INT AUTO_INCREMENT NOT NULL, assistance INT NULL, cards INT NULL, endresult INT NULL, fouls INT NULL, halftimeresult INT NULL, passes INT NULL, CONSTRAINT matchstatsPK PRIMARY KEY (id));

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1524043055147-13', 'rajko.jegdic (generated)', 'db.changelog-master.xml', NOW(), 13, '7:8c0920b86166a494105bcb65b4e1cabd', 'createTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset db.changelog-master.xml::1524043055147-14::rajko.jegdic (generated)
CREATE TABLE nationalteam (id INT AUTO_INCREMENT NOT NULL, name VARCHAR(255) NULL, competition_id INT NULL, country_id INT NULL, CONSTRAINT nationalteamPK PRIMARY KEY (id));

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1524043055147-14', 'rajko.jegdic (generated)', 'db.changelog-master.xml', NOW(), 14, '7:3cc6aeefb982997faf58395eca698f7c', 'createTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset db.changelog-master.xml::1524043055147-15::rajko.jegdic (generated)
CREATE TABLE playerstats (id INT AUTO_INCREMENT NOT NULL, assistance INT NULL, cards INT NULL, fouls INT NULL, goals INT NULL, passes INT NULL, CONSTRAINT playerstatsPK PRIMARY KEY (id));

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1524043055147-15', 'rajko.jegdic (generated)', 'db.changelog-master.xml', NOW(), 15, '7:e76706d5a92a9efda0580b3613f41bea', 'createTable', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset db.changelog-master.xml::1524043055147-16::rajko.jegdic (generated)
ALTER TABLE Club ADD CONSTRAINT FK_3j5oosrro3364nou5dk2lb3pl FOREIGN KEY (competition_id) REFERENCES Competition (id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1524043055147-16', 'rajko.jegdic (generated)', 'db.changelog-master.xml', NOW(), 16, '7:6b98e9f784695a641c6845b8778621fa', 'addForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset db.changelog-master.xml::1524043055147-17::rajko.jegdic (generated)
ALTER TABLE Player ADD CONSTRAINT FK_3k4v1g8nll9y1oh5r5iumbytp FOREIGN KEY (person_id) REFERENCES Person (id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1524043055147-17', 'rajko.jegdic (generated)', 'db.changelog-master.xml', NOW(), 17, '7:4304cc4e14c8e8d487a7337c9b2b6d6c', 'addForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset db.changelog-master.xml::1524043055147-18::rajko.jegdic (generated)
ALTER TABLE nationalteam ADD CONSTRAINT FK_3kgxbvpegedavkp40jaf715me FOREIGN KEY (competition_id) REFERENCES Competition (id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1524043055147-18', 'rajko.jegdic (generated)', 'db.changelog-master.xml', NOW(), 18, '7:a2a721c9f1d5968b94af399897ce2b17', 'addForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset db.changelog-master.xml::1524043055147-19::rajko.jegdic (generated)
ALTER TABLE `match` ADD CONSTRAINT FK_434omus1a6qf88kutw29qxv1e FOREIGN KEY (homeclub_id) REFERENCES Club (id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1524043055147-19', 'rajko.jegdic (generated)', 'db.changelog-master.xml', NOW(), 19, '7:5a16f8b8b3f9cb820c3bfba2fc540fc7', 'addForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset db.changelog-master.xml::1524043055147-20::rajko.jegdic (generated)
ALTER TABLE Referee ADD CONSTRAINT FK_89rhe8wm2one3sr262p3k2fk7 FOREIGN KEY (person_id) REFERENCES Person (id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1524043055147-20', 'rajko.jegdic (generated)', 'db.changelog-master.xml', NOW(), 20, '7:d720680484edf441b73241c0b0b5f96d', 'addForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset db.changelog-master.xml::1524043055147-21::rajko.jegdic (generated)
ALTER TABLE Person ADD CONSTRAINT FK_8wn40qodtwfnnucxs25pjvuah FOREIGN KEY (cityofbirth_id) REFERENCES City (id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1524043055147-21', 'rajko.jegdic (generated)', 'db.changelog-master.xml', NOW(), 21, '7:daa8775f92f1bae61d3af6cda95c112e', 'addForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset db.changelog-master.xml::1524043055147-22::rajko.jegdic (generated)
ALTER TABLE Player ADD CONSTRAINT FK_eu2x28qhmvl1lfrc6b2pxu7io FOREIGN KEY (nationalteam_id) REFERENCES nationalteam (id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1524043055147-22', 'rajko.jegdic (generated)', 'db.changelog-master.xml', NOW(), 22, '7:a70d724a65e6997817bd4e456618bad3', 'addForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset db.changelog-master.xml::1524043055147-23::rajko.jegdic (generated)
ALTER TABLE clubhistory ADD CONSTRAINT FK_f4aqj213n7kh08339wh7hjktu FOREIGN KEY (player_id) REFERENCES Player (id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1524043055147-23', 'rajko.jegdic (generated)', 'db.changelog-master.xml', NOW(), 23, '7:a8f86c80e7ec8cc847ac021d44c92ed5', 'addForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset db.changelog-master.xml::1524043055147-24::rajko.jegdic (generated)
ALTER TABLE Player ADD CONSTRAINT FK_g4vfjfg8nqnyp9quuses90hwp FOREIGN KEY (club_id) REFERENCES Club (id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1524043055147-24', 'rajko.jegdic (generated)', 'db.changelog-master.xml', NOW(), 24, '7:983a08425355dd0fae4573c3aecb8edd', 'addForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset db.changelog-master.xml::1524043055147-25::rajko.jegdic (generated)
ALTER TABLE Club ADD CONSTRAINT FK_gmaufqu7x6j778jsypdhl4msl FOREIGN KEY (city_id) REFERENCES City (id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1524043055147-25', 'rajko.jegdic (generated)', 'db.changelog-master.xml', NOW(), 25, '7:0b5a69b681e1af9af36bb9e2c9deaf7a', 'addForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset db.changelog-master.xml::1524043055147-26::rajko.jegdic (generated)
ALTER TABLE Competition ADD CONSTRAINT FK_hbjbk32o32lf7nrp0c5ionrak FOREIGN KEY (rank_id) REFERENCES Rank (id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1524043055147-26', 'rajko.jegdic (generated)', 'db.changelog-master.xml', NOW(), 26, '7:a17349cb36d30c5a15a86b5eaaf6d173', 'addForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset db.changelog-master.xml::1524043055147-27::rajko.jegdic (generated)
ALTER TABLE `match` ADD CONSTRAINT FK_iavh8rdhs7upbfwk7kps10to7 FOREIGN KEY (referee_id) REFERENCES Referee (id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1524043055147-27', 'rajko.jegdic (generated)', 'db.changelog-master.xml', NOW(), 27, '7:7d23fc614bc4ddc45b9f46cd6d852000', 'addForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset db.changelog-master.xml::1524043055147-28::rajko.jegdic (generated)
ALTER TABLE `match` ADD CONSTRAINT FK_iwp7ln5bte2a7nuwd97ucl4ft FOREIGN KEY (matchstats_id) REFERENCES matchstats (id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1524043055147-28', 'rajko.jegdic (generated)', 'db.changelog-master.xml', NOW(), 28, '7:8ff8235f6a404cc20d8dc26489115402', 'addForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset db.changelog-master.xml::1524043055147-29::rajko.jegdic (generated)
ALTER TABLE City ADD CONSTRAINT FK_m503bcpirmab9y40lg2ia9d54 FOREIGN KEY (country_id) REFERENCES Country (id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1524043055147-29', 'rajko.jegdic (generated)', 'db.changelog-master.xml', NOW(), 29, '7:52e116824b0a6dee375c11dea06ad46c', 'addForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset db.changelog-master.xml::1524043055147-30::rajko.jegdic (generated)
ALTER TABLE `match` ADD CONSTRAINT FK_mbp9rn05wat8rj8xfpyi0v9vk FOREIGN KEY (awayclub_id) REFERENCES Club (id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1524043055147-30', 'rajko.jegdic (generated)', 'db.changelog-master.xml', NOW(), 30, '7:8b0c608c47826763b311528daf5efa00', 'addForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset db.changelog-master.xml::1524043055147-31::rajko.jegdic (generated)
ALTER TABLE nationalteam ADD CONSTRAINT FK_mnmrmaf664e0gt0tf2f9l0qyr FOREIGN KEY (country_id) REFERENCES Country (id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1524043055147-31', 'rajko.jegdic (generated)', 'db.changelog-master.xml', NOW(), 31, '7:689403e04a2480f811d7d63cee002787', 'addForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset db.changelog-master.xml::1524043055147-32::rajko.jegdic (generated)
ALTER TABLE Player ADD CONSTRAINT FK_mqdpkupwf01p9qpni7pk763ql FOREIGN KEY (playerstats_id) REFERENCES playerstats (id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1524043055147-32', 'rajko.jegdic (generated)', 'db.changelog-master.xml', NOW(), 32, '7:b3f29b0508192d7e8247c829541376dc', 'addForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset db.changelog-master.xml::1524043055147-33::rajko.jegdic (generated)
ALTER TABLE Competition ADD CONSTRAINT FK_qk8sdhsdo6k40vohg37p5052n FOREIGN KEY (country_id) REFERENCES Country (id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1524043055147-33', 'rajko.jegdic (generated)', 'db.changelog-master.xml', NOW(), 33, '7:a017f5240026a46ae302ba0d8a0af36a', 'addForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset db.changelog-master.xml::1524043055147-34::rajko.jegdic (generated)
ALTER TABLE Player ADD CONSTRAINT FK_qslox644kmgewlytf6io8tcco FOREIGN KEY (position_id) REFERENCES Position (id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1524043055147-34', 'rajko.jegdic (generated)', 'db.changelog-master.xml', NOW(), 34, '7:9a6df62a838a26b31dc95e9af9d38d57', 'addForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset db.changelog-master.xml::1524043055147-35::rajko.jegdic (generated)
ALTER TABLE Club ADD CONSTRAINT FK_s4it79fie4hr2yopdet1icinw FOREIGN KEY (stadium_id) REFERENCES Stadium (id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1524043055147-35', 'rajko.jegdic (generated)', 'db.changelog-master.xml', NOW(), 35, '7:78027b10f8dd69bba7e08b6936d77fac', 'addForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset db.changelog-master.xml::1524050687731-1::vladimir.jevtic (generated)
ALTER TABLE country ADD countrycodes VARCHAR(255) NULL;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1524050687731-1', 'vladimir.jevtic (generated)', 'db.changelog-master.xml', NOW(), 36, '7:477a9e343983d11124e71b89019909e6', 'addColumn', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Release Database Lock
UPDATE DATABASECHANGELOGLOCK SET LOCKED = 0, LOCKEDBY = NULL, LOCKGRANTED = NULL WHERE ID = 1;

