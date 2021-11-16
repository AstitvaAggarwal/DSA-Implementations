package algorithms;

public class OperationBinarysearch {
	int[] arr;
	int currentindex;

	void delete(int val) {
		int index = BinarySearch(val);
		if (index != -1) {
			for (int i = index; i < currentindex; i++) {
				arr[i] = arr[i + 1];
			}
		} else {
			System.out.println(val + " dosent exist in Array !");
		}

		currentindex--;
	}

	void insert(int val, int pos) {
		if (pos < currentindex + 1) {
			int[] arr0 = new int[currentindex + 2];
			for (int i = 0; i < pos; i++) {
				arr0[i] = arr[i];
			}
			for (int i = pos + 1; i < arr0.length; i++) {
				arr0[i] = arr[i - 1];
			}
			arr0[pos] = val;
			arr = arr0;
		} else {
			System.out.println("Cannot enter in " + pos + " th position !");
		}
		currentindex++;
	}

	int dupDelete(int value) {
		int count = 0;
		int j = 0;
		for (int i = 0; i < currentindex + 1; i++) {
			if (arr[i] == value) {
				count++;
			}
		}

		int[] a1 = new int[currentindex - count + 1];

		for (int i = 0; i < currentindex + 1; i++) {
			if (arr[i] != value) {
				a1[j] = arr[i];
				j++;
			}
		}
		currentindex = currentindex - count;

		arr = a1;
		return count;
	}

	int BinarySearch(int val) {

		// sort using selection sort
		int imin;
		for (int i = 0; i < currentindex; i++) {
			imin = i;
			for (int j = i + 1; j < currentindex + 1; j++) {
				if (arr[imin] > arr[j]) {
					imin = j;
				}
			}
			if (imin != i) {
				int temp = arr[imin];
				arr[imin] = arr[i];
				arr[i] = temp;
			}
		}

		// sorting finished
		System.out.println(": The Array :");
		display();
		System.out.println("The positon : ");

		// Carry out binary search
		int high = currentindex;
		int low = 0;
		while (low <= high) {
			int mid = (low + high) / 2;

			if (val < arr[mid]) {
				high = mid - 1;

			} else if (val > arr[mid]) {
				low = mid + 1;

			} else {
				return mid;
			}
		}
		// binary search ended

		return -1;
	}

	void display() {
		for (int i = 0; i < currentindex + 1; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println(" ");
	}

	public static void main(String[] args) {
		OperationBinarysearch test = new OperationBinarysearch();
		test.arr = new int[] { 1, 2, 2, 4, 5, 6, 74, 4, 1 };
		test.currentindex = test.arr.length - 1;
		System.out.println("The Array is now :");
		test.display();
		System.out.println("Deleting all duplicates of 4 within Array:");
		test.dupDelete(4);
		System.out.println("The Array is now :");
		test.display();
		System.out.println("The position/index of 74 in Array got by using Binary Search (sorted array) is :");
		System.out.println(test.BinarySearch(74));
		System.out.println("Deleting 74 from Array :");
		test.delete(74);
		System.out.println("The Array is now :");
		test.display();
		System.out.println("The position/index of 74 in Array got by using Binary Search (sorted array) is :");
		System.out.println((test.BinarySearch(74) == -1) ? null : test.BinarySearch(74));
		System.out.println("Inserting 34234 in the Array at index number 5 :");
		test.insert(34234, 5);
		System.out.println("The Array is now :");
		test.display();
	}
}
