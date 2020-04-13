package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NoPrefixSet {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numStr = Integer.parseInt(br.readLine());

		Trie_nps t = new Trie_nps();
		boolean isBadSet = false;
		String s = "";
		for (int i = 0; i < numStr; i++) {
			s = br.readLine();
			if (!t.insert(s)) {
				isBadSet = true;
				break;
			}
		}

		if (isBadSet) {
			System.out.println("BAD SET");
			System.out.println(s);
		} else {
			System.out.println("GOOD SET");
		}
	}
}

class Trie_nps {
	Node_nps root;

	public Trie_nps() {
		root = new Node_nps();
	}

	public boolean insert(String s) {
		Node_nps tmp = root;
		char[] cArr = s.toCharArray();
		for (int i = 0; i < cArr.length; i++) {
			char c = cArr[i];
			int index = (int) c - 'a';
			if (tmp.children[index] == null) {
				tmp.children[index] = new Node_nps();
			} else if (tmp.children[index].isLastChar) {
				// A prefix already exists in the tree.
				return false;
			} else if (i == cArr.length - 1) {
				// Current string is prefix of a string already exists in tree.
				return false;
			}

			tmp = tmp.children[index];
		}
		tmp.isLastChar = true;
		return true;
	}
}

class Node_nps {
	Node_nps[] children = new Node_nps[26];
	boolean isLastChar;

	public Node_nps() {
		isLastChar = false;
		for (Node_nps node_nps : children) {
			node_nps = null;
		}
	}
}