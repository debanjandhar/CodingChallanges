package leetcode.thirtyday;

import java.util.HashMap;

class FirstUnique {

	class Node {
		int val;
		Node next;
		Node prev;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.prev = null;
		}

		@Override
		public String toString() {
			return "[" + val + "]";
		}
	}

	Node head;
	Node tail;

	HashMap<Integer, Node> map = new HashMap<Integer, Node>();

	public FirstUnique(int[] nums) {
		head = null;
		tail = null;
		for (int i : nums) {
			add(i);
		}
	}

	public int showFirstUnique() {
		if (head==null) {
			return -1;
		}
		
		return head.val;
	}

	public void add(int value) {
		if (map.containsKey(value)) {
			removeNode(map.get(value));
			map.put(value, null);
		} else {
			Node currNode = new Node(value);
			if (head == null) {
				head = currNode;
				tail = currNode;
			} else {
				tail.next = currNode;
				currNode.prev = tail;
				tail = currNode;
			}

			map.put(value, currNode);
		}
	}

	private void removeNode(Node node) {
		if (node == null) {
			return;
		} else if (node == head) {
			Node next = head.next;
			if (next != null) {
				head = next;
			} else {
				head = null;
				tail = null;
			}
		} else if (node == tail) {
			tail = node.prev;
			tail.next = null;
		} else {
			Node prev = node.prev;
			Node next = node.next;

			prev.next = next;
			next.prev = prev;
		}
	}
}

public class FirstUniqueNumber {
	public static void main(String[] args) {
//		int[] nums = new int[] { 7, 7, 7, 7, 7, 7 };
//		FirstUnique firstUnique = new FirstUnique(nums);
//		System.out.println(firstUnique.showFirstUnique());
//		firstUnique.add(7);         
//		System.out.println(firstUnique.showFirstUnique());
//		firstUnique.add(3);            
//		System.out.println(firstUnique.showFirstUnique());
//		firstUnique.add(3);            
//		System.out.println(firstUnique.showFirstUnique());
//		firstUnique.add(7);            
//		System.out.println(firstUnique.showFirstUnique());
//		firstUnique.add(17);           
//		System.out.println(firstUnique.showFirstUnique());
		
		int[] nums = new int[] { 2,3,5 };
		FirstUnique firstUnique = new FirstUnique(nums);
		System.out.println(firstUnique.showFirstUnique());
		firstUnique.add(5);
		System.out.println(firstUnique.showFirstUnique());
		firstUnique.add(2);
		System.out.println(firstUnique.showFirstUnique());
		firstUnique.add(3);
		System.out.println(firstUnique.showFirstUnique());
	}
}
