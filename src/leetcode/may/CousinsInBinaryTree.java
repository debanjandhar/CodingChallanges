package leetcode.may;

import java.util.LinkedList;
import java.util.Queue;

public class CousinsInBinaryTree {

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

	}

	public boolean isCousins(TreeNode root, int x, int y) {
		boolean isCousin = false;

		TreeNode tmp = root;
		Traverse first = null;
		Queue<Traverse> q = new LinkedList<>();
		q.add(new Traverse(tmp, 1, -1));
		while (!q.isEmpty()) {
			Traverse curr = q.remove();
			int currH = curr.height;
			
			if (first != null && currH > first.height) {
				break;
			}
			
			if (curr.node.val == x || curr.node.val == y) {
				if (first == null) {
					first = curr;
				}else {
					if (first.parent != curr.parent) {
						isCousin = true;
					}
					break;
				}
			}
			
			if (curr.node.left != null) {
				q.add(new Traverse(curr.node.left, curr.height+1, curr.node.val));
			}

			if (curr.node.right != null) {
				q.add(new Traverse(curr.node.right, curr.height+1, curr.node.val));
			}
		}

		return isCousin;
	}

	class Traverse {
		TreeNode node;
		int height;
		int parent;

		public Traverse(TreeNode node, int height, int parent) {
			this.node = node;
			this.height = height;
			this.parent = parent;
		}
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
		CousinsInBinaryTree c = new CousinsInBinaryTree();
		TreeNode tn = c.prepareTree(new Integer[] { 1, 18, 2, null, null, 3, 4, 17, 10, 5, 6, null, null, 21, 12, 8, 11,
				31, 7, null, null, 37, 15, null, 9, 29, 14, null, 35, 24, 20, 44, null, 19, 25, 22, 13, 41, 32, 39, 16,
				36, null, null, null, 27, null, null, null, 23, null, null, 47, 30, 26, null, 49, null, 50, null, null,
				null, null, 45, 28, null, null, null, null, 43, null, null, null, 34, 38, null, 33, null, null, null,
				null, null, 46, 40, null, null, null, null, 48, null, 42 });

		System.out.println(c.isCousins(tn, 28, 30));
	}
}
