drop table if exists payments;
drop table if exists orders;

create table if not exists payments
(
    id    serial primary key,
    paid  boolean not null,
    created timestamp without time zone not null
);
create table if not exists orders
(
    id           serial primary key,
    name  varchar(122)               not null,
    address      varchar(122)  not null,
    payment_id int references payments (id)   not null
    );


