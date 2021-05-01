CREATE TABLE IF NOT EXISTS products
(
    id    INTEGER PRIMARY KEY ,
    market_id integer,
    name  VARCHAR(200),
    price DOUBLE PRECISION
);
CREATE SEQUENCE IF NOT EXISTS products_id_seq START WITH 5 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS markets
(
    id    INTEGER PRIMARY KEY ,
    name  VARCHAR(200),
    address VARCHAR(254)
);
CREATE SEQUENCE IF NOT EXISTS markets_id_seq START WITH 4 INCREMENT BY 1;
