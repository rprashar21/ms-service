-- Connect to cards_db and populate with sample data
\c cards_db;

-- Create a basic cards table if it doesn't exist (for demo purposes)
CREATE TABLE IF NOT EXISTS cards (
    card_id SERIAL PRIMARY KEY,
    customer_id BIGINT NOT NULL,
    card_type VARCHAR(50) NOT NULL,
    card_number VARCHAR(16) NOT NULL,
    card_limit DECIMAL(15,2) NOT NULL,
    card_status VARCHAR(20) DEFAULT 'ACTIVE',
    created_at TIMESTAMP DEFAULT NOW(),
    created_by VARCHAR(50) DEFAULT 'system'
);

-- Sample data for Cards table
INSERT INTO cards (customer_id, card_type, card_number, card_limit, card_status, created_at, created_by) VALUES
(1, 'Credit Card', '1234567890123456', 25000.00, 'ACTIVE', NOW(), 'system'),
(2, 'Debit Card', '1234567890123457', 50000.00, 'ACTIVE', NOW(), 'system'),
(3, 'Credit Card', '1234567890123458', 15000.00, 'ACTIVE', NOW(), 'system'),
(4, 'Debit Card', '1234567890123459', 30000.00, 'ACTIVE', NOW(), 'system'),
(5, 'Credit Card', '1234567890123460', 20000.00, 'ACTIVE', NOW(), 'system'),
(1, 'Debit Card', '1234567890123461', 10000.00, 'ACTIVE', NOW(), 'system'),
(2, 'Credit Card', '1234567890123462', 35000.00, 'ACTIVE', NOW(), 'system'); 