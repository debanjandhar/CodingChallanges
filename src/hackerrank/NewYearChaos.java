package hackerrank;
public class NewYearChaos {

	// Complete the minimumBribes function below.
	static void minimumBribes(int[] q) {
		int bribes = 0;
		
		for(int i=0;i<q.length;i++) {
			if (q[i] - (i+1) > 2) {
				System.out.println("Too chaotic");
				return;
			}
			
			for (int j = Math.max(0, q[i]-2); j < i; j++) {
				if (q[j] > q[i]) {
					bribes++;
				}
			}
		}

		System.out.println(bribes);
	}

	public static void main(String[] args) {

		minimumBribes(new int[] { 2, 1, 5, 3, 4 });
		minimumBribes(new int[] { 2, 5, 1, 3, 4 });
		minimumBribes(new int[] { 1, 2, 5, 3, 7, 8, 6, 4 });
	}
}
