package leetcode.thirtyday;

import java.util.HashMap;

public class CountingNumber {

	public int countElements(int[] arr) {
		HashMap<Integer, Integer> remCount = new HashMap<Integer, Integer>();
		int count = 0;
		for (int i : arr) {
			int remNextNum = i + 1;
			int remPrevNum = i - 1;

			if (remCount.containsKey(i) && remCount.get(i) != 1) {
				remCount.remove(i);
				count++;
			}
			if (!remCount.containsKey(remNextNum)) {
				remCount.put(remNextNum, 0);
			} else {
				remCount.put(remNextNum, remCount.get(remNextNum) + 1);

			}

			if (!remCount.containsKey(remPrevNum)) {
				remCount.put(remPrevNum, 0);
			} else {
				remCount.put(remPrevNum, remCount.get(remPrevNum) + 1);
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 3, 2, 3, 5, 0 };
		System.out.println(new CountingNumber().countElements(arr));
	}
}
