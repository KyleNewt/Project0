package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.revature.util.ConnectionUtil;

public class PlayerDao {
	
	public static void setRoomID(int room_id) {
			int roomID = room_id;
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "UPDATE Player SET room_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, roomID);
			ps.executeQuery();
			} catch (Exception ex) {
				ex.printStackTrace();
			}		
		
	}
}
