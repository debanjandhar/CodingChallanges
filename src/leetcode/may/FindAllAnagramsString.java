package leetcode.may;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsString {

	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> output = new ArrayList<Integer>();
		char[] sortedP = p.toCharArray();
		Arrays.sort(sortedP);
		
		for (int i = 0; i <= s.length() - p.length(); i++) {
			char[] cArr = new char[p.length()];
			s.getChars(i, i + p.length(), cArr, 0);
			if (isAnagaram(cArr, sortedP)) {
				output.add(i);
			}
		}

		return output;
	}

	private boolean isAnagaram(char[] input, char[] checker) {
		Arrays.sort(input);

		if (String.copyValueOf(input).equals(String.copyValueOf(checker))) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		System.out.println(new FindAllAnagramsString().findAnagrams("cbaebabacd", "abc"));
		System.out.println(new FindAllAnagramsString().findAnagrams("abab", "ab"));
	}

}
