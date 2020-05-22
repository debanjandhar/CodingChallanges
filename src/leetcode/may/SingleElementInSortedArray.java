package leetcode.may;

public class SingleElementInSortedArray {

	public int singleNonDuplicate(int[] nums) {
		int nonDup = -1;
		for (int i = 0; i < nums.length; i += 2) {
			if (i + 1 == nums.length) {
				return nums[i];
			} else if (nums[i] != nums[i + 1]) {
				nonDup = nums[i];
				break;
			}
		}

		return nonDup;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 3, 3, 7, 7, 10, 11, 11 };
		System.out.println(new SingleElementInSortedArray().singleNonDuplicate(nums));
	}

}
