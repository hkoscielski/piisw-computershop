insert into products (id)
values
    (1),
    (2),
    (3),
    (4);

insert into rams (series, memory_size, memory_type, number_of_modules, speed_rating, standard, cycle_latency, frequency, product_id)
values
    ('DOMINATOR PLATINUM RGB', '8 GB', 'DIMM', 1, 'PC4-32000', 'DDR4-4000', 19, '4000 MHz', 1),
    ('HyperX Impact', '16 GB', 'DIMM', 2, 'PC3-12000', 'DDR3-1500', 19, '1500 MHz', 2);

insert into graphics_cards (chipset_manufacturer, chipset, memory_size, memory_type, core_speed, memory_speed, connector_type, product_id)
values
    ('NVIDIA', 'GeForce GTX 1050 Ti', '4096 MB', 'GDDR5', '1341 MHz', '7008 MHz', 'PCI-Express x16', 3),
    ('AMD', 'Radeon RX 590', '8192 MB', 'GDDR5', '1565 MHz', '8000 MHz', 'PCI-Express x16', 4);
