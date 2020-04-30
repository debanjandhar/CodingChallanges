package leetcode.thirtyday;

public class BinaryTreeMaximumPathSum {
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

	private int maxPath(TreeNode node, Result res) {
		if (node == null)
			return 0;

		int l = maxPath(node.left, res);
		int r = maxPath(node.right, res);

		int max_single = Math.max(Math.max(l, r) + node.val, node.val);

		int max_top = Math.max(max_single, l + r + node.val);

		res.result = Math.max(res.result, max_top);

		return max_single;
	}

	class Result {
		int result;
	}

	public int maxPathSum(TreeNode root) {
		Result res = new Result();
		res.result = Integer.MIN_VALUE;
		maxPath(root, res);
		return res.result;
	}

//	public int maxPathSum(TreeNode root) {
//		int max = Integer.MIN_VALUE;
//		if (root == null) {
//			return 0;
//		} else if (root.left == null && root.right == null) {
//			return root.val;
//		}
//
//		TreeNode tmp = root;
//		max = root.val;
//		while (tmp != null) {
//			int left = Integer.MIN_VALUE;
//			int currMax = 0;
//			if (tmp.left != null) {
//				left = maxPath(tmp.left);
//				currMax += left;
//			} else {
//				currMax += 0;
//			}
//
//			int right = Integer.MIN_VALUE;
//			if (tmp.right != null) {
//				right = maxPath(tmp.right);
//				currMax += right;
//			} else {
//				currMax += 0;
//			}
//
//			currMax += tmp.val;
//
//			if (left > right) {
//				tmp = tmp.left;
//			} else {
//				tmp = tmp.right;
//			}
//		}
//
//		return max;
//	}
//
//	private int max(int a, int b, int c, int d) {
//		int left = max(a, b, c);
//		int right = max(b, c, d);
//		
//		if (left > right) {
//			return left;
//		}else {
//			return right;
//		}
//	}
//
//	private int max(int a, int b, int c) {
//		if (a > b) {
//			return a > c ? a : c;
//		} else {
//			return b > c ? b : c;
//		}
//	}
//
//	private int maxPath(TreeNode node) {
//		if (node == null) {
//			return 0;
//		}
//
//		int left = maxPath(node.left);
//		int right = maxPath(node.right);
//
//		if (left > right) {
//			return left + node.val;
//		} else {
//			return right + node.val;
//		}
//
//	}

	public static void main(String[] args) {
		BinaryTreeMaximumPathSum b = new BinaryTreeMaximumPathSum();

		TreeNode root = b.new TreeNode(5);
		root.left = b.new TreeNode(-9);
		root.right = b.new TreeNode(4);

		// TreeNode root = b.new TreeNode(1);
//		root.left = b.new TreeNode(-2);
//		root.right = b.new TreeNode(3);

		// TreeNode root = b.new TreeNode(1);
//		root.left = b.new TreeNode(2);
//		root.right = b.new TreeNode(3);

//		TreeNode root = b.new TreeNode(-2);
//		root.left = b.new TreeNode(-1);

//		TreeNode root = b.new TreeNode(-10);
//		root.left = b.new TreeNode(9);
//		root.right = b.new TreeNode(20);
//		root.right.left = b.new TreeNode(15);
//		root.right.right = b.new TreeNode(7);

		System.out.println(b.maxPathSum(root));
	}
}
