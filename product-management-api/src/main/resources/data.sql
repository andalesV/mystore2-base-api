--Category sample Data
INSERT INTO category(name) VALUES ('Electronics')^
INSERT INTO category(name) VALUES ('Mobile')^
INSERT INTO category(name) VALUES ('Apparels')^
INSERT INTO category(name) VALUES ('Automotives')^
INSERT INTO category(name) VALUES ('Sports & Motors')^
INSERT INTO category(name) VALUES ('Books')^

--product sample data
	--category CT-001
INSERT INTO product(product_name, description, image_url) VALUES ('iMac', 
'All-in-one Macintosh desktop computers designed and built by Apple Inc.', 'http://wesellmac.co.uk/wp-content/uploads/2014/04/imac.jpeg')^
INSERT INTO product(product_name, description, image_url) VALUES ('Macbook Pro', 
'MacBook Pro has a 2.5- or 2.9-GHz chip, while the one on the 15-inch MacBook Pro is a more powerful but slower 2.3 GHz quad-core Intel Core i7.', 'https://static.pexels.com/photos/249538/pexels-photo-249538.jpeg')^

	--category CT-002
INSERT INTO product(product_name, description, image_url) VALUES ('Samsung Note 8', 
'Samsung Galaxy Note 8 is powered by 1.7GHz octa-core Samsung Exynos 9 Octa 8895 processor and it comes with 6GB of RAM.', 'https://www.thesun.co.uk/wp-content/uploads/2017/06/samsungnote7.jpg?strip=all&w=682')^
INSERT INTO product(product_name, description, image_url) VALUES ('Gear S3 frontier', 
'Gear S3 frontier LTE watch. Announced Aug 2016. Features 1.3 Super AMOLED display, Exynos 7270 chipset, 380 mAh battery, 4 GB storage', 'http://s7d2.scene7.com/is/image/SamsungUS/001class?$product-details-jpg$')^

	--category CT-003
INSERT INTO product(product_name, description, image_url) VALUES ('Jacket', 
'Mens Jacket', 'https://shopcaterpillar.com/media/catalog/product/cache/1/image/650x/040ec09b1e35df139433887a97daa66f/5/6/56b8e50e31d8ebb033ab552af7aa9365.jpg')^
INSERT INTO product(product_name, description, image_url) VALUES ('Jeans', 
'Denim', 'http://industrial.tecgen.com/files/01143575-2207-43DB-9A6A-956D0D50802C--90A518E9-1B61-4E53-9F72-6AF54781EF29/5-pocket-jean-sm.jpg')^

	--category CT-004
INSERT INTO product(product_name, description, image_url) VALUES ('Rolls-Royce Ghost', 
'British luxury car manufactured by Rolls-Royce Motor Cars.', 'https://www.rolls-roycemotorcars.com/content/dam/rollsroyce-website/Black%20Badge/Ghost%20Black%20Badge/01.Hero_v1-1.jpg.rr.1920.MED.jpg')^
INSERT INTO product(product_name, description, image_url) VALUES ('McLaren 570S', 
'The car is powered by a new iteration of the 3.8-litre twin-turbocharged V8 engine already used in the McLaren 650S and P1', 'http://st.automobilemag.com/uploads/sites/11/2016/10/2016-McLaren-570S-at-Dream-Cruise.jpg')^

	--category CT-005
INSERT INTO product(product_name, description, image_url) VALUES ('Triathlon bike', 
'Triathlon bikes are aerodynamic race machines designed for flat-out speed', 'https://static.trisports.com/productimages/imageslarge/azcfs1-1.jpg')^
INSERT INTO product(product_name, description, image_url) VALUES ('Nike Soccer Balls', 
'', 'http://www.prodirectsoccer.com/us/productimages/V3_1_Main/157419.jpg')^

	--category CT-006
INSERT INTO product(product_name, description, image_url) VALUES ('The Art of War', 
'The Art of War is an ancient Chinese military treatise dating from the Spring and Autumn period in 5th century BC', 'https://images-na.ssl-images-amazon.com/images/I/51QZW1ZJitL._SX331_BO1,204,203,200_.jpg')^
INSERT INTO product(product_name, description, image_url) VALUES ('The Lord of the Rings', 
'The Lord of the Rings is an epic high fantasy novel written by English author and scholar J. R. R. Tolkien', 'https://upload.wikimedia.org/wikipedia/en/8/87/Ringstrilogyposter.jpg')^

--product_category sample data
INSERT INTO product_category(category_id, product_id) VALUES(1,1)^
INSERT INTO product_category(category_id, product_id) VALUES(1,2)^


INSERT INTO product_category(category_id, product_id) VALUES(2,3)^
INSERT INTO product_category(category_id, product_id) VALUES(2,4)^

INSERT INTO product_category(category_id, product_id) VALUES(3,5)^
INSERT INTO product_category(category_id, product_id) VALUES(3,6)^

INSERT INTO product_category(category_id, product_id) VALUES(4,7)^
INSERT INTO product_category(category_id, product_id) VALUES(4,8)^

INSERT INTO product_category(category_id, product_id) VALUES(5,9)^
INSERT INTO product_category(category_id, product_id) VALUES(5,10)^

INSERT INTO product_category(category_id, product_id) VALUES(6,11)^
INSERT INTO product_category(category_id, product_id) VALUES(6,12)^

--product detail sample data
INSERT INTO product_detail(quantity, isAvailable, price, product_id) VALUES (10, true, 105000.50, 1)^
INSERT INTO product_detail(quantity, isAvailable, price, product_id) VALUES (5, true, 78000.50, 2)^
INSERT INTO product_detail(quantity, isAvailable, price, product_id) VALUES (1, true, 45000.35, 3)^
INSERT INTO product_detail(quantity, isAvailable, price, product_id) VALUES (3, true, 16452.00, 4)^
INSERT INTO product_detail(quantity, isAvailable, price, product_id) VALUES (25, true, 999.00, 5)^
INSERT INTO product_detail(quantity, isAvailable, price, product_id) VALUES (8, true, 1500.65, 6)^
INSERT INTO product_detail(quantity, isAvailable, price, product_id) VALUES (1, true, 8500000.00, 7)^
INSERT INTO product_detail(quantity, isAvailable, price, product_id) VALUES (4, true, 25000000.50, 8)^
INSERT INTO product_detail(quantity, isAvailable, price, product_id) VALUES (7, true, 36000.00, 9)^
INSERT INTO product_detail(quantity, isAvailable, price, product_id) VALUES (55, true, 2500.00, 10)^
INSERT INTO product_detail(quantity, isAvailable, price, product_id) VALUES (150, true, 1100.00, 11)^
INSERT INTO product_detail(quantity, isAvailable, price, product_id) VALUES (500, true, 1800.75, 12)^

--product order sample data
INSERT INTO sale_order(customer_name) VALUES('Victor Andales III')^

INSERT INTO sale_order_line(product_id,quantity,amount) VALUES(1,2,210001)^
INSERT INTO sale_order_line(product_id,quantity,amount) VALUES(2,1,78000.50)^


INSERT INTO product_sale_order(sale_order_id, sale_order_line_id) VALUES(1,1)^
INSERT INTO product_sale_order(sale_order_id, sale_order_line_id) VALUES(1,2)^
