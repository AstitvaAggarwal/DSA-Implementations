package algorithms;

public class sortings1 {

	public void insertionsort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int j = i;
			while (j > 0 && array[j - 1] > array[j]) {
				int temp = array[j - 1];
				array[j - 1] = array[j];
				array[j] = temp;
				j--;
			}

		}
	}

	public void selectionsort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int imin = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[imin]) {
					imin = j;
				}
			}
			if (imin != i) {
				int temp1 = array[i];
				array[i] = array[imin];
				array[imin] = temp1;
			}
		}
	}

	public void bubbleSort(int[] array) {
		for (int i = array.length - 1; i > 1; i--) {
			for (int j = 0; j < i; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;
				}
			}
		}

	}

	public static void main(String[] args) {
		int array[] = { 2, 43, 75, 1, 5, 6, 86, 0, 54, 3, 6, 7, 342, 3, 6 };
		sortings1 pog = new sortings1();
		long startime = System.currentTimeMillis();
		// pog.insertionsort(pog.array);
		// pog.selectionsort(pog.array);
		pog.bubbleSort(array);
		long endtime = System.currentTimeMillis();
		long time = endtime - startime;
		System.out.println(startime);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("\n" + endtime);
		System.out.printf("time taken is : %d", time);
	}
}
