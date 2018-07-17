DROP TABLE Barricades;
DROP TABLE Items;
DROP TABLE Player;
DROP TABLE Room;

CREATE TABLE Room(
        room_id INTEGER PRIMARY KEY NOT NULL,
        north INTEGER,
        south INTEGER,
        east INTEGER,
        west INTEGER,
        room_long_description VARCHAR2(400),
        room_description VARCHAR2(200)
);

CREATE TABLE Player(
    room_id INTEGER PRIMARY KEY NOT NULL,
    inventory VARCHAR2(200)
);

CREATE TABLE Items(
    item_id INTEGER PRIMARY KEY NOT NULL,
    room_id INTEGER NOT NULL,
    item_name VARCHAR2(20),
    obtained INTEGER
);

CREATE TABLE Barricades(
    barricade_id INTEGER PRIMARY KEY NOT NULL,
    room_id INTEGER NOT NULL,
    barricade_exists NUMBER DEFAULT (1) CHECK (barricade_exists in (0,1))
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
        'You enter the secret passage.  One hand is still dripping blood, the other is...moist with...something from the bed.  But you have done it.  Welcome to the secret TREASURE ROOM of legend!  Before you sits the most extravagent chest you have ever seen!',
        'You are in the TREASURE ROOM!  The chest is right there for the taking!');

--insert into Items
INSERT INTO Items(item_id, room_id, item_name, obtained)
    VALUES(1, 2, 'key', 0);
INSERT INTO Items 
    VALUES(2, 4, 'key', 0);

--Insert into barricades(Front door, Wooden Door, Metal Door, Hidden Passage)
INSERT INTO Barricades(barricade_id, room_id, barricade_exists)
    VALUES(1, 1, 1);
INSERT INTO Barricades VALUES(2, 3, 1);
    
INSERT INTO Player(room_id, inventory)
    VALUES(1, null);

COMMIT;


