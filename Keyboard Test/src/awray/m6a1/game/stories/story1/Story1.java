package awray.m6a1.game.stories.story1;

import awray.m6a1.engine.StaticObject;
import awray.m6a1.game.stories.Story;
import awray.m6a1.game.stories.story1.interactables.Carpet;
import awray.m6a1.game.stories.story1.interactables.Door;
import awray.m6a1.game.stories.story1.interactables.HolyCactus;
import awray.m6a1.game.stories.story1.interactables.Ladder;
import awray.m6a1.game.stories.story1.interactables.Scruffy;
import awray.m6a1.game.stories.story1.interactables.Egg;
import awray.m6a1.game.stories.Scene;
import awray.m6a1.game.stories.story1.interactables.Blue;
import awray.m6a1.game.stories.story1.interactables.Cave;
import awray.m6a1.game.stories.story1.interactables.Green;
import awray.m6a1.game.stories.story1.interactables.HolyCactusTall;
import awray.m6a1.game.stories.story1.interactables.MultiDoor;
import awray.m6a1.game.stories.story1.interactables.Ratking;
import awray.m6a1.game.stories.story1.interactables.Red;
import awray.m6a1.game.stories.story1.interactables.Sassafrazzle;
import awray.m6a1.game.stories.story1.interactables.Wormy;

public class Story1 extends Story {
	
	public Story1() {
		addScene(new Scene("Grass")
				.setCanCrossRight(true));
		addScene(new Scene("Grass2")
				.setCanCrossBoth(true)
				.addDrawable(new StaticObject("flower", 425, 5)));
		addScene(new Scene("Grass3")
				.setCanCrossBoth(true)
				.addDrawable(new HolyCactus(405, 15)));
		addScene(new Scene("house")
				.setCanCrossLeft(true)
				.addDrawable(new Door(679, 86)));
		addScene(new Scene("room")
				.addDrawable(new Scruffy(50, 50))
				.addDrawable(new Carpet(224, 43)));
		addScene(new Scene("Grass42").setCanCrossRight(true).addDrawable(new Ladder(155, 0)));
		addScene(new Scene("Grass43").setCanCrossBoth(true));
		addScene(new Scene("Grass44").setCanCrossLeft(true).addDrawable(new Egg(450, 120)).addDrawable(new Sassafrazzle(200,100)));
                addScene(new Scene("Grass52")
				.setCanCrossRight(true));
                addScene(new Scene("Grass53")
				.setCanCrossBoth(true).addDrawable(new HolyCactusTall(405,87)));
                addScene(new Scene("Grass55")
				.setCanCrossLeft(true).addDrawable(new Cave(600,50)));
                addScene(new Scene("Grass56")
				.setCanCrossLeft(true).addDrawable(new Wormy(500,20)).addDrawable(new StaticObject("Desk", 100, 5)).addDrawable(new Red(435, 250)).addDrawable(new Blue(485, 250)).addDrawable(new Green(535, 250)).addDrawable(new Door(700,50)));
                addScene(new Scene("Grass57").setCanCrossLeft(true).addDrawable(new MultiDoor(175,100,1)).addDrawable(new MultiDoor(325,100,2)).addDrawable(new MultiDoor(475,100,3)).addDrawable(new MultiDoor(625,100,4)));
                addScene(new Scene("Grass57test")
                .setCanCrossLeft(true).addDrawable(new Ratking (600,50)).addDrawable(new StaticObject("Light",105,150)).addDrawable(new StaticObject("Light",245,130)).addDrawable(new StaticObject("Light",400,120)).addDrawable(new StaticObject("Light",545,130)));
                addScene(new Scene("Grass58").setCanCrossLeft(true));
	}
}
 