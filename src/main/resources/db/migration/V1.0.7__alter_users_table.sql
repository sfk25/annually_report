ALTER TABLE users DROP COLUMN group_id;

ALTER TABLE users ADD group_id int(11) NOT NULL AFTER name;
ALTER TABLE users ADD self_introduction varchar(64) AFTER email;
ALTER TABLE users ADD birthday DATETIME AFTER email;
ALTER TABLE users ADD blood_type int(11) AFTER email;
ALTER TABLE users ADD sex int(11) AFTER email;
ALTER TABLE users ADD entering_company_date DATETIME AFTER email;
