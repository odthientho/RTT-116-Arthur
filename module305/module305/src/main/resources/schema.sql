-- Create the schema with utf8 and utf8_bin collation
CREATE DATABASE IF NOT EXISTS `jobtracker` CHARACTER SET utf8 COLLATE utf8_bin;

-- Use the schema
USE `jobtracker`;

-- Drop tables if they exist (to avoid conflicts if tables already exist)
DROP TABLE IF EXISTS `tasks`;
DROP TABLE IF EXISTS `relationships`;
DROP TABLE IF EXISTS `people`;
DROP TABLE IF EXISTS `jobs`;

-- create the table jobs
CREATE TABLE `jobs` (
                        `id` INT NOT NULL AUTO_INCREMENT,
                        `title` VARCHAR(255) NOT NULL,
                        `description` TEXT,
                        `salary` INT,
                        `officetype` VARCHAR(20),
                        `roletype` VARCHAR(20),
                        `location` VARCHAR(255),
                        `link` VARCHAR(500),
                        `stage` VARCHAR(50),
                        `resume` VARCHAR(500),
                        `coverletter` VARCHAR(500),
                        PRIMARY KEY (`id`)
) CHARACTER SET utf8 COLLATE utf8_bin;

-- Create the people table
CREATE TABLE `people` (
                          `id` INT NOT NULL AUTO_INCREMENT,
                          `name` VARCHAR(255) NOT NULL,
                          `email` VARCHAR(255) UNIQUE,
                          `phone` VARCHAR(20),
                          `linkedin` VARCHAR(255),
                          `note` TEXT,
                          PRIMARY KEY (`id`)
) CHARACTER SET utf8 COLLATE utf8_bin;

-- Create the relationships table
CREATE TABLE `relationships` (
                                 `id` INT NOT NULL AUTO_INCREMENT,
                                 `people_id` INT,
                                 `job_id` INT,
                                 `type` VARCHAR(20),
                                 PRIMARY KEY (`id`),
                                 FOREIGN KEY (`people_id`) REFERENCES `people`(`id`) ON DELETE CASCADE,
                                 FOREIGN KEY (`job_id`) REFERENCES `jobs`(`id`) ON DELETE CASCADE
) CHARACTER SET utf8 COLLATE utf8_bin;

-- Create the tasks table
CREATE TABLE `tasks` (
                         `id` INT NOT NULL AUTO_INCREMENT,
                         `title` VARCHAR(255) NOT NULL,
                         `duedate` DATE,
                         `details` TEXT,
                         `stage` VARCHAR(20),
                         `people_id` INT,
                         `job_id` INT,
                         PRIMARY KEY (`id`),
                         FOREIGN KEY (`people_id`) REFERENCES `people`(`id`) ON DELETE SET NULL,
                         FOREIGN KEY (`job_id`) REFERENCES `jobs`(`id`) ON DELETE SET NULL
) CHARACTER SET utf8 COLLATE utf8_bin;