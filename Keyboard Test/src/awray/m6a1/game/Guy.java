package awray.m6a1.game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import awray.m6a1.engine.Controllable;
import awray.m6a1.engine.Drawable;
import awray.m6a1.engine.Input;
import awray.m6a1.utils.ImageLoader;

public class Guy implements Drawable, Controllable {
	private static final int NOT_MOVING = 0;
	private static final int MOVING_LEFT = 1;
	private static final int MOVING_UP = 2;
	private static final int MOVING_RIGHT = 3;
	private static final int MOVING_DOWN = 2;
	private static final int CROUCHING = 4;

	private ArrayList<BufferedImage> sprites;
	private ArrayList<BufferedImage> canInteractSprites;

	private int x = 0;
	private int y = 150;

	private int sprite = 0;
	private boolean canInteract = false;

	private boolean isCrouching = false;

	public Guy() {
		sprites = new ArrayList<>();
		canInteractSprites = new ArrayList<>();

		// load all sprites
		for (int i = 0; i < 5; i++) {
			sprites.add(ImageLoader.load("Guy" + i));
			canInteractSprites.add(ImageLoader.load("Guy" + (i + 5)));
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void resetXToLeft() {
		x = -50;
	}

	public void resetXToRight() {
		x = 750;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public void update(Game game, Input input) {
		sprite = NOT_MOVING;
		if (input.isPressed(Input.MOVE_UP) && game.getStory().canGoUp(this)) {
			sprite = MOVING_UP;
			isCrouching = false;
			y -= 10;
		} else if (input.isPressed(Input.MOVE_DOWN) && game.getStory().canGoDown(this)) {
			sprite = MOVING_DOWN;
			isCrouching = false;
			y += 10;
		} else if (input.isPressed(Input.MOVE_LEFT) && game.getStory().canGoLeft(this)) {
			sprite = MOVING_LEFT;
			isCrouching = false;
			x -= 10;
		} else if (input.isPressed(Input.MOVE_RIGHT) && game.getStory().canGoRight(this)) {
			sprite = MOVING_RIGHT;
			isCrouching = false;
			x += 10;
		}
		if (input.isJustPressed(Input.CROUCH)) {
			isCrouching = !isCrouching;
		}

		canInteract = game.getStory().canInteract(game);

		if (input.isJustPressed(Input.INTERACT)) {
			game.getStory().interact(game, x, y);
		}

		if (isCrouching) {
			sprite = CROUCHING;
		}
	}

	@Override
	public void draw(Game game, Graphics gc) {
		gc.drawImage((canInteract ? canInteractSprites : sprites).get(sprite), x, y, null);
	}

	@Override
	public String getName() {
		return "Guy";
	}

}
