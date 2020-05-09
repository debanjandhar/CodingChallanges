package leetcode.may;

public class Sqrt {

	public boolean isPerfectSquare(int num) {
		return isSquare(1, num, num);
	}

	private boolean isSquare(int start, int end, int target) {
		if (start == end) {
			if (square(start) == target) {
				return true;
			} else {
				return false;
			}
		}

		int mid = start + ((end - start) / 2);
		if (square(mid) < target) {
			return isSquare(mid + 1, end, target);
		} else {
			return isSquare(start, mid, target);
		}
	}

	private long square(int n) {
		return (long)n * (long)n;
	}

	public static void main(String[] args) {
		System.out.println(new Sqrt().isPerfectSquare(808201));
	}

}
