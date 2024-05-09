-- DDL
CREATE TABLE user (
	`id` VARCHAR(20) PRIMARY KEY,
	`password` VARCHAR(255) NOT NULL,
	`email` VARCHAR(100) NOT NULL UNIQUE,
	`name` VARCHAR(40) NOT NULL,
    `birth` DATE NOT NULL,
	`telecom` VARCHAR(3) NOT NULL CHECK(`telecom` IN('skt', 'kt', 'lgt')),
	`phone` CHAR(13) NOT NULL UNIQUE CHECK(`phone` REGEXP '^[0-9]{3}-[0-9]{4}-[0-9]{4}$'),
	`license` enum('Y','N') NOT NULL,
    `license_date` DATE,
	`agree` TINYINT NOT NULL,
	`admin` enum('Y','N') NOT NULL,
	`reg_date` TIMESTAMP NOT NULL DEFAULT(NOW()),
    `mod_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);


CREATE TABLE car (
	`car_num` INT PRIMARY KEY,
	`car_name` VARCHAR(100) NOT NULL,
	`car_brand` VARCHAR(20) NOT NULL,
    `car_img` VARCHAR(500) NOT NULL,
    `size` VARCHAR(4) NOT NULL CHECK(`size` IN('소형', '중형', '대형')),
    `price` INT NOT NULL,
	`country` ENUM('local', 'foreign') NOT NULL,
	`year` INT NOT NULL,
	`fuel` VARCHAR(20) NOT NULL CHECK(`fuel` IN('휘발유', '경유', 'LPG')),
	`limit_age` INT,
	`limit_period` INT,
	`reg_date` TIMESTAMP NOT NULL DEFAULT(NOW()),
    `mod_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
CREATE TABLE reservation (
	`id` VARCHAR(20),
	`car_num` INT,
	`rent_start` DATE,
	`rent_end` DATE,
	`rent_period` INT,
	`status` ENUM('complete', 'waiting', 'cancel', 'used') NOT NULL,
	`reg_date` TIMESTAMP NOT NULL DEFAULT(NOW()),
    `mod_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY(id, car_num, rent_start, rent_end),
	FOREIGN KEY(id) references user(id) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY(car_num) references car(car_num) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE board (
	`id` VARCHAR(20),
    `num` INT PRIMARY KEY auto_increment,
	`title` VARCHAR(100) NOT NULL,
	`content` TEXT NOT NULL,
	`notice` enum('Y','N') NOT NULL,
	`reg_date` TIMESTAMP NOT NULL DEFAULT(NOW()),
    `mod_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	FOREIGN KEY(id) references user(id) ON DELETE CASCADE ON UPDATE CASCADE

	
	
-- INSERT
INSERT INTO car(car_num, car_name, car_brand, car_img, size, price, country, year, fuel, limit_age, limit_period)
VALUES(FLOOR(RAND() * 9000) + 1000 , '캐스퍼', '현대', 'https://i.namu.wiki/i/8kBah1P5GkfEyDf3rTUkz66vdME0mGUyet0ZaVaUx2ozJpol1RBrAci6HjS2KBbAR57pRMtIDYZOQ-na8fhCEA.webp', '소형', 82500, 'local', 2022, '휘발유', 23, 2);

INSERT INTO car(car_num, car_name, car_brand, car_img, size, price, country, year, fuel, limit_age, limit_period)
VALUES(FLOOR(RAND() * 9000) + 1000 , '더 뉴 아반떼', '현대', 'https://autoimg.danawa.com/photo/4455/model_360.png', '중형', 88000, 'local', 2023, '휘발유', 26, 2);

INSERT INTO car(car_num, car_name, car_brand, car_img, size, price, country, year, fuel, limit_age, limit_period)
VALUES(FLOOR(RAND() * 9000) + 1000 , '아반떼AD', '현대', 'https://autoimg.danawa.com/photo/3259/model_360.png', '중형', 65450, 'local', 2017, '휘발유', 26, 2);

INSERT INTO car(car_num, car_name, car_brand, car_img, size, price, country, year, fuel, limit_age, limit_period)
VALUES(FLOOR(RAND() * 9000) + 1000 , '올 뉴 아반떼LPG', '현대', 'https://www.iusm.co.kr/news/photo/202008/884940_429627_52.jpg', '중형', 88000, 'local', 2021, 'LPG', 26, 2);

INSERT INTO car(car_num, car_name, car_brand, car_img, size, price, country, year, fuel, limit_age, limit_period)
VALUES(FLOOR(RAND() * 9000) + 1000 , '디 올 뉴 그랜저', '현대', 'https://autoimg.danawa.com/photo/4188/model_360.png', '대형',154000, 'local', 2023, '휘발유', 26, 2);

INSERT INTO car(car_num, car_name, car_brand, car_img, size, price, country, year, fuel, limit_age, limit_period)
VALUES(FLOOR(RAND() * 9000) + 1000 , '쏘나타 DN8', '현대', 'https://autoimg.danawa.com/photo/3652/model_360.png', '중형',101750, 'local', 2020, '휘발유', 21, 1);

INSERT INTO car(car_num, car_name, car_brand, car_img, size, price, country, year, fuel, limit_age, limit_period)
VALUES(FLOOR(RAND() * 9000) + 1000 , '쏘나타 DN8', '현대', 'https://autoimg.danawa.com/photo/3652/model_360.png', '중형', 96250, 'local', 2022, 'LPG', 26, 2);

INSERT INTO car(car_num, car_name, car_brand, car_img, size, price, country, year, fuel, limit_age, limit_period)
VALUES(FLOOR(RAND() * 9000) + 1000 , 'G80', '제네시스', 'https://autoimg.danawa.com/photo/3656/model_360.png', '대형', 181500, 'local', 2019, '휘발유', 26, 2);

INSERT INTO car(car_num, car_name, car_brand, car_img, size, price, country, year, fuel, limit_age, limit_period)
VALUES(FLOOR(RAND() * 9000) + 1000 , 'G90', '제네시스', 'https://flexible.img.hani.co.kr/flexible/normal/640/276/imgdb/resize/2018/1127/00501698_20181127.JPG', '대형', 258500, 'local', 2023, '휘발유', 26, 2);

INSERT INTO car(car_num, car_name, car_brand, car_img, size, price, country, year, fuel, limit_age, limit_period)
VALUES(FLOOR(RAND() * 9000) + 1000 , 'GV70', '제네시스', 'https://autoimg.danawa.com/photo/3849/model_360.png', '중형', 192500, 'local', 2021, '경유', 26, 2);

INSERT INTO car(car_num, car_name, car_brand, car_img, size, price, country, year, fuel, limit_age, limit_period)
VALUES(FLOOR(RAND() * 9000) + 1000 , '더 뉴 모닝', '기아', 'https://autoimg.danawa.com//photo/3239/model_360.png', '소형', 81400, 'local', 2023, '휘발유', 23, 2);

INSERT INTO car(car_num, car_name, car_brand, car_img, size, price, country, year, fuel, limit_age, limit_period)
VALUES(FLOOR(RAND() * 9000) + 1000 , '더 뉴 레이', '기아', 'https://autoimg.danawa.com/photo/4402/model_360.png', '소형', 65450, 'local', 2022, '휘발유', 21, 1);

INSERT INTO car(car_num, car_name, car_brand, car_img, size, price, country, year, fuel, limit_age, limit_period)
VALUES(FLOOR(RAND() * 9000) + 1000 , '올 뉴 K3', '기아', 'https://autoimg.danawa.com/photo/3551/model_360.png', '중형', 77000, 'local', 2020, '휘발유', 21, 1);

INSERT INTO car(car_num, car_name, car_brand, car_img, size, price, country, year, fuel, limit_age, limit_period)
VALUES(FLOOR(RAND() * 9000) + 1000 , '올 뉴 K3', '기아', 'https://autoimg.danawa.com/photo/3551/model_360.png', '중형', 88000, 'local', 2022, '휘발유', 26, 2);

INSERT INTO car(car_num, car_name, car_brand, car_img, size, price, country, year, fuel, limit_age, limit_period)
VALUES(FLOOR(RAND() * 9000) + 1000 , '더 뉴 K5', '기아', 'https://autoimg.danawa.com/photo/3566/model_360.png', '중형', 110000, 'local', 2024, 'LPG', 26, 2);

INSERT INTO car(car_num, car_name, car_brand, car_img, size, price, country, year, fuel, limit_age, limit_period)
VALUES(FLOOR(RAND() * 9000) + 1000 , '스파크', '쉐보레', 'https://autoimg.danawa.com//photo/3594/model_360.png', '소형', 51700, 'local', 2017, '휘발유', 26, 2);

INSERT INTO car(car_num, car_name, car_brand, car_img, size, price, country, year, fuel, limit_age, limit_period)
VALUES(FLOOR(RAND() * 9000) + 1000 , 'XM3', '르노', 'https://autoimg.danawa.com/photo/3701/model_360.png', '소형', 101750, 'local', 2022, '휘발유', 26, 2);

INSERT INTO car(car_num, car_name, car_brand, car_img, size, price, country, year, fuel, limit_age, limit_period)
VALUES(FLOOR(RAND() * 9000) + 1000 , 'SM6', '르노', 'https://autoimg.danawa.com/photo/3979/model_360.png', '중형', 90750, 'local', 2018, '휘발유', 26, 2);

INSERT INTO car(car_num, car_name, car_brand, car_img, size, price, country, year, fuel, limit_age, limit_period)
VALUES(FLOOR(RAND() * 9000) + 1000 , 'c200d', '벤츠', 'https://autoimg.danawa.com/photo/4037/model_360.png', '중형', 220000, 'foreign', 2021, '경유', 26, 2);

INSERT INTO car(car_num, car_name, car_brand, car_img, size, price, country, year, fuel, limit_age, limit_period)
VALUES(FLOOR(RAND() * 9000) + 1000 , 'G클래스 AMG', '벤츠', 'https://autoimg.danawa.com/photo/3753/model_360.png', '중형', 825000, 'foreign', 2021, '휘발유', 30, 3);

INSERT INTO car(car_num, car_name, car_brand, car_img, size, price, country, year, fuel, limit_age, limit_period)
VALUES(FLOOR(RAND() * 9000) + 1000 , '520i', 'BMW', 'https://autoimg.danawa.com/photo/3422/model_360.png', '대형', 231000, 'foreign', 2019, '휘발유', 26, 2);
 
INSERT INTO car(car_num, car_name, car_brand, car_img, size, price, country, year, fuel, limit_age, limit_period)
VALUES(FLOOR(RAND() * 9000) + 1000 , 'A6', '아우디', 'https://autoimg.danawa.com/photo/3713/model_360.png',  '대형', 253000, 'foreign', 2020, '휘발유', 26, 2);

INSERT INTO car(car_num, car_name, car_brand, car_img, size, price, country, year, fuel, limit_age, limit_period)
VALUES(FLOOR(RAND() * 9000) + 1000 , '제타', '폭스바겐', 'https://autoimg.danawa.com/photo/4412/model_360.png', '중형', 132000, 'foreign', 2022, '휘발유', 26, 2);

INSERT INTO car(car_num, car_name, car_brand, car_img, size, price, country, year, fuel, limit_age, limit_period)
VALUES(FLOOR(RAND() * 9000) + 1000 , 'XC40', '볼보', 'https://autoimg.danawa.com/photo/4405/model_360.png', '중형', 253000, 'foreign', 2022, '휘발유', 26, 2);

INSERT INTO car(car_num, car_name, car_brand, car_img, size, price, country, year, fuel, limit_age, limit_period)
VALUES(FLOOR(RAND() * 9000) + 1000 , '쿠퍼 컨버터블', '미니', 'https://autoimg.danawa.com/photo/3358/model_360.png', '소형', 154000, 'foreign', 2021, '휘발유', 26, 2);


-- etc