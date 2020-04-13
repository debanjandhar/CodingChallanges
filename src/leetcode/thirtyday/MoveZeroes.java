package leetcode.thirtyday;

import java.util.Arrays;

public class MoveZeroes {
	public void moveZeroes(int[] nums) {
		int firstIndex = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				if (firstIndex == -1) {
					firstIndex = i;
				}
			} else if (firstIndex != -1) {
				int tmp = nums[firstIndex];
				nums[firstIndex] = nums[i];
				nums[i] = tmp;
				firstIndex++;
			}
		}
		System.out.println(Arrays.toString(nums));
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 0, 0, 3, 12 };
		new MoveZeroes().moveZeroes(nums);
	}
}
