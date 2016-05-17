package BST;

//import java.util.Stack;

public class BinaryTree {
	
	protected Node root; //This keeps track of the root
	protected Node current; //This keeps track of the node you are on
	protected BinaryTree left;
	protected BinaryTree right;
	protected int value;
	protected int size;
	protected int index = 0;
	protected int[] result = new int[100]; //Contains the postOrder traversal result
	protected int[] searchResult = new int[100]; //Contains the postOrder traversal result
	
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
		//Stack<BinaryTree> stack = new Stack<BinaryTree>();
		
		if (size == 0) { //In the case that the Tree effectively does not exist
			return result;
		}
		
		if (node.left != null) {
			postOrder(node.left); //Go to the farthest left of the tree before inserting values in result
		}
		if (node.right != null) {
			postOrder(node.right); //Go to the farthest left of the tree before inserting values in result
		}
		
		//stack.push(this); //Now push the node onto the stack
		result[index] = node.value;
		index++;
		//Hence, LRN
		return result;
	}
}
