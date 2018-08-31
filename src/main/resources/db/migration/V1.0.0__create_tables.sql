CREATE TABLE users (
  id         INT          NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name       VARCHAR(20)  NOT NULL,
  password   VARCHAR(255) NOT NULL,
  created_at DATETIME     NOT NULL,
  updated_at DATETIME     NOT NULL,
  INDEX idx_username(name)
);

CREATE TABLE articles (
  id         INT          NOT NULL PRIMARY KEY AUTO_INCREMENT,
  user_id    INT          NOT NULL,
  tag_ids    VARCHAR(255),
  title      VARCHAR(255) NOT NULL,
  value      TEXT         NOT NULL,
  created_at DATETIME     NOT NULL,
  updated_at DATETIME     NOT NULL,
  FOREIGN KEY (user_id)
    REFERENCES users(id),
  INDEX idx_article(tag_ids, title),
  FULLTEXT INDEX idx_article_value(value)
);

CREATE TABLE comments (
  id         INT      NOT NULL PRIMARY KEY AUTO_INCREMENT,
  article_id INT      NOT NULL,
  user_id    INT      NOT NULL,
  value      TEXT     NOT NULL,
  created_at DATETIME NOT NULL
);

CREATE TABLE likes (
  article_id INT NOT NULL,
  user_id INT NOT NULL,
  PRIMARY KEY(article_id, user_id)
);