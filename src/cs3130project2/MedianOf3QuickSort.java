package cs3130project2;

import java.util.Random;

public class MedianOf3QuickSort extends QuickSort {
	public MedianOf3QuickSort() {
		super();
		name = "Median of 3 Quick Sort";
	}

	@Override
	protected void quickSort(int[] a, int start, int end) {
		int partitionIndex = partition(a, start, end);
		if (start < partitionIndex - 1) {
			quickSort(a, start, partitionIndex - 1);
		}
		if (partitionIndex < end) {
			quickSort(a, partitionIndex, end);
		}
	}

	@Override
	protected int partition(int[] a, int start, int end) {
		int i = start, j = end;
		int pivot = getPivot(a, start, end);
		
		while (i <= j) {
			numComparisons++;
			while (a[i] < pivot) {
				i++;
				numComparisons++;
			}
			numComparisons++;
			while(a[j] > pivot) {
				j--;
				numComparisons++;
			}
			if (i <= j) {
				swap(a, i, j);
				i++;
				j--;
			}
		}
		return i;
	}
	
	private int getPivot(int[] arr, int min, int max) {
		int a = getRandomInt(min, max);
		int b = getRandomInt(min, max);
		int c = getRandomInt(min, max);
		return findMedian(arr[a], arr[b], arr[c]);
	}
	
	private int getRandomInt(int min, int max) {
		Random rand = new Random();
		return rand.nextInt((max - min) + 1) + min;
	}
	
	private int findMedian(int a, int b, int c) {
		if (a > b) {
			numComparisons++;
			if (b > c) {
				numComparisons++;
				return b;
			} else if (a > c) {
				numComparisons += 2;
				return c;
			} else {
				numComparisons += 2;
				return a;
			}
		} else {
			numComparisons++;
			if (a > c) {
				numComparisons++;
				return a;
			} else if (b > c) {
				numComparisons += 2;
				return c;
			} else {
				numComparisons += 2;
				return b;
			}
		}
	}
}
