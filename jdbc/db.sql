DROP TABLE category;
DROP TABLE product;
DROP TABLE orders;
CREATE TABLE category(id int PRIMARY KEY AUTO_INCREMENT, type varchar(25));
CREATE TABLE product(id int PRIMARY KEY AUTO_INCREMENT, name varchar(20), price float, category_id int references category(id));
CREATE TABLE orders(id int PRIMARY KEY AUTO_INCREMENT, product_id int references product(id), order_date date);
