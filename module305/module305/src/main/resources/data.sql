-- Insert sample data into the jobs table
INSERT INTO `jobs` (`title`, `description`, `salary`, `officetype`, `roletype`, `location`, `link`, `stage`, `resume`, `coverletter`)
VALUES
    ('Software Engineer', 'Develop software solutions', 90000, 'remote', 'fulltime', 'San Francisco, CA', 'http://example.com/software-engineer', 'created', 'http://example.com/resume.pdf', 'http://example.com/coverletter.pdf'),
    ('Data Scientist', 'Analyze data to gain insights and build models', 110000, 'onsite', 'fulltime', 'New York, NY', 'http://example.com/data-scientist', 'applied', 'http://example.com/resume2.pdf', 'http://example.com/coverletter2.pdf');

-- Insert sample data into the people table
INSERT INTO `people` (`name`, `email`, `phone`, `linkedin`, `note`)
VALUES
    ('John Doe', 'john.doe@example.com', '555-1234', 'https://linkedin.com/in/johndoe', 'Known through previous job'),
    ('Jane Smith', 'jane.smith@example.com', '555-5678', 'https://linkedin.com/in/janesmith', 'Met through university'),
    ('Mark Johnson', 'mark.johnson@example.com', '555-9876', 'https://linkedin.com/in/markjohnson', 'Referred by John Doe');

-- Insert sample data into the relationships table
INSERT INTO `relationships` (`people_id`, `job_id`, `type`)
VALUES
    (1, 1, 'colleague'),     -- John Doe is a colleague for Software Engineer job
    (2, 2, 'friend'),        -- Jane Smith is a friend for Data Scientist job
    (3, 1, 'referral');      -- Mark Johnson is a referral for Software Engineer job

-- Insert sample data into the tasks table
INSERT INTO `tasks` (`title`, `duedate`, `details`, `stage`, `people_id`, `job_id`)
VALUES
    ('Submit Resume', '2024-11-10', 'Submit resume for Software Engineer position', 'created', 1, 1),
    ('Prepare for Interview', '2024-11-12', 'Prepare for technical interview for Data Scientist position', 'in progress', 2, 2),
    ('Follow up with Referral', '2024-11-15', 'Follow up with Mark about Software Engineer referral', 'completed', 3, 1);
