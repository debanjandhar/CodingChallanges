package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class JimAndSkyscrapers {

	static long solve(int[] arr) {
		Stack<Integer> stack = new Stack<Integer>();
		HashMap<Integer, Integer> eleCount = new HashMap<Integer, Integer>();
		long count = 0;
		for (int i : arr) {
			if (stack.isEmpty() || i < stack.peek()) {
				stack.push(i);
				mapPut(eleCount, i);
			} else {
				// Pop all elements smaller than
				while (!stack.isEmpty() && i > stack.peek()) {
					int tmpNum = stack.pop();
					eleCount.remove(tmpNum);
				}

				// Now stack head is equal to the current number
				if (stack.isEmpty() || stack.peek() != i) {
					stack.push(i);
				} else {
					count += eleCount.get(i);
				}
				mapPut(eleCount, i);
			}
		}

		return count * 2;
	}

	static void mapPut(Map<Integer, Integer> map, int val) {
		if (map.containsKey(val)) {
			map.put(val, map.get(val) + 1);
		} else {
			map.put(val, 1);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
//		int[] arr = new int[] { 3, 2, 1, 2, 3, 3 };
//		int[] arr = new int[] { 1, 100, 1 };
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numEle = Integer.parseInt(br.readLine());
		int[] arr = new int[numEle];
		String[] elements = br.readLine().split(" ");
		for (int i = 0; i < numEle; i++) {
			arr[i] = Integer.parseInt(elements[i]);
		}

		System.out.println(solve(arr));
	}
}
