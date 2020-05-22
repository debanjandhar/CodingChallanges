package leetcode.may;

public class StockSpanner {

	private int[] arr;
	private int end;

	public StockSpanner() {
		arr = new int[10000];
		end = -1;
	}

	public int next(int price) {
		arr[++end] = price;
		int count = 1;
		int tmp = end - 1;
		while (tmp >= 0) {
			if (arr[tmp--] > price) {
				break;
			}
			count++;
		}

		return count;
	}

	public static void main(String[] args) {
		StockSpanner ss = new StockSpanner();
		
		System.out.println(ss.next(100));
		System.out.println(ss.next(80));
		System.out.println(ss.next(60));
		System.out.println(ss.next(70));
		System.out.println(ss.next(60));
		System.out.println(ss.next(75));
		System.out.println(ss.next(85));
	}

}
