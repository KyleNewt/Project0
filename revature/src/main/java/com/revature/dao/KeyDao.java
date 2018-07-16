package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.revature.beans.Room;
import com.revature.util.ConnectionUtil;

public class KeyDao {
	public static void getKey(int room_id) {
		int roomID = room_id;
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "UPDATE Items SET obtained = 1 WHERE room_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, roomID);
			ps.executeQuery();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	
	public static void useKey(int room_id) {
		//SELECT [direction] from Barricades WHERE [item_name] = (item_name) AND [room_id] = (room_id)
		//set direction = returned data
		//SELECT (direction) from Room WHERE [room_id] = (room_id)
		//set barricadeBreaker = returned data
		//barricadeBreaker = barricadeBreaker - 100
		//UPDATE Room SET ( (direction) ) = ( (barricadeBreaker) ) WHERE [room_id] = (room_id);
		//SELECT barricade_gone_description FROM Barricades WHERE [room_id] = (roomID);
		int roomID = room_id;
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "UPDATE Items SET obtained = 2 WHERE room_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, roomID);
			ps.executeQuery();
			} catch (Exception ex) {
				ex.printStackTrace();
			}		
	}
}
