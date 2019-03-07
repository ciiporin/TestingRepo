package bin;



    //Monster is a subclass or child of actor
    public class Monster extends Actor {
    	//it uses it variable: vx
      protected int vx;
      
    //makes sure that the monster is recognised by the stage and works 
      //with the stages methods
      public Monster(Stage stage) {
    	//this method overrides the superclass 'stage'
        super(stage);
        //adds array elements to the spritenames array
        setSpriteNames( new String[] {"smiley3.png"});
       setFrameSpeed(35);
      }
     /* *public void act() {
          super.act();
          x+=vx;
         // y+=vy;
          
          if(x < 1){
          	x = 1;
          }
          if (x > 500){
          	x = 500;
          }
          if (y < 1){
          	y = 1;
          }
          if (y > 350){
          	y = 350;
          }
        }*/
     
    ///tells the actor class to run 
      public void act() {
    	//this overides the 'act' method and replaces it with the below code
        super.act();
      //the value of the variable x must be added and assigned to the 
  	  // the value of the the vector position on the x axis
        x+=vx;
      //according to the above meaning, if the position on the x axis is 
  	  //less than 0, or if x is greater than 600 the monster cannot go past 
        //the edge of the screen
       if (x < 0 || x > 600)
         vx = -vx;
      }
      //gets the x variables value of the maonster's velocity and returns
      //the monster's vector on the x axis
      public int getVx() { return vx; }
    //sets the velocity at which the monster can move as the value of the 
      //variable
      //'i' and says that the variable vx should hold the value of 'i'
      public void setVx(int i) {vx = i; }
    
   //says that if an instance of a bullet class collides with a monster, the 
      //monster should remove itself from memory/game/screen
      public void collision(Actor a) {
    	       if (a instanceof Bullet )
    	         remove();
    }
}
  