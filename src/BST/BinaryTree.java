package BST;

//import java.util.Stack;

public class BinaryTree {
	
	protected Node root; //This keeps track of the root
	protected BinaryTree left;
	protected BinaryTree right;
	protected int size;
	protected int index = 0;
	protected int[] postResult = new int[100]; //Contains the postOrder traversal result
	protected int[] preResult = new int[100]; //Contains the preOrder traversal result
	protected int[] inResult = new int[100]; //Contains the inOrder traversal result
	
	BinaryTree(int startValue) {
		root = new Node(startValue); //Create and save the root's location
		size = 1;
	}
	
	public void insert(Node node, int valToIns) {
		if (this.size != 1 && valToIns < node.value && node.left != null) {
			insert(node.left, valToIns); //So if the value to insert is less than the value of the current node, move down the left tree
		}
		else if (this.size != 1 && node.right != null) {
			if (valToIns > node.value) {
				insert(node.right, valToIns); //So if the value to insert is more than the value of the current node, move down the right tree
			}
		}
		
		if (node.value == 0) { //In the case you are inserting a new value in the root
			node = new Node(valToIns); //The first node that is created
			this.root = node; //Make sure the root of this tree points to the right place
		}
		else if (node.left == null && valToIns < node.value) { //If you cannot go any farther left
			node.left = new Node(valToIns);
		}
		else if (node.right == null && valToIns > node.value) { //If you cannot go any farther right otherwise
			node.right = new Node(valToIns);
		}
		size++;
	}
	
	public int[] postOrder(Node node) { //LRN traversal
		if (size == 0) { //In the case that the Tree effectively does not exist
			return postResult;
		}
		
		if (node.left != null) {
			postOrder(node.left); //Go to the farthest left of the tree before inserting values in result
		}
		if (node.right != null) {
			postOrder(node.right); //Go to the farthest left of the tree before inserting values in result
		}
	
		postResult[index] = node.value;
		index++;
		//Hence, LRN
		return postResult;
	}
	
	public int[] preOrder (Node node) { //NLR traversal
		if (size == 0) { //Watch out for an empty tree
			return preResult;
		}
		
		preResult[index] = node.value; //First push the node value
		index++;
		
		if (node.left != null) { //Now go through the left subtree
			preOrder(node.left);
		}
		if (node.right != null) { //Now go through the right subtree
			preOrder(node.right);
		}
		
		return preResult;
	}
	
	public int[] inOrder (Node node) { //NLR traversal
		if (size == 0) { //Watch out for an empty tree
			return inResult;
		}
		
		if (node.left != null) {
			inOrder(node.left);
		}
		
		inResult[index] = node.value;
		index++;
		
		if (node.right != null) {
			inOrder(node.right);
		}
		
		return inResult;
	}
}
