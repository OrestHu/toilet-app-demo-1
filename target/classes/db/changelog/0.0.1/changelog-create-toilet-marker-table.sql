----liquibase formatted sql

--changeset OrestHutovych:create-toilet-markers-table
--comment create table toilet.markers
create table toilet.markers(
    id                  serial primary key,
    name                varchar(50) not null,
    coordinates         varchar(180) not null,
    created_timestamp    timestamp not null
);
--rollback drop table toilet.markers;

--changeset OrestHutovych:create-toilet-tags-table
--comment create table toilet.tags
create table toilet.tags(
    id            serial primary key,
    name      varchar(50) not null
);
--rollback drop table toilet.tags;

--changeset OrestHutovych:create-toilet-marker_tags-table
--comment create table toilet.marker_tags
create table toilet.marker_tags(
marker_id            integer not null,
tag_id               integer not null
);
--rollback drop table toilet.marker_tags;

--changeset OrestHutovych:add-marker_tags-table-constraints
--comment add constraints to marker_tags
alter table toilet.marker_tags
    add constraint marker_tags__marker_id__fk
        foreign key (marker_id) references toilet.markers(id);

alter table toilet.marker_tags
    add constraint marker_tags__tag_id__fk
        foreign key (tag_id) references toilet.tags(id);

alter table toilet.marker_tags
    add constraint marker_tags_unique
        unique (marker_id, tag_id);

--rollback alter table toilet.marker_tags drop constraints marker_tags__marker_id__fk;
--rollback alter table toilet.marker_tags drop constraints marker_tags__tag_id__fk;
--rollback alter table toilet.marker_tags drop constraints marker_tags_unique;

--changeset OrestHutovych:add-data-to-tags-table
--commit add tag_name to tags table
insert into toilet.tags(name)
values ('CAFFE'),
       ('SUPERMARKET'),
       ('RESTAURANT'),
       ('PUBLIC'),
       ('FREE'),
       ('PAID'),
       ('STORE');
--rollback truncate table toilet.tags;


--changeset OrestHutovych:add-toilet-markers-table-column-visibility
--comment add column visibility to toilet.markers table
alter table toilet.markers
    add column visibility bool;

--rollback alter table toilet.markers drop column visibility;
