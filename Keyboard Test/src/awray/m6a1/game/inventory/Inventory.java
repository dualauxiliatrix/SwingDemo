package awray.m6a1.game.inventory;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import awray.m6a1.utils.ImageLoader;

public class Inventory {
	private static final int SIZE = 6;
	
	private BufferedImage background;

	private BufferedImage heart;
	
	private InventorySlot[] slots;

	public Inventory() {
		background = ImageLoader.load("Inventory");
		heart = ImageLoader.load("Heart");
		
		slots = new InventorySlot[SIZE];
		
		for(int i = 0; i < slots.length; i++) {
			slots[i] = new InventorySlot(i);
		}
	}
	
	//check if you have an object in your inventory
	public boolean has(InventoryObject object) {
		for(int i = 0; i < slots.length; i++) {
			if(!slots[i].isEmpty()) {
				if(slots[i].getContent().equals(object))
					return true;
			}else {
				return false;
			}
		}
		return false;
	}
	
	//add an object to the inventory, return false if the inventory is full
	public boolean addToInventory(InventoryObject object) {
		if(has(object)) {
			return true;
		}
		
		for(int i = 0; i < slots.length; i++) {
			if(slots[i].isEmpty()) {
				slots[i].setContent(object);
				return true;
			}
		}
		return false;
	}

	public void draw(Graphics gc) {
		//draw background
		gc.drawImage(background, 0, 300, 800, 40, null);
		
		//draw slots
		for(InventorySlot slot : slots) {
			slot.draw(gc);
		}
		
		//draw hearts
		for(int i = 0; i < 3; i++) {
			gc.drawImage(heart, 645 + (i * 40), 307, 25, 25, null);
		}
	}

}
