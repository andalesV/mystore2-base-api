DROP SEQUENCE IF EXISTS category_code^
DROP FUNCTION IF EXISTS gen_category_code() CASCADE^
DROP SEQUENCE IF EXISTS product_code^
DROP FUNCTION IF EXISTS gen_product_code() CASCADE^


CREATE SEQUENCE category_code^

CREATE OR REPLACE FUNCTION gen_category_code() 
RETURNS TEXT
LANGUAGE sql
AS
$category_code$
	SELECT REPLACE('CT-'||to_char(nextval('category_code'),'00000'), ' ', '');
$category_code$^

CREATE SEQUENCE product_code^

CREATE OR REPLACE FUNCTION gen_product_code()
RETURNS TEXT
LANGUAGE sql
AS
$product_code$
	SELECT REPLACE('PR-'||to_char(nextval('product_code'), '00000'), ' ', '');
$product_code$^