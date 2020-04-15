package leetcode.thirtyday;

public class MaxSubArray {
	public int maxSubArray(int[] nums) {
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i : nums) {
			sum += i;
			max = sum > max ? sum : max;
			sum = sum < 0 ? 0 : sum;
		}

		return max;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(new MaxSubArray().maxSubArray(nums));
	}
}
