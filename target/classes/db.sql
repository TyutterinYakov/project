create table address
(
	ad_id serial primary key,
	country varchar(100) not null,
	city varchar(100) not null,
	street varchar(100) not null,
	post_code varchar(100) not null
);

create table project(
	pr_id serial primary key,
	title varchar(200) not null,
	 FOREIGN KEY (pr_id) REFERENCES address(ad_id) ON DELETE RESTRICT
);

create table employee
(
	em_id serial primary key,
	first_name varchar(100) not null,
	last_name varchar(100) not null,
	birthday date not null,
	address_id bigint not null,
	FOREIGN KEY (em_id) REFERENCES address(ad_id) ON DELETE RESTRICT
);

create table empl_proj
(
	employee_id bigint not null,
	project_id bigint not null,
	FOREIGN KEY (employee_id) REFERENCES employee(em_id) ON DELETE RESTRICT,
	FOREIGN KEY (project_id) REFERENCES project(pr_id) ON DELETE RESTRICT

);