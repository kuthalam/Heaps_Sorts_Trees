package BST;

import javax.swing.JOptionPane;

//import java.util.TreeSet;

public class TreeDriver {
	public static void main(String args[]) {
		String rootValue = null;
		String addValue = "Y";
		int rootVal = 0;
		int addVal = 0;
		
		rootValue = JOptionPane.showInputDialog(null, "Hey, there. This program builds binary trees for you and does stuff with that tree.\n" +
		"To create a binary tree, specify a value that does not equal 0 to assign to the root node. Or press \"Q\" to quit: ");
		
		if (rootValue.equals("Q") || rootValue.equals("q")) {
			JOptionPane.showMessageDialog(null, "Well, come back another time to make use of this mini-project!");
			return;
		}
		
		rootVal = Integer.parseInt(rootValue);
		while (rootVal == 0) {
			rootValue = JOptionPane.showInputDialog(null, "Can you please NOT make the root node value 0? Please enter something else:");
			rootVal = Integer.parseInt(rootValue);
		}
		
		BinaryTree tree = new BinaryTree(rootVal); //Now we can specify the value we want the root to have
		Node root = tree.root;
		
		while (!addValue.equals("N") && !addValue.equals("n")) {
			addValue = JOptionPane.showInputDialog(null, "Would you like to add more nodes to the binary tree?" +
			"If so, specify another non-zero values to add to the tree. If not, just enter \"N\":");
			while (!addValue.equals("N") && !addValue.equals("n") && Integer.parseInt(addValue) == 0) {
				addValue = JOptionPane.showInputDialog(null, "Please do not add non-zero values to the tree. Now try again:");
			}
			if (!addValue.equals("N") && !addValue.equals("n") && (Integer.parseInt(addValue) != 0)) {
				addVal = Integer.parseInt(addValue);
				tree.insert(root, addVal);
			}
		}
		int[] result = tree.postOrder(root);
		JOptionPane.showMessageDialog(null, "The PostOrder (LRN) traversal of this tree is:\n" + printArray(result));
	}
	
	public static String printArray(int[] array) {
		String print = "";
		for (int i = 0; i < array.length; i++) {
			if (array[i] != 0) {
				print += Integer.toString(array[i]) + ", ";
			}
		}
		print = print.substring(0, print.length()-2);
		return print;
	}
}
