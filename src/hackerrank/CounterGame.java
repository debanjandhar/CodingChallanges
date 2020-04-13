package hackerrank;
import java.io.IOException;

public class CounterGame {

	// Complete the counterGame function below.
	static String counterGame(long n) {
		String zero = "Louise";
		String one = "Richard";

		int zeroFl = 1;

		while (n != 1) {
			zeroFl = (zeroFl + 1) % 2;
			if (isPowerOf2(n)) {
				n /= 2;
			} else {
				long nextLowerNum = getLowerNumPowOf2(n);
				n -= nextLowerNum;
			}
		}

		if (zeroFl == 0) {
			return zero;
		} else {
			return one;
		}
	}

	private static boolean isPowerOf2(long n) {
		return n > 1 && ((n & (n - 1)) == 0);
	}

	private static long getLowerNumPowOf2(long n) {
		long num = 0;
		int counter = 1;
		while (true) {
			long currNum = 1l << counter++;

			if (currNum > n) {
				break;
			}

			num = currNum;
		}

		return num;
	}

	public static void main(String[] args) throws IOException {

//		System.out.println(counterGame(6));
//		System.out.println(counterGame(1560834904));
//		System.out.println(counterGame(1768820483));
		System.out.println(counterGame(1533726144));
//		System.out.println(counterGame(1620434450));
//		System.out.println(counterGame(1463674015));
	}
}
