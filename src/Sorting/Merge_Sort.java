package Sorting;

public class Merge_Sort {
	private int[] tempMergeArray = new int[27]; //Create a new array of 27 values
	
	public void partitionArray(int startIndex, int lastIndex, int[] array) {
		if (startIndex < lastIndex) { //If the start index is lower than the last one, there are elements to sort
			int middle = (lastIndex + startIndex)/2; //This is the middle of the array
			partitionArray(startIndex, middle, array); //Keep partitioning the left side
			partitionArray(middle+1, lastIndex, array); //Now keep partitioning the right side
			mergePartitions(startIndex, middle, lastIndex, array); //Now merge all the partitions
		}
	}
	
	public void mergePartitions(int startIndex, int middle, int lastIndex, int[] array) {
		for (int i = startIndex; i <= lastIndex; i++) {
            tempMergeArray[i] = array[i];
        }
        int i = startIndex;
        int j = middle + 1;
        int k = startIndex;
        while (i <= middle && j <= lastIndex) {
            if (tempMergeArray[i] <= tempMergeArray[j]) {
                array[k] = tempMergeArray[i];
                i++;
            } else {
                array[k] = tempMergeArray[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergeArray[i];
            k++;
            i++;
        }
	}
}
