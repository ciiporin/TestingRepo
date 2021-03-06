package SpaceInvaders;



 /**Canvas is an awt class = A Canvas component represents a blank rectangular */
    import java.awt.Canvas;
    import java.awt.Color;
    import java.awt.Dimension;
    import java.awt.Font;
    import java.awt.Graphics2D;
    import java.awt.Rectangle;
/**keylistener = The listener interface for receiving keyboard events (keystrokes). 
 * The class that is interested in processing a keyboard event either implements 
 * this interface (and all the methods it contains) or extends the abstract KeyAdapter 
 * class (overriding only the methods of interest). 
The listener object created from that class is then registered with a component 
using the component's addKeyListener method. A keyboard event is generated when a 
key is pressed, released, or typed (pressed and released). The relevant method in 
the listener object is then invoked, and the KeyEvent is passed to it. 
*/
    import java.awt.event.KeyEvent;
    import java.awt.event.KeyListener;
    import java.awt.event.WindowAdapter;
    import java.awt.event.WindowEvent;
    import java.awt.image.BufferStrategy;
    import java.awt.image.BufferedImage;
    import java.util.ArrayList;
    
    import javax.swing.JFrame;
    import javax.swing.JPanel;
    

    public class SpaceInvaders extends Canvas implements Stage, KeyListener {
      
    	/**
         * The BufferStrategy class represents the mechanism with which to organize 
         complex memory on a particular Canvas or Window. it is creating a  it's own 
         buffer strategy called 'strategy'
         */
private static final long serialVersionUID = 1L;
	  private BufferStrategy strategy;
	 //creates a variable called 'usedTime' for use as part of a stop watch 
      private long usedTime;
      /**initialises the use of the Spritecache class and creates a new variable(object) 
      spritecache   */ 
      private SpriteCache spriteCache;
      private BufferedImage background;
      /**initialises the use of an ArrayList. in between the <> is the element,the name of 
      the array list, actors relates to, this array list seems to be built wrong, it 
      initialises the use of the actor class but does not specify any elements or the 
      amount of elements
      **after further reading it seems that this form of array is re-sizable and can 
      *be added to at any time which is why it does not have the [] brackets indicating 
      *its size
         */ 
      private ArrayList<Actor> actors; 
      /**creates an instance of player*/
      private Player player;
      /**is the main method of the class SpaceInvader*/
      public SpaceInvaders() {
    	  /**creates a spriteCache for use in the SpaceInvader taking the attributes of the
    	   * SpriteCache class*/
        spriteCache = new SpriteCache();
        
        /**initialises the use of the various elements needed for the interface and the 
        sizes of each element*/
         //JFrame holds the panel. this line creates an instance of a JFrame 
         //and gives it a name 'windows'
        JFrame windows = new JFrame("Space Invaders");
//      JPanel holds the layout manager and size etc of the panel. this JPanel is
   	 //controlled by the JFrame 'windows' and uses the class 'getContentPane'which
   	// returns a JPanel container
        JPanel panel = (JPanel)windows.getContentPane();
//      sets the width and height and the position of the JPanel on the x and y axis 
        setBounds(0,0,650,700);
        //Uses the setPreferredSize method to provide
        // a size hint to the parent of this component:the Jpanel, if not the 
  	  //the JPanel will use a default size of (10,10)
        panel.setPreferredSize(new Dimension(650,700));
//      normally here you would determine what layout manager is required
  	  //but this is not required for a single panel layout
        panel.setLayout(null);
//      'this' represents an instance of the object SpaceInvaders and adds the panel for
  	  //use
        panel.add(this);
//      sets the width and height and the position of the JFrame: 'windows' on the x and y axis 
        windows.setBounds(0,0,650,700);
//      makes the JFrame 'windows' visible
        windows.setVisible(true);
 /**the window listener brings the window onto the screen*/
        windows.addWindowListener( new WindowAdapter() {
        	 /** adds a closing function to the window*/
          public void windowClosing(WindowEvent e) {
        	  /**the window listener brings the window onto the screen*/
            System.exit(0);
          }
        });
        /**this makes the window resizable or in this case, not resizable*/
        windows.setResizable(false);
        /**stops the monsters from going off screen, being stuck and flickering*/
        createBufferStrategy(2);
//      this calls on the bufferStrategy created above, called 'strategy'
        strategy = getBufferStrategy();
//      this requests that this class has the main focus and should be listened
        //to 1st
        requestFocus();
//      this adds a key listener to 'SpaceInvaders' class which tells the program to
        //respond whenever certain keys are hit by the user
        addKeyListener(this);
      }
      // method which will initialise all classes at the start of the game
      public void initWorld() {
//    	initialises the use of the arraylist named 'actors' that was created above, each
    	  //element will be named 'Actor...'
       actors = new ArrayList<Actor>();
//      this for loop tells the monsters created below to keep moving
        for (int i = 0; i < 20; i++){
//        	initialises the class 'Monster' by saying bring 'Monster'into the 'SpaceInvaders'
  		  //class and tells 'SpaceInvaders' to refer to monsters as 'm'
          Monster m = new Monster(this);
//        positions each monster on the 'x' axis and says don't go beyond the width
		  //of the stage, which is set as an integer, it is also telling the program
		  //to paint each monster in a random position on the x axis when the game
		  //starts
          m.setX( (int)(Math.random()*Stage.WIDTH) );
//        positions each monster on the 'y' axis and creates an infinite loop for monster 
		  //movement as it is always multiplying the value of i by 20, therefore
		  //i will never be less than 10
          m.setY( i*20 );
          //sets the velocity at which the monsters should move along axis x, in this case
		  //a random integer between 10 and 20
          m.setVx( (int)(Math.random()*20-10) );
//        adds the monsters to the 'actors' array list
          actors.add(m);
        }
        //initialises the use of the 'Player' class inside the 'SpaceInvaders' class
        player = new Player(this);
        //sets the position of the 'Player' on the x axis and says don't go beyond
        //the 'stage' width
        player.setX(Stage.WIDTH/2);
        //sets the position of the player on the 'y' axis and says don't go beyond
        //the 'Stages' height
        player.setY(500);
      }
      
//    method which initialises the use of the Actor class and names it 'a' for 
      //later use in the arraylist
      public void addActor(Actor a) {
    	       //adds the newly named 'Actor' element 'a' to the array list
    	  actors.add(a);
        } 
      //this repaints the world 
      public void updateWorld() {
    	  //this initialises the variable 'i' and sets its value to '0'     
    	  int i = 0;
    	  //this initialises the the use of a while loop and says: to loop while the 
    	  //variable 'i' is less than the size of the array list 'actors'
    	         while (i < actors.size()) {
    	        	 //each time the arraylist element 'Actor m' loops it should compare 
    	        	 //itself to the value/size of 'i'
    	           Actor m = (Actor)actors.get(i);
    	           // array element 'm' is marked for removal
    	            if (m.isMarkedForRemoval()) {
    	            	//remove the use of the variable 'i' from the loop if 'm' is removed
    	              actors.remove(i);
    	           } else {
    	              //otherwise 'm' should carry on looping and the buffer should carry
    	        	   //on re-painting and timing the re-paints with the incrementing 
    	        	   //of 'i' 
    	        	   m.act();
    	              i++;
    	            }
    	          }
    	         //the player should carry on being re-painted and buffered
    	          player.act();
       }
//initialises the method for checking for collisions
      public void checkCollisions() {
    	  //the area in which the player can move is a rectangle and the player cannot 
    	  //cannot move outside of the boundary of the rectangle 
    	 
    	         Rectangle playerBounds = player.getBounds();
    	  //while the  value of 'i' is equal to 0 and less than the size of the actor
    	         //array list, it will increment the size of 'i' by 1, each cycle
    	        for (int i = 0; i < actors.size(); i++) {
    	      //Actor 1 or array element 1 get the value of 'i'
    	        	//a1 = the player
    	           Actor a1 = (Actor)actors.get(i);
    	           //the player is inside rectangle 1. the rectangle is renamed as r1 
    	           //and on each cycle should get the boundary value and position of 
    	           //array element a1
    	           Rectangle r1 = a1.getBounds();
    	           
    	           //if the rectangle and the player intersect or meet, this should be 
    	           //registered as a collision 
    	          if (r1.intersects(playerBounds)) {
    	            //if the player collides register a1 as having collided
    	        	  player.collision(a1);
    	        	  //this line of code is useless
    	             a1.collision(player);
    	           }
    	          //loop until the variable 'j' is less than size of the 'actors' array 
    	          //list
    	        for (int j = i+1; j < actors.size(); j++) {
    	            //array element a2 'Actor' class and should get the value of 'j' 
    	        	//a2 = the bullet
    	        	Actor a2 = (Actor)actors.get(j);
    	        	//another rectangle is created to hold a2. the rectangle is renamed 
    	        	//as r2 and on each cycle should get the boundary value and position of 
     	           //array element a2
    	             Rectangle r2 = a2.getBounds();
    	         
    	             if (r1.intersects(r2)) {
    	               //constantly checks to see if the bullet an d player have collided
    	            	 //but gives no result if they do, because they never will collide
    	            	 a1.collision(a2);
    	               a2.collision(a1);
    	             }
    	           }
    	         }
    	      }
//this method paints the world
      public void paintWorld() {
    	  //uses the Graphics2D class to paint the world  and uses the getDrawGraphics
    	  //in conjunction with the buffer strategy
    	  //g = the world
        Graphics2D g = (Graphics2D)strategy.getDrawGraphics();
        //Change background image here
        //Puts the pic in memory
        background = spriteCache.getSprite("saturn-dragon-storm.jpg");
        //draws the picture on the screen
        g.drawImage(background, null, 0, 0);
       //sets the colour of the world to black
   g.setColor(Color.black);
        //sets the background colour for all the rectangles in the game
   g.fillRect(0,0,getWidth(),getHeight());
       //says that whilst there is a monster looping paint it on the world
        for (int i = 0; i < actors.size(); i++) {
          Actor m = (Actor)actors.get(i);
          m.paint(g);
       }
        //paint the player the same colour as 'g'
        player.paint(g);
        paintScore(g);
    
       //says that if something has a used time, then paint it white
        g.setColor(Color.white);
        //says that if used time is greater than 0 it should follow the instructions
        //in the body 
        if (usedTime > 0)
         //tells the world to draw a string which equals the value of 1000 divided by 
        	//usedtime
        	//then sets its size on the screen
        	g.drawString(String.valueOf(1000/usedTime)+" fps",0,Stage.HEIGHT-50);
       else
    	   //if the value of used time is less than 0 paint ---fps instead of the value
          g.drawString("--- fps",0,Stage.HEIGHT-50);
      //says display the above strategy
        strategy.show();
    }
      
      public void paintScore(Graphics2D g) {
  	   	//Define the font & size used for the score
	         g.setFont(new Font("Arial",Font.BOLD,20));
	         //Defines the color of the font used
	         g.setPaint(Color.orange);
	         //Draw the score label & define its position on the screen
	         g.drawString("Score:",540,650);
	         //Define the color used for the accual score itself
	         g.setPaint(Color.yellow);
	         //Draw the score and define its position
	    //     g.drawString(player.getScore()+"",610,650);
      }
      
 //initiates the use of the SpriteCache class    
   public SpriteCache getSpriteCache() {
       return spriteCache;
     }
     //initiates the use of action keys for use only by the Player class
     public void keyPressed(KeyEvent e) {
       player.keyPressed(e);
     }
     //initiates the releasing of keys
     public void keyReleased(KeyEvent e) {
       player.keyReleased(e);

    }
    //initiates the use of typing keys
     public void keyTyped(KeyEvent e) {}
     
    //initiates a method called game, this sets the rate for 
     //painting/refreshing the screen
     public void game() {
       //says that the variable usedtime declared above is to store the value of 1000
    	 usedTime=1000;
    	 //initialises the world
       initWorld();
       //while the world is visible
       while (isVisible()) {
    	   //create a variable called start time and it should be equal to the current
    	   //system time and count in milli seconds
         long startTime = System.currentTimeMillis();
        //repaint the world
         updateWorld();
         //check if there has been any collisions
         checkCollisions();
//and repaint the world again
         paintWorld();
         //used time should now be updated to be equal to the systems current time
         // minus the start time stored in the above variable
         usedTime = System.currentTimeMillis()-startTime;
        
         //tells the program to test if there is sleep period in a thread, for
         //the time specified by its argument,
         //this argument is specified in the stage class as being 5 milliseconds
         try { 
            Thread.sleep(SPEED);
            //if there is a sleep time in a thread for 5 milliseconds or above
            //the thread will be interupted and a new thread begun
            //ensuring the game does not stop
         } catch (InterruptedException e) {}
       }
     }
     //tells all the other classes that this is the main class and they cannot run
     //unless this class is running.
     public static void main(String[] args) {
       SpaceInvaders inv = new SpaceInvaders();
       inv.game();
    }
	
	public Player getPlayer() {
		// TODO Auto-generated method stub
		return player;
	}
  }
   

   