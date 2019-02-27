create table Project353.Users(
FirstName VARCHAR(25),
LastName VARCHAR(25),
UserID VARCHAR(15),
Email VARCHAR(50),
SecQuestion VARCHAR(250),
SecAnswer VARCHAR(250),
primary key(UserID)
);



INSERT INTO Project353.Users(FirstName, LastName, UserID, Email, SecQuestion, SecAnswer)
VALUES('John', 'Owen', 'jaowen', 'jaowen@ilstu.edu', 'University Attending?', 'Illinois State University'),
('Carter', 'Owen', 'jcowen', 'carter@jaocns.com', 'School Attending?', 'NCHS'),
('Jack', 'Owen', 'jbowen', 'jack@jaocns.com', 'School Attending?', 'NCHS');

/*
select * from Project353.LoginInfo;
select * from Project353.Users;

select * from Project353.LOGININFO a
join Project353.Users b on a.UserID = b.UserID;
*/