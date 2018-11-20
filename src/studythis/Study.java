package studythis;
//trees and recursion 

//remember you can always dfs or bfs without recursion using stack and queue respectivly
//also if you do use recursion you can pre in or post order . 

import java.util.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;
//remember you can make a custom data structure (class) whenever you need to... (e.g. nodeDepthPair)
class MaxStack {
	
	Stack<Integer> stack = new Stack<>();
	int max = 0;
	
	
	void push(Integer i){
		stack.push(i);
		if (i > max)
			max = i;
	}
	
	
	Integer getMax(){
		return max;
	}
	
	
}

class Node {

	Node left, right;
	int data;
	boolean wasVisited = false;

	Node(int data) {
		this.data = data;
		left = right = null;

	}

}

class NodeDepthPair {

	Node node;
	int depth;

	NodeDepthPair(Node node, int depth) {
		this.node = node;
		this.depth = depth;
	}
}

public class Study {

	static String reverseSentence(String s) {
		String out = "";
		String[] stringArray = s.split(" ");
		// System.out.println(Arrays.toString(stringArray));
		for (int i = stringArray.length - 1; i >= 0; i--) {
			out += stringArray[i] + " "; // bad for memory if string is long
		}
		return out;
	}

	static void BFS(Node root) {

		Queue<Node> q = new ArrayDeque<>();
		root.wasVisited = true;
		System.out.println(root.data);
		q.add(root);
		Node v2;
		while (!q.isEmpty()) {
			Node v1 = q.poll();
			while ((v2 = getNextNode(v1)) != null) {
				v2.wasVisited = true;
				System.out.println(v2.data);
				q.add(v2);
			}
		} // end q not empty
	}
	
	static void noVisitsBFS(Node root){ //for binary tree visits are not required for bfs or dfs
		Queue<Node> q = new ArrayDeque<>();
		q.add(root);
		Node v2;
		while (!q.isEmpty()){
			Node v1 = q.poll();
			System.out.println(v1.data);
			if (v1.left !=null){
				v2 = v1.left;
				q.add(v2);
				
			}
			if (v1.right !=null){
				v2 = v1.right;
				q.add(v2);
				
			}
		}
		
		
	}
	
	static boolean isSymmetric(Node root){
		return isSymmetric(root.left, root.right);
	}
	
	static boolean isSymmetric(Node left, Node right){
		if (left == null && right == null){
			return true;
		}
		if (left == null || right == null){
			return false;
		}
		return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
	}
	
	
	static void reverseTree(Node root){
		if (root == null){
			return;
		}
		Node temp = root.right;
		root.right = root.left;
		root.left = temp;
		
		reverseTree(root.left);
		reverseTree(root.right);
	}
	
	// the following two methods are the efficient way to create a min height
	// bin search tree with sorted array
	// without calling insert and recursing over and over the tree, which was my
	// initial mistake
	static Node createMinHeightTree(int[] a) {
		return createMinHeightTree(a, 0, a.length - 1);
	}

	static Node createMinHeightTree(int[] a, int start, int end) {
		if (end > start) {
			return null;
		}
		int mid = start + end / 2;
		Node n = new Node(a[mid]);
		n.left = createMinHeightTree(a, 0, mid - 1);
		n.right = createMinHeightTree(a, mid + 1, end);
		return n;
	}

	public static Node insert(Node root, int data) { // builds valid bst

		if (root == null) {
			return new Node(data);
		} else {
			Node cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			// System.out.println("root data " + root.data);
			return root;
		}
	}

	static int getHeight(Node n) {

		if (n == null) {
			System.out.println("null");
			return -1;
		} else {
			int leftC = getHeight(n.left);
			int rightC = getHeight(n.right);

			if (leftC > rightC) {
				System.out.println(leftC + 1);
				return leftC + 1;
			} else {
				System.out.println(rightC + 1);
				return rightC + 1;
			}
		}

	}

	static Node lca(Node root, int v1, int v2) {
		// Decide if you have to call recursively

		// Smaller than both
		if (root.data < v1 && root.data < v2) {
			return lca(root.right, v1, v2);
		}
		// Bigger than both
		if (root.data > v1 && root.data > v2) {
			return lca(root.left, v1, v2);
		}

		// Else solution already found

		return root;
	}

