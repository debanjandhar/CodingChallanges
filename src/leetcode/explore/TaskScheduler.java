package leetcode.explore;

import java.util.HashMap;
import java.util.Map;

public class TaskScheduler {
	public int leastInterval(char[] tasks, int n) {
		int count = 0;
		Map<Character, Integer> taskCounts = new HashMap<Character, Integer>();
		int[] iterationPossible = new int[26];

		for (char c : tasks) {
			if (taskCounts.containsKey(c)) {
				taskCounts.put(c, taskCounts.get(c) + 1);
			} else {
				taskCounts.put(c, 1);
				iterationPossible[getIndex(c)] = 0;
			}
		}

		while (!taskCounts.isEmpty()) {
			char taskExecuted = ' ';
			for (Character task : taskCounts.keySet()) {
				if (isPossible(iterationPossible, task, count)) {
					taskExecuted = task;
					iterationPossible[getIndex(taskExecuted)] += n + 1;
					break;
				}
			}

			if (taskExecuted != ' ') {
				if (taskCounts.get(taskExecuted) == 1) {
					taskCounts.remove(taskExecuted);
				} else {
					taskCounts.put(taskExecuted, taskCounts.get(taskExecuted) - 1);
				}
			}

			count++;
		}

		return count;
	}

	private boolean isPossible(int[] checkPossible, char task, int iteration) {
		int index = getIndex(task);
		if (checkPossible[index] <= iteration) {
			return true;
		}
		return false;
	}

	private int getIndex(char c) {
		return c - 'A';
	}

	public static void main(String[] args) {
		char[] tasks = new char[] { 'A', 'A', 'A', 'B', 'B', 'B', };
		int n = 1;
		System.out.println("\n" + new TaskScheduler().leastInterval(tasks, n));
	}
}
