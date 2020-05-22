package leetcode.may;

public class CountSquareSubmatricesWithAllOnes {

	public int countSquares(int[][] matrix) {
		int numSquares = 0;
		if (matrix.length == 0) {
			return 0;
		}

		int[][] sumMatrix = new int[matrix.length][matrix[0].length];

		sumMatrix[0][0] = matrix[0][0];
		if (sumMatrix[0][0] == 1) {
			numSquares++;
		}

		for (int i = 1; i < matrix.length; i++) {
			sumMatrix[i][0] = matrix[i][0];
			if (sumMatrix[i][0] == 1) {
				numSquares++;
			}
		}

		for (int i = 1; i < matrix[0].length; i++) {
			sumMatrix[0][i] = matrix[0][i];
			if (sumMatrix[0][i] == 1) {
				numSquares++;
			}

		}

		for (int i = 1; i < sumMatrix.length; i++) {
			for (int j = 1; j < sumMatrix[0].length; j++) {
				int delta = min(sumMatrix[i][j - 1], sumMatrix[i - 1][j], sumMatrix[i - 1][j - 1]);

				if (matrix[i][j] == 1) {
					numSquares++;
					sumMatrix[i][j] = matrix[i][j] + delta;
				}

				if (matrix[i][j] != sumMatrix[i][j]) {
					numSquares+=delta;
				}
			}
		}

		return numSquares;
	}

	private int min(int a, int b, int c) {
		if (a < b) {
			return a < c ? a : c;
		} else {
			return b < c ? b : c;
		}
	}

	public static void main(String[] args) {
//		int[][] matrix = new int[][] { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 1, 1, 1 } };
		int[][] matrix = new int[][] { { 1, 0, 1 }, { 1, 1, 0 }, { 1, 1, 0 } };
		System.out.println(new CountSquareSubmatricesWithAllOnes().countSquares(matrix));
	}

}
