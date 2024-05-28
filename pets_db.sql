-- Создание базы данных и таблиц в соответсвии с иерархией из диаграммы
CREATE DATABASE IF NOT EXISTS pets_db;

USE pets_db;

CREATE TABLE animals (
    animal_id INT AUTO_INCREMENT PRIMARY KEY,
    animal_class ENUM('домашний', 'вьючный') NOT NULL
);

-- Таблица для домашних животных
CREATE TABLE Domestic_Animals (
    domestic_id INT AUTO_INCREMENT PRIMARY KEY,
    animal_id INT,
    animal_type VARCHAR(50),
    FOREIGN KEY (animal_id) REFERENCES animals(animal_id)
);

-- Таблица для вьючных животных
CREATE TABLE Livestock_Animals (
    livestock_id INT AUTO_INCREMENT PRIMARY KEY,
    animal_id INT,
    animal_type VARCHAR(50),
    FOREIGN KEY (animal_id) REFERENCES animals(animal_id)
);

-- Таблица для кошек
CREATE TABLE Cats (
    cat_id INT AUTO_INCREMENT PRIMARY KEY,
    animal_id INT,
    name VARCHAR(50),
    birth_date DATE,
    breed VARCHAR(50),
    commands VARCHAR(100),
    FOREIGN KEY (animal_id) REFERENCES animals(animal_id)
);

-- Таблица для собак
CREATE TABLE Dogs (
    dog_id INT AUTO_INCREMENT PRIMARY KEY,
    animal_id INT,
    name VARCHAR(50),
    birth_date DATE,
    breed VARCHAR(50),
    commands VARCHAR(100),
    FOREIGN KEY (animal_id) REFERENCES animals(animal_id)
);

-- Таблица для хомяков
CREATE TABLE Hamsters (
    hamster_id INT AUTO_INCREMENT PRIMARY KEY,
    animal_id INT,
    name VARCHAR(50),
    birth_date DATE,
    breed VARCHAR(50),
    commands VARCHAR(100),
    FOREIGN KEY (animal_id) REFERENCES animals(animal_id)
);

-- Таблица для лошадей
CREATE TABLE Horses (
    horse_id INT AUTO_INCREMENT PRIMARY KEY,
    animal_id INT,
    name VARCHAR(50),
    birth_date DATE,
    breed VARCHAR(50),
    commands VARCHAR(100),
    FOREIGN KEY (animal_id) REFERENCES animals(animal_id)
);

-- Таблица для верблюдов
CREATE TABLE Camels (
    camel_id INT AUTO_INCREMENT PRIMARY KEY,
    animal_id INT,
    name VARCHAR(50),
    birth_date DATE,
    breed VARCHAR(50),
    commands VARCHAR(100),
    FOREIGN KEY (animal_id) REFERENCES animals(animal_id)
);

-- Таблица для ослов
CREATE TABLE Donkeys (
    donkey_id INT AUTO_INCREMENT PRIMARY KEY,
    animal_id INT,
    name VARCHAR(50),
    birth_date DATE,
    breed VARCHAR(50),
    commands VARCHAR(100),
    FOREIGN KEY (animal_id) REFERENCES animals(animal_id)
);

-- ------------------------------------------------------------------------------------------------------------

-- ЗАПОЛНЕНИЕ ТАБЛИЦ

-- Заполнение таблицы animals
INSERT INTO animals (animal_class) VALUES 
('домашний'), -- 1
('домашний'), -- 2
('домашний'), -- 3
('домашний'), -- 4
('домашний'), -- 5
('домашний'), -- 6
('домашний'), -- 7
('вьючный'),  -- 8
('вьючный'),  -- 9
('вьючный'),  -- 10
('вьючный'),  -- 11
('вьючный'),  -- 12
('вьючный'),  -- 13
('вьючный'),  -- 14
('вьючный'),  -- 15
('вьючный'),  -- 16
('вьючный'),  -- 17
('вьючный'),  -- 18
('вьючный'),  -- 19
('вьючный');  -- 20

-- Заполнение таблицы Domestic_Animals (домашние животные)
INSERT INTO Domestic_Animals (animal_id, animal_type) VALUES
(1, 'Cat'), -- Мурка
(2, 'Cat'), -- Барсик
(3, 'Dog'), -- Бобик
(4, 'Dog'), -- Рекс
(5, 'Dog'), -- Макс
(6, 'Hamster'), -- Хома
(7, 'Hamster'); -- Буся

-- Заполнение таблицы Livestock_Animals (вьючные животные)
INSERT INTO Livestock_Animals (animal_id, animal_type) VALUES
(8, 'Horse'), -- Буран
(9, 'Horse'), -- Амур
(10, 'Horse'), -- Гроза
(11, 'Horse'), -- Зорька
(12, 'Horse'), -- Пегас
(13, 'Camel'), -- Маруся
(14, 'Camel'), -- Баклажан
(15, 'Camel'), -- Жемчуг
(16, 'Camel'), -- Сафари
(17, 'Donkey'), -- Иван
(18, 'Donkey'), -- Матильда
(19, 'Donkey'), -- Грейси
(20, 'Donkey'); -- Барней


