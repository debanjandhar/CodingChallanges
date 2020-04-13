package projecteuler;

public class SmallestPrime {

	public static void main(String[] args) {
		long n = 20;

		for (long i = n;; i += n) {
			boolean found = true;
			for (long j = 2; j <= n; j++) {
				if (i % j != 0) {
					found = false;
					break;
				}
			}
			
			if (found) {
				System.out.println(i);
				break;
			}
		}

	}
}
