package awray.m6a1.game.stories.story1.interactables;

import java.awt.Color;
import java.util.ArrayList;

import awray.m6a1.engine.InteractableObject;
import awray.m6a1.game.Game;

public class Scruffy extends InteractableObject {

	private ArrayList<String> dialogues;

	public Scruffy(int x, int y) {
		super("Scruffy", x, y);
		dialogues = new ArrayList<>();
		dialogues.add("...Okay. What the fuck are you doing here?");
		dialogues.add("Oh, you had a key? I guess that must be okay then. I don't really know how that works.");
		dialogues.add("I'm guessing the landlord must have given it to you since I haven't paid rent, right?");
		dialogues.add(
				"Well I'm not paying it, damnit! I keep telling the landlord, I hear something scurrying around under the floor!");
		dialogues.add(
				"Why should I have to pay rent when I can't even get a good night of sleep, and the landlord refuses to do anything about it?");
		dialogues.add(
				"I'll tell you what, if you figure out what the hell is making that noise and get it to stop, I'll pay rent NEXT month. Good enough?");
	}

	@Override
	public void interact(Game game, int step) {
		game.setDiagFill(Color.WHITE);
		if (step > 0 && step <= dialogues.size()) {
			game.setDialogue(dialogues.get(step - 1));
		} else {
			Carpet carpet = game.getStory().getInteractableOfType(Carpet.class);
			carpet.setActive(true);
			setActive(false);
			resetStep(game);
		}
	}

}
