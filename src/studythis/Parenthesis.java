package studythis;

import java.util.*;

public class Parenthesis {

	//good answer but could have done better with space complexity. see answer below
	static int closingPosition(String s, int pos) {
		int closingPosition = 0;
		char[] arr = s.toCharArray();
		Stack<Character> stack = new Stack<>();
		stack.push(arr[pos]);

		if (s.length() < 2)
			System.out.println("string too short");

		for (int i = pos + 1; i < arr.length; i++) {

			if (arr[i] == '(') {
				stack.push(arr[i]);
			}
			if (arr[i] == ')') {
				stack.pop();
			}
			if (stack.size() == 0) {
				closingPosition = i;
				return closingPosition;
			}
		}

		return closingPosition;
	}

	//answer:
	//excellent example of iterating over a string:
	
	public static int getClosingParen(String sentence, int openingParenIndex) {
		int openNestedParens = 0;

		for (int position = openingParenIndex + 1; position < sentence.length(); position++) {
			char c = sentence.charAt(position);

			if (c == '(') {
				openNestedParens++;
			} else if (c == ')') {
				if (openNestedParens == 0) {
					return position;
				} else {
					openNestedParens--;
				}
			}
		}

		throw new IllegalArgumentException("No closing parenthesis :(");
	}

	
	
	public static void main(String[] args) {

		System.out.println(closingPosition("hello (I am talking ((to you) not)) you", 6));

	}

}
