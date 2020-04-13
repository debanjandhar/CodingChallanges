package hackerrank;

import java.io.IOException;
import java.util.Scanner;

public class FlatlandSpaceStation {

	// Complete the flatlandSpaceStations function below.
	static int flatlandSpaceStations(int n, int[] c) {
		int max = 0;
		for (int i = 0; i < n; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < c.length; j++) {
				int dist = Math.abs(i - c[j]);
				if (i == c[j]) {
					min = Integer.MAX_VALUE;
					break;
				}else if (dist < min) {
					min = dist;
				}
			}
			if (min != Integer.MAX_VALUE && min > max) {
				max = min;
			}
		}
		return max;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int[] c = new int[] { 0, 4 };

		System.out.println(flatlandSpaceStations(5, c));
	}
}
