package Sorting;

public class Sort_Driver {
	
	public static void main(String[] args) {
		int[] array_to_sort = {8, 5, 45, 32, -12, 16, -12};
		Bubble_Sort bubbleSorter = new Bubble_Sort();
		Merge_Sort mergeSorter = new Merge_Sort();
		Insertion_Sort insertSorter = new Insertion_Sort();
		
		bubbleSorter.bubbleSort(array_to_sort);
		printArray(array_to_sort);
		
		int[] array_to_mergeSort = {8, 5, 45, 32, -12, 16, -12};
		mergeSorter.partitionArray(0, array_to_mergeSort.length-1, array_to_mergeSort); //Perform the merge sort
		printArray(array_to_mergeSort); //Look at more closely
		
		int[] array_to_insertionSort = {8, 5, 45, 32, -12, 16, -12};
		insertSorter.insertionSort(array_to_insertionSort);
		printArray(array_to_insertionSort); //Maybe look at again, to be clear
	}
	
	public static void printArray(int[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("");
	}
}
