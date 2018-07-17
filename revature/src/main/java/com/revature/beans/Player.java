package com.revature.beans;

import com.revature.dao.KeyDao;
import com.revature.dao.PlayerDao;

public class Player {
	static int roomID;
	private static int keys = 0;
	
	public static int getRoomID() {
		return roomID;
	}
	public static int getKeys() {
		return keys;
	}
	
	public static void setRoomID(int room_id) {
		//use PlayerDAO to set Player[room_id] to (room_id)
		PlayerDao.setRoomID(room_id);
		roomID = room_id;
	}
	
	public static void getKey(int room_id) {
		//use DAO to flag key in room_id to 1
		if(keys > 0) {
			System.out.println("Except you're clearly loony.  You already got that key.");
		} else {
			KeyDao.getKey(room_id);
			keys++;
		}
	}	
	public static void getKey() {
		//use DAO to flag key in room_id to 1
		keys++;
	}	
	public static void useKey(String direction, int room_id, int directionValue) {
		//use DAO to flag key in room_id to 1
		//KeyDao.useKey(direction, room_id, directionValue);
		if(keys > 0) {
			System.out.println("keys = "+ keys);
			keys--;
		} 
	}	
}



