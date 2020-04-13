package hackerrank;
import java.io.IOException;
import java.util.List;

class NonDivisibleSubsetResult {

	/*
	 * Complete the 'nonDivisibleSubset' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER k 2. INTEGER_ARRAY s
	 */

	public static int nonDivisibleSubset(int k, List<Integer> s) {
		int[] reminders = new int[k];
		int count = 0;

		// Calculate the number of reminders from given set.
		for (Integer set : s) {
			reminders[set % k]++;
		}

		// If one or more than one element is present which is completely divisible by
		// k, then we can pick only one such element because sum of 2 of them will be
		// divisible by k.
		if (reminders[0] > 0) {
			count++;
		}

		int endPivot;
		// Traversing half the length because we will be using 2 pivot elements from
		// start and end.
		for (int startPivot = 1; startPivot <= reminders.length / 2; startPivot++) {
			endPivot = reminders.length - startPivot;
			if (startPivot == endPivot) {
				count++;
				continue;
			}

			// since both start and end pivot sum up to k, so both cannot be selected. We
			// will select the one which has higher count because it contributes to larger
			// final
			// array. In case both values are equal, we are randomly choosing startpivot
			// element.
			if (reminders[startPivot] >= reminders[endPivot]) {
				count += reminders[startPivot];
			} else {
				count += reminders[endPivot];
			}
		}

		return count;
	}

}

/**
 * @author debanjandhar
 * 
 *         Question :
 *         https://www.hackerrank.com/challenges/non-divisible-subset/problem
 *
 */
public class NonDivisibleSubset {
	public static void main(String[] args) throws IOException {

//		int result = NonDivisibleSubsetResult.nonDivisibleSubset(3, Helper.getListFromint(new int[] { 1, 7, 2, 4 }));
		int result = NonDivisibleSubsetResult.nonDivisibleSubset(4,
				Helper.getListFromint(new int[] { 19, 10, 12, 10, 24, 25, 22 }));
		System.out.println(result);
	}
}
