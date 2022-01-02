/* DELETE 'strava' database*/
DROP SCHEMA stravadb;
/* DELETE USER 'strava' AT LOCAL SERVER*/
DROP USER 'strava'@'%';

/* CREATE ''stravadb' DATABASE */
CREATE SCHEMA stravadb;
/* CREATE THE USER 'strava' AT LOCAL SERVER WITH PASSWORD 'strava' */
CREATE USER 'strava'@'%' IDENTIFIED BY 'strava';
/* GRANT FULL ACCESS TO THE DATABASE 'stravadb' FOR THE USER 'strava' AT LOCAL SERVER*/
GRANT ALL ON strava.* TO 'strava'@'%';
