package bin;

 //import the Graphics 2d package
    import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
    //creates and declares the variables to be used by the motionable parts of the game
    public class Actor {
      protected int x,y;
      protected int width, height;
      protected String[] spriteNames;
      protected int currentFrame;
      protected int frameSpeed;
     protected int t;

     //initialises the use of the stage and spritecache classes
      protected Stage stage;
      protected SpriteCache spriteCache;
      //declares a variable: marked for removal that will be used to tag an actor
      //for removal when certain conditions are met
      protected boolean markedForRemoval;

      //makes sure that actor is recognised by the stage and works 
      //with the stages methodse
      public Actor(Stage stage) {
    	  //reference to the subclass stage, inserts itself in the stage class
        this.stage = stage;
        //tells the stage to get the spriteCache class's methods
        spriteCache = stage.getSpriteCache();
        //inserts the value 0 in the variable current frame
        currentFrame = 0;
        //inserts the value 1 in the variable frame speed
        frameSpeed = 1;
        //inserts the value 0 in the t variable
        t=0;
      }
    //tells the main method that the actor is removable
      public void remove() {
    	         markedForRemoval = true;
       }
    	        
      public boolean isMarkedForRemoval() {
    	         return markedForRemoval;
     }
    	        

      //uses the Graphics2D class to paint the the actors  and uses the drawImage method
	  //in conjunction with the buffer strategy to paint the objects within spriteCache
      //in line with the values specified by the currentframe, x and y variables
      public void paint(Graphics2D g){
        g.drawImage( spriteCache.getSprite(spriteNames[currentFrame]), x,y, stage );
      }
      //returns the X-coordinate of the current position of the actors and returns the 
      //value of the variable x 
      public int getX()  { return x; }
      //sets the value of x to the value of i
      public void setX(int i) { x = i; }
      
    //returns the Y-coordinate of the current position of the actors and returns the 
      //value of the variable y 
     public int getY() { return y; }
     //sets the value of y to the value of i
      public void setY(int i) { y = i; }
      
      //returns the value of the current framespeed
      public int getFrameSpeed() {return frameSpeed;  }
      //sets the value of framespeed to the value of i
      public void setFrameSpeed(int i) {frameSpeed = i; }
      
      //method for the use of the contents of the spritenames array
      public void setSpriteNames(String[] names) { 
        //says the elements of the array are called names
    	  spriteNames = names;
    	  //says that all elements of the array have a height and width of 0
        height = 0;
        width = 0;
        //this for loop says that it will increment the value of i, 
        //starting at 0 until it is less than the value of the array elements:names
        //and the length of the array
        for (int i = 0; i < names.length; i++ ) {
        	//this will use the buffer strategy to pre-create the next image
        	//it is given by the spritenames array, when it is told to do so
        	//by coming out of the above loop
          BufferedImage image = spriteCache.getSprite(spriteNames[i]);
          //this will return the largest of the values between the height 
          //and width variables
          height = Math.max(height,image.getHeight());
          width = Math.max(width,image.getWidth());
        }
      }     
      //returns the value of the height variable
      public int getHeight() { return height; }
    //returns the value of the width variable
      public int getWidth() { return width; }
      //sets the value of the height variable to that of i
      public void setHeight(int i) {height = i; }
    //sets the value of the width variable to that of i
     public void setWidth(int i) { width = i;  }
    
     //tells the actor class to run 
     public void act() {
    	 //tells the act method to continually increment the value of t, by one
        t++;
        //this will calculate and pass on the value of the remainder of the sum 
        //t divided by framespeed and tell the method that id the remainder 
        //is equal to 0, then change the value of the variable t to 0
       if (t % frameSpeed == 0){
          t=0;
          //then also make the variable currentframe the value of currentframe 
          //add 1 and show the remainder of the sum currentframe plus 1 divided by
          //the length of the array:spritenames
          currentFrame = (currentFrame + 1) % spriteNames.length;
        }
     }
    //initialises the method for checking for collisions
   //each actor is to be surrounded by a rectangle in proportion to its shape
     //this method will then return the size of its boundary's
     //to pass on to the collision checking method below
   public Rectangle getBounds() {
       return new Rectangle();
    	     	          
    
    }

	public void collision(Actor a2) {
		// TODO Auto-generated method stub
		
	}
    	      
    	      
    	        
    	      }
    	    



