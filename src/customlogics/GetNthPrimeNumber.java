package customlogics;

import java.util.ArrayList;
import java.util.List;

public class GetNthPrimeNumber {

	public static void main(String[] args) {
		System.out.println(getNPrimeNumbers(200000));
	}

	private static List<Integer> getNPrimeNumbers(int n) {
		List<Integer> primeNos = new ArrayList<Integer>();
		int start = 0;

		int CHUNK_SIZE = n;
		boolean[] primes = new boolean[CHUNK_SIZE];

		for (int i = start; i < CHUNK_SIZE; i++) {
			primes[i] = true;
		}

		for (int i = 2; i * i <= CHUNK_SIZE; i++) {
			if (primes[i] == true) {
				for (int j = i * i; j < CHUNK_SIZE; j += i) {
					primes[j] = false;
				}
			}
		}

		for (int i = 2; i < CHUNK_SIZE; i++) {
			if (primes[i]) {
				primeNos.add((Integer) i);
			}
		}

		return primeNos;
	}
}
