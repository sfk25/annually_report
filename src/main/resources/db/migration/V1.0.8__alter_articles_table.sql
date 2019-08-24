ALTER TABLE articles DROP COLUMN created_year;

ALTER TABLE articles ADD created_year INT AFTER value;