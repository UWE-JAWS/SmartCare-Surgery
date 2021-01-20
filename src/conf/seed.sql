-- must delete in certain order to avoid breaking ref-integrity constraints
DELETE FROM Operations;
DELETE FROM Clients;
DELETE FROM Employees;
DELETE FROM Users;

INSERT INTO Users VALUES
    ('jsaxby', 'password', 'A'), -- Admin
    ('mrbump', 'clumsy', 'C'), -- Client
    ('dbeat', 'funky', 'D'), -- Doctor
    ('cjrwhitty', 'nextslideplease', 'D'), -- Doctor
    ('thetasigma', 'wouldyoulikeajellybaby?', 'D'), -- Doctor
    ('fnightingale', 'ladywiththelamp', 'N'), -- Nurse
    ('anurse', 'iamwhatmynameis', 'N'), -- Nurse
    ('turi', 'cabbages', 'N'); -- Nurse

INSERT INTO Employees VALUES
    (DEFAULT, 'Joshua Saxby', 'UWE BRISTOL', 'jsaxby'),
    (DEFAULT, 'Doctor Beat', 'USA', 'dbeat'),
    (DEFAULT, 'Prof. Chris Whitty', 'SW1A 0AA', 'cjrwhitty'),
    (DEFAULT, 'Doctor Who', 'Gallifrey', 'thetasigma'),
    (DEFAULT, 'Florence Nightingale', 'Ye Aulde Englande', 'fnightingale'),
    (DEFAULT, 'Nurse Nurse', 'Yorkshire', 'anurse'),
    (DEFAULT, 'Nurse Uri', 'Vladivostock', 'turi');

INSERT INTO Clients VALUES(
    DEFAULT, -- primary key
    'Mr Bump',
    'Fictional Book, Libraryshire',
    'N',
    'mrbump'
); -- NHS Patient

INSERT INTO Operations VALUES(
    DEFAULT, -- primary key
    (SELECT id FROM Employees WHERE username = 'dbeat'),
    (SELECT id FROM Clients WHERE username = 'mrbump'),
    '2021-01-20', -- take care, ISO 8601 format!
    '12:23:00', -- as above
    1, -- we need to consider what the meaning of "slot" is
    123.45 -- we store charges for all patient types, NHS foots bill if NHS patient
);
