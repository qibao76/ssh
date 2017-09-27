-- mysql.sql

create database ssh;
use ssh;
create table t_user(
	t_id int,
	t_name varchar(100),
	t_age int,
	t_salary double,
	t_hiredate timestamp,
	primary key (t_id)
);

