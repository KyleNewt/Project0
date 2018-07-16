package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.Bear;
import com.revature.game.Room;
import com.revature.util.ConnectionUtil;

public class RoomDao {

	public static int getRoom_ID() {
		//SELECT room_id IN Player;
		
		int room_id = 0;
		return room_id;
	}
	
	public static String getLongDescription(int room_id) {
		//SELECT [room_long_description] IN Room WHERE [room_id] = room_id
		String longDescription = null;
		
		return longDescription;
	}
	
	public static String getShortDescription(int room_id) {
		//SELECT [room_short_description] IN Room WHERE [room_id] = room_id
		String shortDescription = null;
		
		return shortDescription;
	}
	
	public static String getExits(int room_id) {
		//return exits
		String exits = null;
		
		return exits;
	}
	
	public static int moveRooms(int roomID, String direction) {
		int daoRoomID = roomID;
		String daoDirection = direction;
		int nextRoomID = 0;
		//go to Room[(direction)] where player[room_id] = room_id
		//set nextRoomID = that value
		
		return nextRoomID;
	}
}
