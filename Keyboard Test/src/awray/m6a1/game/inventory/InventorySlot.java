package awray.m6a1.game.inventory;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import awray.m6a1.utils.ImageLoader;

//an inventory slot, in which you can store inventory objects
public class InventorySlot {
	//the object stored in this slot, can be null (for empty slots)
	private InventoryObject content;
	
	private int index;
	private BufferedImage slotImage;

	public InventorySlot(int index) {
		this.index = index;
		
		slotImage = ImageLoader.load("Illustration16");
	}

	public void setContent(InventoryObject content) {
		this.content = content;
	}
	
	public InventoryObject getContent() {
		return content;
	}
	
	public boolean isEmpty() {
		return content == null;
	}
	
	public void draw(Graphics gc) {
		//draw slot
		gc.drawImage(slotImage, (index + 1) * 50, 307, 25, 25, null);
		
		if(content != null) {
			content.draw(index, gc);
		}
	}

}
