CREATE TABLE car
(
    id REAL PRIMARY KEY,
    car_brand TEXT NOT NULL,
    car_model TEXT NOT NULL,
    price NUMERIC CHECK (price > 0)
);


CREATE TABLE human
(
    id REAL,
    name           TEXT PRIMARY KEY,
    age            INTEGER CHECK (age > 0),
    driver_license BOOLEAN DEFAULT FALSE,
    car_id REAL REFERENCES car (id)
);

