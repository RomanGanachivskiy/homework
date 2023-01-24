DROP SEQUENCE IF EXISTS persons_sequence;
CREATE SEQUENCE persons_sequence START WITH 3;

DROP TABLE IF EXISTS persons;
CREATE TABLE persons (
	id int8 NOT NULL,
	email varchar(256) NOT NULL,
	first_name varchar(256) NOT NULL,
	last_name varchar(256) NOT NULL,
	password varchar(256) NOT NULL,
	active bool NULL DEFAULT false,
	role varchar(256) NULL,
	CONSTRAINT persons PRIMARY KEY (id)
);