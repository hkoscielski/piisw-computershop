alter sequence product_seq restart with 1;
alter sequence product_attr_seq restart with 1;
alter sequence image_seq restart with 1;

insert into images (id, content_id, content_length, mime_type)
values
    (image_seq.nextval, 'image1.png', 32131312, 'image/png'),
    (image_seq.nextval, 'image2.png', 12312312, 'image/png');

insert into products (id, image_id)
values
    (product_seq.nextval, null),
    (product_seq.nextval, null),
    (product_seq.nextval, 1),
    (product_seq.nextval, 2);

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