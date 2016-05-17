package BST;

public class Node {

	protected Node left;
	protected Node right;
	protected int value;
	
	Node(int startVal) {
		left = null;
		right = null;
		value = startVal;
	}
	
	public Node newNode(int valToIns) {
		if (value == 0) { //In the case, you are inserting a new value in the root
			new Node(valToIns); //The first node that is created
		}
		else if (this.left == null) { //If you cannot go any farther left
			return new Node(valToIns); //Create a new node for the left pointer to point to
		}
		else if (this.right == null) { //If you cannot go any farther right otherwise
			return new Node(valToIns);
		}
		return new Node(0); //If this node is returned, the previous insert() calls this again
	}
}
