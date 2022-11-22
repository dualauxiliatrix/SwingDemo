package awray.m6a1.engine;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import awray.m6a1.game.Game;
import awray.m6a1.utils.ImageLoader;

//base class for static objects
public class StaticObject implements Drawable {
	private BufferedImage img;
	private String name;
	private int x;
	private int y;
	private int width;
	private int height;

	public StaticObject(String name, int x, int y) {
		this(x, y);
		setImage(name);
	}
	
	public StaticObject(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setImage(String name) {
		img = ImageLoader.load(name);
		this.name = name;
		this.width = img.getWidth();
		this.height = img.getHeight();
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public void draw(Game game, Graphics gc) {
		gc.drawImage(img, x, y, null);
	}

}
