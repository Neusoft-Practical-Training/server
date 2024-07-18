drop
database practice;
create
database if not exists practice;
use
practice;

-- user
CREATE TABLE users
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
    createTime DATETIME DEFAULT CURRENT_TIMESTAMP,
    updateTime DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- province
CREATE TABLE `provinces`
(
    `id`   int          NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
);

-- cities
CREATE TABLE `cities`
(
    `id`            int          NOT NULL AUTO_INCREMENT,
    `name`          varchar(255) NOT NULL,
    `province_id`   int          NOT NULL,
    `province_name` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
);

-- grids
CREATE TABLE `grids`
(
    `id`            int          NOT NULL AUTO_INCREMENT,
    `name`          varchar(255) NOT NULL,
    `city_id`       int          NOT NULL,
    `city_name`     varchar(255) NOT NULL,
    `province_id`   int          NOT NULL,
    `province_name` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
);

-- admins
CREATE TABLE `admins`
(
    `id`          int          NOT NULL AUTO_INCREMENT,
    `user_id`     int          NOT NULL,
    `province_id` varchar(255) NOT NULL,
    `city_id`     varchar(255) NOT NULL,
    `permission`  int          NOT NULL,
    PRIMARY KEY (`id`)
);

-- aqis
CREATE TABLE `aqis`
(
    `id`              int          NOT NULL AUTO_INCREMENT,
    `aqi_id`          int          NOT NULL,
    `chinese_explain` varchar(255) NOT NULL,
    `aqi_explain`     varchar(255) NOT NULL,
    `color`           varchar(255) NOT NULL,
    `health_impact`   varchar(255) NOT NULL,
    `suggestions`     varchar(255) NOT NULL,
    `so2_min`         double       NOT NULL,
    `so2_max`         double       NOT NULL,
    `co_min`          double       NOT NULL,
    `co_max`          double       NOT NULL,
    `spm_min`         double       NOT NULL,
    `spm_max`         double       NOT NULL,
    `remarks`         varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

-- aqi_assignments
CREATE TABLE `aqi_assignments`
(
    `id`            int          NOT NULL AUTO_INCREMENT,
    `aa_id`         int          NOT NULL,
    `af_id`         int          NOT NULL,
    `as_id`         int          NOT NULL,
    `supervisor_id` int          NOT NULL,
    `admin_id`      int          NOT NULL,
    `gm_id`         int          NOT NULL,
    `cross_domain`  int          NOT NULL,
    `completed`     int          NOT NULL,
    `grid_id`       varchar(255) NOT NULL,
    `address`       varchar(255) NOT NULL,
    `assign_date`   varchar(255) NOT NULL,
    `assign_time`   varchar(255) NOT NULL,
    `remarks`       varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

-- aqi_feedbacks
CREATE TABLE `aqi_feedbacks`
(
    `id`            int          NOT NULL AUTO_INCREMENT,
    `af_id`         int          NOT NULL,
    `supervisor_id` int          NOT NULL,
    `pre_aqi_id`    int          NOT NULL,
    `aa_id`         int          NOT NULL,
    `state`         int          NOT NULL,
    `grid_id`       varchar(255) NOT NULL,
    `address`       varchar(255) NOT NULL,
    `af_time`       varchar(255) NOT NULL,
    `af_date`       varchar(255) NOT NULL,
    `explain`       varchar(255) NOT NULL,
    `remarks`       varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

-- aqi_statistics
CREATE TABLE `aqi_statistics`
(
    `id`             int          NOT NULL AUTO_INCREMENT,
    `as_id`          int          NOT NULL,
    `aa_id`          int          NOT NULL,
    `gm_id`          int          NOT NULL,
    `confirm_aqi_id` int          NOT NULL,
    `so2_level`      int          NOT NULL,
    `co_level`       int          NOT NULL,
    `spm_level`      int          NOT NULL,
    `so2_value`      double       NOT NULL,
    `co_value`       double       NOT NULL,
    `spm_value`      double       NOT NULL,
    `grid_id`        varchar(255) NOT NULL,
    `address`        varchar(255) NOT NULL,
    `confirm_date`   varchar(255) NOT NULL,
    `confirm_time`   varchar(255) NOT NULL,
    `explain`        varchar(255) NOT NULL,
    `remarks`        varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

-- grid_members
CREATE TABLE `grid_members`
(
    `id`          int          NOT NULL AUTO_INCREMENT,
    `user_id`     int          NOT NULL,
    `task_num`    int          NOT NULL,
    `province_id` varchar(255) NOT NULL,
    `city_id`     varchar(255) NOT NULL,
    `state`       int          NOT NULL,
    PRIMARY KEY (`id`),
    KEY `user_id_idx` (`user_id`)
);