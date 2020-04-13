package hackerrank;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author debanjandhar
 * 
 *         Question :
 *         https://www.hackerrank.com/challenges/between-two-sets/problem?isFullScreen=true&h_r=next-challenge&h_v=zen
 *
 */
class Result {

	/*
	 * Complete the 'getTotalX' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER_ARRAY a 2. INTEGER_ARRAY b
	 */

	public static int getTotalX(List<Integer> a, List<Integer> b) {

		int[] aArr = getIntArrFromList(a);
		int[] bArr = getIntArrFromList(b);

		// Considering given arrays are sorted in ascending order.
		int maxA = aArr[aArr.length - 1];
		int minB = bArr[0];
		List<Integer> factors = new ArrayList<Integer>();

		int count = 1;

		// Search for a factor until you hit the min setNUm
		while (maxA * count <= minB) {
			int factor = maxA * count;
			boolean isFactor = true;
			for (Integer integer : a) {
				if (factor % integer != 0) {
					// Found an int which does not divide the factor
					isFactor = false;
					break;
				}
			}

			if (isFactor) {
				factors.add(factor);
			}

			count++;
		}

		count = 0;
		for (Integer factor : factors) {
			boolean isFactorForAllSetNum = true;

			for (Integer setNum : b) {
				if (setNum % factor != 0) {
					isFactorForAllSetNum = false;
					break;
				}
			}
			if (isFactorForAllSetNum) {
				count++;
			}
		}

		return count;
	}

	private static int[] getIntArrFromList(List<Integer> arr) {
		int[] output = new int[arr.size()];
		int index = 0;
		for (Integer integer : arr) {
			output[index++] = integer;
		}

		return output;
	}

}

public class BetweenTwoSets {
	public static void main(String[] args) throws IOException {

		List<Integer> arr = getListFromint(new int[] { 2, 4 });

		List<Integer> brr = getListFromint(new int[] { 16, 32, 96 });

		int total = Result.getTotalX(arr, brr);

		System.out.println(total);
	}

	private static List<Integer> getListFromint(int[] elements) {
		List<Integer> outputList = new ArrayList<Integer>();

		for (int i = 0; i < elements.length; i++) {
			outputList.add(elements[i]);
		}

		return outputList;
	}
}
