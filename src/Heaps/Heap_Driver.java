package Heaps;

public class Heap_Driver {
	
	public static void main(String[] args) {
		int[] values = {15,19,10,7,17,16};
		int[] result = new int[6];
		MinHeap Heap = new MinHeap(values); //Create a MinHeap from these values
		result = Heap.MaxHeap(); //Make the heap a MaxHeap
		printHeap(result);
	}
	
	public static void printHeap(int[] values) {
		for (int i = 0; i < values.length; i++) {
			System.out.println(values[i] + " ");
		}
	}
}
