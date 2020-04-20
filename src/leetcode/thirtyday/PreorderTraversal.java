package leetcode.thirtyday;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PreorderTraversal {

	public TreeNode bstFromPreorder(int[] preorder) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		int[] inOrder = Arrays.copyOf(preorder, preorder.length);

		int preIndex = 0;
		int inIndex = 0;
		Arrays.sort(inOrder);

		TreeNode root = new TreeNode(preorder[preIndex++]);
		TreeNode tmp = root;

		s.push(tmp);

		while (preIndex < preorder.length) {
			TreeNode currNode = new TreeNode(preorder[preIndex]);

			TreeNode poppedNode = null;
			while (!s.isEmpty() && inOrder[inIndex] == s.peek().val) {
				poppedNode = s.pop();
				inIndex++;
			}

			if (poppedNode != null) {
				tmp.left = null;
				poppedNode.right = currNode;
				tmp = currNode;
			} else {
				tmp.left = currNode;
				tmp = tmp.left;
			}

			s.push(currNode);
			preIndex++;
		}

		return root;
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			return "[" + val + "]";
		}
	}

	public static void main(String[] args) {
		int[] preorder = new int[] { 8, 5, 1, 7, 10, 12 };

		TreeNode root = new PreorderTraversal().bstFromPreorder(preorder);

		printTree(root);
	}

	private static void printTree(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);

		while (!q.isEmpty()) {
			TreeNode cn = q.remove();
			if (cn == null) {
				System.out.print("null, ");
				continue;
			}

			System.out.print(cn.val + ", ");

			q.add(cn.left);
			q.add(cn.right);
		}
	}

}
