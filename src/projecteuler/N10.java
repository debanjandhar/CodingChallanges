package projecteuler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class N10 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		List<Integer> l = getNPrimeNumbers(1100000);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numTestCases = Integer.parseInt(br.readLine());

		for (int i = 0; i < numTestCases; i++) {
			int num = Integer.parseInt(br.readLine());
			int index = 0;
			long sum = 0;
			while (l.get(index) <= num) {
				sum += l.get(index);
				index++;
			}

			System.out.println(sum);
		}
	}

	private static List<Integer> getNPrimeNumbers(int n) {
		List<Integer> primeNos = new ArrayList<Integer>();
		int start = 0, primeCheckStart = 2;
		boolean calPrimeFl = true;

		int CHUNK_SIZE = n;
		boolean[] primes = new boolean[CHUNK_SIZE];

		for (int i = start; i < CHUNK_SIZE; i++) {
			primes[i] = true;
		}

		for (int i = primeCheckStart; i * i <= CHUNK_SIZE; i++) {
			if (primes[i] == true) {
				for (int j = i * i; j < CHUNK_SIZE; j += i) {
					primes[j] = false;
				}
			}
		}

		for (int i = primeCheckStart; i < CHUNK_SIZE; i++) {
			if (primes[i]) {
				primeNos.add((Integer) i);
			}
		}

		return primeNos;
	}
}
