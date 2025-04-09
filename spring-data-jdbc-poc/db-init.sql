DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS users;

-- Create roles table
CREATE TABLE roles (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Create users table
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    role_id BIGINT REFERENCES roles(id)
);

-- Insert roles
INSERT INTO roles (name) VALUES ('Admin');
INSERT INTO roles (name) VALUES ('User');
INSERT INTO roles (name) VALUES ('Guest');

-- Insert users (some with role_id, some without)
INSERT INTO users (name, email, role_id) VALUES ('John Doe', 'john@example.com', 1);
INSERT INTO users (name, email, role_id) VALUES ('Jane Smith', 'jane@example.com', 2);
INSERT INTO users (name, email, role_id) VALUES ('Alice Brown', 'alice@example.com', 2);
INSERT INTO users (name, email, role_id) VALUES ('Bob Green', 'bob@example.com', 3);
INSERT INTO users (name, email) VALUES ('No Role User', 'norole@example.com');
INSERT INTO users (name, email) VALUES ('Another User', 'another@example.com');
