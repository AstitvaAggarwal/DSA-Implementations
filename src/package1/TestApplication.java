package package1;

import java.util.Scanner;

public class TestApplication {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the capacity of the array you want : ");
		int var1 = Integer.parseInt(input.nextLine());

		sortingarray array1 = new sortingarray(var1);

		System.out.println("Do you want a randomnly initialised (Long -5 to Long 5) array ? ");
		System.out.println("Yes(y) || No(n) : ");
		char var2 = input.next().charAt(0);
		input.nextLine();

		if (var2 == 'y') {

			array1.initArray();
			array1.currentindex = array1.a.length - 1;

		} else if (var2 == 'n') {

			System.out.print("Enter the number of elements you want to enter in the array : ");
			array1.currentindex = Integer.parseInt(input.nextLine());
			array1.currentindex--;

			System.out.println("Enter the elements of the array : ");
			for (int i = 0; i < array1.currentindex + 1; i++) {
				array1.a[i] = Long.parseLong(input.nextLine());
			}

		} else {
			System.out.println("Wrong entry!");
		}

		array1.display();

		while (true) {
			System.out.println("Enter the operation u want to execute ");
			System.out.println("Enter i(insert)|d(delete)|D(duplicatedelete)|s(sort)|reset(r)");
			System.out.println("|f(findindex of given element)|p(display)|g(getElement by given index)");
			System.out.println("|L(perform linear search)|B(perform Binary search)|E(Exit program) :");
			System.out.println(
					"(NOTE-reset(r) reinitialises the entire array to random values between long -5 to long 5) :");
			var2 = input.next().charAt(0);
			input.nextLine();

			if (var2 == 'i') {

				System.out.print("Enter the element u want to insert : ");
				long var4 = Long.parseLong(input.nextLine());
				System.out.print("Do you want to enter at a particular position apart from end (Y/N) ? : ");
				char var3 = input.next().charAt(0);
				input.nextLine();

				if (var3 == 'Y') {

					System.out.println("Enter the index u want to enter the element :");
					int var5 = Integer.parseInt(input.nextLine());
					array1.insert(var5, var4);

				} else if (var3 == 'N') {

					array1.insert(var4);

				} else {

					System.out.println("WRONG VALUE ENTERED inserting at specified position BY DEFAULT");
					System.out.println("Enter the index u want to enter the element :");
					int var5 = Integer.parseInt(input.nextLine());
					array1.insert(var5, var4);

				}

			} else if (var2 == 'd') {

				System.out.println("Enter element u want to delete : ");
				long var4 = Long.parseLong(input.nextLine());
				array1.delete(var4);

			} else if (var2 == 'D') {

				System.out.println("Enter element who's duplicates u want deleted : ");
				long var4 = Long.parseLong(input.nextLine());
				System.out.println("Deleted " + array1.dupDelete(var4) + " occurences of " + var4);

			} else if (var2 == 'f') {

				System.out.println("Enter element u want to find : ");
				long var4 = Long.parseLong(input.nextLine());
				System.out.println("the desired element's index is : " + array1.find(var4));

			} else if (var2 == 'p') {

				array1.display();

			} else if (var2 == 'g') {

				System.out.println("Enter the index of the element which u want :");
				int var3 = Integer.parseInt(input.nextLine());

				if (array1.getElement(var3) == -1) {
					System.out.println("The index u entered is empty/unaccessible");
				} else {
					System.out.println("the element is : " + array1.getElement(var3));
				}

			} else if (var2 == 's') {

				System.out.println("Enter type of sorting bubble(b)|insertion(i)|selection(s) : ");
				char var4 = input.next().charAt(0);
				input.nextLine();

				if (var4 == 'b') {

					array1.bubblesort();

				} else if (var4 == 's') {

					array1.selectionsort();

				} else if (var4 == 'i') {

					array1.insertionsort();

				}
				System.out.println("The array is now sorted !");
			} else if (var2 == 'r') {
				array1.initArray();
			} else if (var2 == 'E') {
				break;
			} else {
				System.out.println("WRONG VALUE ENTERED CONTINUING BY DEFAULT");
			}
		}
		input.close();
		System.out.println("-----------THE PROGRAM HAS ENDED-----------");
	}
}
