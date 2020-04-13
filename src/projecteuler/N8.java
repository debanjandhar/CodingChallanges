package projecteuler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N8 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numTestCases = Integer.parseInt(br.readLine());

		for (int i = 0; i < numTestCases; i++) {
			String[] input = br.readLine().split(" ");
			String num = br.readLine();

			int startIndex = 0;
			char[] c = num.toCharArray();
			long max = Long.MIN_VALUE, product = 1;
			for (int endIndex = 0; endIndex < c.length; endIndex++) {
				int tmp = Character.digit(c[endIndex], 10);

				if ((endIndex - startIndex) > Integer.parseInt(input[1]) - 1) {
					int removeNum = Character.digit(num.charAt(startIndex), 10);
					startIndex++;

					if (removeNum == 0) {
						product = 1;
						for (int j = startIndex; j < endIndex; j++) {
							product *= Character.digit(num.charAt(j), 10);
						}
					} else {
						product /= removeNum;
					}
				}

				product *= tmp;

				if (product > max && (endIndex - startIndex) == Integer.parseInt(input[1]) - 1) {
					max = product;
				}

			}

			System.out.println(max);
		}
	}
}
