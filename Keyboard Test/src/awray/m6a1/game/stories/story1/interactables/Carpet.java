package awray.m6a1.game.stories.story1.interactables;

import java.awt.Color;

import awray.m6a1.engine.InteractableObject;
import awray.m6a1.game.Game;

public class Carpet extends InteractableObject {

	public Carpet(int x, int y) {
		super(x, y);
		setImage("carpet0");
		setActive(false);
	}

	@Override
	public void interact(Game game, int step) {
		game.setDiagFill(Color.WHITE);
		if (getName().equals("carpet0")) {
			game.setDialogue("What the hell are you doing with the carpet? This had better not affect my deposit!");
			setImage("carpet1");
		} else {
			resetStep(game);
			game.getGuy().setX(150);
			game.getGuy().setY(40);
			game.getStory().nextScene();
		}
	}
}
