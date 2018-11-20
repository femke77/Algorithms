package studythis;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
//NOT MY CODE
public class Windows {


static int[] riddle(int[] input) {
        int N = input.length;
        int	[] result = new int[N];
        int[] span = new int[N];

        ArrayDeque<Integer> deckValues = new ArrayDeque<>();
        ArrayDeque<Integer> deckIndexes = new ArrayDeque<>();
        deckIndexes.push(-1);
        System.out.println(deckIndexes.peek());
        // count number of ge elements to the left
        for (int i = 0; i < N; i++) {
                while (!deckValues.isEmpty() && deckValues.peek() >= input[i]) {
                        deckValues.pop();
                        deckIndexes.pop();
                }
                span[i] = i - deckIndexes.peek()-1;
                //System.out.println(span[i]);
                deckValues.push(input[i]);
                deckIndexes.push( i);
        }
        System.out.println(deckValues.toString() + " " + deckIndexes.toString() +" "+ Arrays.toString(span));
        // count number of ge elements to the right
        deckValues.clear();
        deckIndexes.clear();
        deckIndexes.push(N);
        for (int i = N-1; i >=0; i--) {
                while (!deckValues.isEmpty() && deckValues.peek() >= input[i]) {
                        deckValues.pop();
                        deckIndexes.pop();
                }
                span[i] += deckIndexes.peek() - i-1;
                deckValues.push(input[i]);
                deckIndexes.push(i);
        }
        System.out.println(deckValues.toString() + " " + deckIndexes.toString() +" "+ Arrays.toString(span));
        // fill results
        for (int i = 0; i < N; i++) {
                result[(int)span[i]] = Math.max(result[span[i]], input[i]);
        }

        // fill the gaps
        for (int i = N-2; i >=0; i--) {
                result[i] = Math.max(result[i], result[i+1]);
        }

        return result;
}
	public static void main(String[] args) {
		
		int[] input = new int[]{6,3,5,1,2};
		
		System.out.println(Arrays.toString(riddle(input)));
	}

}
