package bin;

 
  //initialises the use of keys to control the program 
   import java.awt.event.KeyEvent;
// the player class takes on the attributes of the actor class
    public class Player extends Actor {
//    	this declares the speed at which the player moves across the screen
    	//is marked for removal
    	//has access to all its variables
    	//interacts with the stage class
    	//interacts with the spritecache class
      protected static final int PLAYER_SPEED = 5;
//    creates a variable which protects methods from access by other objects
  	//vx is the vector postion of the space ship on the x axis
      protected int vx;
//    creates a variable which is dependent on left or right being true
      private boolean left,right;
      private static int lives;

      //Score variable
      private static int score;
      
      private int clusterBombs;
//    makes sure that the player is recognised by the stage and works 
      //with the stages methods
      public Player(Stage stage) {
//    	this method overrides the superclass 'stage'
        super(stage);
//      creates an array to reference each of the sprites
     setSpriteNames( new String[] {"Side_Spaceship.gif"});
        clusterBombs = 5;
        lives=3;
      }

     //this method initialises the use of the 'act' method in SpaceInvaders
    /** public void act() {
        super.act();
        x+=vx;*/

        //this method initialises the use of the 'act' method in SpaceInvaders
        public void act() {
        	  //this overides the 'act' method and replaces it with the below code
          super.act();
//        the value of the variable x must be added and assigned to the 
    	  // the value of the  the vector position on the x axis
          x+=vx;
        
//        according to the above meaning, if the position on the x axis is 
    	  //less than 1, the space ship cannot go past the edge of the screen
          if(x < 1){
          	x = 1;
          }
//        according to the above meaning, if the position on the x axis is 
    	  //greater than 500, the space ship cannot go past the edge of the screen
    //      if (x > 500){
   //       	x = 500;
   //       }
          if (y < 1){
          	y = 1;
          }
          if (y > 550){
          	y = 550;
          }
        
        
        
        if (x < 0){
        	x = 0;
        }
        		
        		
        if (x > 500){
        	x =500;
        }
      }
        
        //Returns the the amount of lives the player has remaining
        public int getLives(){
       	 
       	 return lives;
        }
        
    	//Game score
    	public int getScore(){ return score;}
    	public void setScore(int i) { score = i; }
    	public void addScore(int i) { score += i;  }
    	
//   gets the x variables value of of the space ship's  velocity and returns
     //the space ship's vector on the x axis
      public int getVx() { return vx; }
//    sets the velocity at which the ship can move as the value of the variable
      //'i' and says that the variable vx should hold the value of 'i'
      public void setVx(int i) {vx = i; }
      
      
      
//    sets the value of the variable vx as 0
      protected void updateSpeed() {
        vx=0;
        //if the player moves left, the value of vx must subtract the value of
        //player speed
        if (left) System.out.println("Left Click"); vx = -PLAYER_SPEED;
//      if the player moves right, the value of vx must be replaced by the 
        //value of player speed
        if (right) vx = PLAYER_SPEED;
      }
//    initialises the key released event
      public void keyReleased(KeyEvent e) {
//    	if an event happens do one of the following based on what the event is
        switch (e.getKeyCode()) {
        //if the non number pad left arrow is released: do not move left, 
         case KeyEvent.VK_LEFT : left = false; break; 
//       if the non number pad right arrow is released: do not move right,
         case KeyEvent.VK_RIGHT : right = false;break;
//       if the space bar is released: do not do the method'fire'
         case KeyEvent.VK_SPACE : fire(); break;
//       if the b button is released: do not do the method'fireCluster'
         case KeyEvent.VK_B : fireCluster(); break;


        }
//      carry out the 'updateSpeed' method
        updateSpeed();
      }
//    initialises the use of the key pressed events 
      public void keyPressed(KeyEvent e) {
//    	if the non number pad left arrow is pressed, get the code for the required action
      	//if the non number pad right arrow is pressed, get the code for the required action
       switch (e.getKeyCode()) {
//     if the non number pad left arrow is pressed, move right
          case KeyEvent.VK_LEFT : left = true; System.out.println("leftpress"); break;
          //if the non number pad right arrow is pressed, move right
          case KeyEvent.VK_RIGHT : right = true; System.out.println("leftpress");break;
          
        } //carry out the 'updateSpeed' method
        updateSpeed();
      }
//    method for firing bullets
      public void fire() {
//    	the class bullet is being refered to so that it can create 
    	  //a new bullet on the stage
    	          Bullet b = new Bullet(stage);
//    	        makes sure thaT  the bullet comes from the centre of the 
    	          //ship
    	          b.setX(x + 70);
//    	        sets the hieght on the screen on the y axix that the 1st bullet appears
    	          b.setY(y - b.getHeight());
    	          //add the bullets to the actors methods for use on the stage
    	          stage.addActor(b);
      }
//    method for firing cluster bombs        
      public void fireCluster() {
    	  if (clusterBombs == 0)
    		  return;
    	  
    	  clusterBombs--;
    	  stage.addActor( new Bomb(stage, Bomb.UP_LEFT, x,y));
    	  stage.addActor( new Bomb(stage, Bomb.UP, x,y));
    	  stage.addActor( new Bomb(stage, Bomb.UP_RIGHT, x,y));
    	  stage.addActor( new Bomb(stage, Bomb.LEFT, x,y));
    	  stage.addActor( new Bomb(stage, Bomb.RIGHT, x,y));
    	  stage.addActor( new Bomb(stage, Bomb.DOWN_LEFT, x,y));
    	  stage.addActor( new Bomb(stage, Bomb.DOWN, x,y));
    	  stage.addActor( new Bomb(stage, Bomb.DOWN_RIGHT, x,y));
      }
   	        
        }
 
    
    
