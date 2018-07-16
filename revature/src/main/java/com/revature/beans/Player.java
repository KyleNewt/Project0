package com.revature.beans;

import java.util.ArrayList;

import com.revature.dao.ItemDao;
import com.revature.dao.PlayerDao;

public class Player {
	static int roomID;
	static ArrayList<String> inventory = new ArrayList<>();

	public int getRoomID(){
		PlayerDao.getRoomID();
		
		return roomID;
	}
	
	public static void setRoomID(int newRoom) {
		roomID = newRoom;
		PlayerDao.setRoomID(newRoom);
	}
	
	public void getInventory() {
		ItemDao.getInventory();
		
		/* if (inventory.size() == 0) {
			System.out.println("You have no items");
		} else {
		System.out.println("You open your backpack.  Inside is: " + Arrays.toString(inventory.toArray()) + " ");
		}
		*/
	}
	/*
	public static void addItem(String item) {
		inventory.add(item);
	}
	
	public static void removeItem(String item) {
		inventory.remove(item);
	}
	*/
		
}



