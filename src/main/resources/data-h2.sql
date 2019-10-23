insert into images (id, content_id, content_length, mime_type)
values
(1, 'image1.jpg', 32131312, 'image/png'),
(2, 'image2.jpg', 12312312, 'image/png'),
(3, 'image3.jpg', 12312312, 'image/png'),
(4, 'image4.jpg', 12312312, 'image/png'),
(5, 'image5.jpg', 12312312, 'image/png'),
(6, 'image6.jpg', 12312312, 'image/png'),
(7, 'image7.jpg', 12312312, 'image/png'),
(8, 'image8.jpg', 12312312, 'image/png'),
(9, 'image9.jpg', 12312312, 'image/png'),
(10, 'image10.jpg', 12312312, 'image/png'),
(11, 'image11.jpg', 12312312, 'image/png'),
(12, 'image12.jpg', 12312312, 'image/png'),
(13, 'image13.jpg', 12312312, 'image/png'),
(14, 'image14.jpg', 12312312, 'image/png'),
(15, 'image15.jpg', 12312312, 'image/png'),
(16, 'image16.jpg', 12312312, 'image/png'),
(17, 'image17.jpg', 12312312, 'image/png'),
(18, 'image18.jpg', 12312312, 'image/png'),
(19, 'image19.jpg', 12312312, 'image/png'),
(20, 'image20.jpg', 12312312, 'image/png'),
(21, 'image21.jpg', 12312312, 'image/png'),
(22, 'image22.jpg', 12312312, 'image/png'),
(23, 'image23.jpg', 12312312, 'image/png');

insert into categories (id, name)
values
(1, 'Accessories'),
(2, 'CPU'),
(3, 'Graphics cards'),
(4, 'Monitors'),
(5, 'Storages'),
(6, 'RAM');

