package leetcode.thirtyday;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
	public int findMaxLength(int[] nums) {
		int[] sumArr = new int[nums.length];
		Map<Integer, Integer> firstCountMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			int sumElement = 1;
			if (nums[i] == 0) {
				sumElement = -1;
			}

			if (i == 0) {// first element
				sumArr[i] = sumElement;
			} else {
				sumArr[i] = sumArr[i - 1] + sumElement;
			}
			if (!firstCountMap.containsKey(sumArr[i])) {
				firstCountMap.put(sumArr[i], i);
			}
		}

		System.out.println(Arrays.toString(sumArr));

		int max = 0;
		for (int i = nums.length - 1; i >= max; i--) {
			int tmpMax = 0;
			if (sumArr[i] == 0) {
				tmpMax = i + 1;
			} else if (firstCountMap.containsKey(sumArr[i])) {
				tmpMax = i - firstCountMap.get(sumArr[i]);
			}
			if (tmpMax > max) {
				max = tmpMax;
			}
		}

		return max;
	}

	public static void main(String[] args) {
//		int[] nums = new int[] { 0, 1, 1, 0, 1, 1, 1, 0 };
		int[] nums = new int[] { 0, 0, 1 };
//		int[] nums = new int[] { 0, 1 };
//		int[] nums = new int[] { 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0 };
//		int[] nums = new int[] { 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0,
//				0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0,
//				1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1,
//				1 };
//		int[] nums = new int[] { 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1,
//				0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1,
//				1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1,
//				1 };

		System.out.println(new ContiguousArray().findMaxLength(nums));
	}
}
