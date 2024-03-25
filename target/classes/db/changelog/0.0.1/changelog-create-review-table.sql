----liquibase formatted sql

--changeset OrestHutovych:create-toilet-reviews-table
--comment create table toilet.reviews
create table toilet.reviews(
id                  serial primary key,
review              varchar(255) not null,
rating              integer  not null,
username            varchar(100) not null,
created_timestamp    timestamp not null,
marker_id           integer not null
);
--rollback drop table toilet.reviews;

--changeset OrestHutovych:add-reviews-table-constraints
--comment add constraints to reviews
alter table toilet.reviews
    add constraint reviews__marker_id__fk
        foreign key (marker_id) references toilet.markers(id);
alter table toilet.reviews
    add constraint reviews_unique
        unique (marker_id);
--rollback alter table toilet.reviews drop constraints reviews__marker_id__fk;
--rollback alter table toilet.reviews drop constraints reviews_unique;