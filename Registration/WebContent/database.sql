create table Users(Username varchar2(20) not null,Password varchar2(20) not null, Name varchar2(50), Country varchar2(20));
select * from USERS;

select name,username,country from Users where username='uday'and password='uday' limit=1;

DELETE FROM Users WHERE name='uday';

insert into USERS values('uday','uday','uday','uday');
insert into USERS values('raj','raj','raj','raj');