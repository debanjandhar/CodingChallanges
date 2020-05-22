package leetcode.may;

class Trie {
	
	class Node {
		private final int NUM_ALPHABETS = 26;

		public Node[] children;

		public boolean isLastAlphabet;

		public Node() {
			this.children = new Node[NUM_ALPHABETS];

			for (Node node : children) {
				node = null;
			}
		}
	}
	
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
			tmp = tmp.children[charIndex];
		}

		tmp.isLastAlphabet = true;
	}

	public boolean search(String word) {
		Node tmp = root;

		for (char c : word.toCharArray()) {
			int charIndex = getCharIndex(c);

			if (tmp.children[charIndex] == null) {
				return false;
			}
			tmp = tmp.children[charIndex];
		}

		if (tmp.isLastAlphabet) {
			return true;
		} else {
			return false;
		}
	}

	public boolean startsWith(String prefix) {
		Node tmp = root;

		for (char c : prefix.toCharArray()) {
			int charIndex = getCharIndex(c);

			if (tmp.children[charIndex] == null) {
				return false;
			}
			tmp = tmp.children[charIndex];
		}

		return true;
	}

	private int getCharIndex(char c) {
		return (int) c - (int) 'a';
	}

	public static void main(String[] args) {
		Trie trie = new Trie();

		trie.insert("apple");
		System.out.println(trie.search("apple"));
		System.out.println(trie.search("app"));
		System.out.println(trie.startsWith("app"));
		trie.insert("app");
		System.out.println(trie.search("app"));
	}
}
