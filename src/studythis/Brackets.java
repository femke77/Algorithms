package studythis;
import java.util.*;

//O(n) space and time 
//input is a string of open and closing brackets only. no spaces and no other characters

public class Brackets {
	static boolean verifyBrackets(String s){
		Stack<Character> stack = new Stack<>();		
		if (s == "")
			throw new IllegalArgumentException("can't check an empty string");		
		for (int i = 0; i < s.length(); i++){			
			char cur = s.charAt(i);			
			if (cur == '(' || cur  == '[' || cur == '{'){
				stack.push(cur);
			}
			else {	
				if (i == 0)
					throw new IllegalArgumentException("can't begin string with closer type");
				if (!(findMatch(cur) == stack.pop()))
					return false;								
			} 			
		}
		return stack.isEmpty();
	}
	
	static char findMatch(char c){
		char match = '0';
		if (c == ')' )
			match = '(';			
		if (c == ']' )
			match = '[';		
		if (c == '}' )
			match = '{';
		return match;
	}
	
	
	
	
	public static void main(String[] args) {
		System.out.println(verifyBrackets("]"));
		
	
		

	}//end main

}
