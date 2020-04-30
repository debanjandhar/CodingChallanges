package leetcode.thirtyday;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeValidSequence {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return String.valueOf(val);
		}

	}

	public boolean isValidSequence(TreeNode root, int[] arr) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		if (root == null) {
			if (arr.length == 0) {
				return true;
			} else {
				return false;
			}
		} else if (root.val != arr[0]) {
			return false;
		}

		s.add(root);

		int index = 1;
		while (!s.isEmpty()) {
			boolean isFound = false;
			TreeNode curr = s.pop();

			if (index == arr.length) {
				if (curr.left == null && curr.right == null) {
					return true;
				} else {
					continue;
				}
			}

			if (curr.left != null && curr.left.val == arr[index]) {
				s.add(curr.left);
				isFound = true;
			}

			if (curr.right != null && curr.right.val == arr[index]) {
				s.add(curr.right);
				isFound = true;
			}

			if (isFound) {
				index++;
			} else if (!s.isEmpty() && s.peek().val != curr.val) {
				index--;
			}

		}

		return false;
	}

	private TreeNode prepareTree(Integer[] nodes) {

		if (nodes.length == 0) {
			return null;
		}

		TreeNode root = new TreeNode(nodes[0]);
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		int index = 1;
		while (index < nodes.length) {
			TreeNode curr = q.remove();
			if (nodes[index] != null) {
				TreeNode left = new TreeNode(nodes[index++]);
				curr.left = left;
				q.add(left);
			} else {
				index++;
			}
			if (index < nodes.length && nodes[index] != null) {
				TreeNode right = new TreeNode(nodes[index++]);
				curr.right = right;
				q.add(right);
			} else {
				index++;
			}
		}

		return root;
	}

	public static void main(String[] args) {
		BinaryTreeValidSequence b = new BinaryTreeValidSequence();

		TreeNode root = b.prepareTree(new Integer[] { 0, 1, 0, 0, 1, 0, null, null, 1, 0, 0 });
		int[] arr = new int[] { 0, 0, 1 };

		System.out.println(b.isValidSequence(root, arr));
	}
}
