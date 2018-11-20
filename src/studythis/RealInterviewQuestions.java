package studythis;
//questions from my actual interviews

import java.util.Arrays;

public class RealInterviewQuestions {

	static void balancedParenthesis(int n) {
		balancedParenthesis(n, n, "");
	}

	static void balancedParenthesis(int open, int close, String s) {

		if (close == 0 && open == 0)
			System.out.println(s);
		if (open > close)
			return;
		if (open > 0)
			balancedParenthesis(open - 1, close, s + "(");
		if (close > 0)
			balancedParenthesis(open, close - 1, s + ")");

	}

	// ---------------------------------------------------------------------------------------
	static void isPrime(int num) { // 7 = 2,3,5,7

		if (num <= 1) {
			System.out.println("not a prime");
		} else {
			for (int i = 2; i <= num; i++) {
				if (!composite(i)) {
					System.out.println(i);
				}

			}
		}
	}

	static boolean composite(int num) {

		for (int i = 2; i <= num / 2; i++) {
			// this makes it non-prime:
			if (num % i == 0) {
				return true;
			}
		}
		return false;
	}

	// -----------------------------------------------------------------
	public static boolean isPermutation(String s) {
		int rightIndex = s.length() - 1;
		int leftIndex = 0;

		while (leftIndex < rightIndex) {
			if (s.charAt(leftIndex) != s.charAt(rightIndex))
				return false;
			else
				leftIndex++;
			rightIndex--;

		}
		return true;
	}

	// ---------------------------------------------------------------------------------------
	//given a string with special characters included, reverse only the letters and nothing else
	public static void reverseLetters(String s){
		
		int leftIndex = 0;
		int rightIndex = s.length()-1;
		char[] char_array = s.toCharArray();
		
		while(leftIndex <= rightIndex){
			
			while (!(Character.isLetter(char_array[leftIndex++])));
			while (!(Character.isLetter(char_array[rightIndex--])));

			char temp = char_array[rightIndex];
			char_array[rightIndex] = char_array[leftIndex];
			char_array[leftIndex] = temp;
			leftIndex++;
			rightIndex--;
		}
		
	
		System.out.println(Arrays.toString(char_array));
		
	}
	
	//---------------------------------------------------------------------------------------
	public static void main(String[] args) {

		System.out.println(isPermutation("10101"));
		balancedParenthesis(4);
		reverseLetters("Ab&.!Cd!");
	}

}