insert into products (id, name, price, image_id, category_id, description)
values
(1, 'Logitech Wireless Mouse M185', 18.99, 1, 1, 'Plug-and-play wireless mouse delivers simple, reliable wireless performance with no delays or dropouts. The tiny wireless receiver gives you a dependable connection with no software and no hassles. Simply plug in the tiny nano receiver and start using your mouse right away. The nano receiver is so small and unobtrusive that you can plug it into a USB port and forget about it. Compatible with Window-based and Mac computers, wireless receiver provides the reliability of a cord with wireless convenience and freedom. Using this advanced, 2.4 GHz wireless connectivity results in fast data transmission and virtually no delays or dropouts. The mouse''s 12-month battery life makes sure you don''t have to deal with the hassle of frequent battery changes. The On/Off switch and smart sleep mode help conserve power. Wireless Mouse M185 also features a contoured design that feels good in either hand and offers more comfort than a touchpad. Mouse includes the nano receiver and one AA battery.'),              -- 1
(2, 'Intel Core i7-8700', 200.00, 2, 2, 'Core i7-8700 is a 64-bit hexa-core high-end performance x86 desktop microprocessor introduced by Intel in 2017. This processor, which is based on the Coffee Lake microarchitecture, is manufactured on Intel''s 3rd generation enhanced 14nm++ process. The i7-8700 operates at a 3.2 GHz with a TDP of 65 W and a Turbo Boost frequency of up to 4.6 GHz. This chip supports up to 64 GiB of dual-channel DDR4-2666 memory and incorporates Intel''s UHD Graphics 630 IGP operating at 350 MHz with a burst frequency of 1.2 GHz.'),                       -- 2
(3, 'Gigabyte GeForce GTX 1050 Ti WF OC', 189.99, 3, 3, 'Turn your PC into a true gaming machine with the GeForce GTX 1050 Ti graphics card. It''s based on the state-of-the-art Pascal architecture manufactured with the ultra-fast FinFET, and comes with 768 CUDA Cores and 4GB 128-bit GDDR5 memory. Thus you get impressive performance and capability to experience the latest titles in their full glory. The GeForce GTX 1050 Ti is also loaded with a rich array of gaming-enhancing technologies to improve your gaming experience, like Ansel technology that captures 360-degree game scenes, G-Sync for smooth, tear-free images, and more. This Gigabyte GeForce GTX 1050 Ti OC 4G model can operate, in OC mode, at up to 1341MHz Base/1455MHz Boost clock (1290MHz/1392MHz for reference card) to give you more graphics power out of the box. And the dual fan thermal solution keeps your card nice and cool even in the heat of gaming, without giving out too much noise.'),       -- 3
(4, 'MSI Radeon RX 590 ARMOR OC', 239.99, 4, 3, 'The 4th generation GCN architecture is engineered for gamers who play anything from the latest MOBA’s to the most popular AAA titles. Asynchronous Shaders and an enhanced Geometry Engine power new levels of smooth gameplay performance. Experience the next level of immersion with the world of VR gaming and entertainment with Radeon RX graphics cards powered by the revolutionary Polaris architecture. Puts an end to choppy gameplay and broken frames with fluid, artifact-free performance at virtually any framerate. Enhanced contrast and colors deliver a strikingly sharp, colorful, and vivid visual experience.'),               -- 4
(5, 'Gigabyte GeForce GTX 1660 OC', 269.00, 5, 3, 'The GIGABYTE patent “Alternate Spinning” is the only solution that can solve the turbulent airflow of adjacent fans. Since the adjacent fans rotate in the same direction, the airflow direction is opposite between the fans, which will cause turbulent airflow and reduce heat dissipation efficiency. GIGABYTE turns the adjacent fans in the opposite direction, so that the airflow direction between the two fans is the same, reducing the turbulence and enhancing the airflow pressure.'),             -- 5
(6, 'Gigabyte GeForce RTX 2070 WINDFORCE', 585.99, 6, 3, 'The NVIDIA GeForce RTX 2070 GPU is based on the ground-breaking Turning architecture that was built using 12nm FinFET—a new generation of graphics chip engineered for a new level of realism. This graphics card series incorporates brand-new, industry-changing, real-time ray tracing, AI and shading technology to transform gaming visuals with lifelike reflections, refractions and shadows. Meanwhile, the Deep-Learning Super-Sampling feature enables much smoother frame rates and less burden on the GPU than previous-generation anti-aliasing technology. This GeForce RTX 2070 card packs 2,304 CUDA Cores, and 8GB of GDDR6/256-bit memory running at 14Gbps (reference card frequency).'),      -- 6
(7, 'ASUS GeForce RTX 2060 ROG Strix OC', 485.39, 7, 3, 'The ROG Strix GeForce RTX™ 2060 teams up NVIDIA''s A-list GPU with an elite cast of specialists, setting the stage for epic gaming action. Gargantuan power delivery provides the muscle to push overclocking boundaries, while cooling that''s honed to perfection keeps the spotlight squarely on Turing™''s performance. And with an arsenal of utilities that allow you to customize and tweak this extreme hardware, you call the shots.'),       -- 7
(8, 'Gigabyte Radeon RX 580 GAMING', 343.65, 8, 3, 'The Gigabyte Radeon RX 580 Gaming 4G with semi-passive Windforce cooler reaches a base clock of 1.340 MHz, which can be boosted to 1.355 MHz. The 4 GB GDDR5 VRAM is clocked at 4.000 MHz (8.000 MHz) and connected via a 256-Bit memory interface to the GPU. An 8-Pin power connector keeps the 23,2 cm long graphics card supplied with power and a power supply capable of delivering 500 Watts is recommended. '),            -- 8
(9, 'MSI GeForce RTX 2080 GAMING X TRIO', 980.00, 9, 3, 'The GeForce RTX 20 Series GAMING TRIO is the return of MSI’s mighty three-fan graphics card. Only reserved for the most powerful of GPU’s, the TRIO Series features a mix of black and gunmetal grey with elegant shapes and a classy brushed metal backplate that matches the front. This looks great with the gorgeous RGB effects found on the front and the side of the card, which can be controlled using MSI’s Mystic Light software and made to synchronize with other RGB components.'),       -- 9
(10, 'MSI GeForce GTX 1050 TI 4GT OC', 170, 10, 3, 'Based on NVIDIA''s Pascal architecture, the MSI GeForce GTX 1050 4G OC Graphics Card provides major improvements in performance, memory bandwidth, and power efficiency over its predecessor, the high-performance Maxwell architecture. It also introduces innovative graphics features and technologies that redefine the computer as the platform for playing AAA games. The front panel of the card features a variety of outputs. There is one DisplayPort 1.4 output, one HDMI 2.0b output, and one DVI-D Dual-Link output. The GTX 1050 Ti is not just about high-resolution gaming. Computationally intensive programs can utilize the GPU''s 768 cores to accelerate tasks using CUDA or other APIs.'),             -- 10
(11, 'Palit GeForce GTX 1070 JetStream', 339.50, 11, 3, 'The revolutionary Palit JetStream series of graphics cards features advanced innovative cooling and an optimized product design to deliver the ultimate gaming performance. As the latest and the next generation NVIDIA Pascal architecture features power efficiency, gaming experiences and latest gaming technologies, the Palit GeForce 1070 JetStream series guarantee gamers cutting-edge performance and a explosive new gaming experience.'),        -- 11
(12, 'Palit GeForce GTX 1660 StormX OC', 279.99, 12, 3, 'The GeForce GTX 1660 Ti is built with the breakthrough graphics performance of the award-winning NVIDIA Turing™ architecture. With performance that rivals the GeForce GTX 1070, it’s a blazing-fast supercharger for today’s most popular games, and even faster with modern titles.'),        -- 12
(13, 'Palit GeForce RTX 2080 GameRock', 960.50, 13, 3, 'The brand new gaming series, Palit “GameRock” is specially designed for enthusiast gamers who desire to have the ultimate gaming experience. GameRock series provides the best gaming features, the best thermal solution and the best graphics card quality, make you become a real game rocker without any fears.'),         -- 13
(14, 'PNY GeForce GT 1030', 89.00, 14, 3, 'Accelerate your entire PC experience with the fast, powerful PNY GeForce® GT 1030 graphics card. Its award-winning NVIDIA Pascal™ architecture, powerful graphics engine, and state-of-the-art technologies give you the performance upgrade you need to drive today’s most demanding PC application.'),                      -- 14
(15, 'ASUS GeForce GTX 1060 Dual OC', 195.99, 15, 3, 'ASUS Dual series of GeForce GTX 1060 comes equipped with Patented Wing-Blade Fans for max air flow with 105% more air pressure. While exclusive Auto-Extreme Technology with Super Alloy Power II components for superior stability. GPU Tweak II with XSplit Gamecaster that provides intuitive performance tweaking and instant gameplay streaming. ASUS Dual series of GeForce® GTX 1060 is perfectly matched with your ASUS X99-A II motherboard.'),           -- 15
(16, 'Sapphire Radeon RX 560 PULSE', 150.00, 16, 3, 'The SAPPHIRE Pulse Radeon RX560 plays your favourites at a smooth 1080p, from the latest eSports games and MOBAs to the most popular, graphically-intensive AAA titles. Built on the future-ready Polaris architecture and sporting 1024 GCN stream processors boost-clocked at 1216MHz. The card is ready for the latest technologies like DisplayPort 1.4 HBR3/HDR, HDMI 4K60, and FreeSync 2 technology delivering a high level of graphical fidelity in your favourite games and multimedia experience.'),            -- 16
(17, 'Gainward GeForce RTX 2060 Phoenix', 420.00, 17, 3, 'This graphic card has oneHDMI port. HDMI is among the most modern ports if we speak about connecting TVs and the latest generation monitors. The main advantages of HDMI in comparison to DVI and D-SUB are a thin cable which permits to transfer a high quality digital picture and also the multichannel sound signal is transmitted via the same cable. HDMI is compatible with DVI if you buy an extra transition or a cable, however the possibility to transmit also sound is lost in this case.'),       -- 17
(18, 'Gigabyte GeForce GTX 1050 OC Low Profile', 155.50, 18, 3, 'The WINDFORCE 2X cooling system features two 80 mm unique blade fans and semi-passive 3D active fan together delivering an effective heat dissipation capacity for higher performance at lower temperatures. The airflow is spilled by the triangle fan edge, and guided smoothly through the 3D stripe curve on the fan surface, effectively enhancing the air flow by 23% over traditional fans. The semi-passive fans will remain off when the GPU is under a set loading or temperature for low power gaming. It allows gamers to enjoy gameplay in complete silence when the system is running light or idle.'),-- 18
(19, 'Acer Nitro VG220QBMIIX', 119.99, 19, 4, 'The Acer KG1 is a monitor for demanding gamers of action genres, which are not enough for common models. Full HD sharpness here keeps the milliseconds response even in the fastest scenes , so you will not lose sight even for a moment, even if the battle is very frantic. Smoother viewing is provided by AMD FreeSync, when a compatible video card (AMD) dynamically changes the Acer Nitro VG220Qbmiix refresh rate to the maximum of 75 Hz.Acer Low Dimming is designed to help reduce eye fatigue when working under difficult lighting conditions . Allows you to set at least 15% brightness at low ambient light levels to reduce eye strain. The minimum brightness level for standard monitors starts at 30%. ComfyView has been developed to reduce glare. The Acer Nitro VG220Qbmiix dashboard with a matte finish reduces the reflections of surrounding light sources.'),                  -- 19
(20, 'LG 29UM69G', 235.99, 20, 4, 'Enhance your gaming experience with the 29UM69G-B 29" 21:9 UltraWide IPS Gaming Monitor from LG. This monitor features an UltraWide 21:9 aspect ratio expanding your screen space while the 1 ms response time, backed by Motion Blur Reduction functionality, helps to eliminate screen tearing.'),                              -- 20
(21, 'Crucial 500GB 2,5" SATA SSD MX500', 79.99, 21, 5, 'Solid state drive - internal - TRIM support, Error Correction Code (ECC), Adaptive Thermal Protection, Microsoft eDrive compatible, Redundant Array of Independent NAND, Multistep Data Integrity Algorithm, Active Garbage Collection, dynamic write acceleration, upgradable firmware, 3D NAND Technology, Device Sleep support, power loss data protection.'),        -- 21
(22, 'Samsung 500GB 970 EVO Plus M.2 2280 NVMe', 145.89, 22, 5, 'The ultimate in performance, upgraded. Faster than the 970 EVO, the 970 EVO Plus is powered by the latest V-NAND technology and firmware optimisation. It maximises the potential of NVMe bandwidth for unbeatable computing in capacities up to 2TB, with reliability of up to 1,200 TBW.'),-- 22
(23, 'G.SKILL 16GB 3000MHz Aegis CL16', 145.89, 23, 6, 'DDR4 now comes to the widely acclaimed AEGIS family. Higher speed and lower voltage requirement combine to give your gaming PC system a sharp increase in performance and stability. It is constructed with hand-selected ICs and tested with stringent validation process. That is a real big deal. AEGIS DDR memory is something you can count on whether you play FPS, RTS, MOBA, or MMORPG.');         -- 23

