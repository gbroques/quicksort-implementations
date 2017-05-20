package cs3130project2;

public class Main {
	
	public static final int SIZE = 1000;

	public static void main(String[] args) {
		int[] randomData = generateRandomData(1, SIZE);
		int[] ascData = generateAscData(1, SIZE);
		int[] descData = generateDescData(1, SIZE);
		printHeading("Unsorted Data");
		displayData(randomData);

		QuickSort[] quickSortImplementations = new QuickSort[4];
		quickSortImplementations[0] = new QuickSort();
		quickSortImplementations[1] = new RandomizedQuickSort();
		quickSortImplementations[2] = new MedianOf3QuickSort();
		quickSortImplementations[3] = new MedianOf5QuickSort();

		for (QuickSort quickSort : quickSortImplementations) {
			int[] sortedData = quickSort.sort(randomData);
			printHeading("Random Data");
			quickSort.displayStats();
			displayData(sortedData);
		}

		for (QuickSort quickSort : quickSortImplementations) {
			int[] sortedData = quickSort.sort(ascData);
			printHeading("Ascending Data");
			quickSort.displayStats();
			displayData(sortedData);
		}
		
		for (QuickSort quickSort : quickSortImplementations) {
			int[] sortedData = quickSort.sort(descData);
			printHeading("Descending Data");
			quickSort.displayStats();
			displayData(sortedData);
		}
		
	}
	
	public static void printHeading(String title) {
		for (int i = 0; i < title.length() + 4; i++) {
			System.out.print("*");
		}
		System.out.println("");
		System.out.println("* " + title + " *");
		for (int i = 0; i < title.length() + 4; i++) {
			System.out.print("*");
		}
		printLineBreak();					
	}
	
	public static void printLineBreak() {
		System.out.println(System.getProperty("line.separator"));
	}
	
	/**
	 * Generates an array of random numbers from
	 * a lower bound to an upper bound inclusive.
	 * 
	 * @param lower Lower Bound
	 * @param upper Upper Bound
	 * @return Array of randomly generated numbers
	 */
	public static int[] generateRandomData(int lower, int upper) {
		int[] data = new int[upper];
		for (int i = 0; i < upper; i++) {
			data[i] = lower + (int) (Math.random() * (upper - lower + 1));
		}
		return data;
	}
	
	public static int[] generateAscData(int lower, int upper) {
		int [] data = new int[upper];
		for (int i = 0; i < upper; i++) {
			data[i] = lower + i;
		}
		return data;
	}
	
	public static int[] generateDescData(int lower, int upper) {
		int [] data = new int[upper];
		for (int i = 0; i < upper; i++) {
			data[i] = upper - i;
		}
		return data;
	}
	
	/**
	 * Displays a comma separated list of data,
	 * with new lines every 20 elements.
	 * @param data
	 */
	public static void displayData(int[] data) {
		for (int i = 0, len = data.length; i < len; i++) {
			if (i % 20 == 0 && i != 0) {
				System.out.print(System.getProperty("line.separator"));
			}
			System.out.printf("%-4d", data[i]);
		}
		printLineBreak();
	}
}