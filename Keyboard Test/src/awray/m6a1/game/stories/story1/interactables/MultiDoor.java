package awray.m6a1.game.stories.story1.interactables;

import java.awt.Color;

import awray.m6a1.engine.InteractableObject;
import awray.m6a1.game.Game;
import awray.m6a1.game.inventory.InventoryObject;
import java.util.ArrayList;

public class MultiDoor extends InteractableObject {

    private ArrayList<String> doorNumber;
    
	public MultiDoor(int x, int y, int number) {
		super("door"+number, x, y);
                doorNumber = new ArrayList<>();
                doorNumber.add(String.valueOf(number));
	}

	@Override
	public void interact(Game game, int step) {
            game.setDiagFill(Color.WHITE);
            if(step == 1){
                switch(doorNumber.get(0)){
                    case "1": game.getStory().nextScene();
                            break;
                    case "2":
                            if(game.getInventory().has(InventoryObject.COIN)){
                                game.getStory().nextScene();
                                game.getStory().nextScene();
                            } else {
                                game.setDialogue("You can't go here yet!");
                            }
                            break;
                    case "3": game.setDialogue("You can't go here yet!");
                           // game.getStory().nextScene();game.getStory().nextScene();game.getStory().nextScene();
                            break;
                    case "4": game.setDialogue("You can't go here yet!");
                           // game.getStory().nextScene();game.getStory().nextScene();game.getStory().nextScene();game.getStory().nextScene();
                            break;  
                    default: game.setDialogue("what's a number");
                            break;
                    }
                }    
	}

}
