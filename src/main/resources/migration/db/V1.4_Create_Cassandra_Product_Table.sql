--Create Product Table Script.

create table enterprise_services.sr_product(id text, title text, display_name text, short_description text, long_description text, brand text, status boolean, 
discountable boolean, fulfiller text, has_available_child_skus boolean, has_price boolean, is_available boolean, creation_date TIMESTAMP, non_returnable boolean, 
online_only boolean, type text, vat_code text, alternativeProducts list<text> , ancestorCategories list<text> , childSKUs list<text> ,catalogIds list<text> , PRIMARY KEY (id));