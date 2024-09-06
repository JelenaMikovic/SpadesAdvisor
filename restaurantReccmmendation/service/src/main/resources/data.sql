INSERT INTO Users (first_name, last_name, email, password, is_admin) VALUES
('John', 'Doe', 'john@example.com', 'password123', true),
('Jane', 'Doe', 'jane@example.com', 'password456', false),
('Alice', 'Smith', 'alice@example.com', 'password789', false),
('Michael', 'Johnson', 'michael@example.com', 'password1', false),
('Emily', 'Williams', 'emily@example.com', 'password2', false),
('Daniel', 'Brown', 'daniel@example.com', 'password3', false),
('Sophia', 'Jones', 'sophia@example.com', 'password4', false),
('William', 'Garcia', 'william@example.com', 'password5', false),
('Olivia', 'Martinez', 'olivia@example.com', 'password6', false),
('Alexander', 'Hernandez', 'alexander@example.com', 'password7', false),
('Isabella', 'Lopez', 'isabella@example.com', 'password8', false),
('Ethan', 'Gonzalez', 'ethan@example.com', 'password9', false),
('Ava', 'Wilson', 'ava@example.com', 'password10', false),
('Liam', 'Anderson', 'liam@example.com', 'password11', false),
('Mia', 'Thomas', 'mia@example.com', 'password12', false),
('James', 'Taylor', 'james@example.com', 'password13', false),
('Emma', 'Moore', 'emma@example.com', 'password14', false),
('Benjamin', 'Jackson', 'benjamin@example.com', 'password15', false),
('Amelia', 'White', 'amelia@example.com', 'password16', false),
('Lucas', 'Harris', 'lucas@example.com', 'password17', false),
('Charlotte', 'Clark', 'charlotte@example.com', 'password18', false),
('Henry', 'Lewis', 'henry@example.com', 'password19', false),
('Harper', 'Walker', 'harper@example.com', 'password20', false);

