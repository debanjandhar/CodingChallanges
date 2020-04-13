package hackerrank;
import java.io.IOException;

public class HourGlass {

	// Complete the hourglassSum function below.
	static int hourglassSum(int[][] arr) {
		int maxHG = Integer.MIN_VALUE;

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int currSum = calcHourGlassSum(arr, i, j);
				if (currSum > maxHG) {
					maxHG = currSum;
				}
			}
		}

		return maxHG;
	}

	private static int calcHourGlassSum(int[][] arr, int row, int col) {
		int[][] hourGlasCoordinates = { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 1 }, { 2, 0 }, { 2, 1 }, { 2, 2 } };
		int hourGlassSum = 0;

		for (int i = 0; i < hourGlasCoordinates.length; i++) {
			hourGlassSum += arr[row + hourGlasCoordinates[i][0]][col + hourGlasCoordinates[i][1]];
		}

		return hourGlassSum;
	}

	public static void main(String[] args) throws IOException {
//		int[][] arr = new int[][] { { 1, 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 0, 0 }, { 1, 1, 1, 0, 0, 0 },
//				{ 0, 0, 2, 4, 4, 0 }, { 0, 0, 0, 2, 0, 0 }, { 0, 0, 1, 2, 4, 0 } };
		int[][] arr = new int[][] { { -9, -9, -9, 1, 1, 1 }, { 0, -9, 0, 4, 3, 2 }, { -9, -9, -9, 1, 2, 3 },
				{ 0, 0, 8, 6, 6, 0 }, { 0, 0, 0, -2, 0, 0 }, { 0, 0, 1, 2, 4, 0 } };

		System.out.println(hourglassSum(arr));
	}
}
