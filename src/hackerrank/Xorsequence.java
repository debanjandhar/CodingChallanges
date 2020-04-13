package hackerrank;
import java.io.IOException;

public class Xorsequence {

	// Complete the xorSequence function below.
	static long xorSequence(long l, long r) {
		return getXorValue(l-1)^getXorValue(r);
	}

	private static long getXorValue(long num) {
		long out = num % 8;
		
		if (out == 0 || out == 1) {
			return num;
		} else if (out == 2 || out == 3) {
			return 2l;
		} else if (out == 4 || out == 5) {
			return num + 2;
		} else {
			return 0l;
		}
	}

	public static void main(String[] args) throws IOException {

		System.out.println(xorSequence(1, 4));
		System.out.println(xorSequence(2, 4));
		System.out.println(xorSequence(2, 8));
		System.out.println(xorSequence(5, 9));
		System.out.println(xorSequence(81933645, 201678107));
	}
}
