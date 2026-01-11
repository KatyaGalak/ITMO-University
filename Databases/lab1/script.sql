DROP TABLE IF EXISTS Participation CASCADE;
DROP TABLE IF EXISTS Communication CASCADE;
DROP TABLE IF EXISTS Psychological_state CASCADE;
DROP TABLE IF EXISTS Phychological_action CASCADE;
DROP TABLE IF EXISTS Sound_production CASCADE;
DROP TABLE IF EXISTS Sound_source CASCADE;
DROP TABLE IF EXISTS Reation_to_sound CASCADE;
DROP TABLE IF EXISTS Sound CASCADE;
DROP TABLE IF EXISTS Physical_action CASCADE;
DROP TABLE IF EXISTS Social_action CASCADE;
DROP TABLE IF EXISTS Danger CASCADE;
DROP TABLE IF EXISTS Collision CASCADE;
DROP TABLE IF EXISTS "Object" CASCADE;
DROP TABLE IF EXISTS Thought CASCADE;
DROP TABLE IF EXISTS "Location" CASCADE;
DROP TABLE IF EXISTS Person CASCADE;
DROP TYPE IF EXISTS Type_sound CASCADE;
DROP TYPE IF EXISTS Type_danger CASCADE;

CREATE TABLE Thought (
    thought_id SERIAL PRIMARY KEY,
    "name" TEXT NOT NULL,
    "description" TEXT
);

CREATE TABLE "Location" (
    location_id SERIAL PRIMARY KEY,
    "name" TEXT NOT NULL,
    "description" TEXT
);

CREATE TABLE Person (
    person_id SERIAL PRIMARY KEY,
    first_name TEXT NOT NULL,
    second_name TEXT NOT NULL,
    date_of_birth DATE,
    thought_id BIGINT REFERENCES Thought(thought_id),
    location_id BIGINT REFERENCES "Location"(location_id)
);

CREATE TABLE "Object" (
    object_id SERIAL PRIMARY KEY,
    "name" TEXT NOT NULL,
    "description" TEXT,
    "number" INT,
    location_id BIGINT REFERENCES "Location"(location_id) ON DELETE CASCADE
);

CREATE TYPE Type_danger AS ENUM (
    'животные',
    'насекомые',
    'землетрясение',
    'ураган',
    'пожар',
    'цунами'
);

CREATE TABLE Danger (
    danger_id SERIAL PRIMARY KEY,
    "name" TEXT NOT NULL,
    "description" TEXT,
    type_danger Type_danger
);

CREATE TABLE Collision (
    person_id BIGINT REFERENCES Person(person_id),
    danger_id BIGINT REFERENCES Danger(danger_id),
    PRIMARY KEY (person_id, danger_id)  
);

CREATE TABLE Phychological_action (
    psychological_action_id SERIAL PRIMARY KEY,
    "name" TEXT NOT NULL,
    "description" TEXT
);

CREATE TABLE Psychological_state (
    person_id BIGINT REFERENCES Person(person_id),
    psychological_action_id BIGINT REFERENCES Phychological_action(psychological_action_id),
    PRIMARY KEY (person_id, psychological_action_id)  
);

CREATE TABLE Social_action (
    social_action_id SERIAL PRIMARY KEY,
    "name" TEXT NOT NULL,
    "description" TEXT
);

CREATE TABLE Communication (
    person_id BIGINT REFERENCES Person(person_id),
    social_action_id BIGINT REFERENCES Social_action(social_action_id),
    PRIMARY KEY (person_id, social_action_id)  
);

CREATE TABLE Physical_action (
    physical_action_id SERIAL PRIMARY KEY,
    "name" TEXT NOT NULL,
    "description" TEXT
);

CREATE TABLE Participation (
    person_id BIGINT REFERENCES Person(person_id),
    physical_action_id BIGINT REFERENCES Physical_action(physical_action_id),
    PRIMARY KEY (person_id, physical_action_id)  
);

CREATE TYPE Type_sound AS ENUM (
    'звуки животных',
    'звуки природы',
    'звуки от человека',
    'звуки техники',
    'звуки транспорта',
    'акустические звуки',
    'звуки других источников'
);

CREATE TABLE Sound (
    sound_id SERIAL PRIMARY KEY,
    "name" TEXT NOT NULL,
    "description" TEXT,
    type_sound Type_sound
);

CREATE TABLE Reation_to_sound (
    person_id BIGINT REFERENCES Person(person_id),
    sound_id BIGINT REFERENCES Sound(sound_id),
    PRIMARY KEY (person_id, sound_id)  
);

CREATE TABLE Sound_source (
    sound_source_id SERIAL PRIMARY KEY,
    "name" TEXT NOT NULL,
    "description" TEXT
);

CREATE TABLE Sound_production (
    sound_id BIGINT REFERENCES Sound(sound_id),
    sound_source_id BIGINT REFERENCES Sound_source(sound_source_id),
    PRIMARY KEY (sound_id, sound_source_id)  
);

INSERT INTO "Location" ("name") VALUES ('коридор');
INSERT INTO Thought ("name", "description") VALUES ('Планировка здания','вспомнил планировку этой части здания, так как был здесь на экскурсии');
INSERT INTO Person (first_name, second_name, thought_id, location_id) VALUES ('Тим', 'Пуговкин', 1, 1), ('Лекси', 'Землякова', NULL, 1);

---INSERT INTO Thought ("name", "description") VALUES ('Мысли о смерти','долго думала о смерти из-за опасности');
---INSERT INTO Person (first_name, second_name, thought_id, location_id) VALUES ('Настя', 'Смелкова', 2, 1);

