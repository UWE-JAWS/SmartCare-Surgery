CREATE TABLE Users(
    username VARCHAR(255) NOT NULL PRIMARY KEY,
    password VARCHAR(255) NOT NULL, -- TODO: Replace with password_hash, possible binary type
    role CHAR(1) CONSTRAINT role_constraint CHECK (role IN ('A', 'C', 'D', 'N')) -- {Admin, Client, Doctor, Nurse}
);

CREATE TABLE Clients(
    id INT NOT NULL PRIMARY KEY
                    GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    name VARCHAR(255),
    address VARCHAR(255),
    type CHAR(1) CONSTRAINT type_constraint CHECK (type IN ('N', 'P')), -- assumption: {NHS, Private}
    username VARCHAR(255) REFERENCES Users(username) -- WARN: Referential Integrity, uncheckable constraint (User(id = user_id).role = 'C')
);

CREATE TABLE Employees(
    id INT NOT NULL PRIMARY KEY
                    GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    name VARCHAR(255),
    address VARCHAR(255),
    username VARCHAR(255) NOT NULL REFERENCES Users(username) UNIQUE -- WARN: Referential Integrity, uncheckable constraint (User(id = user_id).role != 'C')
);

CREATE TABLE Operations(
    id INT NOT NULL PRIMARY KEY
                    GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    employee_id INT NOT NULL REFERENCES Employees(id),
    client_id INT NOT NULL REFERENCES Clients(id),
    start_date DATE,
    start_time TIME,
    slot SMALLINT,
    charge DECIMAL(8, 2) CONSTRAINT charge_constraint CHECK (charge >= 0) -- range {0.00 .. 999999.99}
);
