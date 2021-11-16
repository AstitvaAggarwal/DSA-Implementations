package package1;

public class MyLongArray {
	Long[] a;
	int currentindex = 0;

	MyLongArray(int size) {
		a = new Long[size];
	}

	int find(long searchkey) {
		int index = -1;
		for (int i = 0; i < currentindex; i++) {
			if (a[i] == searchkey) {
				index = i;
				break;
			}
		}
		return index;
	}

	void insert(long value) {
		if (currentindex < a.length - 1) {
			a[currentindex + 1] = value;
			currentindex++;
		} else {
			System.out.println("Since array is full replacing last element");
			a[currentindex] = value;
		}
	}

	long getElement(int index) {
		if (index <= currentindex) {
			return a[index];
		} else {
			return -1;
		}
	}

	boolean delete(long value) {
		int j = 0;
		int count = 0;
		Long[] a1 = new Long[currentindex + 1];
		for (int k = 0; k < currentindex + 1; k++) {
			if ((a[k] == value) && (count == 0)) {
				count++;
			} else {
				a1[j] = a[k];
				j++;
			}
		}
		for (int k = 0; k < currentindex + 1; k++) {
			a[k] = a1[k];
		}
		currentindex--;
		if (count == 0) {
			return false;
		} else {
			return true;
		}
	}

	void display() {
		System.out.println(": The Array is now : ");
		for (int i = 0; i < currentindex + 1; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.print("\n");
	}

	int dupDelete(long value) {
		int count = 0;
		int j = 0;
		Long[] a1 = new Long[currentindex + 1];
		for (int i = 0; i < currentindex + 1; i++) {
			if (a[i] == value) {
				count++;
			} else {
				a1[j] = a[i];
				j++;
			}
		}
		for (int i = 0; i < currentindex + 1 - count; i++) {
			a[i] = a1[i];
		}
		currentindex = currentindex - count;
		return count;
	}

	void insert(int index, long value) {
		if (currentindex < a.length - 1) {
			if (index == currentindex + 1) {
				a[currentindex + 1] = value;

			} else {

				Long[] a1 = new Long[currentindex + 2];
				for (int i = 0; i < currentindex + 1; i++) {
					if (i < index) {
						a1[i] = a[i];

					} else if (i == index) {

						a1[i] = value;
						a1[i + 1] = a[i];

					} else {
						a1[i + 1] = a[i];
					}
				}

				for (int i = 0; i < currentindex + 2; i++) {
					a[i] = a1[i];
				}
			}

			if (index <= currentindex + 1) {
				currentindex++;
			}

		} else {
			System.out.println("Cannot add more elements as array is full");
		}

	}

}