package leetcode.thirtyday;

import java.util.HashSet;
import java.util.Stack;

public class JumpGame {
	public boolean canJump(int[] nums) {
		Stack<Jump> s = new Stack<Jump>();
		Jump j = new Jump(0, nums[0]);
		s.add(j);
		
		HashSet<Integer> hs = new HashSet<>();
		hs.add(j.index);
//		return checkNext(nums, 0);
		return canJump(nums, s, hs);
	}

	private boolean canJump(int[] nums, Stack<Jump> s, HashSet<Integer> hs) {
		if (s.isEmpty()) {
			return false;
		}

		Jump j = s.pop();
//		System.out.println("Removed element [" + j + "]");
		if (j.index == nums.length - 1) {
			return true;
		} else if (nums[j.index] != 0) {
			for (int i = j.jumpDist; i > 0; i--) {
				int jumpedIndex = j.index + i;
				if (jumpedIndex < nums.length) {
					Jump jump = new Jump(jumpedIndex, nums[jumpedIndex]);
					if (hs.contains(jump.index)) {
						break;
					}
					hs.add(jump.index);
					s.add(jump);
				}
			}
		}

//		System.out.println("Stack : " + s.size());

		return canJump(nums, s, hs);
	}

	public static void main(String[] args) {
//		int[] nums = new int[] { 2, 0 };
		int[] nums = new int[] { 2, 0, 6, 9, 8, 4, 5, 0, 8, 9, 1, 2, 9, 6, 8, 8, 0, 6, 3, 1, 2, 2, 1, 2, 6, 5, 3, 1, 2,
				2, 6, 4, 2, 4, 3, 0, 0, 0, 3, 8, 2, 4, 0, 1, 2, 0, 1, 4, 6, 5, 8, 0, 7, 9, 3, 4, 6, 6, 5, 8, 9, 3, 4, 3,
				7, 0, 4, 9, 0, 9, 8, 4, 3, 0, 7, 7, 1, 9, 1, 9, 4, 9, 0, 1, 9, 5, 7, 7, 1, 5, 8, 2, 8, 2, 6, 8, 2, 2, 7,
				5, 1, 7, 9, 6 };
//		int[] nums = new int[] { 2, 3, 1, 1, 4 };
//		int[] nums = new int[] { 2, 5, 0, 0 };
//		int[] nums = new int[] {3,2,1,0,4};
//		int[] nums = new int[] { 8, 2, 4, 4, 4, 9, 5, 2, 5, 8, 8, 0, 8, 6, 9, 1, 1, 6, 3, 5, 1, 2, 6, 6, 0, 4, 8, 6, 0,
//				3, 2, 8, 7, 6, 5, 1, 7, 0, 3, 4, 8, 3, 5, 9, 0, 4, 0, 1, 0, 5, 9, 2, 0, 7, 0, 2, 1, 0, 8, 2, 5, 1, 2, 3,
//				9, 7, 4, 7, 0, 0, 1, 8, 5, 6, 7, 5, 1, 9, 9, 3, 5, 0, 7, 5 };

		System.out.println(new JumpGame().canJump(nums));
	}
}

class Jump {
	int index;
	int jumpDist;

	public Jump(int index, int jumpDist) {
		this.index = index;
		this.jumpDist = jumpDist;
	}

	@Override
	public boolean equals(Object obj) {
		Jump j = (Jump) obj;
		return this.index == j.index && this.jumpDist == j.jumpDist;
	}
	
	@Override
	public int hashCode() {
		return 31*Integer.hashCode(index)*Integer.hashCode(jumpDist);
	}

	@Override
	public String toString() {
		return "[" + index + ", " + jumpDist + "]";
	}
}
