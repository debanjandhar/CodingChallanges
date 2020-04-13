package projecteuler;

public class N3 {
	public static void main(String[] args) {

		System.out.println(largestPrime(600851475143l));
	}

	private static long largestPrime(long n) {
		long tmp = n;
		// Even multiple
		while (tmp % 2 == 0) {
			if (tmp == 1) {
				return 2;
			}
			tmp /= 2;
		}

		long i;
		for (i = 3; i <= (long) Math.sqrt(tmp); i++) {
			if (tmp % i == 0) {
				tmp /= i;
				i = 2;
			}
		}
		if (tmp > 2) {
			return tmp;
		} else {
			return i;
		}

	}
}
