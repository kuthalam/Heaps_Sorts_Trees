package Sorting;

public class Bubble_Sort {
	public void bubbleSort(int[] array) {
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
	}
}
