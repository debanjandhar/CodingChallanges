package codegig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BeyBlade {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numTestCases = Integer.parseInt(br.readLine());

		for (int i = 0; i < numTestCases; i++) {
			int numMembers = Integer.parseInt(br.readLine());
			long[] gMems = new long[numMembers];
			long[] ngMems = new long[numMembers];

			StringTokenizer gTokens = new StringTokenizer(br.readLine());
			StringTokenizer ngTokens = new StringTokenizer(br.readLine());

			int index = 0;
			while (index < numMembers) {
				gMems[index] = Long.parseLong((String)gTokens.nextElement());
				ngMems[index] = Long.parseLong((String)ngTokens.nextElement());

				index++;
			}
			
			sort(gMems);
			sort(ngMems);
			
			int gIndex = 0, ngIndex = 0, count = 0;
			while (ngIndex < numMembers) {
				if (gMems[gIndex] > ngMems[ngIndex]) {
					gIndex++;
					count++;
				}
				ngIndex++;
			}
			
			System.out.println(count);
		}
	}

	private static void sort(long[] input) {
		mergeSort(input, 0, input.length-1);
	}
	
	static void mergeSort(long[] inputArr, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(inputArr, start, mid);
			mergeSort(inputArr, mid + 1, end);

			merge(inputArr, start, mid, end);
		}

	}

	static void merge(long[] inputArr, int start, int mid, int end) {
		int i = start, j = mid + 1;
		long[] l = new long[mid - start + 1], r = new long[end - mid];

		for (int k = 0; k < l.length; k++) {
			l[k] = inputArr[i + k];
		}
		for (int k = 0; k < r.length; k++) {
			r[k] = inputArr[j + k];
		}

		int k = start;
		i = 0;
		j = 0;
		while (i < l.length && j < r.length) {
			if (l[i] >= r[j]) {
				inputArr[k] = l[i];
				i++;
			} else {
				inputArr[k] = r[j];
				j++;
			}
			k++;
		}

		while (i < l.length) {
			inputArr[k++] = l[i++];
		}
		while (j < r.length) {
			inputArr[k++] = r[j++];
		}
	}

}
