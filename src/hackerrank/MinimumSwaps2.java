package hackerrank;
import java.io.IOException;

public class MinimumSwaps2 {

	// Complete the minimumSwaps function below.
	static int minimumSwaps(int[] arr) {
		int numSwaps = 0;
		int pivot = 0;

		while (pivot < arr.length - 1) {
			if (mustShift(arr[pivot], pivot + 1) > 0) {
				// Must shift right, so find an element that has to be shifted left.
				for (int i = pivot + 1; i < arr.length; i++) {
					if (arr[i] == (pivot + 1)) {
						int temp = arr[i];
						arr[i] = arr[pivot];
						arr[pivot] = temp;
						numSwaps++;
						break;
					}
				}
			} else {
				pivot++;
			}
		}

		return numSwaps;
	}

	/**
	 * @return -1 for left Shift, 1 for right shift and 0 for no shift
	 */
	private static int mustShift(int ele, int position) {
		if (ele - position == 0) {
			return 0;
		} else if (ele - position < 0) {
			return -1;
		} else {
			return 1;
		}
	}

	public static void main(String[] args) throws IOException {

		System.out.println(minimumSwaps(new int[] { 4, 3, 1, 2 }));
		System.out.println(minimumSwaps(new int[] { 1, 3, 5, 2, 4, 6, 7 }));
		System.out.println(minimumSwaps(new int[] { 3, 7, 6, 9, 1, 8, 10, 4, 2, 5 }));
	}
}
