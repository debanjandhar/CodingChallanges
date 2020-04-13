package projecteuler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N9 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		for (int a0 = 0; a0 < t; a0++) {
			int n = Integer.parseInt(br.readLine());
			boolean found = false;
			for (int a = n - 2; a > 0; a--) {
				int startB = n - a - 1;
				for (int b = startB; b > 0; b--) {
					int startC = n - (a + b);
					for (int c = startC; c > 0; c--) {
						if ((a * a + b * b) == (c * c) && (a + b + c) == n) {
							System.out.println(a * b * c);
							found = true;
							break;
						}
					}
					if (found) {
						break;
					}
				}
				if (found) {
					break;
				}
			}
			if (!found) {
				System.out.println(-1);
			}
			
		}
	}
}
