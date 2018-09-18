--Create Catalog Table Script.

create table enterprise_services.sr_catalog(id text, default_shipping_method text, 
display_name text, short_description text, long_description text, is_root boolean, status boolean, creation_date TIMESTAMP, type text, siteIds list<text> , 
shippingMethods list<text> , ancestorCatalogs list<text> ,childCatalogs list<text> , rootCategories list<text> , categories list<text> ,PRIMARY KEY (id));