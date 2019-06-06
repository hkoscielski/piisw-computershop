alter sequence image_seq restart with 1;
alter sequence category_seq restart with 1;
alter sequence product_seq restart with 1;
alter sequence product_attr_seq restart with 1;

insert into images (id, content_id, content_length, mime_type)
values
    (image_seq.nextval, 'image1.jpg', 32131312, 'image/png'),
    (image_seq.nextval, 'image2.jpg', 12312312, 'image/png'),
    (image_seq.nextval, 'image3.jpg', 12312312, 'image/png'),
    (image_seq.nextval, 'image4.jpg', 12312312, 'image/png'),
    (image_seq.nextval, 'image5.jpg', 12312312, 'image/png'),
    (image_seq.nextval, 'image6.jpg', 12312312, 'image/png'),
    (image_seq.nextval, 'image7.jpg', 12312312, 'image/png'),
    (image_seq.nextval, 'image8.jpg', 12312312, 'image/png'),
    (image_seq.nextval, 'image9.jpg', 12312312, 'image/png'),
    (image_seq.nextval, 'image10.jpg', 12312312, 'image/png'),
    (image_seq.nextval, 'image11.jpg', 12312312, 'image/png'),
    (image_seq.nextval, 'image12.jpg', 12312312, 'image/png'),
    (image_seq.nextval, 'image13.jpg', 12312312, 'image/png'),
    (image_seq.nextval, 'image14.jpg', 12312312, 'image/png'),
    (image_seq.nextval, 'image15.jpg', 12312312, 'image/png'),
    (image_seq.nextval, 'image16.jpg', 12312312, 'image/png'),
    (image_seq.nextval, 'image17.jpg', 12312312, 'image/png'),
    (image_seq.nextval, 'image18.jpg', 12312312, 'image/png'),
    (image_seq.nextval, 'image19.jpg', 12312312, 'image/png'),
    (image_seq.nextval, 'image20.jpg', 12312312, 'image/png'),
    (image_seq.nextval, 'image21.jpg', 12312312, 'image/png'),
    (image_seq.nextval, 'image22.jpg', 12312312, 'image/png'),
    (image_seq.nextval, 'image23.jpg', 12312312, 'image/png');

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
    (product_seq.nextval, 'Logitech Wireless Mouse M185', 18.99, 1, 1),              -- 1
    (product_seq.nextval, 'Intel Core i7-8700', 200.00, 2, 2),                      -- 2
    (product_seq.nextval, 'Gigabyte GeForce GTX 1050 Ti WF OC', 189.99, 3, 3),       -- 3
    (product_seq.nextval, 'MSI Radeon RX 590 ARMOR OC', 239.99, 4, 3),               -- 4
    (product_seq.nextval, 'Gigabyte GeForce GTX 1660 OC', 269.00, 5, 3),             -- 5
    (product_seq.nextval, 'Gigabyte GeForce RTX 2070 WINDFORCE', 585.99, 6, 3),      -- 6
    (product_seq.nextval, 'ASUS GeForce RTX 2060 ROG Strix OC', 485.39, 7, 3),       -- 7
    (product_seq.nextval, 'Gigabyte Radeon RX 580 GAMING', 343.65, 8, 3),            -- 8
    (product_seq.nextval, 'MSI GeForce RTX 2080 GAMING X TRIO', 980.00, 9, 3),       -- 9
    (product_seq.nextval, 'MSI GeForce GTX 1050 TI 4GT OC', 170, 10, 3),             -- 10
    (product_seq.nextval, 'Palit GeForce GTX 1070 JetStream', 339.50, 11, 3),        -- 11
    (product_seq.nextval, 'Palit GeForce GTX 1660 StormX OC', 279.99, 12, 3),        -- 12
    (product_seq.nextval, 'Palit GeForce RTX 2080 GameRock', 960.50, 13, 3),         -- 13
    (product_seq.nextval, 'PNY GeForce GT 1030', 89.00, 14, 3),                      -- 14
    (product_seq.nextval, 'ASUS GeForce GTX 1060 Dual OC', 195.99, 15, 3),           -- 15
    (product_seq.nextval, 'Sapphire Radeon RX 560 PULSE', 150.00, 16, 3),            -- 16
    (product_seq.nextval, 'Gainward GeForce RTX 2060 Phoenix', 420.00, 17, 3),       -- 17
    (product_seq.nextval, 'Gigabyte GeForce GTX 1050 OC Low Profile', 155.50, 18, 3),-- 18
    (product_seq.nextval, 'Acer Nitro VG220QBMIIX', 119.99, 19, 4),                  -- 19
    (product_seq.nextval, 'LG 29UM69G', 235.99, 20, 4),                              -- 20
    (product_seq.nextval, 'Crucial 500GB 2,5" SATA SSD MX500', 79.99, 21, 5),        -- 21
    (product_seq.nextval, 'Samsung 500GB 970 EVO Plus M.2 2280 NVMe', 145.89, 22, 5),-- 22
    (product_seq.nextval, 'G.SKILL 16GB 3000MHz Aegis CL16', 145.89, 23, 6);         -- 23

