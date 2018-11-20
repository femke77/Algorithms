package studythis;

import java.util.Arrays;
import java.util.Stack;

//stack is good whenever you need to look back on the last element. why can you jump over some of the elements as you look 
//back in this case? because they are already checked... we already know when anything on the left is greater than some
//element, so we don't need to worry about those lesser elements anymore.

public class StockSpan {
	public static int[] stockSpan(int[] prices) {

		Stack<Integer> s = new Stack<>();
		int[] span = new int[prices.length];

		// Step 1. Initialization
		span[0] = 1;
		s.push(0);

		for (int i = 1; i < prices.length; i++) {
			// Find the price on stack which is greater than current day's price
			while (!s.empty() && prices[i] > prices[s.peek()])
				s.pop();

			if (s.empty())
				span[i] = i + 1;
			else
				span[i] = i - s.peek();

			// Push current day onto top of stack
			s.push(i);
		}

		return span;
	}

	public static void main(String args[]) {
		int prices[] = { 100, 60, 70, 65, 80, 85, 200 };
		int[] span = stockSpan(prices);

		System.out.println(Arrays.toString(stockSpan(span)));

	}
}
