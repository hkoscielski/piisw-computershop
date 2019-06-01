alter sequence image_seq restart with 1;
alter sequence category_seq restart with 1;
alter sequence product_seq restart with 1;
alter sequence product_attr_seq restart with 1;

insert into images (id, content_id, content_length, mime_type)
values
    (image_seq.nextval, 'image1.png', 32131312, 'image/png'),
    (image_seq.nextval, 'image2.png', 12312312, 'image/png');

insert into categories (id, name)
values
    (category_seq.nextval, 'Accessories'),
    (category_seq.nextval, 'CPU'),
    (category_seq.nextval, 'Graphics cards'),
    (category_seq.nextval, 'Monitors'),
    (category_seq.nextval, 'Storages'),
    (category_seq.nextval, 'RAM');

insert into products (id, name, price, image_id, category_id)
values
    (product_seq.nextval, 'Logitech Wireless Mouse M185', 18.99, null, 1),
    (product_seq.nextval, 'Intel Core i7-8750HQ', 200.00, null, 2),
    (product_seq.nextval, 'NVIDIA GeForce GTX 1050 Ti', 189.99, 1, 3),
    (product_seq.nextval, 'AMD Radeon RX 590', 239.99, 2, 3);

insert into products_attr (id, code, name, value, is_main, product_id)
values
    (product_attr_seq.nextval, 'chipsetManufacturer', 'Chipset manufacturer', 'NVIDIA', true, 1),
    (product_attr_seq.nextval, 'chipset', 'Chipset', 'GeForce GTX 1050 Ti', true, 1),
    (product_attr_seq.nextval, 'memorySize', 'Memory size', '4096 MB', true, 1),
    (product_attr_seq.nextval, 'memoryType', 'Memory type', 'GDDR5', true, 1),
    (product_attr_seq.nextval, 'coreSpeed', 'Core speed', '1341 MHz', false, 1),
    (product_attr_seq.nextval, 'memorySpeed', 'Memory speed', '7008 MHz', false, 1),
    (product_attr_seq.nextval, 'connectorType', 'Connector Type', 'PCI-Express x16', false, 1),
    (product_attr_seq.nextval, 'chipsetManufacturer', 'Chipset manufacturer', 'AMD', true, 2),
    (product_attr_seq.nextval, 'chipset', 'Chipset', 'Radeon RX 590', true, 2),
    (product_attr_seq.nextval, 'memorySize', 'Memory size', '8192 MB', true, 2),
    (product_attr_seq.nextval, 'memoryType', 'Memory type', 'GDDR5', true, 2),
    (product_attr_seq.nextval, 'coreSpeed', 'Core speed', '1565 MHz', false, 2),
    (product_attr_seq.nextval, 'memorySpeed', 'Memory speed', '8000 MHz', false, 2),
    (product_attr_seq.nextval, 'connectorType', 'Connector Type', 'PCI-Express x16', false, 2);