insert into products_attr (id, code, name, value, is_main, product_id)
values
(1, 'communication', 'Communication', 'Wireless', true, 1),
(2, 'dpi', 'DPI', '1000', true, 1),
(3, 'range', 'Range', '10m', false, 1),
(4, 'buttons', 'Buttons', '3', false, 1),

(5, 'processorManufacturer', 'Manufacturer', 'Intel', true, 2),
(6, 'processorNumber', 'Number', 'i7-8700', true, 2),
(7, 'processorBaseFrequency', 'Base Frequency', '3.20 GHz', true, 2),
(8, 'processorTurboFrequency', 'Turbo Frequency', '4.60 GHz', true, 2),
(9, 'processorTDP', 'TDP', '65 W', false, 2),
(10, 'processorGraphics', 'Graphics', 'Intel UHD Graphics 630', false, 2),

(11, 'chipsetManufacturer', 'Chipset manufacturer', 'Gigabyte', true, 3),
(12, 'chipset', 'Chipset', 'GeForce GTX 1050', true, 3),
(13, 'memorySize', 'Memory size', '4 GB', true, 3),
(14, 'memoryType', 'Memory type', 'GDDR5', true, 3),
(15, 'coreSpeed', 'Core speed', '1354 MHz', false, 3),
(16, 'memorySpeed', 'Memory speed', '7008 MHz', false, 3),
(17, 'connectorType', 'Connector Type', 'PCI-E x16 3.0', false, 3),

