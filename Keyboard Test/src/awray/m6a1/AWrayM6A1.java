/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awray.m6a1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.util.TimerTask;
import javax.swing.Timer;

/**
 *
 * @author Alex
 */
public class AWrayM6A1 extends JFrame implements KeyListener{

    /**
     * @param args the command line arguments
     */
    
    static int SCREEN_WIDTH = 800;
    static int SCREEN_HEIGHT = 600;
    static WidgetPanel widget;
    static GraphicPanel myPanel;
    public static Timer moveTimer;
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        AWrayM6A1 frame = new AWrayM6A1();
        JFrame myFrame = new JFrame("BESTEST GAME EVER");
        JFrame.setDefaultLookAndFeelDecorated(true);
        
        
        myPanel = new GraphicPanel();
        myPanel.setBounds(0, 0, 800, 340);
        myPanel.setVisible(true);
        myFrame.add(myPanel);
        
        widget = new WidgetPanel();
        widget.setBounds(0, 300, 800, 260);
        widget.setVisible(true);
        myFrame.add(widget);
        
        
        
        
        widget.moveButton.addMouseListener(new MouseAdapter(){
           
            Timer moveTimer = new Timer(40, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ev) {
                    new AWrayM6A1().myButtonPressed(); 
                    moveTimer.setInitialDelay(0); 
                }
            });
            
        public void mousePressed(MouseEvent e) {
            
            moveTimer.start();
            }

        public void mouseReleased(MouseEvent e) {
            moveTimer.stop();
            }
        });
        widget.moveButton2.addMouseListener(new MouseAdapter(){
           
            Timer moveTimer = new Timer(40, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ev) {
                    new AWrayM6A1().myButtonPressed2(); 
                    moveTimer.setInitialDelay(0); 
                }
            });
            
        public void mousePressed(MouseEvent e) {
            
            moveTimer.start();
            }

        public void mouseReleased(MouseEvent e) {
            moveTimer.stop();
            }       
        });
        
        widget.moveButton3.addMouseListener(new MouseAdapter(){
           
            Timer moveTimer = new Timer(40, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ev) {
                    new AWrayM6A1().myButtonPressed3(); 
                    moveTimer.setInitialDelay(0); 
                }
            });
            
        public void mousePressed(MouseEvent e) {
            
            moveTimer.start();
            }

        public void mouseReleased(MouseEvent e) {
            moveTimer.stop();
            }
        });
        
        widget.moveButton4.addMouseListener(new MouseAdapter(){
           
            Timer moveTimer = new Timer(40, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ev) {
                    new AWrayM6A1().myButtonPressed4(); 
                    moveTimer.setInitialDelay(0); 
                }
            });
            
        public void mousePressed(MouseEvent e) {
            
            moveTimer.start();
            }

        public void mouseReleased(MouseEvent e) {
            moveTimer.stop();
            }
        });
        widget.moveButton5.addActionListener((ActionEvent ev) -> {
            new AWrayM6A1().myButtonPressed5();
            
        });
        widget.interact.addActionListener((ActionEvent ev) -> {
            new AWrayM6A1().myButtonPressed6();
            
        });

        
        
        
        JPanel lastPanel = new JPanel();
        myFrame.add(lastPanel);

        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.pack();
        myFrame.setVisible(true);
        myFrame.setBounds(0,0, SCREEN_WIDTH, SCREEN_HEIGHT);
        
    }

    private void myButtonPressed() {
        myPanel.moveGraphic(-10, 0, 1);
        //widget.text1.add(this);
    }
    private void myButtonPressed2() {
        myPanel.moveGraphic(0, -10, 2);
    }
    private void myButtonPressed3() {
        myPanel.moveGraphic(10, 0, 3);
    }
    private void myButtonPressed4() {
        myPanel.moveGraphic(0, 10, 4);
    }
    private void myButtonPressed5() {
        myPanel.moveGraphic(0, 0, 5);
    }
    private void myButtonPressed6() {
        myPanel.interaction();
    }
    
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT ) {
            myButtonPressed();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT ) {
            //Left arrow key code
            Timer moveTimer = new Timer(40, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ev) {
                    new AWrayM6A1().myButtonPressed(); 
                    AWrayM6A1.moveTimer.setInitialDelay(0); 
                }

            
        public void keyPressed(KeyEvent e) {
            
            AWrayM6A1.moveTimer.start();
            }

        public void keyReleased(KeyEvent e) {
            AWrayM6A1.moveTimer.stop();
            }
        });
        } else if (e.getKeyCode() == KeyEvent.VK_UP ) {
            //Up arrow key code
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN ) {
            //Down arrow key code
        }

    }
    public AWrayM6A1(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }


    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
