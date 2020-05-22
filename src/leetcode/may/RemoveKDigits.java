package leetcode.may;

public class RemoveKDigits {

	public String removeKdigits(String num, int k) {

		if (num.length() == k) {
			return "0";
		}

		StringBuilder sb = new StringBuilder(num);

		int i = 0;
		for (int j = 0; j < k; j++) {
			while (i < sb.length() - 1 && sb.charAt(i) <= sb.charAt(i + 1)) {
				i++;
			}
			sb.delete(i, i + 1);
			if (i != 0) {
				i--;
			}
		}

		while (sb.length() > 1 && sb.charAt(0) == '0')
			sb.delete(0, 1);

		if (sb.length() == 0) {
			return "0";
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(new RemoveKDigits().removeKdigits("1432232", 3));
		System.out.println(new RemoveKDigits().removeKdigits("10200", 1));
		System.out.println(new RemoveKDigits().removeKdigits("1234", 3));
		System.out.println(new RemoveKDigits().removeKdigits("4321", 1));
		System.out.println(new RemoveKDigits().removeKdigits("112", 1));
		System.out.println(new RemoveKDigits().removeKdigits("5337", 2));
		System.out.println(new RemoveKDigits().removeKdigits("1173", 2));
		System.out.println(new RemoveKDigits().removeKdigits("11", 1));
	}

}
