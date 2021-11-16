package package1;

import java.util.Random;

public class sortingarray extends MyLongArray {

	public sortingarray(int var1) {
		super(var1); // TODO Auto-generated constructor stub
	}

	void initArray() {
		Random rd = new Random(); // Created a random object
		for (int i = 0; i < a.length; i++) {
			int k = rd.nextInt(11) - 5; // generating random values only between -5 and 5
			a[i] = (long) k;
		}
	}

	void bubblesort() {
		for (int i = currentindex; i > 1; i--) {
			for (int j = 0; j < i; j++) {
				if (a[j] > a[j + 1]) {
					Long temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}

	void selectionsort() {
		for (int i = 0; i < currentindex; i++) {
			int imin = i;
			for (int j = i + 1; j < currentindex + 1; j++) {
				if (a[j] < a[imin]) {
					imin = j;
				}
			}
			if (imin != i) {
				Long temp = a[imin];
				a[imin] = a[i];
				a[i] = temp;
			}
		}
	}

	void insertionsort() {
		for (int i = 1; i < currentindex + 1; i++) {
			int j = i;
			while (j > 0 && a[j - 1] > a[j]) {
				Long temp = a[j - 1];
				a[j - 1] = a[j];
				a[j] = temp;
				j--;
			}

		}
	}
}
