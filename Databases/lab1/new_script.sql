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

SELECT * FROM file_system;
SELECT * FROM file_system_2;