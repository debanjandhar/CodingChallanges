package hackerrank;
public class IsThisBinarySearchTree {
	/*
	 * Hidden stub code will pass a root argument to the function below. Complete
	 * the function to solve the challenge. Hint: you may want to write one or more
	 * helper functions.
	 * 
	 * The Node class is defined as follows: class Node { int data; Node left; Node
	 * right; }
	 */
	boolean checkBST(Node currNode) {
		if (currNode.left == null || currNode.right == null) {
			return true;
		} else if (currNode.data < currNode.left.data || currNode.data > currNode.right.data) {
			return false;
		} else if (checkBST(currNode.left) && checkBST(currNode.right)) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		IsThisBinarySearchTree isbst = new IsThisBinarySearchTree();

		Node root = isbst.new Node(null, null, 18);
		root.left = isbst.new Node(null, null, 8);
		root.right = isbst.new Node(null, null, 20);
		root.right.left = isbst.new Node(null, null, 18);
		root.right.right = isbst.new Node(null, null, 30);

		System.out.println(isbst.checkBST(root)); // Should return false
	}

	class Node {
		int data;
		Node left;
		Node right;

		public Node(Node left, Node right, int data) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

		public Node(Node left, Node right) {
			this.data = 0;
			this.left = left;
			this.right = right;
		}
	}
}
