package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author debanjandhar
 * 
 *         Question :
 *         https://www.hackerrank.com/challenges/fair-rations/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
 *
 */
public class FairRations {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int numEles = Integer.parseInt(br.readLine());
		String[] eles = br.readLine().split(" ");

		boolean checkNextOddFl = false;
		int evenCount = 0, totalCount = 0;

		for (int i = 0; i < numEles; i++) {
			int currEle = Integer.parseInt(eles[i]);
			boolean isOdd = currEle % 2 == 0 ? false : true;
			if (isOdd) {
				if (checkNextOddFl) {
					totalCount += (evenCount + 1) * 2;
					evenCount = 0;
				}
				checkNextOddFl = !checkNextOddFl;
			} else if (checkNextOddFl) {
				evenCount++;
			}
		}

		if (checkNextOddFl) {
			System.out.println("NO");
		} else {
			System.out.println(totalCount);
		}
	}
}
