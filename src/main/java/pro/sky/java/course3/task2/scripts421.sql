ALTER TABLE student ADD CONSTRAINT age_constraint CHECK (age > 5);

ALTER TABLE student ADD PRIMARY KEY (name);

ALTER TABLE faculty ADD CONSTRAINT color_name_unique UNIQUE (color, name);

ALTER TABLE student ALTER age SET DEFAULT 20;