(18, 'chipsetManufacturer', 'Chipset manufacturer', 'MSI', true, 4),
(19, 'chipset', 'Chipset', 'Radeon RX 590', true, 4),
(20, 'memorySize', 'Memory size', '8 GB', true, 4),
(21, 'memoryType', 'Memory type', 'GDDR5', true, 4),
(22, 'coreSpeed', 'Core speed', '1565 MHz', false, 4),
(23, 'memorySpeed', 'Memory speed', '8000 MHz', false, 4),
(24, 'connectorType', 'Connector Type', 'PCI-E x16', false, 4),

(25, 'chipsetManufacturer', 'Chipset manufacturer', 'Gigabyte', true, 5),
(26, 'chipset', 'Chipset', 'GeForce GTX 1660', true, 5),
(27, 'memorySize', 'Memory size', '6 GB', true, 5),
(28, 'memoryType', 'Memory type', 'GDDR5', true, 5),
(29, 'coreSpeed', 'Core speed', '1785 MHz', false, 5),
(30, 'memorySpeed', 'Memory speed', '8002 MHz', false, 5),
(31, 'connectorType', 'Connector Type', 'PCI-E x16 3.0', false, 5),

(32, 'chipsetManufacturer', 'Chipset manufacturer', 'Gigabyte', true, 6),
(33, 'chipset', 'Chipset', 'GeForce GTX 2070', true, 6),
(34, 'memorySize', 'Memory size', '8 GB', true, 6),
(35, 'memoryType', 'Memory type', 'GDDR6', true, 6),
(36, 'coreSpeed', 'Core speed', '1410 MHz', false, 6),
(37, 'memorySpeed', 'Memory speed', '14000 MHz', false, 6),
(38, 'connectorType', 'Connector Type', 'PCI-E x16 3.0', false, 6),

