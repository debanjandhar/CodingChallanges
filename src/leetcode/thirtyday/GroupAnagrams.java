package leetcode.thirtyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> output = new ArrayList<List<String>>();
		Map<String, List<String>> groups = new HashMap<String, List<String>>();
		String tempS = "";
		for (String str : strs) {

			char[] strArr = str.toCharArray();
			Arrays.sort(strArr);
			tempS = new String(strArr);
			if (groups.containsKey(tempS)) {
				List<String> tempList = groups.get(tempS);
				tempList.add(str);
				groups.put(tempS, tempList);
			}else {
				List<String> firstList = new ArrayList<String>();
				firstList.add(str);
				groups.put(tempS, firstList);
			}
		}

		for (List<String> value : groups.values()) {
			output.add(value);
		}

		return output;
	}

	public static void main(String[] args) {
		String[] strs = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> toPrint = new GroupAnagrams().groupAnagrams(strs);
		for (List<String> l : toPrint) {
			System.out.println(l);
		}
	}
}
