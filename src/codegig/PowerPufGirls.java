package codegig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PowerPufGirls {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numIng = Integer.parseInt(br.readLine());
		String[] reqIng = br.readLine().split(" ");
		String[] availIng = br.readLine().split(" ");
		
		long max = Integer.MAX_VALUE;
		for (int i = 0; i < numIng; i++) {
			long maxNum = Long.parseLong(availIng[i])/Long.parseLong(reqIng[i]);
			if ( maxNum < max) {
				max = maxNum;
			}
		}
		
		System.out.println(max);
	}
}
