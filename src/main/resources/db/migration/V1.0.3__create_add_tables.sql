CREATE TABLE groups (
  id    INT PRIMARY KEY AUTO_INCREMENT,
  value VARCHAR(20) NOT NULL
);

CREATE TABLE processes (
  id    INT PRIMARY KEY AUTO_INCREMENT,
  value VARCHAR(20) NOT NULL
);

CREATE TABLE articles_processes (
  article_id INT NOT NULL,
  process_id INT NOT NULL,
  PRIMARY KEY(article_id, process_id)
);

ALTER TABLE users ADD group_id INT NOT NULL;

ALTER TABLE articles ADD created_year INT NOT NULL;