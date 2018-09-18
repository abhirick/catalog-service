--Insert Scripts for dummy data population.

--Sku Data Population Script.
INSERT INTO enterprise_services.sr_sku
(id, brand, catalogids, creation_date, default_shipping_method, discountable, display_name, fulfiller, has_price, is_active, is_available, long_description, non_returnable, on_sale, online_only, parent_product, short_description, status, title, "type", vat_code)
VALUES('sku1', 'FTD', ['catalog1'], dateof(now()) , 'Standard', false, 'Simply Sweet', 'HardGood', true, true, true, 'Picked fresh from the farm to offer your special recipient a harvest bouquet full of fall beauty and charm', false, false, false, 'prod1', 'Simply Sweet', true, 'Count Your Blessings Fall Bouquet', 'default', '');

INSERT INTO enterprise_services.sr_sku
(id, brand, catalogids, creation_date, default_shipping_method, discountable, display_name, fulfiller, has_price, is_active, is_available, long_description, non_returnable, on_sale, online_only, parent_product, short_description, status, title, "type", vat_code)
VALUES('sku2', 'FTD', ['catalog1'], dateof(now()) , 'Standard', false, 'Full and Lush', 'HardGood', true, true, true, 'Picked fresh from the farm to offer your special recipient a harvest bouquet full of fall beauty and charm', false, false, false, 'prod1', 'Full and Lush', true, 'Count Your Blessings Fall Bouquet', 'default', '');


--Product Data Population Script.
INSERT INTO enterprise_services.sr_product
(id, alternativeproducts, ancestorcategories, brand, catalogids, childskus, creation_date, discountable, display_name, fulfiller, has_available_child_skus, has_price, is_available, long_description, non_returnable, online_only, short_description, status, title, "type", vat_code)
VALUES('prod1', [], ['cat1'], 'FTD', ['catalog1'], ['sku1','sku2'], dateof(now()) , false, 'Red 18 Long Stem Roses', 'hardgood', true, true, true, 'Picked fresh from the farm to offer your special recipient a gift straight from the heart our stunning Red Rose Bouquet is a classic romantic gesture that will have them falling head over heels in love with each exquisite bloom.', false, false, 'Red 18 Long Stem Roses VASE INCLUDED',false ,'Red 1 Dozen Long Stem Roses', 'default', '');

INSERT INTO enterprise_services.sr_product
(id, alternativeproducts, ancestorcategories, brand, catalogids, childskus, creation_date, discountable, display_name, fulfiller, has_available_child_skus, has_price, is_available, long_description, non_returnable, online_only, short_description, status, title, "type", vat_code)
VALUES('prod2', [], ['cat2'], 'FTD', ['catalog2'], ['sku3','sku4'], dateof(now()) , false, 'The FTD Autumn Splendor Bouquet', 'hardgood', true, true, true, 'The FTD® Autumn Splendor® Bouquet is a bright flash of fall color that will truly mesmerize your special recipient! Saturated in the alluring hues of the harvest season.', false, false, 'The FTD Autumn Splendor Bouquet',false ,'The FTD Autumn Splendor Bouquet', 'default', '');


--Category Data Population Script.
INSERT INTO enterprise_services.sr_category
(id, ancestorcategories, brand, catalogids, childcategories, childproducts, childskus, creation_date, discountable, display_name, fulfiller, long_description, short_description, status, title, "type")
VALUES('cat1', [], 'FTD', ['catalog1'], [], ['prod1','prod2'], [], dateof(now()), false, 'The Birthday Collection', 'HardGood', 'The Birthday Collection that can make your day.', 'The Birthday Collection', false, 'The Birthday Collection', 'default');

INSERT INTO enterprise_services.sr_category
(id, ancestorcategories, brand, catalogids, childcategories, childproducts, childskus, creation_date, discountable, display_name, fulfiller, long_description, short_description, status, title, "type")
VALUES('cat2', [], 'FTD', ['catalog2'], [], ['prod3','prod4'], [], dateof(now()) , false, 'The Anniversary Collection', 'HardGood', 'The Anniversary Collection that can make your day.', 'The Anniversary Collection', false, 'The Anniversary Collection', 'default');


--Catalog Data Population Script.
INSERT INTO enterprise_services.sr_catalog
(id, ancestorcatalogs, categories, childcatalogs, creation_date, default_shipping_method, display_name, is_root, long_description, rootcategories, shippingmethods, short_description, siteids, status, "type")
VALUES('catalog1', [], [], [], dateof(now()), 'Standard', 'Fall Collection', false, 'Fall Collection. Discover Automn Artistry', [], ['Standard','Expedite'], 'Fall Collection', ['FTD'], false, 'default');

INSERT INTO enterprise_services.sr_catalog
(id, ancestorcatalogs, categories, childcatalogs, creation_date, default_shipping_method, display_name, is_root, long_description, rootcategories, shippingmethods, short_description, siteids, status, "type")
VALUES('catalog2', [], [], [], dateof(now()) , 'Standard', 'Catalog for FTD', false, 'Flowers for Every Season', [], ['Standard','Expedite'], 'Flowers for Every Season', ['FTD'], false, 'default');
