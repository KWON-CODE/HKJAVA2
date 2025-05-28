ALTER TABLE customer
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

ALTER TABLE branch
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

ALTER TABLE service
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

ALTER TABLE account
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

ALTER TABLE item
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

DROP INDEX PK_customer;

DROP INDEX PK_branch;

DROP INDEX PK_service;

DROP INDEX PK_account;

DROP INDEX PK_item;

DROP TABLE customer 
	CASCADE CONSTRAINTS;

DROP TABLE branch 
	CASCADE CONSTRAINTS;

DROP TABLE service 
	CASCADE CONSTRAINTS;

DROP TABLE account 
	CASCADE CONSTRAINTS;

DROP TABLE item 
	CASCADE CONSTRAINTS;

CREATE TABLE customer (
	c_no VARCHAR2(14) NOT NULL,
	c_name VARCHAR2(20) NOT NULL,
	c_addr VARCHAR2(60),
	c_phone VARCHAR2(16),
	c_dist CHAR(2)
);

CREATE UNIQUE INDEX PK_customer
	ON customer (
		c_no ASC
	);

ALTER TABLE customer
	ADD
		CONSTRAINT PK_customer
		PRIMARY KEY (
			c_no
		);

CREATE TABLE branch (
	b_no VARCHAR2(3) NOT NULL,
	b_name VARCHAR2(20) NOT NULL,
	b_addr VARCHAR2(60),
	b_phone VARCHAR2(16),
	b_assets VARCHAR2(13)
);

CREATE UNIQUE INDEX PK_branch
	ON branch (
		b_no ASC
	);

ALTER TABLE branch
	ADD
		CONSTRAINT PK_branch
		PRIMARY KEY (
			b_no
		);

CREATE TABLE service (
	serv_c_no VARCHAR2(14) NOT NULL,
	serv_b_no VARCHAR2(3) NOT NULL
);

CREATE UNIQUE INDEX PK_service
	ON service (
		serv_c_no ASC,
		serv_b_no ASC
	);

ALTER TABLE service
	ADD
		CONSTRAINT PK_service
		PRIMARY KEY (
			serv_c_no,
			serv_b_no
		);

CREATE TABLE account (
	a_no CHAR(8) NOT NULL,
	a_serial_no DECIMAL(5) NOT NULL,
	a_date DATE,
	a_amount DECIMAL(13),
	a_open_date DATE,
	a_total_amount DECIMAL(13),
	a_term DECIMAL(3),
	a_item_dist CHAR(2),
	a_item_name VARCHAR2(20) NOT NULL,
	a_b_no VARCHAR2(3) NOT NULL,
	a_c_no VARCHAR2(14) NOT NULL
);

CREATE UNIQUE INDEX PK_account
	ON account (
		a_no ASC
	);

ALTER TABLE account
	ADD
		CONSTRAINT PK_account
		PRIMARY KEY (
			a_no
		);

CREATE TABLE item (
	item_name VARCHAR2(20) NOT NULL,
	item_limit DECIMAL(13),
	iitem_dist CHAR(2),
	item_c_dist CHAR(2),
	dk_term1 DECIMAL(3),
	dk_rate1 DECIMAL(5,3),
	dk_term2 DECIMAL(3),
	dk_rate2 DECIMAL(5,3),
	dk_term3 DECIMAL(3),
	dk_rate3 DECIMAL(5,3,)
);

CREATE UNIQUE INDEX PK_item
	ON item (
		item_name ASC
	);

ALTER TABLE item
	ADD
		CONSTRAINT PK_item
		PRIMARY KEY (
			item_name
		);