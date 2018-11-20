package studythis;

//implementation of a FIFO queue with 2 built-in stacks, nested static class, generics. 
//Remember, re nested class- if it's not static then you can't create its instance without first creating an instance of the
//outer class, which is a bit inconvenient. Making the inner class static solves this. 



import java.util.*;

import java.math.*;



public class Solution {
    public static class MyQueue<E> {
      
        Stack<Integer> a= new Stack<Integer>();
        Stack<Integer> b = new Stack<Integer>();
        
        void enqueue(int x){
            if (b.isEmpty()){
            	b.push((Integer)x);            	
            } else {
            	while (!b.isEmpty()){
            		a.push(b.pop());           		            		
            	}
            	a.push((Integer)x);
            	while (!a.isEmpty()){
            		b.push(a.pop());
            	}
            }
        }
    
        void dequeue(){
            if (!b.isEmpty()){
            	b.pop();
            } else {
            	System.out.println("nothing to dequeue");
            }
        }

        int peek(){
        	if (!b.isEmpty()){
        		return (int)b.peek();
        	} else {
        		return -1;         //assuming this will mean the queue is empty
        	}
        }      
        
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
              queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
              queue.dequeue();
            } else if (operation == 3) { // print/peek
              System.out.println(queue.peek());
            }
        }
        scan.close();
    }
  }
}    
