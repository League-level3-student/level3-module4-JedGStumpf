package _01_TestMatchingBrackets;

import java.util.Stack;

public class TestMatchingBrackets {
    /*
     * Use a Stack to complete the method for checking if every opening bracket
     * has a matching closing bracket
     */
    public static boolean doBracketsMatch(String b) {
    	boolean matching = false;
    	boolean foundBracket = false;
    	int countFor = 0;
    	int countBack = 0;
    	Stack<String> brackets = new Stack<String>();
    	for (int i = 0; i < b.length(); i++) {
    		brackets.push(String.valueOf(b.charAt(i)));
    		
    	}

    	for (int i = 0; i < brackets.size(); i++) {
    		if (brackets.get(i).equals("{") 
    				&& foundBracket == false 
    				&& countBack == 0 
    				&& countFor ==0) {

    			foundBracket = true;
    			countFor++;
    		
    		} else {
    			if (brackets.get(i).equals("{")){
    				countFor++;
    			} else if (brackets.get(i).equals("}")) {
    				countBack++;
    				if (countFor == countBack) {
    					matching = true;
    				} else {
    					matching = false;
    				}
    			}
    		}
    		
    	}
    	if (matching == true && countFor == countBack) {
    		return matching;
    	}
        return false;
    }
}