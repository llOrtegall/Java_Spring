USE hibernate_db;

SHOW TABLES;

CREATE TABLE IF NOT EXISTS persons (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    names VARCHAR(100) NOT NULL,
    lastnames VARCHAR(100) NOT NULL,
    lenguajes VARCHAR(100) NOT NULL
);

INSERT INTO persons (names, lastnames, lenguajes) VALUES
('John', 'Doe', 'English'),
('Jane', 'Smith', 'Spanish'),
('Carlos', 'Gonzalez', 'Spanish'),
('Maria', 'Garcia', 'English'),
('David', 'Johnson', 'English'),
('Ana', 'Martinez', 'Spanish'),
('Michael', 'Brown', 'English'),
('Laura', 'Davis', 'Spanish'),
('James', 'Wilson', 'English'),
('Patricia', 'Anderson', 'Spanish'),
('Robert', 'Taylor', 'English'),
('Linda', 'Thomas', 'Spanish'),
('William', 'Moore', 'English'),
('Elizabeth', 'Jackson', 'Spanish'),
('Joseph', 'White', 'English'),
('Susan', 'Harris', 'Spanish'),
('Charles', 'Martin', 'English'),
('Jessica', 'Thompson', 'Spanish'),
('Thomas', 'Garcia', 'English'),
('Sarah', 'Martinez', 'Spanish');

SELECT * FROM persons;

DROP TABLE IF EXISTS persons