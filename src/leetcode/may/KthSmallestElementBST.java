package leetcode.may;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class KthSmallestElementBST {

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

	public int kthSmallest(TreeNode root, int k) {
		int[] res = new int[2];
		res[0] = k;

		inOrder(root, res);

		return res[1];
	}

	private void inOrder(TreeNode node, int[] input) {
		if (input[0] == 0 || node == null) {
			return;
		}

		inOrder(node.left, input);
		input[0]--;
		if (input[0] < 0) {
			return;
		}
		input[1] = node.val;
		inOrder(node.right, input);
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
//		Integer[] nodes = new Integer[] { 3, 1, 4, null, 2 };
		Integer[] nodes = new Integer[] { 5, 3, 6, 2, 4, null, null, 1 };
		KthSmallestElementBST k = new KthSmallestElementBST();
		System.out.println(k.kthSmallest(k.prepareTree(nodes), 4));
	}

}
