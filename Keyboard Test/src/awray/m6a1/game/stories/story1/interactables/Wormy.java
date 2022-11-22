package awray.m6a1.game.stories.story1.interactables;

import java.awt.Color;

import awray.m6a1.engine.InteractableObject;
import awray.m6a1.game.Game;
import awray.m6a1.game.inventory.InventoryObject;

public class Wormy extends InteractableObject {

	public Wormy(int x, int y) {
		super("Worm", x, y);
	}

	@Override
	public void interact(Game game, int step) {
		game.setDiagFill(Color.WHITE);
			switch(step){
                            case 1:
				game.setDialogue("Well hi there!");
                                break;
                            case 2:    
                                Red red = game.getStory().getInteractableOfType(Red.class);
                                red.setActive(true);
                                Blue blue = game.getStory().getInteractableOfType(Blue.class);
                                blue.setActive(true);
                                Green green = game.getStory().getInteractableOfType(Green.class);
                                green.setActive(true);
                                setActive(false);
                                
			
			}
	}       
}
