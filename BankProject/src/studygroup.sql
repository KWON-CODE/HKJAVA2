ALTER TABLE board
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

ALTER TABLE member
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

ALTER TABLE file_t
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

ALTER TABLE reply
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

ALTER TABLE group_t
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

ALTER TABLE category_t
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

ALTER TABLE authority
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

ALTER TABLE area
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

ALTER TABLE detail_area
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

ALTER TABLE group_app
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

DROP INDEX PK_board;

DROP INDEX PK_member;

DROP INDEX PK_file_t;

DROP INDEX PK_reply;

DROP INDEX PK_group_t;

DROP INDEX PK_category_t;

DROP INDEX PK_authority;

DROP INDEX PK_area;

DROP INDEX PK_detail_area;

DROP INDEX PK_group_app;

DROP TABLE board 
	CASCADE CONSTRAINTS;

DROP TABLE member 
	CASCADE CONSTRAINTS;

DROP TABLE file_t 
	CASCADE CONSTRAINTS;

DROP TABLE reply 
	CASCADE CONSTRAINTS;

DROP TABLE message 
	CASCADE CONSTRAINTS;

DROP TABLE group_t 
	CASCADE CONSTRAINTS;

DROP TABLE category_t 
	CASCADE CONSTRAINTS;

DROP TABLE authority 
	CASCADE CONSTRAINTS;

DROP TABLE area 
	CASCADE CONSTRAINTS;

DROP TABLE detail_area 
	CASCADE CONSTRAINTS;

DROP TABLE group_app 
	CASCADE CONSTRAINTS;

CREATE TABLE board (
	board_idx NUMBER NOT NULL,
	mem_id VARCHAR2(10) NOT NULL,
	board_subject VARCHAR2(50),
	board_content VARCHAR2(1500),
	board_writedate DATE,
	board_hit NUMBER,
	board_password VARCHAR2(15),
	board_notice_check VARCHAR2(5),
	board_cate VARCHAR2(10),
	board_par VARCHAR2(10),
	board_grp VARCHAR2(10),
	board_seg NUMBER(2),
	board_lev NUMBER(2)
);

CREATE UNIQUE INDEX PK_board
	ON board (
		board_idx ASC
	);

ALTER TABLE board
	ADD
		CONSTRAINT PK_board
		PRIMARY KEY (
			board_idx
		);

CREATE TABLE member (
	mem_id VARCHAR2(10) NOT NULL,
	mem_name VARCHAR2(12),
	mem_phone VARCHAR(30),
	mem_email VARCHAR(40),
	mem_pass_q VARCHAR2(30),
	mem_pass_a VARCHAR2(30),
	mem_password VARCHAR2(15),
	mem_regdate DATE,
	mem_enable NUMBER,
	mem_image VARCHAR2(50)
);

CREATE UNIQUE INDEX PK_member
	ON member (
		mem_id ASC
	);

ALTER TABLE member
	ADD
		CONSTRAINT PK_member
		PRIMARY KEY (
			mem_id
		);

CREATE TABLE file_t (
	file_idx NUMBER NOT NULL,
	board_idx NUMBER,
	file_name VARCHAR(255),
	file_path VARCHAR2(20)
);

CREATE UNIQUE INDEX PK_file_t
	ON file_t (
		file_idx ASC
	);

ALTER TABLE file_t
	ADD
		CONSTRAINT PK_file_t
		PRIMARY KEY (
			file_idx
		);

CREATE TABLE reply (
	rep_idx NUMBER NOT NULL,
	mem_id VARCHAR2(10) NOT NULL,
	board_idx NUMBER NOT NULL,
	rep_content VARCHAR2(150),
	rep_writedate DATE,
	rep_password VARCHAR2(15),
	rep_par NUMBER(10),
	rep_grp NUMBER(10),
	rep_seg NUMBER(2),
	rep_lev NUMBER(2)
);

CREATE UNIQUE INDEX PK_reply
	ON reply (
		rep_idx ASC
	);

ALTER TABLE reply
	ADD
		CONSTRAINT PK_reply
		PRIMARY KEY (
			rep_idx
		);

CREATE TABLE message (
	message_code NUMBER NOT NULL,
	mem_id VARCHAR2(10) NOT NULL,
	message_title VARCHAR2(30),
	message_content VARCHAR2(30),
	send_mem_id VARCHAR2(10),
	message_write_date DATE
);

CREATE TABLE group_t (
	group_code NUMBER NOT NULL,
	mem_id VARCHAR2(10) NOT NULL,
	cat_title VARCHAR2(15) NOT NULL,
	group_place VARCHAR2(30),
	group_leader_call VARCHAR2(15),
	group_title VARCHAR2(50),
	group_subject VARCHAR2(1500),
	group_start_date DATE
);

CREATE UNIQUE INDEX PK_group_t
	ON group_t (
		group_code ASC
	);

ALTER TABLE group_t
	ADD
		CONSTRAINT PK_group_t
		PRIMARY KEY (
			group_code
		);

CREATE TABLE category_t (
	cat_title VARCHAR2(15) NOT NULL,
	cat_code NUMBER
);

CREATE UNIQUE INDEX PK_category_t
	ON category_t (
		cat_title ASC
	);

ALTER TABLE category_t
	ADD
		CONSTRAINT PK_category_t
		PRIMARY KEY (
			cat_title
		);

CREATE TABLE authority (
	mem_id VARCHAR2(10) NOT NULL,
	auth VARCHAR2(10) NOT NULL
);

CREATE UNIQUE INDEX PK_authority
	ON authority (
		mem_id ASC,
		auth ASC
	);

ALTER TABLE authority
	ADD
		CONSTRAINT PK_authority
		PRIMARY KEY (
			mem_id,
			auth
		);

CREATE TABLE area (
	area_name VARCHAR2(15) NOT NULL,
	area_code NUMBER
);

CREATE UNIQUE INDEX PK_area
	ON area (
		area_name ASC
	);

ALTER TABLE area
	ADD
		CONSTRAINT PK_area
		PRIMARY KEY (
			area_name
		);

CREATE TABLE detail_area (
	detail_area_code NUMBER NOT NULL,
	area_name VARCHAR2(15) NOT NULL,
	detail_area_name VARCHAR2(15)
);

CREATE UNIQUE INDEX PK_detail_area
	ON detail_area (
		detail_area_code ASC
	);

ALTER TABLE detail_area
	ADD
		CONSTRAINT PK_detail_area
		PRIMARY KEY (
			detail_area_code
		);

CREATE TABLE group_app (
	app_idx NUMBER NOT NULL,
	mem_id VARCHAR2(10) NOT NULL,
	group_code NUMBER NOT NULL,
	app_date DATE,
	app_mem_call VARCHAR2(15)
);

CREATE UNIQUE INDEX PK_group_app
	ON group_app (
		app_idx ASC
	);

ALTER TABLE group_app
	ADD
		CONSTRAINT PK_group_app
		PRIMARY KEY (
			app_idx
		);