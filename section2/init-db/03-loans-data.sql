-- Connect to loans_db and populate with sample data
\c loans_db;

-- Create a basic loans table if it doesn't exist (for demo purposes)
CREATE TABLE IF NOT EXISTS loans (
    id BIGSERIAL PRIMARY KEY,
    mobile_number VARCHAR(15) NOT NULL,
    loan_number VARCHAR(20) NOT NULL,
    loan_type VARCHAR(50) NOT NULL,
    total_loan_amount DECIMAL(15,2) NOT NULL,
    created_by VARCHAR(50) DEFAULT 'system',
    created_on TIMESTAMP DEFAULT NOW(),
    updated_by VARCHAR(50),
    updated_on TIMESTAMP
);

-- Sample data for Loans table
INSERT INTO loans (mobile_number, loan_number, loan_type, total_loan_amount, created_by, created_on) VALUES
('919876543210', 'LOAN001', 'Personal Loan', 50000.00, 'system', NOW()),
('919876543211', 'LOAN002', 'Home Loan', 500000.00, 'system', NOW()),
('919876543212', 'LOAN003', 'Car Loan', 25000.00, 'system', NOW()),
('919876543213', 'LOAN004', 'Business Loan', 100000.00, 'system', NOW()),
('919876543214', 'LOAN005', 'Education Loan', 75000.00, 'system', NOW()),
('919876543210', 'LOAN006', 'Credit Card Loan', 15000.00, 'system', NOW()),
('919876543211', 'LOAN007', 'Personal Loan', 30000.00, 'system', NOW()); 