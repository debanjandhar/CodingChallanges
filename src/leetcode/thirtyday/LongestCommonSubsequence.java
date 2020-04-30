package leetcode.thirtyday;

import java.util.Arrays;

public class LongestCommonSubsequence {

	public int longestCommonSubsequence(String text1, String text2) {
		char[] text1C = text1.toCharArray();
		char[] text2C = text2.toCharArray();

		int[][] charMatrix = new int[text1C.length+1][text2C.length+1];

		for (int i = 0; i <= text1C.length; i++) {
			for (int j = 0; j <= text2C.length; j++) {
				if (i == 0 || j == 0)
					charMatrix[i][j] = 0;
				else if (text1C[i - 1] == text2C[j - 1])
					charMatrix[i][j] = charMatrix[i - 1][j - 1] + 1;
				else
					charMatrix[i][j] = charMatrix[i - 1][j] > charMatrix[i][j - 1] ? charMatrix[i - 1][j]
							: charMatrix[i][j - 1];
			}
		}
		for (int[] is : charMatrix) {
			System.out.println(Arrays.toString(is));
		}
		
		return charMatrix[text1C.length][text2C.length];
	}

	public static void main(String[] args) {
//		String text2 = "abcde";
//		String text1 = "ace";
//		String text1 = "abc";
//		String text2 = "abc";
//		String text1 = "abc";
//		String text2 = "def";
//		String text2 = "bsbininm";
//		String text1 = "jmjkbkjkv";
		String text1 = "lcnqdmvsdopkvqvejijcdyxetuzonuhuzkpelmva";
		String text2 = "bklgfivmpozinybwlovcnafqfybodkhabyrglsnen";
		System.out.println(new LongestCommonSubsequence().longestCommonSubsequence(text1, text2));
	}

}
