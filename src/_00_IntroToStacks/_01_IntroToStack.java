package _00_IntroToStacks;

import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class _01_IntroToStack {
    public static void main(String[] args) {
        // 1. Create a Stack of Doubles
        //    Don't forget to import the Stack class
    	Stack<Double> stackDoubles = new Stack<Double>();
    	
    	Random ran = new Random();
    	for (int i = 0; i < 100; i++) {
    		stackDoubles.push(ran.nextDouble(0, 101));
    	}
    	
    	System.out.println(stackDoubles.get(11));
    	
    	Double first = Double.valueOf(JOptionPane.showInputDialog("Enter your 1st Double: Low Number"));
    	Double second = Double.valueOf(JOptionPane.showInputDialog("Enter your 1st Double: High Number"));
    	
    	while (! stackDoubles.isEmpty()) {
    		Double temp = stackDoubles.pop();
    		if (temp >= first && temp <= second) {
//    			System.out.println(temp);
    		}
    	}

        // 2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.

        // 3. Ask the user to enter in two numbers between 0 and 100, inclusive. 

        // 4. Pop all the elements off of the Stack. Every time a double is popped that is
        //    between the two numbers entered by the user, print it to the screen.


        // EXAMPLE:
        // NUM 1: 65
        // NUM 2: 75

        // Popping elements off stack...
        // Elements between 65 and 75:
        // 66.66876846
        // 74.51651681
        // 70.05110654
        // 69.21350456
        // 71.54506465
        // 66.47984807
        // 74.12121224
    }
}
