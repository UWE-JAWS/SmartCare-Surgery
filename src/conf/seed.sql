-- must delete in certain order to avoid breaking ref-integrity constraints
DELETE FROM Operations;
DELETE FROM Clients;
DELETE FROM Employees;
DELETE FROM Users;

INSERT INTO Users VALUES
    (DEFAULT, 'jsaxby', 'password', 'A'), -- Admin
    (DEFAULT, 'mrbump', 'clumsy', 'C'), -- Client
    (DEFAULT, 'dbeat', 'funky', 'D'), -- Doctor
    (DEFAULT, 'cjrwhitty', 'nextslideplease', 'D'), -- Doctor
    (DEFAULT, 'thetasigma', 'wouldyoulikeajellybaby?', 'D'), -- Doctor
    (DEFAULT, 'fnightingale', 'ladywiththelamp', 'N'), -- Nurse
    (DEFAULT, 'anurse', 'iamwhatmynameis', 'N'), -- Nurse
    (DEFAULT, 'turi', 'cabbages', 'N'); -- Nurse

INSERT INTO Employees VALUES
    (DEFAULT, 'Joshua Saxby', 'UWE BRISTOL', (SELECT id FROM Users WHERE name = 'jsaxby')),
    (DEFAULT, 'Doctor Beat', 'USA', (SELECT id FROM Users WHERE name = 'dbeat')),
    (DEFAULT, 'Prof. Chris Whitty', 'SW1A 0AA', (SELECT id FROM Users WHERE name = 'cjrwhitty')),
    (DEFAULT, 'Doctor Who', 'Gallifrey', (SELECT id FROM Users WHERE name = 'thetasigma')),
    (DEFAULT, 'Florence Nightingale', 'Ye Aulde Englande', (SELECT id FROM Users WHERE name = 'fnightingale')),
    (DEFAULT, 'Nurse Nurse', 'Yorkshire', (SELECT id FROM Users WHERE name = 'anurse')),
    (DEFAULT, 'Nurse Uri', 'Vladivostock', (SELECT id FROM Users WHERE name = 'turi'));

INSERT INTO Clients VALUES(
    DEFAULT, -- primary key
    'Mr Bump',
    'Fictional Book, Libraryshire',
    'N',
    (SELECT id FROM Users WHERE name = 'mrbump')
); -- NHS Patient

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