INSERT INTO Physical_action("name", "description") VALUES ('Бег вприпрыжку', 'бежала вприпрыжку');
INSERT INTO Participation(person_id, physical_action_id) VALUES (2, 1); -- (2,) - Лекси, (,1) - Бег вприпрыжку

INSERT INTO Danger("name", "description", type_danger) VALUES ('Велоцирапторы', 'опасные хищники, приближающиеся к персонажам', 'животные');
INSERT INTO Collision(person_id, danger_id) VALUES (1, 1), (2, 1); -- (1,) - Тим, (2,) - Лекси, (,1) - Велоцирапторы

INSERT INTO Sound("name", "description", type_sound) VALUES ('Рычание велоцирапторов', 'рычание опасных хищников', 'звуки животных');
INSERT INTO Reation_to_sound(person_id, sound_id) VALUES (1, 1), (2, 1); -- (1,) - Тим, (2,) - Лекси, (,1) - Рычание велоцирапторов

INSERT INTO Sound_source("name") VALUES ('Велоцирапторы');
INSERT INTO Sound_production(sound_id, sound_source_id) VALUES (1, 1); -- (1,) - Рычание велоцирапторов, (1,) - Велоцирапторы

INSERT INTO Phychological_action("name", "description") VALUES ('Страх', 'испытывается страх из-за рычания опасных хищников');
INSERT INTO Psychological_state(person_id, psychological_action_id) VALUES (1, 1); -- (1,) - Тим, (,1) - Страх

INSERT INTO Physical_action("name", "description") VALUES ('Удар о стекло', 'Ударился о стекло, из-за чего стекло издало звон');
INSERT INTO Participation(person_id, physical_action_id) VALUES (1, 2), (2, 2); -- (1,) - Тим, (2,) - Лекси, (,2) - удар о стекло

INSERT INTO Sound("name", type_sound) VALUES ('Звон стекла', 'акустические звуки');
INSERT INTO Reation_to_sound(person_id, sound_id) VALUES (1, 2), (2, 2); -- (1,) - Тим, (2,) - Лекси, (,2) - звон стекла

INSERT INTO Sound_source("name", "description") VALUES ('Стекло', 'звук, получившийся в результате удара о стекло');
INSERT INTO Sound_production(sound_id, sound_source_id) VALUES (2, 2); -- (1,) - Звон стекла, (1,) - Стекло

INSERT INTO Physical_action("name", "description") VALUES ('Толчок двери', 'толкнул дверь, чтобы войти в комнату');
INSERT INTO Participation(person_id, physical_action_id) VALUES (1, 3); -- (1,) - Тим, (,3) - Толчок двери

INSERT INTO Social_action("name",  "description") VALUES ('Обсуждение плана дальнейших действия', 'Тим и Лекси обсуждают план дальнейших действий');
INSERT INTO Communication(person_id, social_action_id) VALUES (1, 1), (2, 1); -- (1,) - Тим, (2,) - Лекси, (,1) - обсуждение плана

INSERT INTO "Location"("name") VALUES ('Контрольный пункт');
UPDATE Person
SET location_id = 2
WHERE person_id IN (1, 2); -- изменяем локацию Тима и Лекси на 2 (контрольный пункт)

INSERT INTO "Object"("name", "description", "number", location_id) VALUES ('пульт', NULL, 1, 2),
                                                                        ('стул', NULL, 4, 2),
                                                                        ('компьютерный дисплей', 'мониторы, на которых высвечивались разноцветные прямоугольники', 4, 2);

CREATE VIEW view_person_ AS (
    SELECT person_id, first_name, second_name, date_of_birth, thought_id
    FROM Person
);

UPDATE view_person_
SET first_name = 'Тоня'
WHERE person_id = 1;





---DROP TABLE if EXISTS file_system CASCADE;
---DROP TABLE if EXISTS file_system_2 CASCADE;
---DROP TYPE IF EXISTS Type_file CASCADE;

/*
CREATE TABLE file_system (
    id SERIAL PRIMARY KEY,
    "name" VARCHAR(255) NOT NULL,
    parent_id Int REFERENCES file_system(id) on delete CASCADE,
    "size" Int default 0,
    is_folder INT default 1
);

CREATE TABLE file_system_2 (
    id SERIAL PRIMARY KEY,
    "name" VARCHAR(255) NOT NULL,
    previos_id Int REFERENCES file_system(id) on delete CASCADE,
    parent_id Int REFERENCES file_system_2(id) on delete CASCADE,
    "size" Int default 0,
    is_folder INT
);

INSERT INTO file_system("name", is_folder) VALUES ('корень', 1);

INSERT INTO file_system("name", parent_id, is_folder, "size") VALUES ('folder_1', 1, 1, 0);
UPDATE file_system 
SET "size" = 1
WHERE id = 2;

INSERT INTO file_system("name", parent_id, is_folder) VALUES ('folder_2', 1, 1);
INSERT INTO file_system("name", parent_id, is_folder) VALUES ('file1', 1, 0);
INSERT INTO file_system("name", parent_id, is_folder) VALUES ('file2', 2, 0);
INSERT INTO file_system("name", parent_id, is_folder) VALUES ('file2', 3, 0);

INSERT INTO file_system_2("name", is_folder) VALUES ('корень', 1);
INSERT INTO file_system_2("name", previos_id, parent_id, is_folder) VALUES ('folder_21', 1, 1, 0);
INSERT INTO file_system_2("name", previos_id, parent_id, is_folder) VALUES ('file_21', 1, 1, 1);

---SELECT id, "name", parent_id, type_file FROM file_system ORDER BY id, type_file;


SELECT * FROM file_system;
SELECT * FROM file_system_2;*/