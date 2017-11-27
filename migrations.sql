CREATE TABLE genres
    (
        id SERIAL PRIMARY KEY,
        name VARCHAR(100) NOT NULL
    );

CREATE TABLE books
    (
        id SERIAL PRIMARY KEY,
        name VARCHAR(100) NOT NULL,
        description TEXT,
        author VARCHAR NOT NULL,
        year INTEGER NOT NULL,
        genre_id INTEGER REFERENCES genres NOT NULL,
        language VARCHAR(30),
        publishing_house VARCHAR(50),
        cover VARCHAR(20),
        price NUMERIC,
        amount INT NOT NULL DEFAULT 0,
        sales INT NOT NULL DEFAULT 0,
        image_url VARCHAR(100) NOT NULL
    );