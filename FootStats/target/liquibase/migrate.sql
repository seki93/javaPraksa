--  *********************************************************************
--  Update Database Script
--  *********************************************************************
--  Change Log: src/main/resources/liquibase-changeLog.xml
--  Ran at: 4/24/18 1:07 PM
--  Against: root@localhost@jdbc:mysql://localhost:3306/footstats
--  Liquibase version: 3.4.1
--  *********************************************************************

--  Lock Database
UPDATE DATABASECHANGELOGLOCK SET LOCKED = 1, LOCKEDBY = 'INTERN-JEVTICV (192.168.52.233)', LOCKGRANTED = '2018-04-24 13:07:28.081' WHERE ID = 1 AND LOCKED = 0;

--  Release Database Lock
UPDATE DATABASECHANGELOGLOCK SET LOCKED = 0, LOCKEDBY = NULL, LOCKGRANTED = NULL WHERE ID = 1;

