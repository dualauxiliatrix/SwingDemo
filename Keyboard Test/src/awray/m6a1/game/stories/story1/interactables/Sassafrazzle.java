package awray.m6a1.game.stories.story1.interactables;

import java.awt.Color;

import awray.m6a1.engine.InteractableObject;
import awray.m6a1.game.Game;
import awray.m6a1.game.inventory.InventoryObject;

public class Sassafrazzle extends InteractableObject {

	public Sassafrazzle(int x, int y) {
		super(x, y);
		setImage("egg2");
		setActive(false);
	}

	@Override
	public void interact(Game game, int step) {
		game.setDiagFill(Color.BLACK);
		if(getName().equals("spoody")) {
                    
			switch (step) {
			case 1:
				game.setDialogue("I don't have anything else... Sorry.");
                                break;
                        case 2: 
                                game.getGuy().setX(20);
                                game.getGuy().setY(150);
                                game.getStory().nextScene();   
                                game.getStory().nextScene(); 
                                resetStep(game);
                                break;
                                
                        default:
				resetStep(game);
			}
		}else {
                        setActive(false);
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