INSERT INTO Restaurants (name, cuisine_type, location, price, opening_hour, closing_hour, is_vegetarian_friendly, is_smoker_friendly, is_trending) VALUES
('Gusto Italiano', 0, 'Bulevar Oslobođenja 22, Stari Grad, Novi Sad', 2500.00, '12:00', '23:00', true, false, false),
('Great Wall', 1, 'Bulevar Cara Lazara 18, Stari Grad, Novi Sad', 2000.00, '11:30', '22:30', true, false, false),
('El Mariachi', 2, 'Bulevar Mihajla Pupina 3, Novo Naselje, Novi Sad', 1800.00, '11:00', '23:00', true, true, false),
('Uncle Sams Diner', 3, 'Bulevar Jovana Dučića 7, Detelinara, Novi Sad', 2200.00, '08:00', '20:00', true, true, false),
('Le Petit Bistro', 4, 'Futoška 44, Grbavica, Novi Sad', 2700.00, '18:00', '00:00', false, false, false),
('Sakura Sushi', 5, 'Narodnog Fronta 20, Liman, Novi Sad', 3000.00, '12:00', '22:00', true, false, false),
('Taj Mahal', 6, 'Bulevar Evrope 15, Novo Naselje, Novi Sad', 2300.00, '12:30', '22:30', true, false, false),
('Bangkok Spice', 7, 'Bulevar Despota Stefana 11, Detelinara, Novi Sad', 2500.00, '12:00', '21:00', true, false, false),
('Olive Tree Taverna', 8, 'Fruškogorska 2, Telep, Novi Sad', 2700.00, '17:30', '23:00', true, false, false),
('Balkan Grill', 9, 'Bulevar Cara Lazara 33, Liman, Novi Sad', 2000.00, '11:00', '22:00', true, true, false),
('La Piazza', 0, 'Kisačka 12, Adamovićevo Naselje, Novi Sad', 2800.00, '18:00', '22:30', true, false, false),
('Golden Dragon', 1, 'Bulevar Mihajla Pupina 14, Novo Naselje, Novi Sad', 2000.00, '11:00', '21:30', true, false, false),
('El Camino', 2, 'Futoška 35, Grbavica, Novi Sad', 1800.00, '12:00', '22:00', true, true, false),
('Route 66 Diner', 3, 'Bulevar Jovana Dučića 9, Detelinara, Novi Sad', 2200.00, '08:00', '21:00', true, true, false),
('Le Croissant', 4, 'Njegoševa 6, Stari Grad, Novi Sad', 2700.00, '07:00', '20:00', false, false, false),
('Mumbai Delight', 6, 'Jovana Subotića 10, Adamovićevo Naselje, Novi Sad', 2300.00, '12:30', '22:30', true, false, false),
('Thai Orchid', 7, 'Bulevar Oslobođenja 15, Telep, Novi Sad', 2500.00, '12:00', '21:00', true, false, false),
('Athenas Tavern', 8, 'Fruškogorska 8, Liman, Novi Sad', 2700.00, '17:00', '23:00', true, false, false),
('Balkan Delight', 9, 'Bulevar Mihajla Pupina 22, Novo Naselje, Novi Sad', 2000.00, '11:00', '22:00', true, true, false),
('Pasta Paradise', 0, 'Bulevar Cara Lazara 7, Liman, Novi Sad', 2800.00, '18:00', '22:30', true, false, false),
('Peking Palace', 1, 'Narodnog Fronta 18, Detelinara, Novi Sad', 2000.00, '11:00', '21:30', true, false, false),
('El Paso', 2, 'Futoška 28, Adamovićevo Naselje, Novi Sad', 1800.00, '12:00', '22:00', true, true, false),
('Star Spangled Diner', 3, 'Bulevar Jovana Dučića 11, Detelinara, Novi Sad', 2200.00, '08:00', '21:00', true, true, false),
('Le Bistro', 4, 'Njegoševa 12, Stari Grad, Novi Sad', 2700.00, '18:00', '23:00', false, false, false),
('Tokyo Teppanyaki', 5, 'Bulevar Oslobođenja 17, Liman 2, Novi Sad', 3000.00, '12:00', '22:00', true, false, true),
('Taj Palace', 6, 'Jovana Subotića 18, Telep, Novi Sad', 2300.00, '12:30', '22:30', true, false, false),
('Siam Spice', 7, 'Bulevar Despota Stefana 19, Detelinara, Novi Sad', 2500.00, '12:00', '21:00', true, false, false),
('Olive Grove', 8, 'Fruškogorska 20, Telep, Novi Sad', 2700.00, '17:30', '23:00', true, false, false),
('Balkan Feast', 9, 'Bulevar Cara Lazara 31, Liman, Novi Sad', 2000.00, '11:00', '22:00', true, true, false),
('Pizza Roma', 0, 'Bulevar Mihajla Pupina 25, Novo Naselje, Novi Sad', 1800.00, '11:00', '23:00', true, false, false),
('Chopsticks', 1, 'Narodnog Fronta 8, Liman, Novi Sad', 2000.00, '11:30', '22:30', true, false, false),
('El Burrito', 2, 'Bulevar Evrope 10, Novo Naselje, Novi Sad', 1900.00, '11:00', '22:00', true, true, false),
('Stars and Stripes', 3, 'Bulevar Jovana Dučića 15, Detelinara, Novi Sad', 2200.00, '08:00', '21:00', true, true, false),
('Le Salon', 4, 'Futoška 16, Grbavica, Novi Sad', 2600.00, '18:00', '23:00', false, false, false),
('Sushi Ninja', 5, 'Bulevar Oslobođenja 12, Telep, Novi Sad', 2900.00, '12:00', '22:00', true, false, true),
('Curry House', 6, 'Bulevar Mihajla Pupina 29, Novo Naselje, Novi Sad', 2200.00, '12:30', '22:30', true, false, false),
('Spice Garden', 7, 'Bulevar Despota Stefana 9, Stari Grad, Novi Sad', 2400.00, '12:00', '21:00', true, false, false),
('Olive Branch', 8, 'Fruškogorska 25, Telep, Novi Sad', 2600.00, '17:30', '23:00', true, false, false),
('Balkan Grillhouse', 9, 'Bulevar Cara Lazara 37, Liman 2, Novi Sad', 2100.00, '11:00', '22:00', true, true, false),
('Serbian Grillhouse', 9, 'Bulevar Oslobođenja 3, Stari Grad, Novi Sad', 1800.00, '11:00', '22:00', true, true, false);

INSERT INTO USERS_VISITED_RESTAURANTS (USER_ID , VISITED_RESTAURANTS_ID) VALUES
(1, 3),  -- John Doe posetio El Mariachi
(2, 5),  -- Jane Doe posetila Le Petit Bistro
(2, 1), -- Jane Doe Great Wall
(3, 7),  -- Alice Smith posetila Taj Mahal
(4, 2),  -- Michael Johnson posetio Great Wall
(5, 8),  -- Emily Williams posetila Bangkok Spice
(6, 6),  -- Daniel Brown posetio Sakura Sushi
(7, 4),  -- Sophia Jones posetila Uncle Sams Diner
(8, 10), -- William Garcia posetio Balkan Grill
(9, 9),  -- Olivia Martinez posetila Olive Tree Taverna
(10, 1), -- Alexander Hernandez posetio Gusto Italiano
(11, 11), -- Isabella Lopez posetila La Piazza
(12, 14), -- Ethan Gonzalez posetio Route 66 Diner
(13, 12), -- Ava Wilson posetila Golden Dragon
(14, 16), -- Liam Anderson posetio Mumbai Delight
(15, 17), -- Mia Thomas posetila Thai Orchid
(16, 19), -- James Taylor posetio Balkan Delight
(17, 20), -- Emma Moore posetila Pasta Paradise
(18, 15), -- Benjamin Jackson posetio Le Croissant
(19, 18), -- Amelia White posetila Athenas Tavern
(20, 13); -- Lucas Harris posetio El Camino

-- CREATE ALIAS GenerateReviews FOR "GenerateReviews.generate";
-- CALL GenerateReviews();
