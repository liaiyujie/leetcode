package ljt.bupt.leetcode.linkedlist;

public class LinkedListCycle_141 {

	public static void main(String[] args) {
		int[] nums = { 6, 1, 2, 3, 4, 5, 2 };
		ListNode head = ListNode.build(nums);
		long start = System.currentTimeMillis();
		boolean res = hasCycle(head);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		System.out.println(res);
	}

	// make all the node you visited links to the head ListNode.
	// once you reach a new ListNode,see whether its next point is the head,
	// if it is, means the node you've already visited,
	// which means the link has a cycle.
	private static boolean hasCycle(ListNode head) {
		ListNode p = head, pre = head;
		while (p != null && p.next != null) {
			if (p.next == head)
				return true;
			p = p.next;
			pre.next = head;
			pre = p;
		}
		return false;
	}

	private static boolean hasCycle1(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				return true;
		}
		return false;
	}

}
