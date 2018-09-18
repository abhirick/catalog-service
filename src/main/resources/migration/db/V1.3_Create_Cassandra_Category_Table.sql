--Create Category Table Script.

create table enterprise_services.sr_category(id text, title text, display_name text, short_description text, long_description text, brand text, status boolean, 
discountable boolean, fulfiller text, creation_date TIMESTAMP, type text, ancestorCategories list<text> , 
childCategories list<text> , childSkus list<text> ,childProducts list<text> , catalogIds list<text> ,PRIMARY KEY (id));