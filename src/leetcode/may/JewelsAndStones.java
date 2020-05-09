package leetcode.may;

import java.util.HashMap;

public class JewelsAndStones {
	public int numJewelsInStones(String J, String S) {
		int count = 0;
		HashMap<Character, Integer> charAndCount = new HashMap<>();
		for (char c : S.toCharArray()) {
			if (charAndCount.containsKey(c)) {
				charAndCount.put(c, charAndCount.get(c) + 1);
			} else {
				charAndCount.put(c, 1);
			}
		}

		for (char c : J.toCharArray()) {
			if (charAndCount.containsKey(c)) {
				count+=charAndCount.get(c);
			}
		}

		return count;
	}

	public static void main(String[] args) {
		System.out.println(new JewelsAndStones().numJewelsInStones("z", "ZZ"));
	}
}
