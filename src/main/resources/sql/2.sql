CREATE TABLE product_table(
  product_id serial PRIMARY KEY NOT NULL,
  name VARCHAR(128),
  description VARCHAR(128),
  price INTEGER,
  stock INTEGER
);

CREATE TABLE user_type_table(
  type_id serial PRIMARY KEY NOT NULL,
  type VARCHAR(128)
);

CREATE TABLE user_table (
  user_id serial PRIMARY KEY NOT NULL,
  username VARCHAR(128),
  password VARCHAR(128),
  user_type_fk INTEGER REFERENCES user_type_table
);

CREATE TABLE shopping_cart_table(
  cart_id serial PRIMARY KEY NOT NULL,
  item_fk INTEGER REFERENCES product_table,
  number_to_purchase INTEGER,
  buyer_fk INTEGER REFERENCES user_table
);

-- Insert items into table
INSERT INTO product_table(product_id, name, description, price, stock) VALUES (1, 'hammer', 'hits nails', 5 ,6);
INSERT INTO product_table(product_id, name, description, price, stock) VALUES (2, 'car', 'screws nails', 3 ,9);
INSERT INTO product_table(product_id, name, description, price, stock) VALUES (3, 'driver', 'hits nails', 5 ,10);
INSERT INTO product_table(product_id, name, description, price, stock) VALUES (4, 'train', 'screws nails', 3 ,3);

-- Insert user types
INSERT INTO user_type_table(type_id, type) VALUES (1, 'user');
INSERT INTO user_type_table(type_id, type) VALUES (2, 'admin');

-- Insert users
INSERT INTO user_table(user_id, username, password, user_type_fk) VALUES(1, 'user', 'user', (SELECT type_id FROM user_type_table WHERE type_id = 1));
INSERT INTO user_table(user_id, username, password, user_type_fk) VALUES(2, 'admin', 'admin', (SELECT type_id FROM user_type_table WHERE type_id = 2));
