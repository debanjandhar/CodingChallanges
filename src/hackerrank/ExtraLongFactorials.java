package hackerrank;
import java.math.BigInteger;

public class ExtraLongFactorials {

	// Complete the extraLongFactorials function below.
	static void extraLongFactorials(int n) {
		BigInteger result = new BigInteger("1");
		for (int i = n; i > 0; i--) {
			result = new BigInteger(Integer.toString(i)).multiply(result);

		}

		System.out.println(result);

	}

	public static void main(String[] args) {
		extraLongFactorials(25);

	}
}