insert into products_attr (id, code, name, value, is_main, product_id)
values
    (product_attr_seq.nextval, 'communication', 'Communication', 'Wireless', true, 1),
    (product_attr_seq.nextval, 'dpi', 'DPI', '1000', true, 1),
    (product_attr_seq.nextval, 'range', 'Range', '10m', false, 1),
    (product_attr_seq.nextval, 'buttons', 'Buttons', '3', false, 1),

    (product_attr_seq.nextval, 'processorManufacturer', 'Manufacturer', 'Intel', true, 2),
    (product_attr_seq.nextval, 'processorNumber', 'Number', 'i7-8700', true, 2),
    (product_attr_seq.nextval, 'processorBaseFrequency', 'Base Frequency', '3.20 GHz', true, 2),
    (product_attr_seq.nextval, 'processorTurboFrequency', 'Turbo Frequency', '4.60 GHz', true, 2),
    (product_attr_seq.nextval, 'processorTDP', 'TDP', '65 W', false, 2),
    (product_attr_seq.nextval, 'processorGraphics', 'Graphics', 'Intel UHD Graphics 630', false, 2),

    (product_attr_seq.nextval, 'chipsetManufacturer', 'Chipset manufacturer', 'Gigabyte', true, 3),
    (product_attr_seq.nextval, 'chipset', 'Chipset', 'GeForce GTX 1050', true, 3),
    (product_attr_seq.nextval, 'memorySize', 'Memory size', '4 GB', true, 3),
    (product_attr_seq.nextval, 'memoryType', 'Memory type', 'GDDR5', true, 3),
    (product_attr_seq.nextval, 'coreSpeed', 'Core speed', '1354 MHz', false, 3),
    (product_attr_seq.nextval, 'memorySpeed', 'Memory speed', '7008 MHz', false, 3),
    (product_attr_seq.nextval, 'connectorType', 'Connector Type', 'PCI-E x16 3.0', false, 3),

    (product_attr_seq.nextval, 'chipsetManufacturer', 'Chipset manufacturer', 'MSI', true, 4),
    (product_attr_seq.nextval, 'chipset', 'Chipset', 'Radeon RX 590', true, 4),
    (product_attr_seq.nextval, 'memorySize', 'Memory size', '8 GB', true, 4),
    (product_attr_seq.nextval, 'memoryType', 'Memory type', 'GDDR5', true, 4),
    (product_attr_seq.nextval, 'coreSpeed', 'Core speed', '1565 MHz', false, 4),
    (product_attr_seq.nextval, 'memorySpeed', 'Memory speed', '8000 MHz', false, 4),
    (product_attr_seq.nextval, 'connectorType', 'Connector Type', 'PCI-E x16', false, 4),

    (product_attr_seq.nextval, 'chipsetManufacturer', 'Chipset manufacturer', 'Gigabyte', true, 5),
    (product_attr_seq.nextval, 'chipset', 'Chipset', 'GeForce GTX 1660', true, 5),
    (product_attr_seq.nextval, 'memorySize', 'Memory size', '6 GB', true, 5),
    (product_attr_seq.nextval, 'memoryType', 'Memory type', 'GDDR5', true, 5),
    (product_attr_seq.nextval, 'coreSpeed', 'Core speed', '1785 MHz', false, 5),
    (product_attr_seq.nextval, 'memorySpeed', 'Memory speed', '8002 MHz', false, 5),
    (product_attr_seq.nextval, 'connectorType', 'Connector Type', 'PCI-E x16 3.0', false, 5),

    (product_attr_seq.nextval, 'chipsetManufacturer', 'Chipset manufacturer', 'Gigabyte', true, 6),
    (product_attr_seq.nextval, 'chipset', 'Chipset', 'GeForce GTX 2070', true, 6),
    (product_attr_seq.nextval, 'memorySize', 'Memory size', '8 GB', true, 6),
    (product_attr_seq.nextval, 'memoryType', 'Memory type', 'GDDR6', true, 6),
    (product_attr_seq.nextval, 'coreSpeed', 'Core speed', '1410 MHz', false, 6),
    (product_attr_seq.nextval, 'memorySpeed', 'Memory speed', '14000 MHz', false, 6),
    (product_attr_seq.nextval, 'connectorType', 'Connector Type', 'PCI-E x16 3.0', false, 6),

    (product_attr_seq.nextval, 'chipsetManufacturer', 'Chipset manufacturer', 'Asus', true, 7),
    (product_attr_seq.nextval, 'chipset', 'Chipset', 'GeForce GTX 2060', true, 7),
    (product_attr_seq.nextval, 'memorySize', 'Memory size', '6 GB', true, 7),
    (product_attr_seq.nextval, 'memoryType', 'Memory type', 'GDDR6', true, 7),
    (product_attr_seq.nextval, 'coreSpeed', 'Core speed', '1395 MHz', false, 7),
    (product_attr_seq.nextval, 'memorySpeed', 'Memory speed', '14000 MHz', false, 7),
    (product_attr_seq.nextval, 'connectorType', 'Connector Type', 'PCI-E x16 3.0', false, 7),

    (product_attr_seq.nextval, 'chipsetManufacturer', 'Chipset manufacturer', 'Gigabyte', true, 8),
    (product_attr_seq.nextval, 'chipset', 'Chipset', 'Radeon RX 580', true, 8),
    (product_attr_seq.nextval, 'memorySize', 'Memory size', '8 GB', true, 8),
    (product_attr_seq.nextval, 'memoryType', 'Memory type', 'GDDR5', true, 8),
    (product_attr_seq.nextval, 'coreSpeed', 'Core speed', '1355 MHz', false, 8),
    (product_attr_seq.nextval, 'memorySpeed', 'Memory speed', '8000 MHz', false, 8),
    (product_attr_seq.nextval, 'connectorType', 'Connector Type', 'PCI-E x16 3.0', false, 8),

    (product_attr_seq.nextval, 'chipsetManufacturer', 'Chipset manufacturer', 'MSI', true, 9),
    (product_attr_seq.nextval, 'chipset', 'Chipset', 'GeForce GTX 2080', true, 9),
    (product_attr_seq.nextval, 'memorySize', 'Memory size', '8 GB', true, 9),
    (product_attr_seq.nextval, 'memoryType', 'Memory type', 'GDDR6', true, 9),
    (product_attr_seq.nextval, 'coreSpeed', 'Core speed', '1490 MHz', false, 9),
    (product_attr_seq.nextval, 'memorySpeed', 'Memory speed', '14000 MHz', false, 9),
    (product_attr_seq.nextval, 'connectorType', 'Connector Type', 'PCI-E x16 3.0', false, 9),

    (product_attr_seq.nextval, 'chipsetManufacturer', 'Chipset manufacturer', 'MSI', true, 10),
    (product_attr_seq.nextval, 'chipset', 'Chipset', 'GeForce GTX 2050', true, 10),
    (product_attr_seq.nextval, 'memorySize', 'Memory size', '4 GB', true, 10),
    (product_attr_seq.nextval, 'memoryType', 'Memory type', 'GDDR5', true, 10),
    (product_attr_seq.nextval, 'coreSpeed', 'Core speed', '1341 MHz', false, 10),
    (product_attr_seq.nextval, 'memorySpeed', 'Memory speed', '7008 MHz', false, 10),
    (product_attr_seq.nextval, 'connectorType', 'Connector Type', 'PCI-E x16 3.0', false, 10),

    (product_attr_seq.nextval, 'chipsetManufacturer', 'Chipset manufacturer', 'Palit', true, 11),
    (product_attr_seq.nextval, 'chipset', 'Chipset', 'GeForce GTX 1070', true, 11),
    (product_attr_seq.nextval, 'memorySize', 'Memory size', '8 GB', true, 11),
    (product_attr_seq.nextval, 'memoryType', 'Memory type', 'GDDR5', true, 11),
    (product_attr_seq.nextval, 'coreSpeed', 'Core speed', '1506 MHz', false, 11),
    (product_attr_seq.nextval, 'memorySpeed', 'Memory speed', '8000 MHz', false, 11),
    (product_attr_seq.nextval, 'connectorType', 'Connector Type', 'PCI-E x16 3.0', false, 11),

    (product_attr_seq.nextval, 'chipsetManufacturer', 'Chipset manufacturer', 'Palit', true, 12),
    (product_attr_seq.nextval, 'chipset', 'Chipset', 'GeForce GTX 1660', true, 12),
    (product_attr_seq.nextval, 'memorySize', 'Memory size', '6 GB', true, 12),
    (product_attr_seq.nextval, 'memoryType', 'Memory type', 'GDDR5', true, 12),
    (product_attr_seq.nextval, 'coreSpeed', 'Core speed', '1408 MHz', false, 12),
    (product_attr_seq.nextval, 'memorySpeed', 'Memory speed', '8000 MHz', false, 12),
    (product_attr_seq.nextval, 'connectorType', 'Connector Type', 'PCI-E x16 3.0', false, 12),

    (product_attr_seq.nextval, 'chipsetManufacturer', 'Chipset manufacturer', 'Palit', true, 13),
    (product_attr_seq.nextval, 'chipset', 'Chipset', 'GeForce GTX 2080', true, 13),
    (product_attr_seq.nextval, 'memorySize', 'Memory size', '8 GB', true, 13),
    (product_attr_seq.nextval, 'memoryType', 'Memory type', 'GDDR6', true, 13),
    (product_attr_seq.nextval, 'coreSpeed', 'Core speed', '1515 MHz', false, 13),
    (product_attr_seq.nextval, 'memorySpeed', 'Memory speed', '14000 MHz', false, 13),
    (product_attr_seq.nextval, 'connectorType', 'Connector Type', 'PCI-E x16 3.0', false, 13),

    (product_attr_seq.nextval, 'chipsetManufacturer', 'Chipset manufacturer', 'PNY', true, 14),
    (product_attr_seq.nextval, 'chipset', 'Chipset', 'GeForce GT 1030', true, 14),
    (product_attr_seq.nextval, 'memorySize', 'Memory size', '2 GB', true, 14),
    (product_attr_seq.nextval, 'memoryType', 'Memory type', 'GDDR5', true, 14),
    (product_attr_seq.nextval, 'coreSpeed', 'Core speed', '1227 MHz', false, 14),
    (product_attr_seq.nextval, 'memorySpeed', 'Memory speed', '1500 MHz', false, 14),
    (product_attr_seq.nextval, 'connectorType', 'Connector Type', 'PCI-E x16 3.0', false, 14),

    (product_attr_seq.nextval, 'chipsetManufacturer', 'Chipset manufacturer', 'ASUS', true, 15),
    (product_attr_seq.nextval, 'chipset', 'Chipset', 'GeForce GTX 1060', true, 15),
    (product_attr_seq.nextval, 'memorySize', 'Memory size', '3 GB', true, 15),
    (product_attr_seq.nextval, 'memoryType', 'Memory type', 'GDDR5', true, 15),
    (product_attr_seq.nextval, 'coreSpeed', 'Core speed', '1594 MHz', false, 15),
    (product_attr_seq.nextval, 'memorySpeed', 'Memory speed', '8008 MHz', false, 15),
    (product_attr_seq.nextval, 'connectorType', 'Connector Type', 'PCI-E x16 3.0', false, 15),

    (product_attr_seq.nextval, 'chipsetManufacturer', 'Chipset manufacturer', 'Sapphire', true, 16),
    (product_attr_seq.nextval, 'chipset', 'Chipset', 'Radeon RX 560', true, 16),
    (product_attr_seq.nextval, 'memorySize', 'Memory size', '4 GB', true, 16),
    (product_attr_seq.nextval, 'memoryType', 'Memory type', 'GDDR5', true, 16),
    (product_attr_seq.nextval, 'coreSpeed', 'Core speed', '1226 MHz', false, 16),
    (product_attr_seq.nextval, 'memorySpeed', 'Memory speed', '6000 MHz', false, 16),
    (product_attr_seq.nextval, 'connectorType', 'Connector Type', 'PCI-E x16 3.0', false, 16),

    (product_attr_seq.nextval, 'chipsetManufacturer', 'Chipset manufacturer', 'Ganiward', true, 17),
    (product_attr_seq.nextval, 'chipset', 'Chipset', 'GeForce RTX 2060', true, 17),
    (product_attr_seq.nextval, 'memorySize', 'Memory size', '6 GB', true, 17),
    (product_attr_seq.nextval, 'memoryType', 'Memory type', 'GDDR6', true, 17),
    (product_attr_seq.nextval, 'coreSpeed', 'Core speed', '1680 MHz', false, 17),
    (product_attr_seq.nextval, 'memorySpeed', 'Memory speed', '14000 MHz', false, 17),
    (product_attr_seq.nextval, 'connectorType', 'Connector Type', 'PCI-E x16 3.0', false, 17),

    (product_attr_seq.nextval, 'chipsetManufacturer', 'Chipset manufacturer', 'Gigabyte', true, 18),
    (product_attr_seq.nextval, 'chipset', 'Chipset', 'GeForce RTX 1050', true, 18),
    (product_attr_seq.nextval, 'memorySize', 'Memory size', '2 GB', true, 18),
    (product_attr_seq.nextval, 'memoryType', 'Memory type', 'GDDR5', true, 18),
    (product_attr_seq.nextval, 'coreSpeed', 'Core speed', '1392 MHz', false, 18),
    (product_attr_seq.nextval, 'memorySpeed', 'Memory speed', '7008 MHz', false, 18),
    (product_attr_seq.nextval, 'connectorType', 'Connector Type', 'PCI-E x16 3.0', false, 18),

    (product_attr_seq.nextval, 'screenSize', 'Size', '21,5"', true, 19),
    (product_attr_seq.nextval, 'screenResolution', 'Resolution', '1920x1080', true, 19),
    (product_attr_seq.nextval, 'screenMatrix', 'Matrix', 'LED, IPS', true, 19),
    (product_attr_seq.nextval, 'screenRefreshRate', 'Refresh Rate', '75 Hz', false, 19),
    (product_attr_seq.nextval, 'screenColours', 'Colours', '16,7 mln', false, 19),
    (product_attr_seq.nextval, 'screenProportion', 'Proportion', '16x9', false, 19),

    (product_attr_seq.nextval, 'screenSize', 'Size', '29"', true, 20),
    (product_attr_seq.nextval, 'screenResolution', 'Resolution', '2560x1080', true, 20),
    (product_attr_seq.nextval, 'screenMatrix', 'Matrix', 'LED, IPS', true, 20),
    (product_attr_seq.nextval, 'screenRefreshRate', 'Refresh Rate', '75 Hz', false, 20),
    (product_attr_seq.nextval, 'screenColours', 'Colours', '16,7 mln', false, 20),
    (product_attr_seq.nextval, 'screenProportion', 'Proportion', '21x9', false, 20),

    (product_attr_seq.nextval, 'discCapacity', 'Capacity', '500 GB', true, 21),
    (product_attr_seq.nextval, 'discInterface', 'Interface', 'SATA III', true, 21),
    (product_attr_seq.nextval, 'discFormat', 'Format', '2.5"', true, 21),
    (product_attr_seq.nextval, 'discReadingSpeed', 'Reading speed', '560 MB/s', false, 21),
    (product_attr_seq.nextval, 'discSavingSpeed', 'Saving speed', '510 MB/s', false, 21),

    (product_attr_seq.nextval, 'discCapacity', 'Capacity', '500 GB', true, 22),
    (product_attr_seq.nextval, 'discInterface', 'Interface', 'M.2', true, 22),
    (product_attr_seq.nextval, 'discReadingSpeed', 'Reading speed', '3500 MB/s', false, 22),
    (product_attr_seq.nextval, 'discSavingSpeed', 'Saving speed', '3200 MB/s', false, 22),

    (product_attr_seq.nextval, 'ramCapacity', 'Capacity', '16 GB', true, 23),
    (product_attr_seq.nextval, 'ramType', 'Type', 'DDR4', true, 23),
    (product_attr_seq.nextval, 'ramClocking', 'Speed', '3000 MHz', true, 23),
    (product_attr_seq.nextval, 'ramDelay', 'Delay', 'CL 16', false, 23);
