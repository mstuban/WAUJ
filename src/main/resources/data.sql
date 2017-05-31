INSERT INTO user(first_name, last_name,username,password,enabled)
VALUES ('Ivo','Ivić','iivic','iivic', true);
INSERT INTO user(first_name, last_name,username,password,enabled)
VALUES ('Marko','Markić','mmarkic','mmarkic', true);
INSERT INTO user(first_name, last_name,username,password,enabled)
VALUES ('Pero','Perić','pperic','pperic', true);
INSERT INTO user(first_name, last_name,username,password,enabled)
VALUES ('Marko','Štuban','mstuban','mstuban', true);
INSERT INTO user(first_name, last_name,username,password,enabled)
VALUES ('Adminko','Adminić','admin','admin', true);
INSERT INTO user_role (username, role)
VALUES ('iivic', 'ROLE_USER');
INSERT INTO user_role (username, role)
VALUES ('mmarkic', 'ROLE_USER');
INSERT INTO user_role (username, role)
VALUES ('pperic', 'ROLE_USER');
INSERT INTO user_role (username, role)
VALUES ('admin', 'ROLE_USER');
INSERT INTO user_role (username, role)
VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO user_role (username, role)
VALUES ('mstuban', 'ROLE_USER');
INSERT INTO notebook(notebook_id, name, content_summary)
VALUES('1', 'Web aplikacije u Javi', 'Bilješke s predavanja iz kolegija web aplikacije bu
Javi');
INSERT INTO notebook(notebook_id, name, content_summary)
VALUES('2', 'Razvoj aplikacija na Android platformi', 'Bilješke s predavanja kolegija razvoj
aplikacija na Android platformi');
INSERT INTO notebook(notebook_id, name, content_summary)
VALUES('3', 'Napredne teme računalnih mreža', 'Bilješke s predavanja napredne teme
računalnih mreža');