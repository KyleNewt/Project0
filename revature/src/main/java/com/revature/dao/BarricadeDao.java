package com.revature.dao;

public class BarricadeDao {
	public String getBarricade(int barricade_name){
		String BarricadeDescription = null;
		//if 
		//SELECT [barricade_description] WHERE [barricade_name] = (barricade_name);
		
		return BarricadeDescription;
	}
	
	public static void breakBarricade(String item_name, int roomID) {
		int barricadeBreaker = 0;
		String direction = null;
		//SELECT [direction] from Barricades WHERE [item_name] = (item_name) AND [room_id] = (room_id)
		//set direction = returned data
		//SELECT (direction) from Room WHERE [room_id] = (room_id)
		//set barricadeBreaker = returned data
		//barricadeBreaker = barricadeBreaker - 100
		//UPDATE Room SET ( (direction) ) = ( (barricadeBreaker) ) WHERE [room_id] = (room_id);
		//SELECT barricade_gone_description FROM Barricades WHERE [room_id] = (roomID);
		
	}
}
