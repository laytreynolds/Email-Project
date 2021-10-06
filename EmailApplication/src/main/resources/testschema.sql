DROP TABLE IF EXISTS email CASCADE;
CREATE TABLE email (
    id INT AUTO_INCREMENT,
    company_suffix VARCHAR(255),
    default_password_length INT,
    department VARCHAR(255),
    email VARCHAR(255),
    first_name  vARCHAR(255),
    last_name VARCHAR(255),
    password VARCHAR(255),
    PRIMARY KEY (id)
);