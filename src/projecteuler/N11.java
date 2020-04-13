package projecteuler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N11 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] input = new int[20][20];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < 20; i++) {
			String[] n = br.readLine().split(" ");
			for (int j = 0; j < 20; j++) {
				input[i][j] = Integer.parseInt(n[j]);
			}
		}

		int[][] dirs = new int[][] { { 1, 1 }, { -1, -1 }, { 0, -1 }, { -1, 0 }, { 1, 0 }, { 0, 1 }, { 1, -1 },
				{ -1, 1 } };
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				for (int[] js : dirs) {
					int curr = input[i][j];
					for (int k = 1; k <= 3; k++) {
						int nextX = i + js[0] * k;
						int nextY = j + js[1] * k;
						if (isValid(nextX, nextY)) {
							curr *= input[nextX][nextY];
						} else {
							curr = 0;
							break;
						}
					}

					if (curr > max) {
						max = curr;
					}
				}
			}
		}

		System.out.println(max);
	}

	private static boolean isValid(int x, int y) {
		return x < 0 || y < 0 || x > 19 || y > 19 ? false : true;
	}
}
