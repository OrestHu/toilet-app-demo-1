--liquibase formatted sql

--changeset OrestHutovych:create-toilet-schema
--comment create new schema
create schema toilet;
--rollback drop schema toilet;