CREATE TABLE Product(
  ProductID serial PRIMARY KEY NOT NULL,
  Name VARCHAR(128),
  Description VARCHAR(128),
  Price INTEGER,
  Stock INTEGER
);
-- INSERT INTO PRODUCT(ProductID, Name, Description, Price, Stock) VALUES (1, 'hammer', 'hits nails', 5 ,6);
