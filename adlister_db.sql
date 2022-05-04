CREATE DATABASE IF NOT EXISTS adlister_db;
USE adlister_db;
DROP TABLE IF EXISTS users;
CREATE TABLE IF NOT EXISTS users
(
    id       INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(150) NOT NULL,
    email    VARCHAR(150),
    password VARCHAR(150),
    PRIMARY KEY (id)
);
DROP TABLE IF EXISTS ads;
CREATE TABLE IF NOT EXISTS ads
(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id INT UNSIGNED NOT NULL,
    title VARCHAR(100),
    description VARCHAR(500),
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
);

INSERT INTO users (username, email, password) VALUES ('paul', 'paul@email.com', 'password');
DESC ads;
SELECT * FROM users;