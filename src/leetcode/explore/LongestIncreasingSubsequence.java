package leetcode.explore;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	private int CeilIndex(int A[], int l, int r, int key) {
		while (r - l > 1) {
			int m = l + (r - l) / 2;
			if (A[m] >= key)
				r = m;
			else
				l = m;
		}

		return r;
	}

	private int lengthOfLIS(int[] nums) {
		int size = nums.length;
		int[] tailTable = new int[size];
		int len;

		tailTable[0] = nums[0];
		len = 1;
		for (int i = 1; i < size; i++) {
			if (nums[i] < tailTable[0])
				// new smallest value
				tailTable[0] = nums[i];

			else if (nums[i] > tailTable[len - 1])
				// A[i] wants to extend largest subsequence
				tailTable[len++] = nums[i];

			else
				// A[i] wants to be current end candidate of an existing
				// subsequence. It will replace ceil value in tailTable
				tailTable[CeilIndex(tailTable, -1, len - 1, nums[i])] = nums[i];
			System.out.println(Arrays.toString(tailTable));
		}

		return len;
	}

	public static void main(String[] args) {
//		int[] nums = new int[] { 10, 9, 2, 5, 3, 7, 101, 18 };
//		int[] nums = new int[] { 10, 9, 2, 5, 3, 4 };
		int[] nums = new int[] { 3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12 };
		System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(nums));
	}

}
