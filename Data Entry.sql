DROP TABLE Barricades;
DROP TABLE Items;
DROP TABLE Player;
DROP TABLE Room;

CREATE TABLE Room(
    room_id INTEGER UNIQUE NOT NULL,
    north INTEGER,
    south INTEGER,
    east INTEGER,
    west INTEGER,
    room_long_description VARCHAR2(400),
    room_description VARCHAR2(200)
);

CREATE TABLE Player(
    room_id INTEGER UNIQUE NOT NULL,
    inventory VARCHAR2(200)
);

CREATE TABLE Items(
    item_id INTEGER UNIQUE NOT NULL,
    item_name VARCHAR2(20),
    item_description VARCHAR2(100),
    item_use VARCHAR2(200),
    room_id INTEGER UNIQUE NOT NULL,
    combines_with VARCHAR2(10),
    obtained Number DEFAULT (0) CHECK (obtained in (0,1,2))
);

CREATE TABLE Barricades(
    barricade_id INTEGER UNIQUE NOT NULL,
    room_id INTEGER NOT NULL,
    barricade_exists NUMBER DEFAULT (0) CHECK (barricade_exists in (0,1)),
    barricade_description VARCHAR2(100),
    barricade_gone_description VARCHAR2(100)
);

ALTER TABLE Barricades 
    ADD CONSTRAINT fk_barricades_to_room_id 
    FOREIGN KEY (room_id) REFERENCES Room(room_id);
ALTER TABLE Items 
    ADD CONSTRAINT fk_items_to_room_id 
    FOREIGN KEY (room_id) REFERENCES Room(room_id);
ALTER TABLE Player
     ADD CONSTRAINT fk_player_to_room_id 
     FOREIGN KEY (room_id) REFERENCES Room(room_id);
     
--Insert into Room (front yard, graveyard, foyer, bedroom, kitchen, treasure room)
INSERT INTO Room(room_id, north, south, east, west, room_long_description, room_description)
    VALUES (1, 103, 0, 0, 2,
        'You enter the abandoned house into a front yard.  It needs work.  All around you are dead plants and broken pots long left untreated.  The front door looms to your north.  A small pathway hidden by overgrown plants is to your west.',
        'There are dead plants and broken pots all around you.');
INSERT INTO Room(room_id, north, south, east, west, room_long_description, room_description)
    VALUES (2, 0, 1, 0, 0, 
        'You wrap around the house and stumble upon the private family graveyard.  Several graves have cracks or mold growing on them.  A freshly dug hole with an open coffin sits to one side.',
        'You are in the graveyard.  A freshly dug hole with a coffin sits to one side. The way back to the front yard is to your south.');
INSERT INTO Room(room_id, north, south, east, west, room_long_description, room_description)
    VALUES(3, 4, 1, 105, 0, 
        'You walk into a large foyer.  Above you hangs the largest chandelier you have ever seen.  Up a large flight of stairs to your north is a small wooden door.  To the east is a pair of large, metal, double doors.',
        'You stand in the foyer.  You see the wooden door to the north, and the metal door to the east.');
INSERT INTO Room(room_id, north, south, east, west, room_long_description, room_description)
    VALUES(4, 0, 3, 0, 0,
        'You enter a large bedroom.  The room has an oddly pink shade of lighting from an unknown source.  In the center of the room, taking up a good majority sits a large bed with a leopard print blanket.  It looks...moist.  The wooden door is to your south.',
        'You are in the bedroom.  A massive bed sits in the middle.  It still looks...moist.  The wooden door is to your south.');
INSERT INTO Room(room_id, north, south, east, west, room_long_description, room_description)
    VALUES (5, 106, 0, 0, 3, 
        'You enter a kitchen.  Your nose is immediately assaulted with the scent of...flowers?  Which is weird because there is blood EVERYWHERE.  The source appears to be the sink off to the far side.  Blood pours out of the open faucet. and onto the floor.  The metal door is to your west.',
        'You are in the kitchen, standing in an inch of blood.  The sink is in the far corner.  The metal door is to the west.');
INSERT INTO Room(room_id, north, south, east, west, room_long_description, room_description)
    VALUES (6, 0, 5, 0, 0,
        'You enter the secret passage.  One hand is still dripping blood, the other is...moist with...something from the bed.  But you have done it.  Welcome found the secret TREASURE ROOM of legend!  Before you sits the most extravagent chest you have ever seen!',
        'You are in the TREASURE ROOM!  The chest is right there for the taking!');

--insert into Items (coffin key, metal key)
INSERT INTO Items(item_id, item_name, item_description, item_use, room_id, combines_with, obtained)
    VALUES(1, 'coffin key', 'This was found in a coffin in the graveyard.', 
    'You slide the key into the lock and twist.  The large door creaks open.', 2, 'front door', 0);
INSERT INTO Items 
    VALUES(2, 'metal key', 'This key is very shiny...and still moist.',
    'It takes a little shoving, but after some force the key goes into the lock.  A good twist, and the door is open.', 4, 'metal door', 0);

--Insert into barricades(Front door, Wooden Door, Metal Door, Hidden Passage)
INSERT INTO Barricades(barricade_id, room_id, barricade_exists, barricade_description, barricade_gone_description)
    VALUES(1, 1, 1, 'The front door to the mansion.', 'The door is unlocked.');
INSERT INTO Barricades VALUES (2, 3, 1, 
    'A wooden door at the top of a large flight of stairs.  A faint pink glow comes from underneath.', 'The door is open!');
INSERT INTO Barricades VALUES (3, 3, 1, 
    'Two large metal doors, with a tiny hole for a key.', 'The door is unlocked.');
INSERT INTO Barricades VALUES(4, 5, 1, 
    'A large, dark passageway.  You cannot see where it ends.', 'The wall hiding this passageway has moved away.');
    
INSERT INTO Player(room_id, inventory)
    VALUES(1, null);

SELECT * FROM Room;
    
SELECT North, South, East, West FROM Room WHERE room_id = 1;
