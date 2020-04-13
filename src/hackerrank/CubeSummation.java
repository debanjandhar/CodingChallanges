package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CubeSummation {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int numTestCases = Integer.parseInt(br.readLine());
		for (int i = 0; i < numTestCases; i++) {
			String[] matrixSizeAndNumQueries = br.readLine().split(" ");
			int matrixSize = Integer.parseInt(matrixSizeAndNumQueries[0]);
			int numQueries = Integer.parseInt(matrixSizeAndNumQueries[1]);
			long[][][] matrix = new long[matrixSize+1][matrixSize+1][matrixSize+1];

			for (int j = 0; j < numQueries; j++) {
				String[] query = br.readLine().split(" ");
				switch (query[0]) {
				case "UPDATE":
					update(matrix, Integer.parseInt(query[1]), Integer.parseInt(query[2]), Integer.parseInt(query[3]),
							Integer.parseInt(query[4]));
					break;
				case "QUERY":
					System.out.println(query(matrix, Integer.parseInt(query[1]), Integer.parseInt(query[2]),
							Integer.parseInt(query[3]), Integer.parseInt(query[4]), Integer.parseInt(query[5]),
							Integer.parseInt(query[6])));
				}
			}
		}
	}

	static void update(long[][][] matrix, int x, int y, int z, long val) {
		matrix[x][y][z] = val;
	}

	static long query(long[][][] matrix, int x1, int y1, int z1, int x2, int y2, int z2) {
		long sum = 0;
		for (int i = x1; i <= x2; i++) {
			for (int j = y1; j <= y2; j++) {
				for (int k = z1; k <= z2; k++) {
					sum += matrix[i][j][k];
				}
			}
		}

		return sum;
	}
}
