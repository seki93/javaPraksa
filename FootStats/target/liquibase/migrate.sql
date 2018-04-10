--  *********************************************************************
--  SQL to add all changesets to database history table
--  *********************************************************************
--  Change Log: src/main/resources/liquibase-changeLog.xml
--  Ran at: 4/10/18 2:00 PM
--  Against: root@localhost@jdbc:mysql://localhost:3306/footstats
--  Liquibase version: 3.4.1
--  *********************************************************************

--  Lock Database
UPDATE DATABASECHANGELOGLOCK SET LOCKED = 1, LOCKEDBY = 'INTERN-JEVTICV (192.168.52.7)', LOCKGRANTED = '2018-04-10 14:00:50.335' WHERE ID = 1 AND LOCKED = 0;

--  Release Database Lock
UPDATE DATABASECHANGELOGLOCK SET LOCKED = 0, LOCKEDBY = NULL, LOCKGRANTED = NULL WHERE ID = 1;

