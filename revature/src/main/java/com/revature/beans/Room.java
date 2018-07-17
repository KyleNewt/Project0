package com.revature.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.revature.dao.KeyDao;
import com.revature.util.ConnectionUtil;

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
	
	public void setRoomNorth(int id) {
		north = id;
		System.out.println(north);
	}

	public void setRoomSouth(int id) {
		south = id;
		System.out.println(south);
	}
	
	public void setRoomEast(int id) {
		east = id;
		System.out.println(east);
	}
	
	public void setRoomWest(int id) {
		west = id;
		System.out.println(west);
	}
	
	public String getLongDescription() {
		return longDescription;
	}
	
	public String getShortDescription() {
		return shortDescription;
	}
	
	public int getExits(String direction, int roomID) {
		if (direction.equals("north")) {
			if (north > 100) {
				System.out.print("North is blocked. ");
				if (Player.getKeys() < 1) {
					System.out.println("You have no keys. ");
					return 0;
				} else {
					System.out.println("You used a key! ");
					north = north-100;
					Player.useKey(direction, roomID, north);
					return north;
				}
			} else if (north < 1) {
				System.out.print("North has nothing. ");
				return 0;
			} else {
				return north;
			}
		} else if (direction.equals("south")) {
			if (south > 100) {
				System.out.print("South is blocked. ");
				if (Player.getKeys() < 1) {
					System.out.println("You have no keys. ");
					return 0;
				} else {
					System.out.println("You used a key! ");
					south = south-100;
					Player.useKey(direction, roomID, south);
					return south;
				}
			} else if (south < 1) {
				System.out.print("South has nothing. ");
				return 0;
			} else {
				return south;
			}
		} else if (direction.equals("east")) {
			if (east > 100) {
				System.out.print("East is blocked. ");
				if (Player.getKeys() < 1) {
					System.out.println("You have no keys. ");
					return 0;
				} else {
					System.out.println("You used a key! ");
					east = east-100;
					Player.useKey(direction, roomID, east);
					return east;
				}
			} else if (east < 1) {
				System.out.print("East has nothing. ");
				return 0;
			} else {
				return east;
			}
		} else if (direction.equals("west")) {
			if (west > 100) {
				System.out.print("West is blocked. ");
				if (Player.getKeys() < 1) {
					System.out.println("You have no keys. ");
					return 0;
				} else {
					System.out.println("You used a key! ");
					west = west-100;
					Player.useKey(direction, roomID, west);
					return west;
				}
			} else if (west < 1) {
				System.out.print("West has nothing. ");
				return 0;
			} else {
				return west;
			}
		}
		System.out.println("That is not a compass direction. ");
		return 0;
	}
	
	public void getData() {
		System.out.println(roomID + " " + north + south + east + west);
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

	public void GenerateRoom(int room_id) {
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM Room WHERE room_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, room_id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
			    north = rs.getInt("north");
			    System.out.print(north + " ");
			    south = rs.getInt("south");
			    System.out.print(south + " ");
			    east = rs.getInt("east");
			    System.out.print(east + " ");
			    west = rs.getInt("west");
			    System.out.print(west + " ");
			    longDescription = rs.getString("room_long_description");
			    shortDescription = rs.getString("room_description");
			    System.out.println("End of Room.");
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

