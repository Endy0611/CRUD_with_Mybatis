CREATE TABLE IF NOT EXISTS authors(
    author_id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    gender VARCHAR(10) NOT NULL
);
CREATE TABLE IF NOT EXISTS books (
    book_id SERIAL NOT NULL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    published_date DATE NOT NULL,
    author_id INT NOT NULL,
    CONSTRAINT fk_author FOREIGN KEY (author_id) REFERENCES authors (author_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS categories(
    category_id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS book_category (
    book_id INT NOT NULL,
    category_id INT NOT NULL,
    PRIMARY KEY (book_id,  category_id),
    CONSTRAINT fk_book FOREIGN KEY (book_id) REFERENCES books (book_id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_category FOREIGN KEY (category_id) REFERENCES categories (category_id) ON DELETE CASCADE ON UPDATE CASCADE
);

