package Sorting;

public class Insertion_Sort {
	public void insertionSort(int[] array) {
		int length = array.length;
		for (int i = 0; i < length-1; i++) {
			int valueToCompare = array[i+1]; //This is the value that may or may not get moved around
			while ((i > -1) && array[i] > valueToCompare) { //If the value is greater than the one in front, swap the two values
				int temp = array[i];
				array[i] = array[i+1];
				array[i+1] = temp;
				i--; //Decrement to compare every value with the values before it
			}
		}
	}
}
