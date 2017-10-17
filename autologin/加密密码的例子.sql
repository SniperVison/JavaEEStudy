create database day17;
use day17;
create table user(
id int primary key auto_increment,
username varchar(100),
password(100)
);

insert into user(id,username,password) values(2,'jerry','666');
-- MD5加密
update user set password=md5(password) where id=2;
-- SHA加密
update user set password=sha(password) where id=2;
-- SHA1加密
update user set password=sha1(password) where id=2;
