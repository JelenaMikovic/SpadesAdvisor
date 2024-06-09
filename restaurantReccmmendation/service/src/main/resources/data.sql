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

INSERT INTO Restaurants (name, cuisine_type, location, price, opening_hour, closing_hour, is_vegetarian_friendly, is_smoker_friendly) VALUES
('Gusto Italiano', 0, 'Bulevar Oslobođenja 22, Stari Grad, Novi Sad', 2500.00, '12:00', '23:00', true, false),
('Great Wall', 1, 'Bulevar Cara Lazara 18, Stari Grad, Novi Sad', 2000.00, '11:30', '22:30', true, false),
('El Mariachi', 2, 'Bulevar Mihajla Pupina 3, Novo Naselje, Novi Sad', 1800.00, '11:00', '23:00', true, true),
('Uncle Sams Diner', 3, 'Bulevar Jovana Dučića 7, Stari Grad, Novi Sad', 2200.00, '08:00', '20:00', true, true),
('Le Petit Bistro', 4, 'Futoška 44, Grbavica, Novi Sad', 2700.00, '18:00', '00:00', false, false),
('Sakura Sushi', 5, 'Narodnog Fronta 20, Stari Grad, Novi Sad', 3000.00, '12:00', '22:00', true, false),
('Taj Mahal', 6, 'Bulevar Evrope 15, Liman, Novi Sad', 2300.00, '12:30', '22:30', true, false),
('Bangkok Spice', 7, 'Bulevar Despota Stefana 11, Stari Grad, Novi Sad', 2500.00, '12:00', '21:00', true, false),
('Olive Tree Taverna', 8, 'Fruškogorska 2, Stari Grad, Novi Sad', 2700.00, '17:30', '23:00', true, false),
('Balkan Grill', 9, 'Bulevar Cara Lazara 33, Stari Grad, Novi Sad', 2000.00, '11:00', '22:00', true, true),
('La Piazza', 0, 'Kisačka 12, Adamovićevo Naselje, Novi Sad', 2800.00, '18:00', '22:30', true, false),
('Golden Dragon', 1, 'Bulevar Mihajla Pupina 14, Novo Naselje, Novi Sad', 2000.00, '11:00', '21:30', true, false),
('El Camino', 2, 'Futoška 35, Grbavica, Novi Sad', 1800.00, '12:00', '22:00', true, true),
('Route 66 Diner', 3, 'Bulevar Jovana Dučića 9, Stari Grad, Novi Sad', 2200.00, '08:00', '21:00', true, true),
('Le Croissant', 4, 'Njegoševa 6, Stari Grad, Novi Sad', 2700.00, '07:00', '20:00', false, false),
('Mumbai Delight', 6, 'Jovana Subotića 10, Stari Grad, Novi Sad', 2300.00, '12:30', '22:30', true, false),
('Thai Orchid', 7, 'Bulevar Oslobođenja 15, Stari Grad, Novi Sad', 2500.00, '12:00', '21:00', true, false),
('Athenas Tavern', 8, 'Fruškogorska 8, Stari Grad, Novi Sad', 2700.00, '17:00', '23:00', true, false),
('Balkan Delight', 9, 'Bulevar Mihajla Pupina 22, Novo Naselje, Novi Sad', 2000.00, '11:00', '22:00', true, true),
('Pasta Paradise', 0, 'Bulevar Cara Lazara 7, Stari Grad, Novi Sad', 2800.00, '18:00', '22:30', true, false),
('Peking Palace', 1, 'Narodnog Fronta 18, Stari Grad, Novi Sad', 2000.00, '11:00', '21:30', true, false),
('El Paso', 2, 'Futoška 28, Grbavica, Novi Sad', 1800.00, '12:00', '22:00', true, true),
('Star Spangled Diner', 3, 'Bulevar Jovana Dučića 11, Stari Grad, Novi Sad', 2200.00, '08:00', '21:00', true, true),
('Le Bistro', 4, 'Njegoševa 12, Stari Grad, Novi Sad', 2700.00, '18:00', '23:00', false, false),
('Tokyo Teppanyaki', 5, 'Bulevar Oslobođenja 17, Stari Grad, Novi Sad', 3000.00, '12:00', '22:00', true, false),
('Taj Palace', 6, 'Jovana Subotića 18, Stari Grad, Novi Sad', 2300.00, '12:30', '22:30', true, false),
('Siam Spice', 7, 'Bulevar Despota Stefana 19, Stari Grad, Novi Sad', 2500.00, '12:00', '21:00', true, false),
('Olive Grove', 8, 'Fruškogorska 20, Stari Grad, Novi Sad', 2700.00, '17:30', '23:00', true, false),
('Balkan Feast', 9, 'Bulevar Cara Lazara 31, Stari Grad, Novi Sad', 2000.00, '11:00', '22:00', true, true),
('Pizza Roma', 0, 'Bulevar Mihajla Pupina 25, Novo Naselje, Novi Sad', 1800.00, '11:00', '23:00', true, false),
('Chopsticks', 1, 'Narodnog Fronta 8, Stari Grad, Novi Sad', 2000.00, '11:30', '22:30', true, false),
('El Burrito', 2, 'Bulevar Evrope 10, Liman, Novi Sad', 1900.00, '11:00', '22:00', true, true),
('Stars and Stripes', 3, 'Bulevar Jovana Dučića 15, Stari Grad, Novi Sad', 2200.00, '08:00', '21:00', true, true),
('Le Salon', 4, 'Futoška 16, Grbavica, Novi Sad', 2600.00, '18:00', '23:00', false, false),
('Sushi Ninja', 5, 'Bulevar Oslobođenja 12, Stari Grad, Novi Sad', 2900.00, '12:00', '22:00', true, false),
('Curry House', 6, 'Bulevar Mihajla Pupina 29, Novo Naselje, Novi Sad', 2200.00, '12:30', '22:30', true, false),
('Spice Garden', 7, 'Bulevar Despota Stefana 9, Stari Grad, Novi Sad', 2400.00, '12:00', '21:00', true, false),
('Olive Branch', 8, 'Fruškogorska 25, Stari Grad, Novi Sad', 2600.00, '17:30', '23:00', true, false),
('Balkan Grillhouse', 9, 'Bulevar Cara Lazara 37, Stari Grad, Novi Sad', 2100.00, '11:00', '22:00', true, true),
('Serbian Grillhouse', 9, 'Bulevar Oslobodjenja 3, Stari Grad, Novi Sad', 800.00, '11:00', '22:00', true, true);

CREATE ALIAS GenerateReviews FOR "GenerateReviews.generate";
CALL GenerateReviews();
