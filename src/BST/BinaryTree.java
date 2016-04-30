package BST;

import java.util.Stack;

public class BinaryTree {
	
	protected Node left;
	protected Node right;
	protected int value;
	protected int size;
	protected int[] result = new int[100]; //Contains the postOrder traversal result
	protected Node node;
	
	BinaryTree() {
		new Node(0);
		size = 0;
	}
	
	public void insert(int valToIns) {
		/* Recursion problems 
		if (size != 1 && value != 0 && valToIns < value) {
			this.left.insert(valToIns); //If the value to insert is less than the root
			//valToIns goes to the left of that node
		}
		else if (size != 1 && value != 0 && valToIns > value) {
			this.right.insert(valToIns); //If the value to insert is greater than the root
			//valToIns goes to the right of that node
		} */
		
		if (value == 0) { //In the case, you are inserting a new value in the root
			new Node(valToIns); //The first node that is created
			size++;
		}
		else if (this.left == null) { //If you cannot go any farther left
			this.left = new Node(valToIns);
			size++;
		}
		else if (this.right == null) { //If you cannot go any farther right otherwise
			this.right = new Node(valToIns);
			size++;
		}
	}
	
	public int[] postOrder() { //LRN traversal
		int index = 0;
		Stack<BinaryTree> stack = new Stack<BinaryTree>();
		
		if (size == 0) { //In the case that the Tree effectively does not exist
			return result;
		}
		
		if (this.left != null) {
			postOrder(); //Go to the farthest left of the tree before inserting values in result
		}
		
		//stack.push(this); //Now push the node onto the stack
		while(index != size-1) { //You know how many elements will go in the loop
			//BinaryTree node = stack.peek(); //This will let you look at the node you are on
			if (this.left != null) {
				result[index] = this.left.value; //If it is not empty, load the left value into result
				index++;
			}
			if (this.right != null) {
				result[index] = this.right.value; //Do the same for the right value
				index++;
			}
			result[index] = this.value;
			index++;
			//Hence, LRN
		}
		return result;
	}
}