-- Заполнение таблицы Cats (коты)
INSERT INTO Cats (animal_id, name, birth_date, breed, commands) VALUES
(1, 'Мурка', '2019-01-15', 'Шотландская вислоухая', 'Прыгать, кушать, спать'), -- 1
(2, 'Барсик', '2018-06-20', 'Персидская', 'Ласкаться, спать на коленях');         -- 2

-- Заполнение таблицы Dogs (собаки)
INSERT INTO Dogs (animal_id, name, birth_date, breed, commands) VALUES
(3, 'Бобик', '2017-07-20', 'Джек-рассел-терьер', 'Сидеть, лежать, апорт'),       -- 3
(4, 'Рекс', '2019-03-10', 'Лабрадор', 'Фас, в положение, место'),                -- 4
(5, 'Макс', '2016-11-05', 'Немецкая овчарка', 'Фу, к ноге, апорт');              -- 5

-- Заполнение таблицы Hamsters (хомяки)
INSERT INTO Hamsters (animal_id, name, birth_date, breed, commands) VALUES
(6, 'Хома', '2020-04-22', 'Сирийский хомяк', 'Крутиться в колесе, кушать семечки'), -- 6
(7, 'Буся', '2021-02-12', 'Роборовский хомяк', 'Бегать по трубочке, кушать овощи');   -- 7

-- Заполнение таблицы Horses (лошади)
INSERT INTO Horses (animal_id, name, birth_date, breed, commands) VALUES
(8, 'Буран', '2014-08-28', 'Арабская скаковая лошадь', 'Верховая езда, рыскание'), -- 8
(9, 'Амур', '2017-05-10', 'Фризский конь', 'Верховая езда, выездка'),                -- 9
(10, 'Гроза', '2018-12-01', 'Тройцкий скакун', 'Верховая езда, скакать по препятствиям'), -- 10
(11, 'Зорька', '2016-02-20', 'Белорусская упряжная', 'Тянуть плуг, возить грузы'),        -- 11
(12, 'Пегас', '2015-09-15', 'Андалузский скакун', 'Верховая езда, выступление на шоу');   -- 12

-- Заполнение таблицы Camels (верблюды)
INSERT INTO Camels (animal_id, name, birth_date, breed, commands) VALUES
(13, 'Маруся', '2016-11-12', 'Двугорбый верблюд', 'Переносить грузы, переносить людей'),   -- 13
(14, 'Баклажан', '2019-03-24', 'Барханец', 'Перевозка грузов, использование шерсти и мяса'), -- 14
(15, 'Жемчуг', '2017-05-28', 'Дромадер', 'Длительные походы, перенос песка и воды'),        -- 15
(16, 'Сафари', '2018-10-10', 'Каракумский верблюд', 'Туристические поездки, перевозка туристов'); -- 16

-- Заполнение таблицы Donkeys (ослы)
INSERT INTO Donkeys (animal_id, name, birth_date, breed, commands) VALUES
(17, 'Иван', '2019-09-05', 'Американский миниатюрный ослик', 'Тянуть повозки, нести грузы'),       -- 17
(18, 'Матильда', '2020-12-18', 'Андалузский ослик', 'Переносить грузы, работать в сельском хозяйстве'), -- 18
(19, 'Грейси', '2018-04-03', 'Малтезский ослик', 'Тянуть плуги, работать на ферме'),        -- 19
(20, 'Барней', '2017-08-22', 'Каракульский ослик', 'Нести грузы, использоваться в туризме'); -- 20

-- ------------------------------------------------------------------------------------------------------------

-- Удаление таблицы Camels
DROP TABLE IF EXISTS Camels;

-- Создание новой таблицы Horses_and_Donkeys
CREATE TABLE Horses_and_Donkeys (
    animal_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    birth_date DATE,
    breed VARCHAR(50),
    commands VARCHAR(100),
    animal_type ENUM('лошадь', 'осел') NOT NULL,
    FOREIGN KEY (animal_id) REFERENCES animals(animal_id)
);

-- Вставка данных из таблицы Horses и объединение с таблицей Donkeys
INSERT INTO Horses_and_Donkeys (animal_id, name, birth_date, breed, commands, animal_type)
SELECT H.animal_id, H.name, H.birth_date, H.breed, H.commands, 'лошадь'
FROM Horses H
UNION ALL
SELECT D.animal_id, D.name, D.birth_date, D.breed, D.commands, 'осел'
FROM Donkeys D;

