package IntegerToBinaryConverter;

import java.lang.Math;
import java.util.Scanner;

public class IntegerToBinary {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.println("Enter the Integer you want to convert to binary :");
			int number = Integer.parseInt(input.nextLine());
			int limit = (int) Math.ceil(Math.log(number) / Math.log(2));
			Stackprocess<Integer> stack = new Stackprocess<Integer>(limit + 1);
			while (number != 0) {
				int temp = number % 2;
				stack.push(temp);
				number /= 2;
			}
			System.out.println("Entered Number in Binary format is : ");
			while (!stack.isEmpty()) {
				System.out.print(stack.pop() + " ");
			}
			System.out.println("\nDo you want to continue ? (Yes(1) or No(any other integer)): ");
			if (Integer.parseInt(input.nextLine()) != 1) {
				break;
			}
		}
		System.out.println("---------Program has Ended---------");
		input.close();
	}
}