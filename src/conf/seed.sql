-- must delete in certain order to avoid breaking ref-integrity constraints
DELETE FROM Operations;
DELETE FROM Clients;
DELETE FROM Employees;
DELETE FROM Users;

INSERT INTO Users VALUES(DEFAULT, 'jsaxby', 'password', 'A'); -- Admin

INSERT INTO Employees VALUES(
    DEFAULT, -- primary key
    'Joshua Saxby',
    'UWE BRISTOL',
    (SELECT id AS user_id FROM Users WHERE name = 'jsaxby')
);

INSERT INTO Users VALUES(DEFAULT, 'mrbump', 'clumsy', 'C'); -- Client

INSERT INTO Clients VALUES(
    DEFAULT, -- primary key
    'Mr Bump',
    'Fictional Book, Libraryshire',
    'N',
    (SELECT id AS user_id FROM Users WHERE name = 'mrbump')
); -- NHS Patient

INSERT INTO Users VALUES(DEFAULT, 'dbeat', 'funky', 'D'); -- Doctor

INSERT INTO Employees VALUES(
    DEFAULT, -- primary key
    'Doctor Beat',
    'USA',
    (SELECT id AS user_id FROM Users WHERE name = 'dbeat')
);

INSERT INTO Operations VALUES(
    DEFAULT, -- primary key
    (
        SELECT Employees.id FROM Employees
        JOIN Users ON Employees.user_id = Users.id
        WHERE Users.name = 'dbeat'
    ),
    (
        SELECT Clients.id FROM Clients
        JOIN Users ON Clients.user_id = Users.id
        WHERE Users.name = 'mrbump'
    ),
    '2021-01-20', -- take care, ISO 8601 format!
    '12:23:00', -- as above
    1, -- we need to consider what the meaning of "slot" is
    123.45 -- we store charges for all patient types, NHS foots bill if NHS patient
);
