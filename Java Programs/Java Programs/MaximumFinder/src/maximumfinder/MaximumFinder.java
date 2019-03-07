/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package maximumfinder;

/**
 *
 * @author matthewp
 */
import java.util.Scanner; 

    public class MaximumFinder {
        
        public static void main(String[] args) {

        
    }
public void determineMaximum(){
    Scanner input = new Scanner(System.in);
    System.out.print("Enter doubles");
       double number1 = input.nextDouble();  
       double number2 = input.nextDouble();
       double number3 = input.nextDouble();

       double result = maximum( number1, number2, number3);
       System.out.println("Maximu is: "+result);
}

    public double maximum(double x, double y, double z) {
       double maximumValue = x;
       if (y >maximumValue)
           maximumValue = y;
       if (z > maximumValue)
           maximumValue = z;
      return maximumValue;
    }
    


/**
     * @param args the command line arguments
     */
    
    }

