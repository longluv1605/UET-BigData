#!/usr/bin/env python3
import logging

# Set logger
log = logging.getLogger()


CREATE_KEYSPACE = """
        CREATE KEYSPACE IF NOT EXISTS {}
        WITH replication = {{ 'class': 'SimpleStrategy', 'replication_factor': {} }}
"""

CREATE_USERS_TABLE = """
    CREATE TABLE IF NOT EXISTS accounts_by_user (
        username TEXT,
        account_number TEXT,
        cash_balance DECIMAL,
        name TEXT STATIC,
        PRIMARY KEY ((username),account_number)
    )
"""

CREATE_POSSITIONS_BY_ACCOUNT_TABLE = """
    CREATE TABLE IF NOT EXISTS positions_by_account (
        account TEXT,
        symbol TEXT,
        quantity DECIMAL,
        PRIMARY KEY ((account),symbol)
    )
"""

CREATE_TRADES_BY_ACCOUNT_DATE_TABLE = """
    CREATE TABLE IF NOT EXISTS trades_by_a_d (
        account TEXT,
        trade_id TIMEUUID,
        type TEXT,
        symbol TEXT,
        shares DECIMAL,
        price DECIMAL,
        amount DECIMAL,
        PRIMARY KEY ((account), trade_id)
    ) WITH CLUSTERING ORDER BY (trade_id DESC)
"""

CREATE_TRADES_BY_ACCOUNT_TYPE_DATE_TABLE = """
    CREATE TABLE IF NOT EXISTS trades_by_a_td (
        account TEXT,
        trade_id TIMEUUID,
        type TEXT,
        symbol TEXT,
        shares DECIMAL,
        price DECIMAL,
        amount DECIMAL,
        PRIMARY KEY ((account), trade_id,  type)
    ) WITH CLUSTERING ORDER BY (trade_id DESC)
"""

CREATE_TRADES_BY_ACCOUNT_SYMBOL_TYPE_DATE_TABLE = """
    CREATE TABLE IF NOT EXISTS trades_by_a_std (
        account TEXT,
        trade_id TIMEUUID,
        type TEXT,
        symbol TEXT
        shares DECIMAL,
        price DECIMAL,
        amount DECIMAL,
        PRIMARY KEY ((account), trade_id, type, symbol)
    ) WITH CLUSTERING ORDER BY (trade_id DESC)
"""

CREATE_TRADES_BY_ACCOUNT_SYMBOL_DATE_TABLE = """
    CREATE TABLE IF NOT EXISTS trades_by_a_sd (
        account TEXT,
        trade_id TIMEUUID,
        type TEXT,
        symbol TEXT
        shares DECIMAL,
        price DECIMAL,
        amount DECIMAL,
        PRIMARY KEY ((account), trade_id, symbol)
    ) WITH CLUSTERING ORDER BY (trade_id DESC)
"""

SELECT_USER_ACCOUNTS = """
    SELECT username, account_number, name, cash_balance
    FROM accounts_by_user
    WHERE username = ?
"""

SELECT_TRADES_BY_A_D = """
    SELECT account, trade_id, type, symbol, shares, price, amount
    FROM trades_by_a_d
    WHERE username = ?
"""

SELECT_TRADES_BY_A_TD = """
    SELECT account, trade_id, type
    FROM trades_by_a_td
    WHERE username = ?
"""

SELECT_TRADES_BY_A_STD = """
    SELECT account, trade_id, type, symbol
    FROM trades_by_a_std
    WHERE username = ?
"""

SELECT_TRADES_BY_A_SD = """
    SELECT account, trade_id, symbo
    FROM trades_by_a_sd
    WHERE username = ?
"""

def create_keyspace(session, keyspace, replication_factor):
    log.info(f"Creating keyspace: {keyspace} with replication factor {replication_factor}")
    session.execute(CREATE_KEYSPACE.format(keyspace, replication_factor))


def create_schema(session):
    log.info("Creating model schema")
    session.execute(CREATE_USERS_TABLE)
    session.execute(CREATE_POSSITIONS_BY_ACCOUNT_TABLE)
    session.execute(CREATE_TRADES_BY_ACCOUNT_DATE_TABLE)
    session.execute(CREATE_TRADES_BY_ACCOUNT_TYPE_DATE_TABLE)
    session.execute(CREATE_TRADES_BY_ACCOUNT_SYMBOL_TYPE_DATE_TABLE)
    session.execute(CREATE_TRADES_BY_ACCOUNT_SYMBOL_DATE_TABLE)


def get_user_accounts(session, username):
    log.info(f"Retrieving {username} accounts")
    stmt = session.prepare(SELECT_USER_ACCOUNTS)
    rows = session.execute(stmt, [username])
    for row in rows:
        print(f"=== Account: {row.account_number} ===")
        print(f"- Cash Balance: {row.cash_balance}")

def get_all(session, username):
    log.info(f"Retrieving {username} get all info")
    stmt = session.prepare(SELECT_TRADES_BY_A_D)
    rows = session.execute(stmt, [username])
    for row in rows:
        print(f"=== Account: {row.account} ===")
        print(f"- Trade date: {row.trade_id}")
        print(f"- Type: {row.type}")
        print(f"- Symbol: {row.symbol}")
        print(f"- Price: {row.price}")
        print(f"- Amount: {row.amount}")

def get_date_range(session, username):
    log.info(f"Retrieving {username} date range info")
    stmt = session.prepare(SELECT_TRADES_BY_A_TD)
    rows = session.execute(stmt, [username])
    for row in rows:
        print(f"=== Account: {row.account} ===")
        print(f"- Trade date: {row.trade_id}")
        print(f"- Type: {row.type}")

def get_transaction_type(session, username):
    log.info(f"Retrieving {username} transaction type (Buy/Sell)")
    stmt = session.prepare(SELECT_TRADES_BY_A_STD)
    rows = session.execute(stmt, [username])
    for row in rows:
        print(f"=== Account: {row.account_number} ===")
        print(f"- Trade date: {row.trade_id}")
        print(f"- Type: {row.type}")
        print(f"- Symbol: {row.symbol}")

def get_instrument_symbol(session, username):
    log.info(f"Retrieving {username} instrument symbol")
    stmt = session.prepare(SELECT_TRADES_BY_A_SD)
    rows = session.execute(stmt, [username])
    for row in rows:
        print(f"=== Account: {row.account_number} ===")
        print(f"- Trade date: {row.trade_id}")
        print(f"- Symbol: {row.symbol}")
