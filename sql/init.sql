create table p_user(
	u_id int not null auto_increment,
	u_name varchar(100), 
	u_password varchar(100),
	u_nick varchar(50),
	u_reg_date timestamp,
	primary key(u_id)
); 

insert into p_user (u_id, u_name, 
	u_password, u_nick, u_reg_date)values
	(null, '李洪鹤', '123', '李大湿', now());

create table p_post(
	p_id int not null auto_increment,
	user_id int,
	p_time timestamp,
	p_content varchar(800),
	primary key(p_id)
);

insert into p_post (p_id, user_id, p_time,
	p_content) values (null, 1, now(), 
	'今天早晨看到大长腿, 嘿嘿!');
	
insert into p_post (p_id, user_id, p_time,
	p_content) values (null, 1, now(), 
	'今天天气不错, 晒吐露皮了!');
	
create table p_comment(
	c_id int not null auto_increment,
	post_id int,
	c_name varchar(100),
	c_time timestamp,
	c_content varchar(800),
	primary key(c_id)
);

insert into p_comment ( c_id, post_id, 
	c_name, c_time, c_content) values 
	(null, 1, '范传奇', now(), 
	'在哪个动物玩呢?');
	
insert into p_comment ( c_id, post_id, 
	c_name, c_time, c_content) values 
	(null, 1, '王克晶', now(), 
	'李老师动物凶猛呀!');
	
insert into p_comment ( c_id, post_id, 
	c_name, c_time, c_content) values 
	(null, 1, '范传奇', now(), 
	'请李老师附湿一首!'); 
	
	


