package awray.m6a1.game.stories.story1.interactables;

import awray.m6a1.engine.InteractableObject;
import awray.m6a1.game.Game;
import awray.m6a1.game.inventory.InventoryObject;
import java.awt.Color;
import java.util.ArrayList;

public class Egg extends InteractableObject{

    
        public Egg(int x, int y) {
		super("egg1", x, y);

	}

        @Override
	public void interact(Game game, int step) {
                if (getName().equals("egg1")) {
                switch(step){
                    case 1:
                           game.setDiagFill(Color.RED);
                           game.setDialogue("Tink. Tink. Tink.");
                           break;
                    case 2:
                           game.setDiagFill(Color.WHITE);
                           game.setDialogue("You befriend the egg!");
                           break;
                    case 3: 
                            game.setDialogue("You place the egg in your pocket- I mean inventory. You'll call it Richard Grant Eggsly Jr.");
                            break;
                    case 4: 
                            setImage("egg2");
                            setActive(false);
                            game.getInventory().addToInventory(InventoryObject.EGG);
                           // game.getGuy().setX(20);
                           // game.getGuy().setY(150);
                            //game.getStory().nextScene();
                            Sassafrazzle Sassafrazzle = game.getStory().getInteractableOfType(Sassafrazzle.class);
                            Sassafrazzle.setActive(true);
                            Sassafrazzle.setImage("spoody");
                            resetStep(game);
                            break;

                    }
                } else {
                        
                        resetStep(game);
                        game.getGuy().setX(20);
			game.getGuy().setY(150);
			game.getStory().nextScene();
                        
		}
                
                
	//	if (getName().equals("egg1")) {
	//		game.setDialogue("Tink. Tink. Tink.");
	//		setImage("egg2");
	//	} else {
	//		resetStep(game);
	//	}
	}
}	
			



