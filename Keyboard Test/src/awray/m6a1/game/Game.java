/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awray.m6a1.game;

/**
 *
 * @author Alex
 */

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

import awray.m6a1.engine.Input;
import awray.m6a1.game.inventory.Inventory;
import awray.m6a1.game.stories.Story;
import awray.m6a1.game.stories.story1.Story1;

public class Game extends JPanel {
	private static final long serialVersionUID = 448989372058547282L;

	//preffered FPS
	private static final double FPS = 30.0;
	
	//is the game running ?
	boolean running = false;
	
	//the input controll object, will be passed to every [Controllable] object when updating
	private Input input;
	
	//the inventory object, will be used to add objects or check if an object is present
	private Inventory inventory;
	
	//the story, with all the backgrounds and shit
	private Story story;
	
	//our guy
	private Guy guy;
	
	//dialogue (empty for no dialogue)
	private String dialogue = " ";
	
	//dialogue color
	private Color diagFill = Color.BLACK;
	
	Game(Input input) {
		this.input = input;
		
		inventory = new Inventory();
		
		story = new Story1();
		
		guy = new Guy();
	}
	
	public Story getStory() {
		return story;
	}
	
	public Inventory getInventory() {
		return inventory;
	}

	public Guy getGuy() {
		return guy;
	}
	
	public void start() {
		running = true;
		new Thread(() -> {
			long then = System.currentTimeMillis();
			while(running) {
				long now = System.currentTimeMillis();
				if(now - then > 1000.0 / FPS) {
					update();
					repaint();
					then = now;
				}
			}
		}).start();
	}

	public void update() {
		guy.update(this, input);
		input.tick();
	}
	
	@Override
	public void paint(Graphics g) {		
		story.draw(this, g);
		inventory.draw(g);

		// dialogues
		if(!dialogue.isBlank()) {
			g.setColor(diagFill);
			g.drawString(dialogue, 75, 275);
		}

		guy.draw(this, g);
	}

	public void setDialogue(String dialogue) {
		this.dialogue = dialogue;
	}
	
	public void setDiagFill(Color diagFill) {
		this.diagFill = diagFill;
	}

}
