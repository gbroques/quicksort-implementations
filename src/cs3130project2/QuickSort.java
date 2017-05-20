package cs3130project2;

import java.text.NumberFormat;

public class QuickSort {
	protected int numComparisons;
	protected int numSwaps;
	protected long runningTime;
	protected String name;
	
	public QuickSort() {
		numComparisons = 0;
		numSwaps = 0;
		runningTime = 0;
		name = "Original Quick Sort";
	}
	
	public int[] sort(int[] a) {
		int len = a.length;
		int[] copy = new int[len];
		System.arraycopy(a, 0, copy, 0, len);
		long startTime = System.nanoTime();
		quickSort(copy, 0, len - 1);
		long endTime = System.nanoTime();
		runningTime = (endTime - startTime);
		return copy;
	}

	protected void quickSort(int[] a, int start, int end) {
		if (start >= end) {
			return;
		}
		
		int partitionIndex = partition(a, start, end);
		quickSort(a, start, partitionIndex - 1);
		quickSort(a, partitionIndex + 1, end);
	}

	protected int partition(int[] a, int start, int end) {
		int pivot = a[end];
		int partitionIndex = start;
		
		for (int i = start; i < end; i++) {
			numComparisons++;
			if (a[i] <= pivot) {
				swap(a, i, partitionIndex);
				partitionIndex++;
			}
		}
		
		swap(a, partitionIndex, end);
		return partitionIndex;
	}
	
	protected void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
		numSwaps++;
	}
	
	public int getNumComparisons() {
		return numComparisons;
	}
	
	public int getNumSwaps() {
		return numSwaps;
	}
	
	public long getRunningTime() {
		return runningTime;
	}
	
	public void displayStats() {
		String runningTime = NumberFormat.getInstance().format(getRunningTime());
		String numComparisons = NumberFormat.getInstance().format(getNumComparisons());
		String numSwaps = NumberFormat.getInstance().format(getNumSwaps());
		System.out.println(name);
		System.out.println("Running Time: " + runningTime + " ns");
		System.out.println("Number of Comparisons: " + numComparisons);
		System.out.println("Number of Swaps: " + numSwaps);
		System.out.println();
	}
	
	public String getName() {
		return name;
	}
}
