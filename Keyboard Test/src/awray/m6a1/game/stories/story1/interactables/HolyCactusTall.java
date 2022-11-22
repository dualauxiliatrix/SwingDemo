package awray.m6a1.game.stories.story1.interactables;

import java.awt.Color;

import awray.m6a1.engine.InteractableObject;
import awray.m6a1.game.Game;
import awray.m6a1.game.inventory.InventoryObject;

public class HolyCactusTall extends InteractableObject {

	public HolyCactusTall(int x, int y) {
		super("SpikeTall", x, y);
	}

	@Override
	public void interact(Game game, int step) {
		game.setDiagFill(Color.BLACK);
		if(game.getInventory().has(InventoryObject.KEY)) {
			if(step == 1) {
				game.setDialogue("I don't have anything else... Sorry.");
			}else {
				resetStep(game);
			}
		}else {
			switch (step) {
			case 1:
				game.setDialogue("Hello Traveler! My name is Spike.");
				break;
			case 2:
				game.setDialogue("Someone gave me this a while ago, but I can't move, so I have no use for it. Here!");
				game.getInventory().addToInventory(InventoryObject.KEY);
				break;
			default:
				resetStep(game);
				break;
			}
		}
	}

}
