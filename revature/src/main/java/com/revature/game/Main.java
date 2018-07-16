package com.revature.game;



import java.util.HashMap;

import com.revature.beans.Room;

public class Main {
    private Parser parser;
    private Room currentRoom;
    HashMap<Integer, Room> map = new HashMap<Integer, Room>();

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
        
        outside.GenerateRoom(1, "outside");
        graveyard.GenerateRoom(2,"graveyard");
        foyer.GenerateRoom(3, "foyer");
        bedroom.GenerateRoom(4, "bedroom");
        kitchen.GenerateRoom(5, "kitchen");
        treasure.GenerateRoom(6, "treasure");

        currentRoom = outside;
        
        map.put(1, outside);
        map.put(2, graveyard);
        map.put(3, foyer);
        map.put(4, bedroom);
        map.put(5, kitchen);
        map.put(6, treasure);
        
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
            System.out.println("Valid commands: go, quit, help");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("go")) {
            goRoom(command);
        } else if (commandWord.equals("help")) {
        	System.out.print("Valid commands are: ");
            parser.showCommands();
            System.out.println();
        } else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }

        return wantToQuit;
    }

    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            //If there is no second word
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        //Try to leave current room
        int nextRoom = currentRoom.getExits(direction);

        if(nextRoom == 0 || nextRoom < 100) {
            System.out.println("Can't go there!");
        } else {
            currentRoom = map.get(nextRoom);
            System.out.println(currentRoom.getLongDescription());
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