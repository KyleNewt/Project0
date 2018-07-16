package com.revature.dao;


public class ItemDao {
	public void addItem(String item) {
		//check Items[item], if exists
		//set obtained 1
		
		//Player.addItem(item);
	}
	
	public void RemoveItem(String item) {
		//check Items[item], if exists
		//set obtained 2
		
		//Player.removeItem(item);
	}

	public static String getInventory() {
		String inventoryContents = null;
		//SELECT item_name from Items WHERE 
		//[obtained] = 1
	
		return inventoryContents;
	}
	
	public static boolean checkIfHaveItem(String item_name) {
		boolean haveItem = false;
		//SELECT * from Items WHERE [item_name] = (item_name) AND [obtained] = 1
		//if no rows are returned you don't have the item
		
		return haveItem;
	}
	
	
}