	static void preorder(Node root, int level) {

		if (root != null) {
			// visit(node);
			System.out.println(root.data + " " + level);
			preorder(root.left, level + 1);
			preorder(root.right, level + 1);
		}

	}

	static void printGivenLevel(Node root, int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.print(root.data + " ");
		else if (level > 1) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}

	

	static Node getNextNode(Node n) {
		if (n.left != null && n.left.wasVisited == false) {
			n = n.left;
		} else if (n.right != null && n.right.wasVisited == false) {
			n = n.right;
		} else {
			n = null;
		}
		return n;
	}

	public static boolean isBalanced(Node treeRoot) { // interview cake

		if (treeRoot == null) {
			return true;
		}
		List<Integer> depths = new ArrayList<>(3);
		Deque<NodeDepthPair> nodes = new ArrayDeque<>();
		nodes.push(new NodeDepthPair(treeRoot, 0));
		while (!nodes.isEmpty()) {

			NodeDepthPair nodeDepthPair = nodes.pop();
			Node node = nodeDepthPair.node;
			int depth = nodeDepthPair.depth;

			if (node.left == null && node.right == null) {

				if (!depths.contains(depth)) {
					depths.add(depth);
					if (depths.size() > 2 || (depths.size() == 2 && Math.abs(depths.get(0) - depths.get(1)) > 1)) {
						return false;
					}
				}

			} else {
				if (node.left != null) {
					nodes.push(new NodeDepthPair(node.left, depth + 1));
				}
				if (node.right != null) {
					nodes.push(new NodeDepthPair(node.right, depth + 1));
				}
			}
		}

		return true;
	}

	static void DFS(Node root) {

		Stack<Node> stack = new Stack<>();
		Node n;
		root.wasVisited = true;
		System.out.println(root.data);
		stack.push(root);

		while (!stack.isEmpty()) {

			n = getNextNode(stack.peek());
			if (n == null) {
				stack.pop();
			} else {
				n.wasVisited = true;
				System.out.println(n.data);
				stack.push(n);
			}

		} // end while

	}// end method

	static void secondLargest(Node n) {

		if (n == null) {
			System.out.println("null");
		} else if (n.right == null && n.left == null) {
			System.out.println("one node tree has no second largest");
		} else if (n.left != null && n.right == null) {
			System.out.println("n.left " + n.left.data);
		} else if (n.right != null) {
			Node parent = n;
			n = n.right;
			while (n.right != null) {
				parent = n;
				n = n.right;
			}
			if (n.left == null) {
				System.out.println(parent.data);
			} else {
				if (n.left != null && n.left.right != null) {
					System.out.println(n.left.right.data);
				}
			}
		}

	}

	public static void main(String[] args) {
		// isPrime(7);
		/*
		 * cool ways to iterate
		 * 
		 * int t = 7; for (int i = 9; i --> 0;) System.out.println(i); while
		 * (t-->0) System.out.println(t);
		 */
		/*
		 * Node root = null; Random r = new Random(); int num = 9; //number of
		 * nodes while (num-->0){ int data = 1 + r.nextInt(100);
		 * System.out.println(num +" " + data); root = insert(root,data);
		 * 
		 * }
		 */
		// String st = "hi how are you";
		// System.out.println(reverseSentence(st));
  
       
        
        
        Node root = null;

		root = insert(root, 90);

		root = insert(root, 70);
		root = insert(root, 100);
		root = insert(root, 60);
		root = insert(root, 80);
		root = insert(root, 55);
		root = insert(root, 120);
		root = insert(root, 95);
		root = insert(root, 91);
		root = insert(root, 98);
		//secondLargest(root);
		//noVisitsBFS(root);
		reverseTree(root);
		noVisitsBFS(root);
		System.out.println(isSymmetric(root));
		// printGivenLevel(root, 0);
		// printGivenLevel(root,1);
		// root = insert(root,100);
		// root = insert(root,98);
		// DFS(root);
		int[] x = new int[] { 2, 3, 4, 5, 6, 7, 8 };
		// createMinHeightTree(x);
		// BFS(root);
		// System.out.println(isBalanced(root));
		// System.out.println("where am i? " +root.data);


	}// end main

}
