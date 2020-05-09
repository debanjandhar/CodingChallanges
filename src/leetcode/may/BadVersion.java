package leetcode.may;

public class BadVersion {
	public int firstBadVersion(int n) {
		return getVersion(1, n);
	}

	private int getVersion(int start, int end) {
		if (start == end) {
			return start;
		}

		int mid = (int) (((long) start + (long) end) / 2l);
		if (isBadVersion(mid)) {
			return getVersion(start, mid);
		} else {
			return getVersion(mid + 1, end);
		}
	}

	private boolean isBadVersion(int num) {
		System.out.println("Called isBadVerion with num [" + num + "]");
		int n = 1702766719;
		if (num >= n) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int n = 2126753390;
		System.out.println(new BadVersion().firstBadVersion(n));
	}
}
