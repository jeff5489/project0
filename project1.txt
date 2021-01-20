CREATE TABLE users(
    id number(5) primary key,
    firstName varchar(50),
    lastName varchar(50),
    username varchar(50),
    password varchar(50)
);

CREATE TABLE accounts(
    id number(5) primary key,
    userId number(5),
    balance varchar(50)
);

CREATE TABLE transactions(
    id number(5) primary key,
    userId number(5),
    accountId number(5),
    amount number(20),
    dateTime varchar2 (30)
);

CREATE TABLE tests(
    id number(5) primary key,
    text varchar2 (30)
);

-----------------------

select * from users;
select * from accounts;
select * from transactions;
select * from tests;

--------------------------

Drop table users;
Drop table transactions;
Drop table accounts;

----------------------

ALTER TABLE accounts DROP CONSTRAINT fk_accounts_users;
ALTER TABLE transactions DROP CONSTRAINT fk_transactions_users;
ALTER TABLE transactions DROP CONSTRAINT fk_transactions_accounts;

----------------------

ALTER TABLE accounts ADD CONSTRAINT fk_accounts_users FOREIGN KEY
(userId) REFERENCES users(id) ON DELETE CASCADE;

ALTER TABLE transactions ADD CONSTRAINT fk_transactions_users FOREIGN KEY
(userId) REFERENCES users(id) ON DELETE CASCADE;

ALTER TABLE transactions ADD CONSTRAINT fk_transactions_accounts FOREIGN KEY
(accountId) REFERENCES accounts(id) ON DELETE CASCADE;

--------------------------------

CREATE SEQUENCE user_id_seq
    START WITH 1
    INCREMENT BY 1;

CREATE SEQUENCE account_id_seq
    START WITH 1
    INCREMENT BY 1;
    
CREATE SEQUENCE transaction_id_seq
    START WITH 1
    INCREMENT BY 1;
    
CREATE SEQUENCE test_id_seq
    START WITH 1
    INCREMENT BY 1;
    
------------------------------------------------
CREATE OR REPLACE PROCEDURE add_transaction(userId NUMBER, accountId NUMBER, amount NUMBER, text VARCHAR2) 
--as
IS
BEGIN
INSERT INTO transactions VALUES (transaction_id_seq.nextval, userId, accountId, amount, text);
END;
---------------------
CREATE OR REPLACE PROCEDURE add_test(text varchar2)
IS
BEGIN
INSERT INTO tests VALUES (test_id_seq.nextval, text);
END;
/
---------------------
call add_transaction(1,1,600);
call add_test('abc');
----------------------------------------
--    id number(5) primary key,
--    userId number(5),
--    accountId number(5),
--    amount number(20),
--    dateTime varchar2 (30)
----------------------------

/*
        
*/
