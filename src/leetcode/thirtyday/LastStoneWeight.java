package leetcode.thirtyday;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {

	public int lastStoneWeight(int[] stones) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});

		for (int stone : stones) {
			pq.add(stone);
		}

		while (pq.size() > 1) {
			int remWt = pq.poll() - pq.poll();
			if (remWt != 0) {
				pq.add(remWt);
			}
		}

		return pq.size() == 1 ? pq.poll() : 0;
	}

	public static void main(String[] args) {
		int[] stones = new int[] { 2, 7, 4, 1, 8, 1 };
		System.out.println(new LastStoneWeight().lastStoneWeight(stones));
	}
}
