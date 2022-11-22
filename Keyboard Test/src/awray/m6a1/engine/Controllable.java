package awray.m6a1.engine;

import awray.m6a1.game.Game;

//interface for all game objects that need to take input from keyboard
public interface Controllable {
	void update(Game game, Input input);
}
