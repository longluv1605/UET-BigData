CREATE KEYSPACE investments WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

USE investments;

CREATE TABLE IF NOT EXISTS accounts_by_user (
    username TEXT PRIMARY KEY,
    account_number TEXT,
    cash_balance DECIMAL,
    name TEXT
);

CREATE TABLE IF NOT EXISTS positions_by_account (
    account TEXT,
    symbol TEXT,
    quantity INT,
    PRIMARY KEY (account, symbol)
);

CREATE TABLE IF NOT EXISTS trades_by_a_d (
    account TEXT,
    trade_id UUID,
    type TEXT,
    symbol TEXT,
    shares INT,
    price DECIMAL,
    amount DECIMAL,
    PRIMARY KEY (account, trade_id)
);

CREATE TABLE IF NOT EXISTS trades_by_a_td (
    account TEXT,
    trade_id UUID,
    type TEXT,
    symbol TEXT,
    shares INT,
    price DECIMAL,
    amount DECIMAL,
    PRIMARY KEY (account, trade_id)
);

CREATE TABLE IF NOT EXISTS trades_by_a_std (
    account TEXT,
    trade_id UUID,
    type TEXT,
    symbol TEXT,
    shares INT,
    price DECIMAL,
    amount DECIMAL,
    PRIMARY KEY (account, trade_id)
);

CREATE TABLE IF NOT EXISTS trades_by_a_sd (
    account TEXT,
    trade_id UUID,
    type TEXT,
    symbol TEXT,
    shares INT,
    price DECIMAL,
    amount DECIMAL,
    PRIMARY KEY (account, trade_id)
);

