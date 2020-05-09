package hackerrank;

import java.text.ParseException;

public class Test {
	public static void main(String[] args) throws ParseException {
		int num = 1;
		for (int i = 0; i < 100; i++) {
			System.out.println(num << i);
		}
	}
}
