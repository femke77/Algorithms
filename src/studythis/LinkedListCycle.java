package studythis;
import java.util.*;

class LLNode{
	
	 int value;
	 LLNode next;
	 
	 public LLNode(int value){
		 this.value = value;
	
	 }
	
}

public class LinkedListCycle {
	
	static boolean containsCycle(LLNode head){
		HashSet<LLNode> nodes = new HashSet<>();
		nodes.add(head);
		LLNode current = head;
		if (current.next == null){
			throw new IllegalArgumentException("more than one node is required for a cycle");
		}
		while (current.next != null){
			if (nodes.contains(current.next)){
				return true;
			} else {
				nodes.add(current.next);
			}
			current = current.next;
		}
		return false;
	}

	public static void main(String[] args) {

		LLNode a = new LLNode(3);
		LLNode b = new LLNode(4);
		LLNode c = new LLNode(1);
		LLNode d = new LLNode(3);
		LLNode e = new LLNode(8);
		
		a.next = b;
		b.next = c;
		c.next = a;
		d.next = e;
		
		
		System.out.println(containsCycle(a));
	}

}
