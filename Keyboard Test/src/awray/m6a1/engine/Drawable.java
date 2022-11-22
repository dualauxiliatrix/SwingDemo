package awray.m6a1.engine;

import java.awt.Graphics;

import awray.m6a1.game.Game;

//interface for all game objects that need to be drawn
public interface Drawable {
	void draw(Game game, Graphics gc);
	String getName();
}
