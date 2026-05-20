create table role
(
    role_id serial primary key,
    name    varchar
);

create table person_details
(
    person_id  serial primary key,
    first_name varchar,
    last_name  varchar
);

create table person_role
(
    person_id int,
    role_id   int,
    primary key (person_id, role_id),
    foreign key (person_id) references person_details (person_id) on delete cascade,
    foreign key (role_id) references role (role_id) on delete cascade
);

create table address
(
    address_id serial primary key,
    person_id  int,
    latitude   double precision,
    longitude  double precision,
    foreign key (person_id) references person_details (person_id) on delete cascade
);

create table hire_date
(
    hire_date_id serial primary key,
    person_id    int,
    hire_date    timestamp,
    foreign key (person_id) references person_details (person_id) on delete cascade
);

create table client
(
    client_id  serial primary key,
    person_id  int,
    address_id int,
    foreign key (person_id) references person_details (person_id) on delete cascade,
    foreign key (address_id) references address (address_id) on delete cascade
);

create table employee
(
    employee_id  serial primary key,
    person_id    int,
    hire_date_id int,
    foreign key (person_id) references person_details (person_id) on delete cascade,
    foreign key (hire_date_id) references hire_date (hire_date_id) on delete cascade
);

create table bakery
(
    bakery_id  serial primary key,
    name       varchar,
    address_id int,
    owner_id   int,
    foreign key (address_id) references address (address_id) on delete cascade,
    foreign key (owner_id) references employee (employee_id) on delete cascade
);

create table bakery_employees
(
    bakery_id   int,
    employee_id int,
    primary key (bakery_id, employee_id),
    foreign key (bakery_id) references bakery (bakery_id) on delete cascade,
    foreign key (employee_id) references employee (employee_id) on delete cascade
);

create table product
(
    product_id serial primary key,
    name       varchar,
    price      double precision,
    customization  varchar,
    stock_quantity int
);

create table orders
(
    order_id    serial primary key,
    client_id   int,
    total_price double precision,
    order_date  timestamp,
    foreign key (client_id) references client (client_id) on delete cascade
);

create table order_item
(
    order_item_id     serial primary key,
    order_id          int,
    product_id        int,
    quantity          int,
    price_at_purchase double precision,
    foreign key (order_id) references orders (order_id) on delete cascade,
    foreign key (product_id) references product (product_id) on delete cascade
);