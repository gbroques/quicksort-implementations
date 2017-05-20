package cs3130project2;

import java.util.Random;

public class RandomizedQuickSort extends QuickSort {

	public RandomizedQuickSort() {
		super();
		name = "Randomized Quick Sort";
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
		int pivotIndex = getPivotIndex(a, start, end);
		int pivot = a[pivotIndex];
		
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
	
	private int getPivotIndex(int[] a, int min, int max) {
		Random rand = new Random();
		return rand.nextInt((max - min) + 1) + min;
	}
}
