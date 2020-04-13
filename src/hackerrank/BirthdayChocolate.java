package hackerrank;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author debanjandhar
 * 
 *         Question :
 *         https://www.hackerrank.com/challenges/the-birthday-bar/problem?isFullScreen=true
 *
 */
public class BirthdayChocolate {

	// Complete the birthday function below.
	static int birthday(List<Integer> s, int d, int m) {

		int count = 0;

		int windowStartIndex = 0;
		int windowEndIndex = 0;
		int windowSize = 1;
		int sum = 0;
		;

		while (windowEndIndex < s.size()) {
			sum += s.get(windowEndIndex);

			if (windowSize == m) {
				if (sum == d) {
					count++;
				}

				// Shift the window by one place
				windowSize--;
				sum -= s.get(windowStartIndex);
				windowStartIndex++;
			}

			windowEndIndex++;
			windowSize++;

		}

		return count;
	}

	public static void main(String[] args) throws IOException {
//    	List<Integer> s = getListFromint(new int[] {1, 2, 1, 3, 2});
//    	int d=3, m=2;

//    	List<Integer> s = getListFromint(new int[] {1, 1, 1, 1, 1, 1});
//    	int d=3, m=2;

		List<Integer> s = getListFromint(new int[] { 4, 1 });
		int d = 4, m = 1;

		int result = birthday(s, d, m);
		System.out.println(result);
	}

	private static List<Integer> getListFromint(int[] elements) {
		List<Integer> outputList = new ArrayList<Integer>();

		for (int i = 0; i < elements.length; i++) {
			outputList.add(elements[i]);
		}

		return outputList;
	}
}
