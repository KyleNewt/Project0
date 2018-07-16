package com.revature.beans;

import com.revature.dao.ItemDao;
import com.revature.dao.PlayerDao;

public class Player {
	static int roomID;
	private static int keys = 0;
	
	public int getKeys() {
		return keys;
	}
	
	public static void getKey(int room_id) {
		//use DAO to flag key in room_id to 1
		
		keys++;
	}
	
	public static void useKey() {
		if (keys < 1) {
			System.out.println("You have no keys. ");
		} else {
		//use DAO to flag [barricade] in room_id to [barricade - 100]
			keys--;
		}
	}	
}



