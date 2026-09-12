INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY) VALUES
                                                       ('John Doe', '1990-01-01', 'Senior', 6000),
                                                       ('Jane Smith', '1995-05-10', 'Middle', 3000),
                                                       ('Mike Tyson', '2000-08-15', 'Junior', 1500),
                                                       ('Anna Lee', '2002-11-20', 'Trainee', 800),
                                                       ('Bruce Wayne', '1985-02-25', 'Senior', 10000),
                                                       ('Clark Kent', '1992-06-18', 'Middle', 4500),
                                                       ('Peter Parker', '2001-04-14', 'Junior', 1200),
                                                       ('Barry Allen', '2003-09-09', 'Trainee', 900),
                                                       ('Diana Prince', '1988-12-30', 'Senior', 8000),
                                                       ('Hal Jordan', '1993-07-22', 'Middle', 4000);

INSERT INTO client (NAME) VALUES
                              ('Wayne Enterprises'),
                              ('Stark Industries'),
                              ('Oscorp'),
                              ('Daily Planet'),
                              ('LexCorp');

INSERT INTO project (CLIENT_ID, START_DATE, FINISH_DATE) VALUES
                                                             (1, '2020-01-01', '2020-12-31'),
                                                             (2, '2021-03-01', '2023-03-01'),
                                                             (3, '2019-05-15', '2024-05-15'),
                                                             (4, '2022-01-01', '2022-06-01'),
                                                             (5, '2018-01-01', '2025-01-01'),
                                                             (1, '2023-01-01', '2023-04-01'),
                                                             (2, '2021-11-01', '2022-11-01'),
                                                             (3, '2022-08-01', '2023-08-01'),
                                                             (4, '2020-02-01', '2021-02-01'),
                                                             (5, '2021-06-01', '2022-06-01');

INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES
                                                       (1, 1), (1, 2), (1, 3),
                                                       (2, 4), (2, 5),
                                                       (3, 6),
                                                       (4, 7), (4, 8), (4, 9), (4, 10),
                                                       (5, 1), (5, 5), (5, 10),
                                                       (6, 2), (6, 7),
                                                       (7, 3), (7, 4), (7, 8),
                                                       (8, 9),
                                                       (9, 6), (9, 2),
                                                       (10, 1), (10, 3), (10, 5), (10, 7);