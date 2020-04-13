package hackerrank;
import java.util.Scanner;

public class BinaryNumbers {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = 5;

		String binaryStr = Integer.toBinaryString(n);

		System.out.println(binaryStr);

		char prevChar = ' ';
		int count = 0;
		int maxCount = Integer.MIN_VALUE;
		for (int c = 0; c < binaryStr.length(); c++) {
			char currChar = binaryStr.charAt(c);
			if (currChar == '1' && currChar == prevChar) {
				count++;
			} else if (currChar == '1') {
				count = 1;
			} else {
				count = 0;
			}
			if (count > maxCount) {
				maxCount = count;
			}
			prevChar = currChar;
		}

		System.out.println(maxCount);
	}
}
