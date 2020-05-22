package leetcode.may;

public class MaximumSumCircularSubarray {

	public int maxSubarraySumCircular(int[] A) {

		int normalMax = getMaxSubarraySum(A);

		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
			A[i] = -A[i];
		}

		int negateMax = sum + getMaxSubarraySum(A);

		if (negateMax == 0) {
			return normalMax;
		}
		
		return Integer.max(normalMax, negateMax);

	}

	public int getMaxSubarraySum(int[] arr) {
		int max = Integer.MIN_VALUE;

		int sum = 0;

		for (int i : arr) {
			sum += i;
			max = sum > max ? sum : max;
			sum = sum < 0 ? 0 : sum;

		}

		return max;
	}

	public static void main(String[] args) {
//		int[] A = new int[] { 1, -2, 3, -2 };
//		int[] A = new int[] { 3, -1, 2, -1 };
//		int[] A = new int[] { 3, -2, 2, -3 };
//		int[] A = new int[] { 5, -3, 5 };
		int[] A = new int[] { -2, -3, -1 };
//		int[] A = new int[] { 1, -2, 3, -2 };

		System.out.println(new MaximumSumCircularSubarray().maxSubarraySumCircular(A));
//		System.out.println(new MaximumSumCircularSubarray().getMaxSubarraySum(A));
	}

}
