DROP TABLE IF EXISTS drives;
DROP TABLE IF EXISTS bikes;
DROP TABLE IF EXISTS users;

/* SELECT drive_id, COST, HOURS, BIKE_ID, USER_ID FROM drives WHERE (BIKE_ID = ?)*/
CREATE TABLE bikes
(
    id SERIAL PRIMARY KEY,
    bike_name VARCHAR(255),
    cost_per_hour INTEGER
);

CREATE TABLE users
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    budget INTEGER
);

CREATE TABLE drives
(
    id SERIAL PRIMARY KEY,
    bike_id BIGINT REFERENCES bikes,
    user_id BIGINT REFERENCES users,
    hours INTEGER,
    cost INTEGER
);

