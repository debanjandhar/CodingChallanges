package leetcode.thirtyday;

public class SearchInRotatedSortedArray {
	public int search(int[] nums, int target) {
		return binarySearch(nums, target, 0, nums.length - 1);
	}

	private int binarySearch(int[] nums, int target, int start, int end) {
		if (start > end) {
			return -1;
		}

		int mid = (start + end) / 2;
		if (nums[mid] == target) {
			return mid;
		}

		if (nums[start] <= nums[mid]) {
			if (inRange(target, nums[start], nums[mid])) {
				return binarySearch(nums, target, start, mid);
			} else {
				return binarySearch(nums, target, mid + 1, end);
			}
		} else {
			if (inRange(target, nums[mid], nums[end])) {
				return binarySearch(nums, target, mid + 1, end);
			} else {
				return binarySearch(nums, target, start, mid);
			}
		}

	}

	private boolean inRange(int num, int start, int end) {
		return num >= start && num <= end;
	}

	public static void main(String[] args) {
//		int[] nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
		int[] nums = new int[] { 1 };

		System.out.println(new SearchInRotatedSortedArray().search(nums, 1));
	}
}
