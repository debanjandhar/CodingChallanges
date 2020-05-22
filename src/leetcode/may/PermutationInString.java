package leetcode.may;

public class PermutationInString {

	public boolean checkInclusion(String s1, String s2) {
		boolean isPresent = false;
		if (s1.length() == 0 || s2.length() == 0 || s1.length() > s2.length()) {
			return isPresent;
		}

		int[] s1Count = new int[26];
		int[] s2Count = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			s1Count[getIndex(s1.charAt(i))]++;
		}

		for (int i = 0; i < s1.length(); i++) {
			s2Count[getIndex(s2.charAt(i))]++;
			if (isFirstInSecond(s1Count, s2Count)) {
				return true;
			}
		}

		for (int i = s1.length(); i < s2.length(); i++) {
			s2Count[getIndex(s2.charAt(i))]++;
			s2Count[getIndex(s2.charAt(i - s1.length()))]--;
			
			if (isFirstInSecond(s1Count, s2Count)) {
				isPresent = true;
				break;
			}
		}

		return isPresent;

	}

	private boolean isFirstInSecond(int[] first, int[] second) {
		for (int i = 0; i < 26; i++) {
			if (first[i] != second[i]) {
				return false;
			}
		}

		return true;
	}

	private int getIndex(char c) {
		return c - 'a';
	}

	public static void main(String[] args) {
		System.out.println(new PermutationInString().checkInclusion("abc", "eidbaooo"));
	}

}
