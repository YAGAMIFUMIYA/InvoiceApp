CREATE TABLE customers (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           name VARCHAR(100),
                           email VARCHAR(100),
                           phone VARCHAR(50),
                           address VARCHAR(255)
);

CREATE TABLE estimates (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           customer_id BIGINT,
                           title VARCHAR(100),
                           total_amount DECIMAL(10,2),
                           created_date DATE,
                           status VARCHAR(20)
);
DROP TABLE IF EXISTS invoices;

CREATE TABLE invoices (
                          id IDENTITY PRIMARY KEY,
                          customer_id BIGINT,
                          issue_date DATE,
                          due_date DATE,
                          amount DECIMAL(10, 2),
                          status VARCHAR(20)
);

