
	import java.awt.*;import java.awt.event.KeyEvent;
import java.io.*;
	import javax.swing.*;import javax.imageio.*;
	
	class IFrame extends JFrame
	{
		     
	  public IFrame() //constructor
	  {
	    super("Image Demo");setBounds(50,50,100,100);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    Container con=this.getContentPane();
	    GCanvas canvas=new GCanvas();
	    con.add(canvas);setVisible(true);
	  }
	  public static void main(String arg[]) {new IFrame();}
	}
	class GCanvas extends Canvas
	{
	  public void paint(Graphics g)
	  {
	    Image img=null;
	    Image img1=null;
	    try {img=ImageIO.read(new File("bin/player.gif"));
	    {img1=ImageIO.read(new File("bin/player.gif"));
	    }
	    }
	    catch(IOException e)
	      {System.out.println("ok");System.exit(0);}
	    g.drawImage(img,50,25,this);
	    g.drawImage(img1, 200, 100, this);
	  }
	  final int PLAYER_SPEED = 1;
	     int vx;
	     boolean left = false;
	     boolean right = false;
	  
	  protected void updateSpeed() {
		     
	   
	        vx=0;
	        //if the player moves left, the value of vx must subtract the value of
	        //player speed
	        if (left) vx = -PLAYER_SPEED;
//	      if the player moves right, the value of vx must be replaced by the 
	        //value of player speed
	        if (right) vx = PLAYER_SPEED;
	      }
//	    initialises the key released event
	      public void keyReleased(KeyEvent e) {
//	    	if an event happens do one of the following based on what the event is
	        switch (e.getKeyCode()) {
	        //if the non number pad left arrow is released: do not move left, 
	         case KeyEvent.VK_LEFT : left = false; break; 
//	       if the non number pad right arrow is released: do not move right,
	         case KeyEvent.VK_RIGHT : right = false;break;
//	       if the space bar is released: do not do the method'fire'
	     //    case KeyEvent.VK_SPACE : fire(); break;
//	       if the b button is released: do not do the method'fireCluster'
	     //    case KeyEvent.VK_B : fireCluster(); break;


	        }
//	      carry out the 'updateSpeed' method
	        updateSpeed();
	      }
//	    initialises the use of the key pressed events 
	      public void keyPressed(KeyEvent e) {
//	    	if the non number pad left arrow is pressed, get the code for the required action
	      	//if the non number pad right arrow is pressed, get the code for the required action
	       switch (e.getKeyCode()) {
//	     if the non number pad left arrow is pressed, move right
	          case KeyEvent.VK_LEFT : left = true; break;
	          //if the non number pad right arrow is pressed, move right
	          case KeyEvent.VK_RIGHT : right = true; break;
	          
	        } //carry out the 'updateSpeed' method
	        updateSpeed();
	      }
	  
	}

