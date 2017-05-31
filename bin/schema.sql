drop table if exists user;
drop table if exists user_role;
drop table if exists notebook;
drop table if exists note;
CREATE TABLE user (
 user_id INT(11) IDENTITY PRIMARY KEY,
 first_name VARCHAR(50) NOT NULL,
 last_name VARCHAR(50) NOT NULL,
 username VARCHAR(45),
 password VARCHAR(100) NOT NULL ,
 enabled TINYINT NOT NULL DEFAULT 1
);
CREATE TABLE user_role (
 user_role_id int(11) IDENTITY PRIMARY KEY,
 username varchar(45) NOT NULL,
 role varchar(45) NOT NULL,
 FOREIGN KEY (username) REFERENCES user (username)
);
CREATE TABLE notebook (
 notebook_id INT(11) IDENTITY PRIMARY KEY,
 name VARCHAR(50),
 content_summary VARCHAR(100) NOT NULL
);
CREATE TABLE note (
 id INT(11) IDENTITY PRIMARY KEY,
 note_headline VARCHAR(100),
 note_text VARCHAR(1000),
 user_id INT(11) NOT NULL,
 notebook_id INT(11) NOT NULL,
 FOREIGN KEY (user_id) REFERENCES user (user_id),
 FOREIGN KEY (notebook_id) REFERENCES notebook (notebook_id)
);
