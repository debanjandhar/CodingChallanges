package projecteuler;

public class N2 {
	private static long getFiboSum(int n) {
		long sum = 0;

		int first = 1;
		int second = 1;
		while (first < n) {
			if (first % 2 == 0) {
				sum += first;
			}

			int tmp = first + second;
			first = second;
			second = tmp;

		}

		return sum;
	}

	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		int t = in.nextInt();
//		for (int a0 = 0; a0 < t; a0++) {
//			long n = in.nextLong();
//
//		}

		System.out.println(getFiboSum(4000000));
	}
}
