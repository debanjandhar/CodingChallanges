package leetcode.thirtyday;

public class SubarraySumEqualsK {
	public int subarraySum(int[] nums, int k) {
		int count = 0;
		int[] sumArr = new int[nums.length + 1];

		sumArr[0] = 0;

		for (int i = 1; i <= nums.length; i++) {
			sumArr[i] = nums[i - 1] + sumArr[i - 1];
		}

		for (int end = sumArr.length - 1; end > 0; end--) {
			for (int start = end - 1; start >= 0; start--) {
				int sum = sumArr[end] - sumArr[start];
				if (sum == k) {
					count++;
				}
			}
		}

		return count;
	}

	public static void main(String[] args) {
//		int[] nums = new int[] { 1, 1, 1 };
//		int k = 2;
		int[] nums = new int[] { -1, -1, 1 };
		int k = 0;
		System.out.println(new SubarraySumEqualsK().subarraySum(nums, k));
	}
}
