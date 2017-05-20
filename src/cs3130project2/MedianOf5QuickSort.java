package cs3130project2;

import java.util.Random;

public class MedianOf5QuickSort extends QuickSort {
	public MedianOf5QuickSort() {
		super();
		name = "Median of 5 Quick Sort";
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
		
		if (a.length <= 5) {
			insertionSort(a);
			return end;
		}
		
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
	
	private void insertionSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j > 0; j--) {
				numComparisons++;
				if (a[j] < a[j-1]) {
					swap(a, j, j - 1);
				}
			}
		}
	}
	
	private int getPivot(int[] arr, int min, int max) {
		int a = getRandomInt(min, max);
		int b = getRandomInt(min, max);
		int c = getRandomInt(min, max);
		int d = getRandomInt(min, max);
		int e = getRandomInt(min, max);
		
		int[] numbers = {arr[a], arr[b], arr[c], arr[d], arr[e]};
		return findMedian(numbers);
	}
	
	private int getRandomInt(int min, int max) {
		Random rand = new Random();
		return rand.nextInt((max - min) + 1) + min;
	}
	
	private int findMedian(int[] a) {
		numComparisons++;
		if (a[1] < a[0]) {
			swap(a, 1, 0);
		}
		
		numComparisons++;
		if (a[3] < a[2]) {
			swap(a, 3, 2);
		}
		
		// Eliminate lowest
		numComparisons++;
		if (a[2] < a[0]) {
			swap(a, 1, 3);
			a[2] = a[0];
		}
		
		a[0] = a[4];
		
		numComparisons++;
		if (a[1] < a[0]) {
			swap(a, 1, 0);
		}
		
		// Eliminate another lowest (Remaining: a, b, d)
		numComparisons++;
		if (a[0] < a[2]) {
			swap(a, 1, 3);
			a[0] = a[2];
		}
		
		numComparisons++;
		if (a[3] < a[0]) {
			return a[3];
		} else {
			return a[0];
		}
	}
}
