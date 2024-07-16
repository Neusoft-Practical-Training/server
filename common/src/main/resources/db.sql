drop database practice;
create database if not exists practice;
use practice;

# user
CREATE TABLE user
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    loginCode  VARCHAR(255) NOT NULL,
    password   VARCHAR(255) NOT NULL,
    tel        VARCHAR(20),
    name       VARCHAR(255),
    gender     INT,
    role       INT,
    age        INT,
    remarks    TEXT,
    status     BOOLEAN,
    avatar     VARCHAR(255),
    createTime DATETIME CURRENT_TIMESTAMP,
    updateTime DATETIME CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
