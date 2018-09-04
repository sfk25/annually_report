ALTER TABLE articles DROP COLUMN tag_ids;

CREATE TABLE articles_tags (
  article_id INT NOT NULL,
  tag_id     INT NOT NULL,
  PRIMARY KEY(article_id, tag_id)
);