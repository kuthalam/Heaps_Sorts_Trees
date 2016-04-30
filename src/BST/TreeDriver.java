package BST;

public class TreeDriver {
	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		tree.insert(8);
		tree.insert(3);
		tree.insert(6);
		tree.insert(1);
		tree.insert(4);
		tree.insert(7);
		tree.insert(10);
		tree.insert(14);
		tree.insert(13);
		
		int[] result = tree.postOrder();
	}
}
