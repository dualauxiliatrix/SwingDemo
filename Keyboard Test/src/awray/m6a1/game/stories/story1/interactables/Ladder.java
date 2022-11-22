package awray.m6a1.game.stories.story1.interactables;

import awray.m6a1.engine.InteractableObject;
import awray.m6a1.game.Game;

public class Ladder extends InteractableObject {

	public Ladder(int x, int y) {
		super("ladder",x, y);
	}

	@Override
	public void interact(Game game, int step) {
		game.getGuy().setX(320);
		game.getGuy().setY(60);
		game.getStory().previousScene();
	}

}
