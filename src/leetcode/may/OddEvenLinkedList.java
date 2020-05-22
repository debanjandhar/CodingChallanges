package leetcode.may;

public class OddEvenLinkedList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
        
        ListNode evenTmp = null, evenHead = null, oddTmp = null;
		ListNode i = head;
		for (; i.next != null; i = i.next.next) {
			if (oddTmp == null) {
				oddTmp = i;
				evenHead = i.next;
				evenTmp = evenHead;
			} else {
				oddTmp.next = i;
				oddTmp = oddTmp.next;
				evenTmp.next = i.next;
				evenTmp = evenTmp.next;
			}
            
            if (i.next.next == null) {
				break;
			}
		}

		oddTmp.next = i;
		i.next = evenHead;
		evenTmp.next = null;
        
		return head;
	}

	public void printLL(ListNode head) {
		ListNode tmp = head;

		while (tmp != null) {
			System.out.print(tmp.val);
			System.out.print(",");
			tmp = tmp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		OddEvenLinkedList o = new OddEvenLinkedList();

//		int[] values = new int[] { 2, 1, 3, 5, 6, 4, 7 };
//		int[] values = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] values = new int[] { 1 };

		ListNode head = o.new ListNode(values[0]);
		ListNode tmp = head;
		for (int i = 1; i < values.length; i++) {
			ListNode l = o.new ListNode(values[i]);
			tmp.next = l;
			tmp = tmp.next;
		}

		o.printLL(head);
		o.printLL(new OddEvenLinkedList().oddEvenList(head));
	}
}
