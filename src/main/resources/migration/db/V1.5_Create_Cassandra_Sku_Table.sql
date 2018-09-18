--Create Sku Table Script.

create table enterprise_services.sr_sku(id text, default_shipping_method text, on_sale boolean, is_active boolean, title text, display_name text,
short_description text, long_description text, brand text, status boolean, discountable boolean, fulfiller text, has_price boolean, is_available boolean, creation_date TIMESTAMP, non_returnable boolean, online_only boolean, type text, vat_code text, 
parent_product text , catalogIds list<text> , PRIMARY KEY (id));
