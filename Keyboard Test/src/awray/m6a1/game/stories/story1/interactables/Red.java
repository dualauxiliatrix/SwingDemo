package awray.m6a1.game.stories.story1.interactables;

import java.awt.Color;

import awray.m6a1.engine.InteractableObject;
import awray.m6a1.game.Game;

public class Red extends InteractableObject {

	public Red(int x, int y) {
		super(x, y);
		setImage("Red");
		setActive(false);
	}

	@Override
	public void interact(Game game, int step) {
		game.setDiagFill(Color.WHITE);
		if(step == 1) {
				System.out.println("Red");
                                setActive(false);
                                
			}
	}
}
