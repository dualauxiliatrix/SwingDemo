package awray.m6a1.game.stories;

import java.awt.Graphics;
import java.util.ArrayList;

import awray.m6a1.game.Game;
import awray.m6a1.game.Guy;

public class Story {
	private ArrayList<Scene> scenes;
	private int atScene = 0;
	
	public Story() {
		scenes = new ArrayList<>();
	}
	
	public Story addScene(Scene scene) {
		scenes.add(scene);
		return this;
	}
	
	public void interact(Game game, int x, int y) {
		getScene().interact(game, x, y);
	}
	
	public boolean canInteract(Game game) {
		boolean canInteract = getScene().canInteract(game.getGuy());
		if(!canInteract) {
			game.setDialogue("");
		}
		return canInteract;
	}
	
	public boolean canGoLeft(Guy guy) {
		if(getScene().canCrossLeft()) {
			if(guy.getX() <= -50) {
				previousScene();
				guy.resetXToRight();
				return false;
			}else {
				return true;
			}
		}else {
			return guy.getX() > 0;
		}
	}
	
	public boolean canGoUp(Guy guy) {
		return guy.getY() > 0;
	}
	
	public boolean canGoRight(Guy guy) {
		if(getScene().canCrossRight()) {
			if(guy.getX() >= 750) {
				nextScene();
				guy.resetXToLeft();
				return false;
			}else {
				return true;
			}
		}else {
			return guy.getX() < 700 ;
		}
	}
	
	public void nextScene() {
		atScene++;
	}
	
	public void previousScene() {
		atScene--;
	}
	
	public boolean canGoDown(Guy guy) {
		return guy.getY() < 200;
	}
	
	public <T> T getInteractableOfType(Class<T> type) {
		return getScene().getInteractableOfType(type);
	}
	
	private Scene getScene() {
		if(atScene >= 0 && atScene < scenes.size()) {
			return scenes.get(atScene);
		}
		throw new IllegalStateException("no scene to draw");
	}
	
	public void draw(Game game, Graphics gc) {
		getScene().draw(game, gc);
	}

}
