package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class SmallestString {
	private static String getSmallestWithOpOne(String s1, String s2) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s1.length(); i++) {
			int s1Char = s1.charAt(i);
			int s2Char = s2.charAt(i);

			// Picking smallest at every iteration gives the desired result.
			if (s1Char < s2Char) {
				sb.append((char) s1Char);
			} else {
				sb.append((char) s2Char);
			}
		}
		return sb.toString();
	}

	private static String getSmallestWithOpTwoAndOne(String s1, String s2, int[] pairs) {
		for (int i = 0; i < pairs.length; i += 2) {
			int firstIndex = pairs[i];
			int secIndex = pairs[i + 1];

			// No swapping if both chars are same.
			if (s2.charAt(firstIndex) < s2.charAt(secIndex) && s2.charAt(firstIndex) != s2.charAt(secIndex)) {
				boolean hasSmaller = false;
				StringBuilder sb = new StringBuilder();
				sb.append(s2.substring(0, firstIndex));

				for (int j = firstIndex; j < s2.length(); j++) {
					if (j == firstIndex) {
						sb.append(s2.charAt(secIndex));
						if (s1.charAt(firstIndex) > s2.charAt(secIndex)) {
							hasSmaller = true;
						}
					} else if (j == secIndex) {
						sb.append(s2.charAt(firstIndex));
						if (!hasSmaller && s1.charAt(secIndex) > s2.charAt(firstIndex)) {
							hasSmaller = true;
						}
						break;
					} else {
						sb.append(s2.charAt(j));
					}
				}

				sb.append(s2.substring(secIndex + 1, s2.length()));

				if (hasSmaller) {
					s2 = sb.toString();
				}
			}
		}

		String smallest = getSmallestWithOpOne(s1, s2);

		return smallest;
	}

	// Considering both the strings of same length
	private static String getSmaller(String s1, String s2) {
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) < s2.charAt(i)) {
				return s1;
			} else if (s1.charAt(i) > s2.charAt(i)) {
				return s2;
			}
		}

		return null;
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numTestCase = Integer.parseInt(br.readLine());

		for (int i = 0; i < numTestCase; i++) {
			String[] inputs = br.readLine().split(" ");
			int strLen = Integer.parseInt(inputs[0]);
			int intPairs = Integer.parseInt(inputs[1]);
			String s1 = br.readLine();
			String s2 = br.readLine();

			int[] pairs = new int[2 * intPairs];
			int index = 0;
			for (int j = 0; j < intPairs; j++) {
				String[] strPairs = br.readLine().split(" ");
				pairs[index++] = Integer.parseInt(strPairs[0]);
				pairs[index++] = Integer.parseInt(strPairs[1]);
			}

			String ret1 = getSmallestWithOpOne(s1, s2);
			String ret2 = getSmallestWithOpTwoAndOne(s1, s2, pairs);
			System.out.println(getSmaller(ret1, ret2));
		}

	}
}
