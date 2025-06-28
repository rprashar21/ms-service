-- Connect to accounts_db and populate with sample data
\c accounts_db;

-- Sample data for Customer table
INSERT INTO customer (customer_id, name, email, mobile_number, created_at, created_by) VALUES
(1, 'John Doe', 'john.doe@email.com', '919876543210', NOW(), 'system'),
(2, 'Jane Smith', 'jane.smith@email.com', '919876543211', NOW(), 'system'),
(3, 'Bob Johnson', 'bob.johnson@email.com', '919876543212', NOW(), 'system'),
(4, 'Alice Brown', 'alice.brown@email.com', '919876543213', NOW(), 'system'),
(5, 'Charlie Wilson', 'charlie.wilson@email.com', '919876543214', NOW(), 'system');

-- Sample data for Accounts table
INSERT INTO accounts (account_number, customer_id, account_type, branch_address, created_at, created_by) VALUES
(1234567890, 1, 'Savings', '123 Main St, New York, NY', NOW(), 'system'),
(1234567891, 2, 'Checking', '456 Oak Ave, Los Angeles, CA', NOW(), 'system'),
(1234567892, 3, 'Savings', '789 Pine Rd, Chicago, IL', NOW(), 'system'),
(1234567893, 4, 'Checking', '321 Elm St, Houston, TX', NOW(), 'system'),
(1234567894, 5, 'Savings', '654 Maple Dr, Phoenix, AZ', NOW(), 'system'); 