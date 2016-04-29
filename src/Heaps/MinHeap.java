package Heaps;

import java.util.PriorityQueue;

public class MinHeap {
	private int size;
	private int queue[] = new int[100];
	
	public MinHeap() {};
	
	public MinHeap(int[] values) {
		queue = values;
		size = values.length;
	}
	/** Inserts the specified element into the Heap
	 * 
	 * @param value
	 * @return
	 */
	public boolean add(int value) {
		int i = size;
		while (i > 0) {
			int parent = (i-1)/2; //Index of the parent value
			int p_val = queue[parent];
			if (value >= queue[parent]) { //If the value to insert is greater than the parent
				break;
			}
			queue[i] = p_val;
			i = parent;
		}
		queue[i] = value;
		size++;
		return true;
	}
	
	public int[] bubbleSort(int[] array) {
		int length = array.length; //The length of the array to sort
		for (int i = 0; i < length; i++) { //Check that EVERY ELEMENT is in the right place
			for (int j = i; j < length; j++) { //Compare every element with the elements in front of it
				if (array[i] > array[j]) {
					int temp = array[i]; //Make sure not to lose any data
					array[i] = array[j]; //Swap the two values
					array[j] = temp;
				}
			}
		}
		return array;
	}
	
	public int[] MaxHeap() {
		int start = (size/2) - 1; //Start with the parent of the last element
		//int[] target = bubbleSort(queue);
		for (int half = start; half >= 0;) {
			if ((2*half + 1 < size) && queue[half] < queue[2*half + 1]) { //If the parent is less than its left child
				if ((2*half + 2 < size) && queue[half] < queue[2*half + 2]) { //In the case the parent is less than both children
					if (queue[2*half + 1] > queue[2*half + 2]) { //If the left child is the greater of the two children
						int temp = queue[half]; //Preserve the parent value
						queue[half] = queue[2*half + 1];
						queue[2*half + 1] = temp;
						half = 2*half + 1; //More percolation may be necessary
						continue;
					}
					else if (queue[2*half + 2] > queue[2*half + 1]) { //If vice-versa
						int temp = queue[half]; //Preserve the parent value
						queue[half] = queue[2*half + 2];
						queue[2*half + 2] = temp;
						half = 2*half + 2; //More percolation may be necessary
						continue;
					}
				}
				//In the case that only the left child is greater
				int temp = queue[half];
				queue[half] = queue[2*half + 1];
				queue[2*half + 1] = temp;
				half = half/2; //Now move up one level
				continue; //At this point, one sort has been completed
			}
			if ((2*half + 2 < size) && queue[half] < queue[2*half + 2]) { //If the parent is less than its right child
				if ((2*half + 1 < size) && queue[half] < queue[2*half + 1]) { //In the case the parent is less than both children
					if (queue[2*half + 1] > queue[2*half + 2]) { //If the left child is the greater of the two children
						int temp = queue[half]; //Preserve the parent value
						queue[half] = queue[2*half + 1];
						queue[2*half + 1] = temp;
						half = 2*half + 1; //More percolation may be necessary
						continue;
					}
					else if (queue[2*half + 2] > queue[2*half + 1]) { //If vice-versa
						int temp = queue[half]; //Preserve the parent value
						queue[half] = queue[2*half + 2];
						queue[2*half + 2] = temp;
						half = 2*half + 2; //More percolation may be necessary
						continue;
					}
				}
				int temp = queue[half];
				queue[half] = queue[2*half + 2];
				queue[2*half + 2] = temp;
				half = half/2; //Now move up one level
				continue;
			}
			half = half/2; //If the section of the tree is already sorted, keep moving to the root
		}
		return queue;
	}
	
	public void heapSort() {
		//First make the queue a MaxHeap
		//Then start the delete & pop operations to sort the queue
		int[] maxHeap = MaxHeap(); //Turn the queue into a MaxHeap
	}
}
