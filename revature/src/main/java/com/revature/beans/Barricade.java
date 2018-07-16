package com.revature.beans;

import com.revature.dao.BarricadeDao;
import com.revature.dao.ItemDao;
import com.revature.dao.RoomDao;

public class Barricade {
	public void breakBarricade(String item_name) {
		if (ItemDao.checkIfHaveItem(item_name)){
			int roomID = RoomDao.getRoom_ID();
			BarricadeDao.breakBarricade(item_name, roomID);
		}
		
		
	}
}
