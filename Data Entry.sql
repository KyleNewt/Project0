CREATE TABLE Room(
    room_id INT UNIQUE NOT NULL,
    north BOOLEAN DEFAULT FALSE,
    south BOOLEAN DEFAULT FALSE,
    east BOOLEAN DEFAULT FALSE,
    west BOOLEAN DEFAULT FALSE,
    barricade_id INT REFERENCES Barricades(barricade_id),
    
    
    CONSTRAINT room_id_pk PRIMARY KEY (room_id)
    
);

CREATE TABLE Player(
    room_id UNIQUE NOT NULL,
    inventory VARCHAR2(200),
    
    
    CONSTRAINT room_id_fk FOREIGN KEY (room_id) REFERENCES Room(room_id)
);

CREATE TABLE Items(
    item_id INT UNIQUE NOT NULL,
    item_name VARCHAR2(20),
    item_description VARCHAR(40),
    item_use VARCHAR(20),
    room_id INT UNIQUE NOT NULL,
    combines_with VARCHAR2(10),
    obtained BOOLEAN,
    
    CONSTRAINT room_id_fk FOREIGN KEY (room_id) REFERENCES Room(room_id)
);

CREATE TABLE Barricades(
    barricade_id INT UNIQUE NOT NULL,
    room_id INT UNIQUE NOT NULL,
    barricade_description VARCHAR2(100),
    
    
    CONSTRAINT room_id_fk FOREIGN KEY (room_id) REFERENCES Room(room_id)
);

