create table if not exists users(
	uname varchar(20) primary key,
	passwd varchar(20),
	role varchar(10)
);

create table if not exists clients(
	cID int not null primary key
            generated always as identity (start with 1, increment by 1), 
	cName varchar(50),
	cAddress varchar(100),
	cType varchar(10),
	uName varchar(20) references users(uname)
);

create table if not exists employee(
	eID int not null primary key
            generated always as identity (start with 1, increment by 1), 
	eName varchar(50),
	eAddress varchar(100),
	uName varchar(20) references users(uname)
);

create table if not exists operations(
    oID int not null primary key
            generated always as identity (start with 1, increment by 1), 
    eID int references employee(eID),
    cID int references clients(cID),
    oDate date,
    oTime time,
    nSlot int,
    charge float
);