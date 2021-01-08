CREATE TABLE Users(
    id INT NOT NULL PRIMARY KEY
           GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	name VARCHAR(255) UNIQUE,
	password VARCHAR(255) NOT NULL, -- TODO: Replace with password_hash, possible binary type
	role CHAR(1) CONSTRAINT role_constraint CHECK (role IN ('A', 'C', 'D', 'N')) -- {Admin, Client, Doctor, Nurse}
);

CREATE TABLE Clients(
	id INT NOT NULL PRIMARY KEY
           GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	name VARCHAR(255),
	address VARCHAR(255),
	type CHAR(1) CONSTRAINT type_constraint CHECK (type IN ('N', 'P')) -- assumption: {NHS, Private}
	FOREIGN KEY(user_id) REFERENCES Users(id) -- WARN: Referential Integrity, uncheckable constraint (User(id = user_id).role = 'C')
);

CREATE TABLE Employees(
	id INT NOT NULL PRIMARY KEY
           GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    name VARCHAR(255),
    address VARCHAR(255),
	FOREIGN KEY(user_id) NOT NULL REFERENCES Users(id) -- WARN: Referential Integrity, uncheckable constraint (User(id = user_id).role != 'C')
);

CREATE TABLE Operations(
    id INT NOT NULL PRIMARY KEY
           GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    FOREIGN KEY(employee_id) NOT NULL REFERENCES Employee(id),
    FOREIGN KEY(client_id) NOT NULL REFERENCES Clients(id),
    start_date DATE,
    start_time TIME,
    slot SMALLINT,
    charge DECIMAL(8, 2) CONSTRAINT charge_constraint CHECK (charge >= 0) -- range {0.00 .. 999999.99}
);
