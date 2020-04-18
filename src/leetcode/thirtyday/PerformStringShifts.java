package leetcode.thirtyday;

public class PerformStringShifts {
	public String stringShift(String s, int[][] shift) {
		int startIndex = 0;
		for (int[] is : shift) {
			int dir = is[0];
			int shiftBy = is[1];

			switch (dir) {
			case 0:
				startIndex = (startIndex + shiftBy) % s.length();
				break;
			case 1:
				for (int i = 0; i < shiftBy; i++) {
					startIndex = startIndex == 0 ? s.length() - 1 : --startIndex;
				}
			}
		}
		String retString = "";
		int index = startIndex;
		do {
			retString += s.charAt(index);
			index = (index + 1) % s.length();
		} while (index != startIndex);

		return retString;
	}

	public static void main(String[] args) {
//		int[][] shift = new int[][] { { 0, 1 }, { 1, 2 } };
//		String s = "abc";
		int[][] shift = new int[][] { { 1, 1 }, { 1, 1 }, { 0, 2 }, { 1, 3 } };
		String s = "abcdefg";

		System.out.println(new PerformStringShifts().stringShift(s, shift));
	}
}
