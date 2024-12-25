

INSERT INTO users (username, password)
VALUES
    ('Alice', '$2a$10$uQwtb4rEhUV2Nnq7ippUT.fWaqX1cB1rfjeVZWxHtWnPHDRAAvtQ.'),      --password
    ('Bob', '$2a$10$b8U7sz.tikU1tfWq81SGCeNTpH1qZc/7Cg.F2SugyhVBW1AMJSsHm'),        --password2
    ('Charlie', '$2a$10$wJ879Wti8h4xv36RINCJmuMogmMoSKYh38xTR4wSbGBzcNoG0xLMu');    --password3


INSERT INTO categories (name)
VALUES
    ('Groceries'),
    ('Transport'),
    ('Utilities');


INSERT INTO accounts (user_id, balance)
VALUES
    (1, 100.50),
    (2, 250.75),
    (3, 0.00);


INSERT INTO records (user_id, category_id, time_creation_record, sum_of_spent)
VALUES
    (1, 1, '2024-12-01 10:00:00', 50.00),
    (2, 2, '2024-12-05 14:30:00', 20.00),
    (3, 3, '2024-12-10 09:15:00', 100.00);