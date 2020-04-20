package leetcode.thirtyday;

import java.util.Arrays;

public class MinimumSubPath {
	public int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] totalCost = new int[m][n];

		totalCost[0][0] = grid[0][0];

		for (int i = 1; i < m; i++) {
			totalCost[i][0] = totalCost[i - 1][0] + grid[i][0];
		}

		for (int i = 1; i < n; i++) {
			totalCost[0][i] = totalCost[0][i - 1] + grid[0][i];
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				int tempSum = 0;
				if (totalCost[i - 1][j] > totalCost[i][j - 1]) {
					tempSum = totalCost[i][j - 1];
				} else {
					tempSum = totalCost[i - 1][j];
				}

				totalCost[i][j] = tempSum + grid[i][j];
			}
		}

		for (int[] is : totalCost) {
			System.out.println(Arrays.toString(is));
		}

		return totalCost[m - 1][n - 1];
	}

	public static void main(String[] args) {

//		int[][] grid = new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
//		int[][] grid = new int[][] { { 1, 2 }, { 1, 1 } };
//		int[][] grid = new int[][] { { 1, 2 }, { 1, 1 } };

		int[][] grid = new int[][] { { 1, 4, 8, 6, 2, 2, 1, 7 }, { 4, 7, 3, 1, 4, 5, 5, 1 }, { 8, 8, 2, 1, 1, 8, 0, 1 },
				{ 8, 9, 2, 9, 8, 0, 8, 9 }, { 5, 7, 5, 7, 1, 8, 5, 5 }, { 7, 0, 9, 4, 5, 6, 5, 6 },
				{ 4, 9, 9, 7, 9, 1, 9, 0 } };
		System.out.println(new MinimumSubPath().minPathSum(grid));
	}
}