-- Удаление таблиц Horses и Donkeys
DROP TABLE IF EXISTS Horses;
DROP TABLE IF EXISTS Donkeys;

-- ------------------------------------------------------------------------------------------------------------

-- Создание таблицы для молодых животных
CREATE TABLE Young_Animals (
    animal_id INT AUTO_INCREMENT PRIMARY KEY,
    animal_type VARCHAR(50),
    name VARCHAR(50),
    birth_date DATE,
    age_months INT,
    FOREIGN KEY (animal_id) REFERENCES animals(animal_id)
);

-- Вычисление возраста каждого животного с точностью до месяца
INSERT INTO Young_Animals (animal_id, animal_type, name, birth_date, age_months)
SELECT A.animal_id,
       CASE
           WHEN C.cat_id IS NOT NULL THEN 'Кот'
           WHEN D.dog_id IS NOT NULL THEN 'Собака'
           WHEN H.hamster_id IS NOT NULL THEN 'Хомяк'
           WHEN HD.animal_type = 'лошадь' THEN 'Лошадь'
           WHEN HD.animal_type = 'осел' THEN 'Осел'
       END AS animal_type,
       CASE
           WHEN C.cat_id IS NOT NULL THEN C.name
           WHEN D.dog_id IS NOT NULL THEN D.name
           WHEN H.hamster_id IS NOT NULL THEN H.name
           WHEN HD.animal_type = 'лошадь' THEN HD.name
           WHEN HD.animal_type = 'осел' THEN HD.name
       END AS name,
       CASE
           WHEN C.cat_id IS NOT NULL THEN C.birth_date
           WHEN D.dog_id IS NOT NULL THEN D.birth_date
           WHEN H.hamster_id IS NOT NULL THEN H.birth_date
           WHEN HD.animal_type = 'лошадь' THEN HD.birth_date
           WHEN HD.animal_type = 'осел' THEN HD.birth_date
       END AS birth_date,
       TIMESTAMPDIFF(MONTH, 
                     CASE
                         WHEN C.cat_id IS NOT NULL THEN C.birth_date
                         WHEN D.dog_id IS NOT NULL THEN D.birth_date
                         WHEN H.hamster_id IS NOT NULL THEN H.birth_date
                         WHEN HD.animal_type = 'лошадь' THEN HD.birth_date
                         WHEN HD.animal_type = 'осел' THEN HD.birth_date
                     END, 
                     CURDATE()) AS age_months
FROM animals A
LEFT JOIN Cats C ON A.animal_id = C.animal_id
LEFT JOIN Dogs D ON A.animal_id = D.animal_id
LEFT JOIN Hamsters H ON A.animal_id = H.animal_id
LEFT JOIN Horses_and_Donkeys HD ON A.animal_id = HD.animal_id
WHERE TIMESTAMPDIFF(YEAR, 
                    CASE
                        WHEN C.cat_id IS NOT NULL THEN C.birth_date
                        WHEN D.dog_id IS NOT NULL THEN D.birth_date
                        WHEN H.hamster_id IS NOT NULL THEN H.birth_date
                        WHEN HD.animal_type = 'лошадь' THEN HD.birth_date
                        WHEN HD.animal_type = 'осел' THEN HD.birth_date
                    END, 
                    CURDATE()) BETWEEN 1 AND 3;

-- Просмотр данных в таблице молодых животных
SELECT * FROM Young_Animals;

-- ------------------------------------------------------------------------------------------------------------

-- Создание объединенной таблицы
CREATE TABLE All_Animals (
    animal_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    birth_date DATE,
    breed VARCHAR(50),
    commands VARCHAR(100),
    animal_type VARCHAR(50), -- Дополнительный столбец для указания на источник данных
    old_table VARCHAR(50) -- Дополнительный столбец для указания на источник таблицы
);

-- Вставка данных из всех таблиц, сохраняя информацию о прежней принадлежности
INSERT INTO All_Animals (name, birth_date, breed, commands, animal_type, old_table)
SELECT name, birth_date, breed, commands, 'Cat' AS animal_type, 'Cats' AS old_table FROM Cats
UNION ALL
SELECT name, birth_date, breed, commands, 'Dog', 'Dogs' FROM Dogs
UNION ALL
SELECT name, birth_date, breed, commands, 'Hamster', 'Hamsters' FROM Hamsters
UNION ALL
SELECT name, birth_date, breed, commands, animal_type, 'Horses_and_Donkeys' FROM Horses_and_Donkeys;

-- Удаление старых таблиц
DROP TABLE IF EXISTS Cats;
DROP TABLE IF EXISTS Dogs;
DROP TABLE IF EXISTS Hamsters;
DROP TABLE IF EXISTS Horses_and_Donkeys;

-- Просмотр данных таблицы all_animals
SELECT * FROM all_animals;
-- ------------------------------------------------------------------------------------------------------------