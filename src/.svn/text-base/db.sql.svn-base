create database ehr;

create table department(
	dep_id int primary key auto_increment,
	dep_seq  varchar(20) unique not null,
 	dep_name varchar(30) not null,
	dep_type varchar(20) not null,
	dep_tel varchar(15) not null,
	dep_fax varchar(20),
	dep_desc varchar(60),
	dep_updep varchar(20),
	dep_date date);

	
	create table post(
	post_id int primary key auto_increment,
	post_seq varchar(20) unique not null,
	post_name varchar(20) not null,
	post_type varchar(20) not null,
	post_org int);
	
	
	create table employee(
	emp_id int auto_increment primary key,
	emp_seq varchar(20) unique not null,
	emp_name varchar(20) not null,
	emp_sex varchar(20) not null,
	emp_birth date not null,
	emp_card varchar(20) not null,
	start_date date not null,
	job_date date not null,
	emp_forms varchar(20) not null,
	emp_origin varchar(20) not null,
	polit_status varchar(20),
	nation varchar(10),
	native_place varchar(10),
	emp_tel varchar(15),
	email varchar(20),
	stature varchar(10),
	blood_type varchar(10),
	marriage varchar(10),
	birthplace varchar(40),
	domicile_place varchar(40),
	education varchar(20),
	degree varchar(10),
	school varchar(40),
	major varchar(40),
	grad_date date,
 	type varchar(20) not null,
	dep_id int ,
	post_id int,
	foreign key (dep_id)  references  department (dep_id),
	foreign key (post_id) references  post (post_id));

	create table probation (
	probation_id int primary key auto_increment,
	start_date Date not null,
	end_date	Date not null,
	result Varchar(20) not null,
	check_time Date not null,
	reviews	Varchar(100),
	remark	Varchar(200),
	emp_id int not null,
	foreign key(emp_id) references employee(emp_id));



	
	create table depch(
	depch_id int primary key auto_increment,
	old_depid int not null,
	old_name Varchar(20) not null,	
	depch_depid int not null,
	depch_name Varchar(20) not null,
	depch_class Varchar(20)	not null,
	depch_yy Varchar(20) not null,
	depch_reviews Varchar(100),	
	depch_time date	not null,
	depch_mode Varchar(20) not null,
	emp_id	int not null,
	emp_name Varchar(20) not null,
	emp_seq Varchar(20) not null,
	foreign key(emp_id) references employee(emp_id),
	foreign key(old_depid) references department(dep_id),
	foreign key(depch_depid) references department(dep_id));
	
	
	create table postch(
	postch_id int primary key auto_increment,
	old_postid int not null,
	postch_postid int not null,
	trance_type Varchar(20) not null,
	reason	Varchar(20) not null,
	reviews	Varchar(100),
	trantime Date not null,
	emp_id	int not null,
	trance_mode	varchar(20) not null,
	foreign key(old_postid) references post(post_id),
	foreign key(postch_postid) references post(post_id),
	foreign key(emp_id) references employee(emp_id));

	
	
	create table fired(
	fired_id int primary key auto_increment,
	fired_date date	 not null,
	fired_type Varchar(20) not null,
	fired_traced Varchar(20),	
	human_resource varchar(10),
	fired_memo Varchar(50),	
	emp_id	int not null,
	foreign key(emp_id) references employee(emp_id));
	
	create table user(
	 uid int primary key auto_increment,
	uname varchar(32) not null unique,
	pwd varchar(32) not null,
	type varchar(32) not null,
	question varchar(100) not null,
	answer varchar(100) not null,	
	state varchar(32) default 'unlogin',
	registDate timestamp not null,
	activestate varchar(32) not null,
	email varchar(32) not null);

	