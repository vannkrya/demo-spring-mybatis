CREATE TABLE authors(
                        author_id serial PRIMARY KEY NOT NULL ,
                        name varchar(50) NOT NULL ,
                        gender varchar(50) NOT NULL
);

create table books(
                      book_id serial PRIMARY KEY NOT NULL ,
                      title varchar(200) NOT NULL ,
                      author_id int NOT NULL ,
                      FOREIGN KEY (author_id) REFERENCES authors (author_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE categories(
                           category_id serial PRIMARY KEY NOT NULL,
                           name varchar(50) NOT NULL
);

CREATE TABLE book_categories(
                                book_id int NOT NULL ,
                                category_id int NOT NULL ,
                                PRIMARY KEY (book_id, category_id),
                                FOREIGN KEY (book_id) REFERENCES books (book_id) ON DELETE CASCADE ,
                                FOREIGN KEY (category_id) REFERENCES categories (category_id) ON DELETE CASCADE
);