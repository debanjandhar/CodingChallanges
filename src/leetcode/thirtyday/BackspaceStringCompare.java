package leetcode.thirtyday;

public class BackspaceStringCompare {
	public boolean backspaceCompare(String S, String T) {
		return getString(S).equals(getString(T));
	}

	private String getString(String s) {
		char[] sTemp = new char[200];
		int sp = 0;
		for (char c : s.toCharArray()) {
			if (c == '#') {
				sp = sp < 0 ? sp : --sp;
			} else {
				sp = sp < 0 ? 0 : sp;
				sTemp[sp++] = c;
			}
		}
		String output = "";
		for (int i = 0; i < sp; i++) {
			output += sTemp[i];
		}
		return output;
	}

	public static void main(String[] args) {
//		System.out.println(new BackspaceStringCompare().backspaceCompare("ab#c", "ad#c"));
		System.out.println(new BackspaceStringCompare().backspaceCompare("ab##", "c#d#"));
	}
}
