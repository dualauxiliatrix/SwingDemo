package awray.m6a1.game.stories.story1.interactables;

import java.awt.Color;

import awray.m6a1.engine.InteractableObject;
import awray.m6a1.game.Game;
import awray.m6a1.game.inventory.InventoryObject;
import java.util.ArrayList;

public class Ratking extends InteractableObject {

    private ArrayList<String> dialogues;
    
	public Ratking(int x, int y) {
		super("Ratking", x, y);
                dialogues = new ArrayList<>();
		dialogues.add("Greetings! It is I, the wonderous Rat King.");
		dialogues.add("No need to waste time worshipping me, I've got plenty of servants for that.");
		dialogues.add("Let's just get down to what ");
		dialogues.add(
				"Well I'm not paying it, damnit! I keep telling the landlord, I hear something scurrying around under the floor!");
		dialogues.add(
				"Why should I have to pay rent when I can't even get a good night of sleep, and the landlord refuses to do anything about it?");
		dialogues.add(
				"I'll tell you what, if you figure out what the hell is making that noise and get it to stop, I'll pay rent NEXT month. Good enough?");
                //game.getInventory().addToInventory(InventoryObject.COIN);
	}

	@Override
	public void interact(Game game, int step) {
		game.setDiagFill(Color.WHITE);
		if (step > 0 && step <= dialogues.size()) {
			game.setDialogue(dialogues.get(step - 1));
		} else {
			game.getInventory().addToInventory(InventoryObject.COIN);
			setActive(false);
			resetStep(game);
		}
	}

}
