package leetcode.thirtyday;

public class DiameterOfBinaryTree {

	public int diameterOfBinaryTree(TreeNode root) {
		int prevDiameter = 0;
		int currDiameter = 0;

		TreeNode tmp = root;

		while (true) {
			if (tmp == null) {
				break;
			}
			int maxHeightLeft = getHeight(tmp.left);
			int maxHeightRight = getHeight(tmp.right);

			currDiameter = maxHeightLeft + maxHeightRight;

			if (prevDiameter > currDiameter) {
				break;
			} else {
				prevDiameter = currDiameter;
			}

			if (maxHeightLeft > maxHeightRight) {
				tmp = tmp.left;
			} else {
				tmp = tmp.right;
			}
		}

		return prevDiameter;
	}

	private int getHeight(TreeNode node) {
		if (node == null) {
			return 0;
		}

		int left = getHeight(node.left);
		int right = getHeight(node.right);

		if (left > right) {
			return left + 1;
		} else {
			return right + 1;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(null));
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