(39, 'chipsetManufacturer', 'Chipset manufacturer', 'Asus', true, 7),
(40, 'chipset', 'Chipset', 'GeForce GTX 2060', true, 7),
(41, 'memorySize', 'Memory size', '6 GB', true, 7),
(42, 'memoryType', 'Memory type', 'GDDR6', true, 7),
(43, 'coreSpeed', 'Core speed', '1395 MHz', false, 7),
(44, 'memorySpeed', 'Memory speed', '14000 MHz', false, 7),
(45, 'connectorType', 'Connector Type', 'PCI-E x16 3.0', false, 7),

(46, 'chipsetManufacturer', 'Chipset manufacturer', 'Gigabyte', true, 8),
(47, 'chipset', 'Chipset', 'Radeon RX 580', true, 8),
(48, 'memorySize', 'Memory size', '8 GB', true, 8),
(49, 'memoryType', 'Memory type', 'GDDR5', true, 8),
(50, 'coreSpeed', 'Core speed', '1355 MHz', false, 8),
(51, 'memorySpeed', 'Memory speed', '8000 MHz', false, 8),
(52, 'connectorType', 'Connector Type', 'PCI-E x16 3.0', false, 8),

(53, 'chipsetManufacturer', 'Chipset manufacturer', 'MSI', true, 9),
(54, 'chipset', 'Chipset', 'GeForce GTX 2080', true, 9),
(55, 'memorySize', 'Memory size', '8 GB', true, 9),
(56, 'memoryType', 'Memory type', 'GDDR6', true, 9),
(57, 'coreSpeed', 'Core speed', '1490 MHz', false, 9),
(58, 'memorySpeed', 'Memory speed', '14000 MHz', false, 9),
(59, 'connectorType', 'Connector Type', 'PCI-E x16 3.0', false, 9),

