package customlogics;

public class Pallindrome {

	public static void main(String[] args) {
		int count = 10;
		for (int i = 809908;;i++) {
			
			if (isPallindrome(i)) {
				System.out.println(i);
				if (count-- == 0) {
					break;
				}
			}
		}
	}

	private static boolean isPallindrome(int n) {
		String nStr = String.valueOf(n);
		int i = 0;
		while (nStr.charAt(i) == nStr.charAt(nStr.length() - 1 - i) && i <= nStr.length() / 2) {
			i++;
		}

		if (i > nStr.length()/2) {
			return true;
		}else {
			return false;
		}
	}

}
