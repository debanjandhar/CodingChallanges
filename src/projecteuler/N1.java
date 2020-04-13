package projecteuler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1 {
	private static long multipleSum(int n) {
		long n3 = (int)n/3;
		long n5 = (int)n/5;
		long n15 = (int)n/15;
		

		long sum = getX(3, n3)+getX(5, n5)-getX(15, n15);
		if (n%3==0 || n%5==0) {
			sum-=n;
		}
		
		return sum;
	}

	
	private static long getX(int n, long m) {
		return (n*m*(m+1))/2;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int a0 = 0; a0 < t; a0++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(multipleSum(n));
		}
	}
}
