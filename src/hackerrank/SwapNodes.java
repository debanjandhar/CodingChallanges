package hackerrank;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author debanjandhar
 * 
 *         Question :
 *         https://www.hackerrank.com/challenges/swap-nodes-algo/problem
 *
 */
public class SwapNodes {

	static int[][] swapNodes(int[][] indexes, int[] queries) {
		int[][] output = new int[queries.length][];

		Node_sn head = prepareTree(indexes);

		for (int height = 0; height < queries.length; height++) {
			Queue<Node_sn> q = new LinkedList<Node_sn>();
			q.add(head);

			while (!q.isEmpty()) {
				Node_sn currNode = q.remove();

				if (currNode.height % queries[height] == 0) {
					// swap nodes
					Node_sn tmp = currNode.left;
					currNode.left = currNode.right;
					currNode.right = tmp;
				}

				if (currNode.left != null) {
					q.add(currNode.left);
				}
				if (currNode.right != null) {
					q.add(currNode.right);
				}
			}
			output[height] = new int[indexes.length];
			inOrderTraverse(head, output[height]);
		}

		return output;
	}

	private static void inOrderTraverse(Node_sn head, int[] output) {
		Stack<Node_sn> s = new Stack<Node_sn>();

		int index = 0;
		Node_sn currNode = head;
		while (!s.isEmpty() || currNode != null) {
			if (currNode == null) {
				Node_sn tmp = s.pop();
				output[index++] = tmp.data;
				currNode = tmp.right;
			} else {
				s.push(currNode);
				currNode = currNode.left;
			}
		}
	}

	private static Node_sn prepareTree(int[][] indexes) {
		Node_sn head = new Node_sn(1);
		Queue<Node_sn> q = new LinkedList<Node_sn>();
		q.add(head);

		head.height = 1;

		Node_sn tmp = null;

		for (int i = 0; i < indexes.length; i++) {
			tmp = q.remove();

			int left = indexes[i][0];
			int right = indexes[i][1];

			if (left == -1) {
				tmp.left = null;
			} else {
				tmp.left = new Node_sn(left);
				tmp.left.height = tmp.height + 1;
				q.add(tmp.left);
			}

			if (right == -1) {
				tmp.right = null;
			} else {
				tmp.right = new Node_sn(right);
				tmp.right.height = tmp.height + 1;
				q.add(tmp.right);
			}

		}

		return head;
	}

	private static void printTree(Node_sn head) {
		Node_sn tmp = head;
		Queue<Node_sn> q = new LinkedList<Node_sn>();
		q.add(tmp);
		System.out.println("Root : " + tmp.data + " at height " + tmp.height);
		while (!q.isEmpty()) {
			tmp = q.remove();
			if (tmp.left != null) {
				System.out.println("Left of " + tmp.data + " is " + tmp.left.data + " at height " + tmp.left.height);
				q.add(tmp.left);
			}
			if (tmp.right != null) {
				System.out.println("Right of " + tmp.data + " is " + tmp.right.data + " at height " + tmp.right.height);
				q.add(tmp.right);
			}
		}
	}

	public static void main(String[] args) throws IOException {

//		int[][] indexes = new int[][] { { 2, 3 }, { 4, -1 }, { 5, -1 }, { 6, -1 }, { 7, 8 }, { -1, 9 }, { -1, -1 },
//				{ 10, 11 }, { -1, -1 }, { -1, -1 }, { -1, -1 } };
//		int[] queries = new int[] { 2, 4 };
		int[][] indexes = new int[][] { { -1, 2 }, { 3, 4 }, { 5, 6 }, { 7, -1 }, { 8, -1 }, { 9, 10 }, { 11, 12 },
				{ -1, 13 }, { 14, 15 }, { -1, -1 }, { -1, 16 }, { 17, -1 }, { 18, 19 }, { 20, 21 }, { 22, 23 },
				{ -1, -1 }, { 24, 25 }, { 26, -1 }, { 27, 28 }, { 29, 30 }, { 31, -1 }, { 32, 33 }, { 34, 35 },
				{ 36, 37 }, { 38, 39 }, { -1, 40 }, { -1, 41 }, { -1, 42 }, { -1, -1 }, { 43, 44 }, { -1, -1 },
				{ 45, 46 }, { 47, 48 }, { -1, -1 }, { -1, 49 }, { -1, 50 }, { 51, 52 }, { -1, 53 }, { 54, 55 },
				{ -1, 56 }, { 57, -1 }, { -1, 58 }, { 59, -1 }, { 60, 61 }, { -1, 62 }, { -1, 63 }, { -1, -1 },
				{ -1, 64 }, { 65, -1 }, { 66, -1 }, { -1, 67 }, { -1, -1 }, { -1, 68 }, { -1, 69 }, { 70, -1 },
				{ 71, -1 }, { 72, 73 }, { 74, 75 }, { -1, -1 }, { 76, -1 }, { 77, -1 }, { -1, -1 }, { 78, -1 },
				{ -1, -1 }, { 79, 80 }, { 81, 82 }, { -1, 83 }, { 84, -1 }, { 85, -1 }, { 86, -1 }, { -1, 87 },
				{ -1, -1 }, { -1, -1 }, { -1, 88 }, { -1, -1 }, { 89, 90 }, { -1, -1 }, { 91, -1 }, { -1, 92 },
				{ 93, -1 }, { 94, 95 }, { -1, -1 }, { 96, 97 }, { 98, -1 }, { -1, 99 }, { 100, -1 }, { -1, -1 },
				{ -1, -1 }, { -1, -1 }, { -1, -1 }, { -1, -1 }, { -1, -1 }, { -1, -1 }, { -1, -1 }, { -1, -1 },
				{ -1, -1 }, { -1, -1 }, { -1, -1 }, { -1, -1 }, { -1, -1 } };
		int[] queries = new int[] { 8, 6, 2, 3, 5, 7, 7, 5, 7, 1, 5, 6, 2, 8, 4, 6, 8, 12, 10, 6, 12, 11, 12, 8, 1, 7,
				9, 3, 8, 7, 2, 7, 8, 3, 8, 9, 7, 9, 9, 8, 11, 10, 4, 12, 4 };

		int[][] output = swapNodes(indexes, queries);
		for (int[] i : output) {
			System.out.println(Arrays.toString(i));
		}

//		printTree(prepareTree(indexes));
//		int[] output = new int[indexes.length];
//		inOrderTraverse(prepareTree(indexes), output);
//		System.out.println(Arrays.toString(output));
	}
}

class Node_sn {
	int data;
	int height;
	Node_sn left;
	Node_sn right;

	public Node_sn(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	@Override
	public String toString() {
		return data + " at height " + height;
	}
}