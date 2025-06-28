-- Create databases for microservices
CREATE DATABASE accounts_db;
CREATE DATABASE loans_db;
CREATE DATABASE cards_db;

-- Grant privileges to postgres user
GRANT ALL PRIVILEGES ON DATABASE accounts_db TO postgres;
GRANT ALL PRIVILEGES ON DATABASE loans_db TO postgres;
GRANT ALL PRIVILEGES ON DATABASE cards_db TO postgres; 