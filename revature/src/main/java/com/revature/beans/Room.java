package com.revature.beans;

import com.revature.dao.RoomDao;

public class Room {
	private String longDescription;
	private String shortDescription;
	private String exits;
	private int roomID;
	
	public void getLongDescription() {
		longDescription = RoomDao.getLongDescription(roomID);
		
		System.out.println(longDescription);
	}
	
	public void getShortDescription() {
		shortDescription = RoomDao.getShortDescription(roomID);
		
		System.out.println(shortDescription);
	}
	
	public void getExits() {
		exits = RoomDao.getExits(roomID);
		//parse through N,S,E,W, set North = N, etc
		//if (direction) = 0, don't show.  If >100, blockaded. Else add to exits.
				
		
		System.out.println("The directions you can go are " + exits);
	}
	
	public void moveRooms(String direction) {
		int nextRoomID;
		if (direction != "north" || direction != "south" || direction != "east" || direction != "west") {
			System.out.println("This is not a valid direction.");
		} else {
			nextRoomID = RoomDao.moveRooms(roomID, direction);
			
			if (nextRoomID == 0) {
				System.out.println("Try as you might, you cannot go this direction.");
			} else if (nextRoomID > 100) {
				System.out.println("You try to go this way, but it appears your path is blocked.");
			} else {
				roomID = nextRoomID;
				Player.setRoomID(roomID);
				getLongDescription();
				System.out.println();
				getExits();
			}
		}
	}
}

