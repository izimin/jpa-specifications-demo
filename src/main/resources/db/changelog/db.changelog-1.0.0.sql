--liquibase formatted sql

--changeset izimin:1
--preconditions onFail:MARK_RAN
--precondition-sql-check expectedResult:0 SELECT count(*) FROM information_schema.tables WHERE table_name = 'users';
CREATE TABLE users
(
    id            BIGSERIAL PRIMARY KEY,
    name          VARCHAR(500),
    birth_date DATE
);