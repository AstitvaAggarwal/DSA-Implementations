package algorithms;

public class OperationLinearSearch {
	int[] arr;
	int currentindex;

	void delete(int val) {
		int index = LinearSearch(val);
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

	int LinearSearch(int val) {
		int index = -1;
		for (int i = 0; i < currentindex + 1; i++) {
			if (arr[i] == val) {
				index = i;
				break;
			}
		}
		return index;
	}

	void display() {
		for (int i = 0; i < currentindex + 1; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println(" ");
	}

	public static void main(String[] args) {
		OperationLinearSearch test = new OperationLinearSearch();
		test.arr = new int[] { 1, 2, 2, 4, 5, 6, 74, 4, 1 };
		test.currentindex = test.arr.length - 1;
		System.out.println("The Array is now :");
		test.display();
		System.out.println("Deleting all duplicates of 4 within Array:");
		test.dupDelete(4);
		System.out.println("The Array is now :");
		test.display();
		System.out.println("The position/index of 74 in Array got by using Linear Search is :");
		System.out.println((test.LinearSearch(74) == -1) ? null : test.LinearSearch(74));
		System.out.println("Deleting 74 from Array :");
		test.delete(74);
		System.out.println("The Array is now :");
		test.display();
		System.out.println("The position/index of 74 in Array got by using Linear Search is :");
		System.out.println((test.LinearSearch(74) == -1) ? null : test.LinearSearch(74));
		System.out.println("Inserting 34234 in the Array at index number 5 :");
		test.insert(34234, 5);
		System.out.println("The Array is now :");
		test.display();

	}
}
