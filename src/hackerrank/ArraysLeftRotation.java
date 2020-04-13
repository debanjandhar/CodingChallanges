package hackerrank;
import java.io.IOException;
import java.util.Arrays;

public class ArraysLeftRotation {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        int startIndex = d % a.length;
        int nextIndex = startIndex;
        int[] outputArr = new int[a.length];

        int index = 0;
        do{
            outputArr[index++] = a[nextIndex];
            nextIndex = (nextIndex+1)%a.length;
        }while(nextIndex != startIndex);

        return outputArr;
    }


    public static void main(String[] args) throws IOException {
    	int[] arr = new int[] {1, 2, 3, 4, 5};
    	int d = 4;

        System.out.println(Arrays.toString(rotLeft(arr, d)));
    }
}
