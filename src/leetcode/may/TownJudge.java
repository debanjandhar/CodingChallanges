package leetcode.may;

public class TownJudge {

	public int findJudge(int N, int[][] trust) {
		int tj = -1;

		int[] trusts = new int[N + 1];
		int[] trusted = new int[N + 1];

		for (int[] t : trust) {
			trusts[t[1]]++;
			trusted[t[0]]++;
		}

		for (int i = 1; i <= N; i++) {
			if (trusts[i] == N - 1 && trusted[i] == 0) {
				tj = i;
				break;
			}
		}

		return tj;
	}

	public static void main(String[] args) {
		int[][] trust = new int[][] { { 1, 3 }, { 1, 4 }, { 2, 3 }, { 2, 4 }, { 4, 3 } };
		System.out.println(new TownJudge().findJudge(4, trust));
	}
}
