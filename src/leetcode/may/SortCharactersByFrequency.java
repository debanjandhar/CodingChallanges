package leetcode.may;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {

	public String frequencySort(String s) {
		StringBuilder sb = new StringBuilder();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		for (char c : s.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}

		PriorityQueue<Map.Entry<Character, Integer>> q = new PriorityQueue<>(
				new Comparator<Map.Entry>() {

					@Override
					public int compare(Map.Entry o1, Map.Entry o2) {
						return (int) o1.getValue() < (int) o2.getValue() ? 1 : -1;
					}
				});

		q.addAll(map.entrySet());
		
		while (!q.isEmpty()) {
			Map.Entry<Character, Integer> curr = q.remove();
			for (int i = 0; i < curr.getValue(); i++) {
				sb.append(curr.getKey());
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(new SortCharactersByFrequency().frequencySort("Aabb"));
	}

}