(60, 'chipsetManufacturer', 'Chipset manufacturer', 'MSI', true, 10),
(61, 'chipset', 'Chipset', 'GeForce GTX 2050', true, 10),
(62, 'memorySize', 'Memory size', '4 GB', true, 10),
(63, 'memoryType', 'Memory type', 'GDDR5', true, 10),
(64, 'coreSpeed', 'Core speed', '1341 MHz', false, 10),
(65, 'memorySpeed', 'Memory speed', '7008 MHz', false, 10),
(66, 'connectorType', 'Connector Type', 'PCI-E x16 3.0', false, 10),

(67, 'chipsetManufacturer', 'Chipset manufacturer', 'Palit', true, 11),
(68, 'chipset', 'Chipset', 'GeForce GTX 1070', true, 11),
(69, 'memorySize', 'Memory size', '8 GB', true, 11),
(70, 'memoryType', 'Memory type', 'GDDR5', true, 11),
(71, 'coreSpeed', 'Core speed', '1506 MHz', false, 11),
(72, 'memorySpeed', 'Memory speed', '8000 MHz', false, 11),
(73, 'connectorType', 'Connector Type', 'PCI-E x16 3.0', false, 11),

(74, 'chipsetManufacturer', 'Chipset manufacturer', 'Palit', true, 12),
(75, 'chipset', 'Chipset', 'GeForce GTX 1660', true, 12),
(76, 'memorySize', 'Memory size', '6 GB', true, 12),
(77, 'memoryType', 'Memory type', 'GDDR5', true, 12),
(78, 'coreSpeed', 'Core speed', '1408 MHz', false, 12),
(79, 'memorySpeed', 'Memory speed', '8000 MHz', false, 12),
(80, 'connectorType', 'Connector Type', 'PCI-E x16 3.0', false, 12),

(81, 'chipsetManufacturer', 'Chipset manufacturer', 'Palit', true, 13),
(82, 'chipset', 'Chipset', 'GeForce GTX 2080', true, 13),
(83, 'memorySize', 'Memory size', '8 GB', true, 13),
(84, 'memoryType', 'Memory type', 'GDDR6', true, 13),
(85, 'coreSpeed', 'Core speed', '1515 MHz', false, 13),
(86, 'memorySpeed', 'Memory speed', '14000 MHz', false, 13),
(87, 'connectorType', 'Connector Type', 'PCI-E x16 3.0', false, 13),

(88, 'chipsetManufacturer', 'Chipset manufacturer', 'PNY', true, 14),
(89, 'chipset', 'Chipset', 'GeForce GT 1030', true, 14),
(90, 'memorySize', 'Memory size', '2 GB', true, 14),
(91, 'memoryType', 'Memory type', 'GDDR5', true, 14),
(92, 'coreSpeed', 'Core speed', '1227 MHz', false, 14),
(93, 'memorySpeed', 'Memory speed', '1500 MHz', false, 14),
(94, 'connectorType', 'Connector Type', 'PCI-E x16 3.0', false, 14),

(95, 'chipsetManufacturer', 'Chipset manufacturer', 'ASUS', true, 15),
(96, 'chipset', 'Chipset', 'GeForce GTX 1060', true, 15),
(97, 'memorySize', 'Memory size', '3 GB', true, 15),
(98, 'memoryType', 'Memory type', 'GDDR5', true, 15),
(99, 'coreSpeed', 'Core speed', '1594 MHz', false, 15),
(100, 'memorySpeed', 'Memory speed', '8008 MHz', false, 15),
(101, 'connectorType', 'Connector Type', 'PCI-E x16 3.0', false, 15),

