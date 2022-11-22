package awray.m6a1.engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

import javax.swing.JFrame;

//class that will handle, store and pass all the input to the objects that require it
public class Input {
	public static final int MOVE_LEFT = KeyEvent.VK_LEFT;
	public static final int MOVE_UP = KeyEvent.VK_UP;
	public static final int MOVE_RIGHT = KeyEvent.VK_RIGHT;
	public static final int MOVE_DOWN = KeyEvent.VK_DOWN;
	public static final int CROUCH = KeyEvent.VK_C;
	public static final int INTERACT = KeyEvent.VK_E;

	private HashMap<Integer, Boolean> oldState;
	private HashMap<Integer, Boolean> keyState;

	public Input(JFrame frame) {
		oldState = new HashMap<>();
		keyState = new HashMap<>();

		frame.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				// ignore this for now
			}

			@Override
			public void keyReleased(KeyEvent e) {
				oldState.put(e.getKeyCode(), keyState.get(e.getKeyCode()));
				keyState.put(e.getKeyCode(), false);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				oldState.put(e.getKeyCode(), keyState.get(e.getKeyCode()));
				keyState.put(e.getKeyCode(), true);
			}
		});
	}

	public void tick() {
		keyState.forEach((key, val) -> oldState.put(key, val));
	}

	public boolean isPressed(int key) {
		Boolean res = keyState.get(key);
		return res != null && res.booleanValue();
	}

	public boolean wasPressed(int key) {
		Boolean res = oldState.get(key);
		return res != null && res.booleanValue();
	}

	public boolean isJustPressed(int key) {
		return isPressed(key) && !wasPressed(key);
	}
}
