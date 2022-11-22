package awray.m6a1.engine;

import awray.m6a1.game.Game;
import awray.m6a1.game.Guy;

//base class for interactable objects
public abstract class InteractableObject extends StaticObject {

	private boolean active = true;
	
	protected InteractableObject(String name, int x, int y) {
		super(name, x, y);
	}
	
	protected InteractableObject(int x, int y) {
		super(x, y);
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public boolean isActive() {
		return active;
	}

	public boolean canInteract(Guy guy) {
		int x1 = guy.getX() + 50;
		int x2 = getX() + getWidth() / 2;
		int y1 = guy.getY() + 50;
		int y2 = getY() + getHeight() / 2;
		return active && Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1)) < 70;
	}
	
	private int step = 0;
	
	public void interact(Game game) {
		step++;
		interact(game, step);
	}
	
	public void resetStep(Game game) {
		setStep(0);
		game.setDialogue("");
	}
	
	public void setStep(int step) {
		this.step = step;
	}
	
	public abstract void interact(Game game, int step);
}