(102, 'chipsetManufacturer', 'Chipset manufacturer', 'Sapphire', true, 16),
(103, 'chipset', 'Chipset', 'Radeon RX 560', true, 16),
(104, 'memorySize', 'Memory size', '4 GB', true, 16),
(105, 'memoryType', 'Memory type', 'GDDR5', true, 16),
(106, 'coreSpeed', 'Core speed', '1226 MHz', false, 16),
(107, 'memorySpeed', 'Memory speed', '6000 MHz', false, 16),
(108, 'connectorType', 'Connector Type', 'PCI-E x16 3.0', false, 16),

(109, 'chipsetManufacturer', 'Chipset manufacturer', 'Ganiward', true, 17),
(110, 'chipset', 'Chipset', 'GeForce RTX 2060', true, 17),
(111, 'memorySize', 'Memory size', '6 GB', true, 17),
(112, 'memoryType', 'Memory type', 'GDDR6', true, 17),
(113, 'coreSpeed', 'Core speed', '1680 MHz', false, 17),
(114, 'memorySpeed', 'Memory speed', '14000 MHz', false, 17),
(115, 'connectorType', 'Connector Type', 'PCI-E x16 3.0', false, 17),

(116, 'chipsetManufacturer', 'Chipset manufacturer', 'Gigabyte', true, 18),
(117, 'chipset', 'Chipset', 'GeForce RTX 1050', true, 18),
(118, 'memorySize', 'Memory size', '2 GB', true, 18),
(119, 'memoryType', 'Memory type', 'GDDR5', true, 18),
(120, 'coreSpeed', 'Core speed', '1392 MHz', false, 18),
(121, 'memorySpeed', 'Memory speed', '7008 MHz', false, 18),
(122, 'connectorType', 'Connector Type', 'PCI-E x16 3.0', false, 18),

(123, 'screenSize', 'Size', '21,5"', true, 19),
(124, 'screenResolution', 'Resolution', '1920x1080', true, 19),
(125, 'screenMatrix', 'Matrix', 'LED, IPS', true, 19),
(126, 'screenRefreshRate', 'Refresh Rate', '75 Hz', false, 19),
(127, 'screenColours', 'Colours', '16,7 mln', false, 19),
(128, 'screenProportion', 'Proportion', '16x9', false, 19),

(129, 'screenSize', 'Size', '29"', true, 20),
(130, 'screenResolution', 'Resolution', '2560x1080', true, 20),
(131, 'screenMatrix', 'Matrix', 'LED, IPS', true, 20),
(132, 'screenRefreshRate', 'Refresh Rate', '75 Hz', false, 20),
(133, 'screenColours', 'Colours', '16,7 mln', false, 20),
(134, 'screenProportion', 'Proportion', '21x9', false, 20),

(135, 'discCapacity', 'Capacity', '500 GB', true, 21),
(136, 'discInterface', 'Interface', 'SATA III', true, 21),
(137, 'discFormat', 'Format', '2.5"', true, 21),
(138, 'discReadingSpeed', 'Reading speed', '560 MB/s', false, 21),
(139, 'discSavingSpeed', 'Saving speed', '510 MB/s', false, 21),

(140, 'discCapacity', 'Capacity', '500 GB', true, 22),
(141, 'discInterface', 'Interface', 'M.2', true, 22),
(142, 'discReadingSpeed', 'Reading speed', '3500 MB/s', false, 22),
(143, 'discSavingSpeed', 'Saving speed', '3200 MB/s', false, 22),

(144, 'ramCapacity', 'Capacity', '16 GB', true, 23),
(145, 'ramType', 'Type', 'DDR4', true, 23),
(146, 'ramClocking', 'Speed', '3000 MHz', true, 23),
(147, 'ramDelay', 'Delay', 'CL 16', false, 23);