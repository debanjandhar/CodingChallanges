package hackerrank;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Contacts {

	static int[] contacts(String[][] queries) {
		List<Integer> output = new ArrayList<Integer>();
		;

		int numQueries = queries.length;
		Trie trie = new Trie();
		for (int i = 0; i < numQueries; i++) {
			switch (queries[i][0]) {
			case "add":
				trie.insert(queries[i][1]);
				break;
			case "find":
				output.add((trie.findPartial(queries[i][1])));
			}
		}

		return getArrayFromList(output);
	}

	private static int[] getArrayFromList(List<Integer> inputList) {
		int[] output = new int[inputList.size()];

		int index = 0;
		for (int i : inputList) {
			output[index++] = i;
		}

		return output;
	}

	public static void main(String[] args) throws IOException {

		String[][] queries = new String[][] { { "add", "hack" }, {"add", "hackerrank"},{"find", "hac"},{"find", "hak"} };
		
		System.out.println(Arrays.toString(contacts(queries)));
	}
}

class Trie {
	Node root;

	public Trie() {
		root = new Node();
		root.isLastAlphabet = true;
	}

	public void insert(String s) {
		Node tmp = root;
		for (char c : s.toCharArray()) {
			int charIndex = getCharIndex(c);

			if (tmp.children[charIndex] == null) {
				tmp.children[charIndex] = new Node();
			}
			tmp.children[charIndex].numChildren++;
			tmp = tmp.children[charIndex];
		}

		tmp.isLastAlphabet = true;
	}

	public int findPartial(String s) {
		Node tmp = root;
		for (char c : s.toCharArray()) {
			int charIndex = getCharIndex(c);
			if (tmp.children[charIndex] == null) {
				return 0;
			} else {
				tmp = tmp.children[charIndex];
			}
		}

		return tmp.numChildren;
	}

	private int getCharIndex(char c) {
		return (int) c - (int) 'a';
	}
}

class Node {
	private final int NUM_ALPHABETS = 26;

	public Node[] children;

	public int numChildren;

	public boolean isLastAlphabet;

	public Node() {
		this.children = new Node[NUM_ALPHABETS];
		this.numChildren = 0;

		for (Node node : children) {
			node = null;
		}
	}
}
