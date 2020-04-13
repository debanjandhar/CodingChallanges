package customlogics;

import java.util.Arrays;

public class GetAllCombinations {

	public static void main(String[] args) {
		int numEle = 3;
		int[] nums = new int[] { 1, 2, 3, 4, 5 };
		getCombinations(nums, new int[numEle], 0, nums.length - 1, 0, numEle);
	}

	static void getCombinations(int[] nums, int[] data, int startIndex, int end, int currNumEle, int numEle) {
		if (currNumEle == numEle) {
			System.out.println(Arrays.toString(data));
			return;
		}

		for (int i = startIndex; i <= end && end - i + 1 >= numEle - currNumEle; i++) {
			data[currNumEle] = nums[i];
			getCombinations(nums, data, i + 1, end, currNumEle + 1, numEle);
		}

	}

}
