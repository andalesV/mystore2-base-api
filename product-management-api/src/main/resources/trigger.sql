DROP FUNCTION IF EXISTS update_quantity() CASCADE^
DROP FUNCTION IF EXISTS modify_date() CASCADE^

--START ->>>TRIGGER CREATION FOR PRODUCT QUANTITY MANAGEMENT --
CREATE FUNCTION update_quantity() RETURNS TRIGGER AS
$quantity$
BEGIN

	Declare quan int;
    BEGIN
        SELECT quantity INTO quan
            FROM product_detail 
            WHERE id = NEW.product_id;
    
        IF (quan < New.quantity) THEN
            RAISE EXCEPTION 'Insufficient Product quantity';
        END IF;

        IF (quan > 0) THEN
            Update public.product_detail
            set quantity = quantity - NEW.quantity,
            isavailable = CASE
                WHEN quantity = NEW.quantity THEN false
                ELSE isavailable
                END
            WHERE id = NEW.product_id
            AND quantity > 0;
            RETURN NEW;
        END IF;
    END;

END;
$quantity$
language plpgsql^

CREATE TRIGGER quantity
	AFTER INSERT ON public.sale_order_line
    FOR EACH ROW
    EXECUTE PROCEDURE update_quantity()^
--END ->>>TRIGGER CREATION FOR PRODUCT QUANTITY MANAGEMENT --

    
--START ->>> TRIGGER FOR LAST MODIFIED DATE FOR SALE ORDER TABLE --
CREATE FUNCTION modify_date() RETURNS TRIGGER AS
$last_modified_date$
BEGIN
	UPDATE public.sale_order so
	SET last_modified_date = CURRENT_TIMESTAMP
	FROM product_sale_order pso
	WHERE OLD.id = pso.sale_order_line_id 
	AND so.id = pso.sale_order_id;
	RETURN NEW;
	
END;
$last_modified_date$
language plpgsql^

CREATE TRIGGER last_modified_date
	AFTER UPDATE ON public.sale_order_line
    FOR EACH ROW
    EXECUTE PROCEDURE modify_date()^

--END ->>> TRIGGER FOR LAST MODIFIED DATE FOR SALE ORDER TABLE --