CREATE TABLE human
(
    id REAL,
    name           TEXT PRIMARY KEY NOT NULL,
    age            INTEGER CHECK (age > 0),
    driver_license BOOLEAN DEFAULT FALSE,
    car_id REAL REFERENCES car (id)
);

CREATE TABLE car
(
    id REAL,
    car_brand TEXT NOT NULL,
    car_model TEXT NOT NULL,
    price INTEGER CHECK (price > 0),
);