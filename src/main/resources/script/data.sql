SELECT * FROM authors WHERE author_id = 2;

INSERT INTO authors(name, gender)
VALUES ('Nimol', 'Female')
RETURNING *