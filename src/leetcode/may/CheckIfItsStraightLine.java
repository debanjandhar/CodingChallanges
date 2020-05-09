package leetcode.may;

public class CheckIfItsStraightLine {

	public boolean checkStraightLine(int[][] coordinates) {
		boolean isSl = true;

		double prevSlope = -1;
		for (int i = 1; i < coordinates.length; i++) {
			double x = Math.abs(coordinates[i][0] - coordinates[i - 1][0]);
			double y = Math.abs(coordinates[i][1] - coordinates[i - 1][1]);

			double currSlope = y / x;
			if (prevSlope == -1) {
				prevSlope = currSlope;
			} else if (prevSlope != currSlope) {
				isSl = false;
				break;
			}
		}

		return isSl;
	}

	public static void main(String[] args) {
//		int[][] coordinates = new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 6, 7 } };
//		int[][] coordinates = new int[][] { { 1, 1 }, { 2, 2 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 7, 7 } };
		int[][] coordinates = new int[][] { { -4, -3 }, { 1, 0 }, { 3, -1 }, { 0, -1 }, { -5, 2 } };
		System.out.println(new CheckIfItsStraightLine().checkStraightLine(coordinates));
	}

}
