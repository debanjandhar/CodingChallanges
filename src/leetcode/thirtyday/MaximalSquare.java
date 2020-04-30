package leetcode.thirtyday;

import java.util.Arrays;

public class MaximalSquare {
	public int maximalSquare(char[][] matrix) {
		int max = 0;

		if (matrix.length == 0 || matrix[0].length == 0) {
			return max;
		}

		int[][] subMatrix = new int[matrix.length][matrix[0].length];

		subMatrix[0][0] = Character.digit(matrix[0][0], 10);
		if (subMatrix[0][0] == 1) {
			max = 1;
		}

		for (int i = 1; i < matrix.length; i++) {
			subMatrix[i][0] = Character.digit(matrix[i][0], 10);
			if (subMatrix[i][0] == 1) {
				max = 1;
			}
		}

		for (int i = 1; i < matrix[0].length; i++) {
			subMatrix[0][i] = Character.digit(matrix[0][i], 10);
			if (subMatrix[0][i] == 1) {
				max = 1;
			}
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == '1') {
					subMatrix[i][j] = min(subMatrix[i - 1][j], subMatrix[i - 1][j - 1], subMatrix[i][j - 1]) + 1;
				} else {
					subMatrix[i][j] = 0;
				}

				if (subMatrix[i][j] > max) {
					max = subMatrix[i][j];
				}
			}
		}

		for (int[] is : subMatrix) {
			System.out.println(Arrays.toString(is));
		}

		return max * max;
	}

	private int min(int a, int b, int c) {
		if (a < b) {
			return a < c ? a : c;
		} else {
			return b < c ? b : c;
		}
	}

	public static void main(String[] args) {
//		char[][] matrix = new char[][] { { '1', '0', '1', '1', '0' }, { '1', '0', '1', '1', '1' },
//				{ '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' } };
		char[][] matrix = new char[][] { { '0', '1' } };
		System.out.println(new MaximalSquare().maximalSquare(matrix));
	}
}
