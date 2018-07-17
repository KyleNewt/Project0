package com.revature.game;



import java.util.HashMap;

import com.revature.beans.Player;
import com.revature.beans.Room;
import com.revature.dao.KeyDao;

public class Main {
    private Parser parser;
    public Room currentRoom;
    HashMap<Integer, Room> map = new HashMap<Integer, Room>();
    String direction = null;
    
    public static void main(String[] args) {
        Main game = new Main();
        game.play();
    }

    public Main() {
    	
        createRooms();
        parser = new Parser();
    }

    private void createRooms() {
        Room outside = new Room(1, "outside");
        Room graveyard = new Room(2, "graveyard");
        Room foyer = new Room(3, "foyer");
        Room bedroom = new Room(4, "bedroom");
        Room kitchen = new Room(5, "kitchen");
        Room treasure = new Room(6, "treasure");
        
        outside.GenerateRoom(1);
        graveyard.GenerateRoom(2);
        foyer.GenerateRoom(3);
        bedroom.GenerateRoom(4);
        kitchen.GenerateRoom(5);
        treasure.GenerateRoom(6);
        
        map.put(1, outside);
        map.put(2, graveyard);
        map.put(3, foyer);
        map.put(4, bedroom);
        map.put(5, kitchen);
        map.put(6, treasure);
        
        currentRoom = map.get(1);

        Player.setRoomID(1);
    }

    public void play() {
        System.out.println();
        System.out.println("Welcome to Project 0.");
        System.out.println("Explore the house.");
        System.out.println("Type 'help' if you need it.");

        System.out.println(currentRoom.getLongDescription());

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thanks for playing.");
    }

    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("go")) {
            goRoom(command);
        } else if (commandWord.equals("help")) {
        	System.out.print("Valid commands are: ");
            parser.showCommands();
            System.out.println();
        } else if (commandWord.equals("use")) {
        	useObject(command);
    	}else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }

        return wantToQuit;
    }

    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            //If there is no second word
            System.out.println("Go where?");
            return;
        } else {
        	direction = command.getSecondWord();
        	System.out.println(direction + " " + currentRoom.getRoomID());
        	int nextRoom = currentRoom.getExits(direction, currentRoom.getRoomID());

            if(nextRoom == 0 || nextRoom > 100) {
                System.out.println("Can't go there!");
            } else {
                currentRoom = map.get(nextRoom);
                Player.setRoomID(currentRoom.getRoomID());
            }
        }
    }
    
    private void useObject(Command command) {
    	if (!command.hasSecondWord()) {
    		System.out.println("Use what?");
    		return;
    	} else {
    		String thisObject = command.getSecondWord();
    		if (thisObject.equals("coffin")) {
    			if (currentRoom.getRoomID() == 2) {
    				System.out.println("You reach into the coffin and pull out a key.");
    				Player.getKey(currentRoom.getRoomID());
    			}
    		} else if (thisObject.equals("bed")) {
    			if (currentRoom.getRoomID() == 4) {
    				System.out.println("You search the bed and find another key!");
    				Player.getKey(4);
    			}
    		} else if (thisObject.equals("sink")) {
    			if (currentRoom.getRoomID() == 5) {
    				System.out.println("You plunge your hand into the blood-filled sink.  And find a button.  Pushing it, a door to the north slides open.");
    				Room kitchen = map.get(5);
    				kitchen.setRoomNorth(6);
    			}
    		} else if (thisObject.equals("chest")) {
    			if (currentRoom.getRoomID() == 6) {
    				System.out.println("Inside the chest is Alex's computer.  It explodes.  You die.");
    				Room treasure = map.get(6);
    				treasure.setRoomSouth(105);
    				System.out.println("Type quit to quit");
    			}
    		}
    	}
    }

    private boolean quit(Command command) {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;
        }
    }
}