package awray.m6a1.game.stories;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import awray.m6a1.engine.Drawable;
import awray.m6a1.engine.InteractableObject;
import awray.m6a1.game.Game;
import awray.m6a1.game.Guy;
import awray.m6a1.utils.ImageLoader;

public class Scene implements Drawable {
	private String name;
	private BufferedImage background;
	private ArrayList<Drawable> drawables;

	//determine if this scene can be crossed into the next scene
	private boolean canCrossRight = false;
	//determine if this scene can be crossed into the previous scene
	private boolean canCrossLeft = false;

	public Scene(String name) {
		this.name = name;
		background = ImageLoader.load(name);

		drawables = new ArrayList<>();
	}

	public Scene addDrawable(Drawable object) {
		drawables.add(object);
		return this;
	}

	public Scene setCanCrossLeft(boolean canCrossLeft) {
		this.canCrossLeft = canCrossLeft;
		return this;
	}

	public Scene setCanCrossRight(boolean canCrossRight) {
		this.canCrossRight = canCrossRight;
		return this;
	}

	public boolean canCrossLeft() {
		return canCrossLeft;
	}

	public boolean canCrossRight() {
		return canCrossRight;
	}

	public Scene setCanCrossBoth(boolean value) {
		this.canCrossLeft = value;
		this.canCrossRight = value;
		return this;
	}

	public boolean canInteract(Guy guy) {
		for (Drawable object : drawables) {
			if (object instanceof InteractableObject intObj) {
				if(intObj.canInteract(guy)) {
					return true;
				}else {
					intObj.setStep(0);
				}
			}
		}
		return false;
	}

	public void interact(Game game, int x, int y) {
		for (Drawable object : drawables) {
			if (object instanceof InteractableObject intObj && intObj.canInteract(game.getGuy())) {
				intObj.interact(game);
			}
		}
	}

	public <T> T getInteractableOfType(Class<T> type) {
		for (Drawable object : drawables) {
			if (type.isInstance(object)) {
				return type.cast(object);
			}
		}

		return null;
	}

	@Override
	public void draw(Game game, Graphics gc) {
		gc.drawImage(background, 0, 0, 800, 300, null);
		drawables.forEach(object -> object.draw(game, gc));
	}

	@Override
	public String getName() {
		return "Scene : " + name;
	}
}
