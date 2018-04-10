--  *********************************************************************
--  SQL to add all changesets to database history table
--  *********************************************************************
--  Change Log: src/main/resources/liquibase-changeLog.xml
--  Ran at: 4/10/18 1:55 PM
--  Against: root@localhost@jdbc:mysql://localhost:3306/footstats
--  Liquibase version: 3.4.1
--  *********************************************************************

--  Lock Database
UPDATE DATABASECHANGELOGLOCK SET LOCKED = 1, LOCKEDBY = 'INTERN-RAJKOJ (192.168.52.66)', LOCKGRANTED = '2018-04-10 13:55:37.251' WHERE ID = 1 AND LOCKED = 0;

--  Release Database Lock
UPDATE DATABASECHANGELOGLOCK SET LOCKED = 0, LOCKEDBY = NULL, LOCKGRANTED = NULL WHERE ID = 1;

