package leetcode.thirtyday;

public class MiddleNode {
	public ListNode middleNode(ListNode head) {
		ListNode slowNode = head;
		ListNode fastNode = head;

		int count = 0;
		while (fastNode != null) {
			count = (count + 1) % 2;
			fastNode = fastNode.next;
			if (count == 0) {
				slowNode = slowNode.next;
			}
		}

		return slowNode;

	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode temp = head;
		for (int i = 2; i <= 6; i++) {
			temp.next = new ListNode(i);
			temp = temp.next;
		}
		
		System.out.println(new MiddleNode().middleNode(head).val);
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}