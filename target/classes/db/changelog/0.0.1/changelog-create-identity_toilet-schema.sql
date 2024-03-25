----liquibase formatted sql

--changeset OrestHutovych:create-identity_toilet-schema
--comment create new identity_toilet schema
create schema identity_toilet;
--rollback drop schema identity_toilet;

--changeset OrestHutovych:create-identity_toilet-users_accounts-table
--comment create table identity_toilet.users_accounts
create table identity_toilet.users_accounts(
id          serial primary key,
username    varchar(30) unique not null,
password    varchar(80) not null
);
--rollback drop table identity_toilet.users_accounts;

--changeset OrestHutovych:create-identity_toilet-roles-table
--comment create table identity_toilet.roles
create table identity_toilet.Roles(
id          serial primary key,
name        varchar(50) not null
);
--rollback drop table identity_toilet.roles;

--changeset OrestHutovych:create-identity_toilet-user_roles-table
--comment create table identity_toilet.user_roles
create table identity_toilet.user_roles(
user_account_id         integer not null,
role_id                 integer not null
);
--rollback drop table identity_toilet.user_roles;

--changeset OrestHutovych:add-user_roles-table-constraints
--comment add constraints to user_roles
alter table identity_toilet.user_roles
    add constraint user_roles__user_account_id__fk
        foreign key (user_account_id) references identity_toilet.users_accounts(id);

alter table identity_toilet.user_roles
    add constraint user_roles__role_id__fk
        foreign key (role_id) references identity_toilet.Roles(id);

alter table identity_toilet.user_roles
    add constraint user_roles_unique
        unique (user_account_id, role_id);
--rollback alter table identity_toilet.user_roles drop constraints user_roles__user_account_id__fk;
--rollback alter table identity_toilet.user_roles drop constraints user_roles__role_id__fk;
--rollback alter table identity_toilet.user_roles drop constraints user_roles_unique;

--changeset OrestHutovych:add-data-to-roles-table
--commit add name to roles table
insert into identity_toilet.Roles(name)
values ('ROLE_USER'),
       ('ROLE_ADMIN');
--rollback truncate table identity_toilet.roles;

