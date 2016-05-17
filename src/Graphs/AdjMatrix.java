package Graphs;

import java.util.ArrayList;

public class AdjMatrix {
	
	//protected ArrayList<Integer> inAdjMat = new ArrayList<Integer>(10);
	protected ArrayList<ArrayList<Integer>> adjMat = new ArrayList<ArrayList<Integer>>(4); //The adjacency matrix itself
	
	/* public ArrayList<ArrayList<Integer>> AdjMatrix() { //Wait, do I even need this!?
		 
	} */
	
	AdjMatrix() {
		for (int i = 0; i < 4; i++) {
			//adjMat[i].set(i, 0);
		}
	}
	
	public void insert(int value) {
		
	}
}
