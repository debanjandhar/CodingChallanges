package hackerrank;
import java.util.ArrayList;
import java.util.List;

public class Helper {
	public static List<Integer> getListFromint(int[] elements) {
		List<Integer> outputList = new ArrayList<Integer>();

		for (int i = 0; i < elements.length; i++) {
			outputList.add(elements[i]);
		}

		return outputList;
	}
}
