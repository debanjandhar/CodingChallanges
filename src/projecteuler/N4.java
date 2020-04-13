package projecteuler;

import java.io.IOException;

public class N4 {
	private static int generatePallindromes(int n) {
		int max = 0;

		if (isPallindrome(n)) {
			return n;
		}
		for (int i = 100; i < 1000; i++) {
			// since first largest pallindrome is 101101(143*707)
			for (int j = 100000 / i + 1; j < 1000; j++) {
				int curr = i * j;
				if (isPallindrome(curr) && curr <= n) {
					System.out.println(curr + ", " + max);
					if (curr >= max) {
						max = curr;
					}
				}
			}
		}

		return max;
	}

	private static boolean isPallindrome(int n) {
		String nStr = String.valueOf(n);
		int i = 0;
		while (nStr.charAt(i) == nStr.charAt(nStr.length() - 1 - i) && i <= nStr.length() / 2) {
			i++;
		}

		if (i > nStr.length() / 2) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		int numTestCases = Integer.parseInt(br.readLine());
//		for (int i = 0; i < numTestCases; i++) {
//			String inputNumber = br.readLine();
//			System.out.println(generatePallindromes(Integer.parseInt(inputNumber)));
//		}

		System.out.println(generatePallindromes(553355));
	}
}
