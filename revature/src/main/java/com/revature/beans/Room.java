package com.revature.beans;

import com.revature.dao.RoomDao;

public class Room {
	private int roomID;
	private int north;
	private int south;
	private int east;
	private int west;
    private String longDescription;
	private String shortDescription;
	private String roomName;
	
	public int getRoomID() {
		return roomID;
	}
	
	public void setRoomID(int id) {
		this.roomID = id;
	}
	
	public String getLongDescription() {
		return longDescription;
	}
	
	public String getShortDescription() {
		return shortDescription;
	}
	
	public int getExits(String direction) {
		if (direction.equals("north")) {
			if (north > 100) {
				System.out.print("North is blocked. ");
				//Check if you have a key
				//if yes ask if you want to use key
				return north;
			} else if (north < 1) {
				System.out.print("North has nothing. ");
				return 0;
			}
		}
		
		if (direction.equals("south")) {
			if (south > 100) {
				System.out.print("South is blocked. ");
				//Check if you have a key
				//if yes ask if you want to use key
				return south;
			} else if (south < 1) {
				System.out.print("South has nothing. ");
				return 0;
			}
		}
		if (direction.equals("east")) {
			if (east > 100) {
				System.out.print("East is blocked. ");
				//Check if you have a key
				//if yes ask if you want to use key
				return east;
			} else if (east < 1) {
				System.out.print("East has nothing. ");
				return 0;
			}
		}
		
		if (direction.equals("west")) {
			if (west > 100) {
				System.out.print("West is blocked. ");
				//Check if you have a key
				//if yes ask if you want to use key
				return west;
			} else if (west < 1) {
				System.out.print("West has nothing. ");
				return 0;
			}
		}
		return 0;
	}

	public Room(int roomID, String roomName) {
		this.roomID = roomID;
		this.roomName = roomName;
	}
	

	public Room(int roomID, int north, int south, int east, int west, String longDescription, String shortDescription) {
		this.roomID = roomID;
		this.north = north;
		this.south = south;
		this.east = east;
		this.west = west;
		this.longDescription = longDescription;
		this.shortDescription = shortDescription;
	}

	public void GenerateRoom(int room_id, String roomName) {
		RoomDao.getRoomData(room_id, roomName);	
	}
}

