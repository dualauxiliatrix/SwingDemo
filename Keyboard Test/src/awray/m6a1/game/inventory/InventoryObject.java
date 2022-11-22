package awray.m6a1.game.inventory;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import awray.m6a1.utils.ImageLoader;

//enum for things that can be stored in inventory
public enum InventoryObject {
	KEY("Key"),EGG("egg3"),COIN("coin");
	
	private BufferedImage img;
	private InventoryObject(String imgName) {
		img = ImageLoader.load(imgName);
	}
	
	public void draw(int index, Graphics g) {
		g.drawImage(img, (index + 1) * 50, 302, 30, 30, null);
	}
}



