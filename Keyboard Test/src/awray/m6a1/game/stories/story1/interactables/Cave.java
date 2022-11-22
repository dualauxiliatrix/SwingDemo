package awray.m6a1.game.stories.story1.interactables;

import java.awt.Color;

import awray.m6a1.engine.InteractableObject;
import awray.m6a1.game.Game;
import awray.m6a1.game.inventory.InventoryObject;

public class Cave extends InteractableObject {

	public Cave(int x, int y) {
		super("Cave", x, y);
	}

	@Override
	public void interact(Game game, int step) {
		game.setDiagFill(Color.WHITE);
		if (game.getInventory().has(InventoryObject.KEY)) {
			switch (step) {
			case 1:
				game.setDialogue("Oh, well.. I guess if you have the key, it must be okay to go in.");
				break;
			case 2:
				game.setDialogue("Uhhh, sure. Yeah, I guess this is what we're doing.");
				break;
			case 3:
				resetStep(game);
				game.getGuy().setX(20);
				game.getGuy().setY(150);
				game.getStory().nextScene();
				break;
			default:
				break;
			}
		} else {
			switch (step) {
			case 1:
				game.setDialogue("What are you doing? You can't just go into someone else's house!");
				break;
			default:
				resetStep(game);
				break;
			}
		}
	}

}
