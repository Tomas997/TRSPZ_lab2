
CREATE TABLE users
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE categories
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE records
(
    id                   SERIAL PRIMARY KEY,
    user_id              INT              NOT NULL,
    category_id          INT              NOT NULL,
    time_creation_record TIMESTAMP        NOT NULL,
    sum_of_spent         DOUBLE PRECISION NOT NULL
);

CREATE TABLE accounts
(
    id      SERIAL PRIMARY KEY,
    user_id INT              NOT NULL,
    balance DOUBLE PRECISION NOT NULL
);
