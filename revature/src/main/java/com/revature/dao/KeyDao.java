package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.revature.beans.Room;
import com.revature.util.ConnectionUtil;

public class KeyDao {
	public static void getKey(int room_id) {
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "UPDATE Items SET obtained = 1 WHERE room_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, room_id);
			System.out.println(room_id);
			ps.executeQuery();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	
	public static void useKey(String direction, int room_id, int directionValue) {
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
			String sql = "UPDATE Player SET obtained = 2 WHERE room_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, roomID);
			ps.executeQuery();
			ps = null;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "UPDATE Room SET ? = ? WHERE room_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "north");
			ps.setInt(2, 3);
			ps.setInt(3, 1);
			ps.executeQuery();
			} catch (Exception ex) {
				ex.printStackTrace();
			}	
		}
}
