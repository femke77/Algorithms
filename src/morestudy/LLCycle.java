package morestudy;

import java.util.ArrayDeque;

import java.util.*;
//alternate to LinkedListCycle in O1 time and space


class LLNode{
	
	 int value;
	 LLNode next;
	 boolean visited = false;
	 
	 public LLNode(int value){
		 this.value = value;
	
	 }
	
}

public class LLCycle {
	
	//can be refactored more
	static LLNode reverseList(LLNode head){
	    if (head == null)
	    	throw new IllegalArgumentException("can't reverse an empty list");
		LLNode previous = head;  
		LLNode current, nextNode;
		if (head.next != null)
			current = head.next;
		else 
			return head;		
		//handle the body first      
		while (current.next != null){
	     	nextNode= current.next;
			current.next = previous;
			previous = current;
			current = nextNode;
		}				
		//set edges
		head.next = null;
		current.next = previous;
		return current;
	}
	
	
	static void reverseAList(LLNode head){
		LLNode currentNode = head; 
		LLNode previousNode = null; 
		ArrayDeque<LLNode> newList = new ArrayDeque<>();
		
		while(currentNode.next != null){
			
			newList.addFirst(new LLNode(currentNode.value));
			newList.peek().next = previousNode;
			previousNode = newList.peek();
			currentNode = currentNode.next;
	
		}
		newList.addFirst(new LLNode(currentNode.value));
	
	}
	

	static boolean containsCycle(LLNode head){
		LLNode current = head;
		current.visited = true;		
		if (current.next == null){
			throw new IllegalArgumentException("more than one node is required for a cycle");
		}		
		while (current.next != null){			
			if (current.next.visited == true)
				return true;
			else {
				current.visited = true;
			}
			current = current.next;
		}
		
		return false;
	}

	
	
	static LLNode kthToLastValue(int k, LLNode head){
		
	
		LLNode current = head;
		LLNode result = null;
		int length = 1;
		while(current.next != null){
			length++;
			current = current.next;
		}
		if (k > length)
			throw new IllegalArgumentException("k can't be larger than list size");
		int target = length - k;
		int count = -1;
		
		current = head;
		while (current.next != null){
			count++;
			if (count == target)
				result = current;
			if (k == 1)
				result = current.next;
			current = current.next;
		}
		return result;
	}
	

	
	public static void main(String[] args) {

		LLNode a = new LLNode(3);
		LLNode b = new LLNode(4);
		LLNode c = new LLNode(1);
		LLNode d = new LLNode(2);
		LLNode e = new LLNode(8);
		LLNode f = new LLNode(7);
		
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		
		
		//System.out.println(containsCycle(a));
		//LLNode res = reverseList(a);
		//System.out.println(res.value);
		
		reverseAList(a);
	
		//System.out.println(kthToLastValue(1,a).value);
		//balancedParenthesis(4);
	}

}
