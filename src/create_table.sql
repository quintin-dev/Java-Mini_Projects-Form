-- This script creates the SurveyResponses table in the javaTest database

CREATE TABLE IF NOT EXISTS SurveyResponses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    age INT,
    email VARCHAR(255),
    role VARCHAR(100),
    preference VARCHAR(50),
    tools VARCHAR(255),
    thoughts TEXT
);
