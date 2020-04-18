package leetcode.thirtyday;

import java.util.Arrays;

public class ProductOfArrayExceptOfSelf {
	public int[] productExceptSelf(int[] nums) {
		int[] prefix_prod = new int[nums.length];
		int[] suffix_prod = new int[nums.length];
		int[] output = new int[nums.length];

		prefix_prod[0] = nums[0];
		suffix_prod[nums.length - 1] = nums[nums.length - 1];

		for (int i = 1; i < nums.length; i++) {
			prefix_prod[i] = nums[i] * prefix_prod[i - 1];
		}

		for (int i = nums.length - 2; i >= 0; i--) {
			suffix_prod[i] = nums[i] * suffix_prod[i + 1];
		}

		for (int i = 0; i < output.length; i++) {
			if (i == 0) {
				output[i] = suffix_prod[i + 1];
			} else if (i == output.length - 1) {
				output[i] = prefix_prod[i - 1];
			} else {
				output[i] = prefix_prod[i - 1] * suffix_prod[i + 1];
			}
		}

		return output;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3, 4 };
		System.out.println(Arrays.toString(new ProductOfArrayExceptOfSelf().productExceptSelf(nums)));
	}
}
