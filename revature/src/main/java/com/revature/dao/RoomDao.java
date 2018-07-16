package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Room;
import com.revature.util.ConnectionUtil;


public class RoomDao {
	public static void getRoomData(int room_id, String roomName){
		PreparedStatement ps = null;
		Room r = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM Room WHERE room_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, room_id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int roomID = rs.getInt("room_id");
			    int north = rs.getInt("north");
			    int south = rs.getInt("south");
			    int east = rs.getInt("east");
			    int west = rs.getInt("west");
			    String longDescription = rs.getString("room_long_description");
			    String shortDescription = rs.getString("room_description");
			    
			    r = new Room(roomID, north, south, east, west, longDescription, shortDescription);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
	}
}
