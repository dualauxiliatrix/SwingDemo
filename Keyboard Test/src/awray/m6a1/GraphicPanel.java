/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awray.m6a1;

/**
 *
 * @author Alex
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GraphicPanel extends JPanel{
    
    private int _X = 100;
    private int _Y = 100;
    private int guyTest = 0;
    private int pressed;    
    //background
    private int i = 1;
    private int a = 0;
    //inventory slots
    private int slot1 = 0;
    //objectspawning
    private int hasKey;
    //allows under the rug interaction
    private int scruffyQuest = 0;
    private int carpet = 0;
    
    BufferedImage image = null;
    File f = null;
    BufferedImage grassImage = null;
    File gr = null;
    BufferedImage bushImage = null;
    File bu = null;
    File f2 = null;
    BufferedImage snakeImage = null;
    File sn = null;
    BufferedImage inventoryImage = null;
    File inv = null;
    BufferedImage scruffyImage = null;
    File scr = null;
    private String guy;
    private String dialogue = " ";
    private int interact = 0;
    
    BufferedImage slotImage = null;
    File slot = null;
    BufferedImage heartImage = null;
    File heart = null;    

    //items
    BufferedImage keyImage = null;
    File key = null;   
    
    
    
    
    GraphicPanel(){
  
    }
    

    public void paint(Graphics g){
        super.paint(g);
        super.paintComponent(g);
        
        
        //Character image options
        if(guyTest == 0){
        guy = "src/Graphics/Guy.png";
        }
        if(guyTest == 1){
        guy = "src/Graphics/Guy1.png";
        }
        if(guyTest == 2){
        guy = "src/Graphics/Guy2.png";
        }
        if(guyTest == 3){
        guy = "src/Graphics/Guy3.png";
        }
        //if(guyTest == 4){
        //guy = "src/Graphics/Guy4.png";
        //}
        if(guyTest == 5){
        guy = "src/Graphics/Guy5.png";
        }
        if(guyTest == 6){
        guy = "src/Graphics/Guy6.png";
        }
        if(guyTest == 7){
        guy = "src/Graphics/Guy7.png";
        }
        if(guyTest == 8){
        guy = "src/Graphics/Guy8.png";
        }
        if(guyTest == 9){
        guy = "src/Graphics/Guy9.png";
        }
        if(guyTest == 10){
        guy = "src/Graphics/Guy10.png";
        }
        
        //Draw background
        if(i==1){
        try{
           gr = new File("src/Graphics/Grass.png");
           grassImage = ImageIO.read(gr);
        }catch(IOException e){
            System.out.println("Error: "+e);
            }
        try{
            bu = new File("src/Graphics/Bush.png");
            bushImage = ImageIO.read(bu);
        }catch(IOException e){
            System.out.println("Error: "+e);
            }
        }
        
        if (i == 2){
            try{
           gr = new File("src/Graphics/Grass2.png");
           grassImage = ImageIO.read(gr);
        }catch(IOException e){
            System.out.println("Error: "+e);
            }  
        }
        if (i == 3){
            try{
           gr = new File("src/Graphics/Grass3.png");
           grassImage = ImageIO.read(gr);
        }catch(IOException e){
            System.out.println("Error: "+e);
            }
        } 
        
        if (i == 4){
            try{
           gr = new File("src/Graphics/Grass4.png");
           grassImage = ImageIO.read(gr);
        }catch(IOException e){
            System.out.println("Error: "+e);
            }
        } 
        
        if (i == 40){
            if(carpet == 0){
            try{
           gr = new File("src/Graphics/Grass40.png");
           grassImage = ImageIO.read(gr);
           scr = new File("src/Graphics/Scruffy.png");
           scruffyImage = ImageIO.read(scr);
           
        }catch(IOException e){
            System.out.println("Error: "+e);
            }   
        }
            if (carpet == 1){
            try{
           gr = new File("src/Graphics/Grass41.png");
           grassImage = ImageIO.read(gr);
           scr = new File("src/Graphics/Scruffy.png");
           scruffyImage = ImageIO.read(scr);
           
        }catch(IOException e){
            System.out.println("Error: "+e);
            }   
        }
        }
        if (i == 41) {
            try {
                gr = new File("src/Graphics/Grass42.png");
                grassImage = ImageIO.read(gr);
            } catch (IOException e) {
                System.out.println("Error: " + e);
            }
        }
        if (i == 42) {
            try {
                gr = new File("src/Graphics/Grass43.png");
                grassImage = ImageIO.read(gr);
            } catch (IOException e) {
                System.out.println("Error: " + e);
            }
        }
        if (i == 43) {
            try {
                gr = new File("src/Graphics/Grass44.png");
                grassImage = ImageIO.read(gr);
            } catch (IOException e) {
                System.out.println("Error: " + e);
            }
        }

        g.drawImage(grassImage, 0, 0, 800, 300, this);
        //draw in scruff when applicable
        if(i == 40){
        g.drawImage(scruffyImage, 50, 50, 100, 100, this);
        }
        //Draw character
        try{
           f = new File(guy);
           image = ImageIO.read(f);
        }catch(IOException e){
            System.out.println("Error: "+e);
            }
        g.drawImage(image, _X, _Y, 100, 100, this);
        
        //Draw inventory background
        try{
           inv = new File("src/Graphics/Inventory.png");
           inventoryImage = ImageIO.read(inv);
        }catch(IOException e){
            System.out.println("Error: "+e);
            }
        g.drawImage(inventoryImage, 0, 300, 800, 40, this);
        
        
        //Spike Dialogue and Conditions
        if(i == 3 && interact == 0){
            dialogue = "Hello Traveler! My name is Spike.";
            }
        if(i == 3 && interact == 1){
        g.drawString(dialogue,75,275);
        repaint();
        }
        if(i == 3 && interact == 2){
        dialogue = "Someone gave me this a while ago, but I can't move, so I have no use for it. Here!";
        g.drawString(dialogue,75,275);
        int hasKey = 1;
        repaint();
        }
        
        //grass4 keyless dialogue
        if(i == 4 && hasKey == 0 && interact == 1){
        dialogue = "What are you doing? You can't just go into someone else's house!";
        g.drawString(dialogue,75,275);   
        repaint();
        }
        //grass4 key dialogue
        if(i == 4 && hasKey == 1 && interact == 1){
        dialogue = "Oh, well.. I guess if you have the key, it must be okay to go in.";
        g.drawString(dialogue,75,275);   
        repaint();
        }
        if(i == 4 && hasKey == 1 && interact == 2){
        dialogue = "Uhhh, sure. Yeah, I guess this is what we're doing.";
        g.drawString(dialogue,75,275);   
        repaint();
        }
        if(i == 4 && hasKey == 1 && interact == 3){
        i = 40;
        _X = 340;
        _Y = 0;
        guyTest = 0;
        interact = 0;
        repaint();
        }
        //inside the house dialogue (grass 40)
        if(i == 40){
            if(scruffyQuest == 0){
            if(interact == 1){
                dialogue = "...Okay. What the fuck are you doing here?";   
                g.setColor(Color.white);
                g.drawString(dialogue,75,275);
                repaint();
                }
            if(interact == 2){
                dialogue = "Oh, you had a key? I guess that must be okay then. I don't really know how that works.";  
                g.setColor(Color.white);
                g.drawString(dialogue,75,275); 
                repaint();
                }
            if(interact == 3){
                dialogue = "I'm guessing the landlord must have given it to you since I haven't paid rent, right?";
                g.setColor(Color.white);
                g.drawString(dialogue,75,275); 
                repaint();
                }
            if(interact == 4){
                dialogue = "Well I'm not paying it, damnit! I keep telling the landlord, I hear something scurrying around under the floor!";  
                g.setColor(Color.white);
                g.drawString(dialogue,75,275); 
                repaint();
                }
            if(interact == 5){
                dialogue = "Why should I have to pay rent when I can't even get a good night of sleep, and the landlord refuses to do anything about it?";  
                g.setColor(Color.white);
                g.drawString(dialogue,75,275); 
                repaint();
                }
            if(interact == 6){
                dialogue = "I'll tell you what, if you figure out what the hell is making that noise and get it to stop, I'll pay rent NEXT month. Good enough?";   
                g.setColor(Color.white);
                g.drawString(dialogue,75,275); 
                repaint();
                }
            if(interact == 7){
                scruffyQuest = 1;
                interact = 0;
                guyTest = 0;
                repaint();
                }
            }
            if(scruffyQuest == 1){
                if(interact == 1){   
                dialogue = "What the hell are you doing with the carpet? This had better not affect my deposit!";
                g.setColor(Color.white);
                g.drawString(dialogue,75,275);
                carpet = 1;
                repaint();
                }
                if(interact == 2){   
                i++;
                _X = 75;
                _Y = 50;
                guyTest = 0;
                interact = 0;
                repaint();
                }
            }
        }
        //we're going to load in inventory slots now 
        try{
           slot = new File("src/Graphics/Illustration16.png");
           slotImage = ImageIO.read(slot);
        }catch(IOException e){
            System.out.println("Error: "+e);
            }
        g.drawImage(slotImage, 50, 307, 25, 25, this);
        g.drawImage(slotImage, 100, 307, 25, 25, this);
        g.drawImage(slotImage, 150, 307, 25, 25, this);
        g.drawImage(slotImage, 200, 307, 25, 25, this);
        g.drawImage(slotImage, 250, 307, 25, 25, this);
        g.drawImage(slotImage, 300, 307, 25, 25, this);
        
        //Hearts
        
        try{
           heart = new File("src/Graphics/Heart.png");
           heartImage = ImageIO.read(heart);
        }catch(IOException e){
            System.out.println("Error: "+e);
            }        
        
        g.drawImage(heartImage, 725, 307, 25, 25, this);
        g.drawImage(heartImage, 685, 307, 25, 25, this);
        g.drawImage(heartImage, 645, 307, 25, 25, this);

        //Key setup
        try{
           key = new File("src/Graphics/Key.png");
           keyImage = ImageIO.read(key);
        }catch(IOException e){
            System.out.println("Error: "+e);
            }
    if(i == 3 && interact == 2){    
    
    hasKey = 1;
    slot1 = 1;
        }
    if(hasKey > 0 && slot1 == 1){
    g.drawImage(keyImage, 50, 302, 30, 30, this);
    repaint();
    }
        
        
       
    } 
    
    
    public void moveGraphic(int incx, int incy, int guyTester){ 

        guyTest = guyTester;
        if(pressed == 1){
         guyTest = 0;  
         pressed = 0;
        }
        if(i == 3 && _X >= 350 && _X <= 390 && _Y >= 50 && _Y <= 80){
         //grass3 interact test
         if(guyTest == 0){
            guyTest = 6;
         }
         if(guyTest == 1){
            guyTest = 8;
         }
         if(guyTest == 2){
            guyTest = 9;
         }
         if(guyTest == 3){
            guyTest = 7;
         }
         if(guyTest == 5){
            guyTest = 10;
         }
        }
         //grass4 interact test
         if(i == 4 && _X >= 550 && _X <= 890){
//             /&& _Y >= 110 && _Y <= 175+

         if(guyTest == 0){
            guyTest = 6;
         }
         if(guyTest == 1){
            guyTest = 8;
         }
         if(guyTest == 2){
            guyTest = 9;
         }
         if(guyTest == 3){
            guyTest = 7;
         }
         if(guyTest == 5){
            guyTest = 10;
         }
        } 
         //grass40 interact tests 
         if(i == 40 && scruffyQuest == 0){
         if( _X >= 0 && _X <= 200){
         if(guyTest == 0){
            guyTest = 6;
         }
         if(guyTest == 1){
            guyTest = 8;
         }
         if(guyTest == 2){
            guyTest = 9;
         }
         if(guyTest == 3){
            guyTest = 7;
         }
         if(guyTest == 5){
            guyTest = 10;
         }
        }
       } 
         if(i == 40 && scruffyQuest == 1){
         if( _X >= 225 && _X <= 325){
         if(guyTest == 0){
            guyTest = 6;
         }
         if(guyTest == 1){
            guyTest = 8;
         }
         if(guyTest == 2){
            guyTest = 9;
         }
         if(guyTest == 3){
            guyTest = 7;
         }
         if(guyTest == 5){
            guyTest = 10;
         }
        }
       }
         
        
        this.repaint();
        
        _X = _X + incx;
        
        if(_X == 0 && i > 1){
        i = i-1;
            _X = 700;
        }
        if(_X == 0 && i <= 1){
            _X = _X - incx;
        }
        //tests whether we can continue moving right to another area or not 
        if(_X == 800 && i < 4){
        i++;
            _X = 0;
        }
        //tests if we can move right for house/basement levels
        if(i > 40){
        if(_X >= 800){
        i++;
            _X = 0;
            }
        }
        
        if(_X == 800 && i == 4){
            _X = _X - incx;
        }
        _Y = _Y + incy;
        if(_Y < 0){
            _Y = _Y - incy;
        }
        if(_Y == 200){
            _Y = _Y - incy;
        }
        
        //basement test 
        
        //put it above this line lmfao^^^
        if(guyTest == 5){
            pressed = 1;
        }
        if(i != 3){
            interact = 0;
        }
        //grass4 movement block
        if(i == 4 && _Y <= 90 && _X >= 550){
            _X = _X - incx;
            _Y = _Y - incy;
        }
        
            
        this.repaint();
        //System.out.println(_X + " " + _Y);
       } 
    
    public void interaction(){
     if (guyTest >= 6){
      interact++;  
      repaint();
     }
     //i think? these start the dialogue loop over for each panel after ending the convo
     if (interact > 2 && i == 3){
         interact = 0;
         repaint();
        }
     if (interact > 7 && i == 40){
         interact = 0;
         repaint();
        }
    }
    
  //  public int movementBlock(int _X, int _Y, int xStart, int xEnd, int yStart, int yEnd){
  //      if(_X >= xStart && _Y >= yStart && _Y <= yEnd){
            
  //      }
  //  return _X && _Y;    
  //  }
}
