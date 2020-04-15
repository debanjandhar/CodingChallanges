package leetcode.thirtyday;

public class BestTimeToBuyAndSellStock {

	public int maxProfit(int[] prices) {
		int profit = 0;
		int bought = -1;
		int tmpProfit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] <= prices[i - 1]) {
				bought = prices[i];
				tmpProfit = 0;
				continue;
			} else if (bought == -1) {
				bought = prices[i - 1];

			}
			profit -= tmpProfit;
			tmpProfit = prices[i] - bought;
			profit += tmpProfit;
		}
		return profit;
	}

	public static void main(String[] args) {
		int[] prices = new int[] { 7, 1, 5, 3, 6, 4 };
//		int[] prices = new int[] { 1, 2, 3, 4, 5 };
//		int[] prices = new int[] { 1, 2 };
		System.out.println(new BestTimeToBuyAndSellStock().maxProfit(prices));
	}
}
