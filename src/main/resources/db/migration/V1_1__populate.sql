
INSERT INTO users (name)
VALUES ('Alice'),
       ('Bob'),
       ('Charlie');

INSERT INTO categories (name)
VALUES ('Groceries'),
       ('Transport'),
       ('Utilities');


INSERT INTO accounts (user_id, balance)
VALUES (1, 100.50),
       (2, 250.75),
       (3, 0.00);


INSERT INTO records (user_id, category_id, time_creation_record, sum_of_spent)
VALUES (1, 1, '2024-12-01 10:00:00', 50.00),
       (2, 2, '2024-12-05 14:30:00', 20.00),
       (3, 3, '2024-12-10 09:15:00', 100.00);
