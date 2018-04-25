--  *********************************************************************
--  Update Database Script
--  *********************************************************************
--  Change Log: src/main/resources/liquibase-changeLog.xml
--  Ran at: 4/25/18 9:56 AM
--  Against: root@localhost@jdbc:mysql://localhost:3306/footstats
--  Liquibase version: 3.4.1
--  *********************************************************************

--  Lock Database
UPDATE DATABASECHANGELOGLOCK SET LOCKED = 1, LOCKEDBY = 'INTERN-STEFANS (192.168.52.61)', LOCKGRANTED = '2018-04-25 09:56:52.806' WHERE ID = 1 AND LOCKED = 0;

--  Changeset db.changelog-master.xml::1524050687731-667::vladimir.jevtic (generated)
ALTER TABLE person DROP FOREIGN KEY FK_8wn40qodtwfnnucxs25pjvuah;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1524050687731-667', 'vladimir.jevtic (generated)', 'db.changelog-master.xml', NOW(), 38, '7:c38c4964cd4fdf940b1a50f3a277b203', 'dropForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset db.changelog-master.xml::1524050687731-668::vladimir.jevtic (generated)
ALTER TABLE person DROP COLUMN cityofbirth_id;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1524050687731-668', 'vladimir.jevtic (generated)', 'db.changelog-master.xml', NOW(), 39, '7:5abb512889802d6fb4ddc214331e703a', 'dropColumn', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset db.changelog-master.xml::1524050687731-669::vladimir.jevtic (generated)
ALTER TABLE person ADD countryofbirth_id INT NULL;

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1524050687731-669', 'vladimir.jevtic (generated)', 'db.changelog-master.xml', NOW(), 40, '7:aa716ff9eb0661a2fce85628b61c3c56', 'addColumn', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Changeset db.changelog-master.xml::1524050687731-670::vladimir.jevtic (generated)
ALTER TABLE Person ADD CONSTRAINT FK_8wn40qodtwfnnucxs25pjvuah FOREIGN KEY (countryofbirth_id) REFERENCES Country (id);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE) VALUES ('1524050687731-670', 'vladimir.jevtic (generated)', 'db.changelog-master.xml', NOW(), 41, '7:39ccfe5afa212775b168dd7123a42c74', 'addForeignKeyConstraint', '', 'EXECUTED', NULL, NULL, '3.4.1');

--  Release Database Lock
UPDATE DATABASECHANGELOGLOCK SET LOCKED = 0, LOCKEDBY = NULL, LOCKGRANTED = NULL WHERE ID = 1;

