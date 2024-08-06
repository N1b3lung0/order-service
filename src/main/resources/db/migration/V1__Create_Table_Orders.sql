create EXTENSION if not exists "uuid-ossp";

create table orders (
   id uuid not null,
   order_number varchar(255) not null unique,
   sku_code varchar(255),
   price decimal(19, 2),
   quantity int,
   primary key (id)
);