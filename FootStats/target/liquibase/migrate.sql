--  *********************************************************************
--  SQL to add all changesets to database history table
--  *********************************************************************
--  Change Log: src/main/resources/liquibase-changeLog.xml
--  Ran at: 4/18/18 1:29 PM
--  Against: root@localhost@jdbc:mysql://localhost:3306/footstats
--  Liquibase version: 3.4.1
--  *********************************************************************

--  Lock Database
UPDATE DATABASECHANGELOGLOCK SET LOCKED = 1, LOCKEDBY = 'INTERN-JEVTICV (192.168.52.186)', LOCKGRANTED = '2018-04-18 13:29:29.501' WHERE ID = 1 AND LOCKED = 0;

--  Release Database Lock
UPDATE DATABASECHANGELOGLOCK SET LOCKED = 0, LOCKEDBY = NULL, LOCKGRANTED = NULL WHERE ID = 1;

