CREATE DATABASE IF NOT EXISTS jdbcdemo;
USE jdbcdemo;
CREATE TABLE category(idCategory int(11) not null PRIMARY KEY AUTO_INCREMENT,
				name varchar(20) not null);
CREATE TABLE product(idProduct int(11) not null PRIMARY KEY AUTO_INCREMENT,
				name varchar(20) not null,
				idCategory int(11));
				
ALTER table product ADD FOREIGN KEY(idCategory) REFERENCES category(idCategory);

CREATE table product_detail(idProduct int(11) not null PRIMARY KEY AUTO_INCREMENT,
							content varchar(5000));
ALTER table product_detail ADD FOREIGN KEY(idProduct) REFERENCES product(idProduct);


CREATE TABLE orders(idOrder int(11) not null PRIMARY KEY AUTO_INCREMENT,
				name varchar(20));
				
CREATE TABLE product_order(idOrder int(11) not null,
				   idProduct int(11) not null);
ALTER TABLE product_order ADD FOREIGN KEY(idOrder) REFERENCES orders(idOrder);
ALTER TABLE product_order ADD FOREIGN KEY(idProduct) REFERENCES product(idProduct);