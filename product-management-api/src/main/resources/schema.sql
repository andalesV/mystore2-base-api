DROP TABLE IF EXISTS category CASCADE^
DROP TABLE IF EXISTS product CASCADE^
DROP TABLE IF EXISTS product_category^
DROP TABLE IF EXISTS product_detail^
DROP TABLE IF EXISTS sale_order CASCADE^
DROP TABLE IF EXISTS sale_order_line CASCADE^
DROP TABLE IF EXISTS product_sale_order^
DROP TYPE IF EXISTS status_enum^

CREATE TYPE status_enum as  ENUM('NEW', 'PENDING', 'DONE', 'CANCELED')^

CREATE TABLE category(
 	id SERIAL PRIMARY KEY,
  	code TEXT DEFAULT gen_category_code(),
	name VARCHAR(50) NOT NULL,
	UNIQUE(id)
)^

CREATE TABLE product(
	id SERIAL PRIMARY KEY,
	product_code TEXT DEFAULT gen_product_code(),
	product_name VARCHAR(100) NOT NULL,
	description VARCHAR(255),
	image_url VARCHAR(255),
	UNIQUE(id, product_code)
)^

CREATE TABLE product_category(
	category_id INT,
	product_id INT,
	FOREIGN KEY(product_id) REFERENCES product(id),
	FOREIGN KEY(category_id) REFERENCES category(id)
)^

CREATE TABLE product_detail(
	id SERIAL PRIMARY KEY,
	isAvailable BOOLEAN DEFAULT FALSE,
	quantity INT,
	price DECIMAL(12,2),
	product_id INT,
	FOREIGN KEY(product_id) REFERENCES product(id),
	UNIQUE(id, product_id)
)^

CREATE TABLE sale_order(
	id SERIAL PRIMARY KEY,
	customer_name VARCHAR(100) NOT NULL,
	status status_enum DEFAULT 'NEW',
	created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	last_modified_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	UNIQUE(id)
)^


CREATE TABLE sale_order_line(
	id SERIAL PRIMARY KEY,
	product_id INT,
	quantity INT,
	amount DECIMAL(12,2),
	FOREIGN KEY(product_id) REFERENCES product(id),
	UNIQUE(id, product_id)
)^

CREATE TABLE product_sale_order(
	sale_order_id INT,
	sale_order_line_id INT,
	FOREIGN KEY(sale_order_id) REFERENCES sale_order(id),
	FOREIGN KEY(sale_order_line_id) REFERENCES sale_order_line(id)
)^

