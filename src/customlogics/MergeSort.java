package customlogics;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		long[] arr = new long[] { 1, 2, 3, 4, 5 };
		mergeSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
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
