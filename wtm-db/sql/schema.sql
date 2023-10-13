use wtm;
CREATE TABLE Heroes (
    Id bigint unsigned auto_increment,
    LastName varchar(255),
    FirstName varchar(255),
    Alias varchar(255),
    City varchar(255),
    primary key (Id)

);

INSERT INTO Heroes
(Id, LastName, FirstName, Alias, City)
VALUES(1, 'Kent', 'Clark', 'Superman', 'Metropolis');
INSERT INTO Heroes
(Id, LastName, FirstName, Alias, City)
VALUES(2, 'Wayne', 'Bruce', 'Batman', 'Gotham');
INSERT INTO Heroes
(Id, LastName, FirstName, Alias, City)
VALUES(3, 'Peter', 'Parker', 'Spiderman', 'New York');
INSERT INTO Heroes
(Id, LastName, FirstName, Alias, City)
VALUES(4, 'Tony', 'Stark', 'Ironman', 'Los Angeles');

