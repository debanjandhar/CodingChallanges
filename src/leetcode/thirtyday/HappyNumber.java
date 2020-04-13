package leetcode.thirtyday;

public class HappyNumber {
	public boolean isHappy(int n) {
		while (n != 1) {
			System.out.println(n);
			int sum = 0;
			while (n != 0) {
				int lastDgt = n % 10;
				sum += lastDgt * lastDgt;
				n /= 10;
			}
			n = sum;
			if (n == 4) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(new HappyNumber().isHappy(121));
	}
}
