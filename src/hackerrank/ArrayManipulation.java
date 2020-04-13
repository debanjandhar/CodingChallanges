package hackerrank;
import java.io.IOException;

public class ArrayManipulation {

	// Complete the arrayManipulation function below.
//	static long arrayManipulation(int n, int[][] queries) {
//		long maxval = Integer.MIN_VALUE;
//
//		long[] matrix = new long[n];
//
//		for (int i = 0; i < queries.length; i++) {
//			for (int j = queries[i][0]; j <= queries[i][1]; j++) {
//				matrix[j-1] += queries[i][2];
//				if (matrix[j-1] > maxval) {
//					maxval = matrix[j-1];
//				}
//			}
//		}
//
//		return maxval;
//	}
	static long arrayManipulation(int n, int[][] queries) {
		long[] arr = new long[n];
        
		int lower;
		int upper;
		long sum;

		for(int i=0;i<n;i++) arr[i]=0;

		for(int i=0;i<queries.length;i++){
		    lower=queries[i][0];
		    upper=queries[i][1];
		    sum=queries[i][2];
		    arr[lower-1]+=sum;
		    if(upper<n) arr[upper]-=sum; 
		}
		        
		long max=0;
		long temp=0;

		for(int i=0;i<n;i++){
		    temp += arr[i];
		    if(temp> max) max=temp;
		}

		return max;
	}

	public static void main(String[] args) throws IOException {
		System.out.println(arrayManipulation(10, new int[][] { { 1, 5, 3 }, { 4, 8, 7 }, { 6, 9, 1 } }));
//		System.out.println(arrayManipulation(5, new int[][] { { 1, 2, 100 }, { 2, 5, 100 }, { 3, 4, 100 } }));
	}
}
