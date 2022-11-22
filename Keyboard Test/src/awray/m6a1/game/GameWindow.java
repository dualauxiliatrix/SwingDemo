/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awray.m6a1.game;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import awray.m6a1.engine.Input;

/**
 *
 * @author Alex
 */
public class GameWindow extends JFrame {
	private static final long serialVersionUID = -8065047026345624191L;

	static final int SCREEN_WIDTH = 815;
	static final int SCREEN_HEIGHT = 379;
	
	static Game gameInstance;

	public static void main(String[] args) {
		JFrame myFrame = new JFrame("BESTEST GAME EVER");
		myFrame.setLayout(new BoxLayout(myFrame, BoxLayout.Y_AXIS));
		JFrame.setDefaultLookAndFeelDecorated(true);

		Input input = new Input(myFrame);

		gameInstance = new Game(input);
		myFrame.setContentPane(gameInstance);
		
		gameInstance.start();
		
		
		myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		myFrame.pack();
		myFrame.setVisible(true);
		myFrame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		myFrame.setLocationRelativeTo(null);
	}

}
