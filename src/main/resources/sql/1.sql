CREATE TABLE Product(
  ProductID serial PRIMARY KEY NOT NULL,
  Name VARCHAR(128),
  Description VARCHAR(128),
  Price INTEGER,
  Stock INTEGER
);
-- INSERT INTO Product(ProductID, Name, Description, Price, Stock) VALUES (1, 'hammer', 'hits nails', 5 ,6);

CREATE TABLE product_table(
  product_id serial PRIMARY KEY NOT NULL,
  name VARCHAR(128),
  description VARCHAR(128),
  price INTEGER,
  stock INTEGER
);
INSERT INTO product_table(product_id, name, description, price, stock) VALUES (1, 'hammer', 'hits nails', 5 ,6);
INSERT INTO product_table(product_id, name, description, price, stock) VALUES (2, 'car', 'screws nails', 3 ,9);
INSERT INTO product_table(product_id, name, description, price, stock) VALUES (3, 'driver', 'hits nails', 5 ,10);
INSERT INTO product_table(product_id, name, description, price, stock) VALUES (4, 'train', 'screws nails', 3 ,3);
