/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awray.m6a1;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Alex
 */
public class WidgetPanel extends JPanel{
    
    JButton moveButton;
    JButton moveButton2;
    JButton moveButton3;
    JButton moveButton4;
    JButton moveButton5;
    JButton interact;
    JLabel  text1;
    JLabel  text2;
    JLabel  text3;
    JLabel  text4;

    
    
    WidgetPanel(){
    this.setOpaque(true);
    this.setBackground(new Color(100,0,75));
    this.setLayout(new BorderLayout());
    
    moveButton = new JButton();
    moveButton.setBounds(400, 100, 100, 50);
    moveButton.setText("LEFT");
    this.add(moveButton);
    
    moveButton2 = new JButton();
    moveButton2.setBounds(500, 50, 100, 50);
    moveButton2.setText("UP");
    this.add(moveButton2);
    
    moveButton3 = new JButton();
    moveButton3.setBounds(600, 100, 100, 50);
    moveButton3.setText("RIGHT");
    this.add(moveButton3);
    
    moveButton4 = new JButton();
    moveButton4.setBounds(500, 150, 100, 50);
    moveButton4.setText("DOWN");
    this.add(moveButton4);
    
    moveButton5 = new JButton();
    moveButton5.setBounds(500, 100, 100, 50);
    moveButton5.setText("CROUCH");
    this.add(moveButton5);
    
    //text1 = new JLabel("hello. i exist. is there anything more terrifying?");
    //text1.setBounds(100, 180, 50, 10);
    //text1.setForeground(new Color(0, 0, 127));
    
    interact = new JButton();
    interact.setBounds(200, 100, 100, 50);
    interact.setText("INTERACT");
    this.add(interact);
    
    JLabel fixBug = new JLabel();
    this.add(fixBug);
    
    }  
}
