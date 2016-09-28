package ljt.bupt.leetcode.linkedlist;

public class LinkedListCycleII_142 {

	public static void main(String[] args) {
		int[] nums = { 6, 1, 2, 3, 4, 5, 2 };
		ListNode head = ListNode.build(nums);
		long start = System.currentTimeMillis();
		ListNode res = detectCycle(head);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		System.out.println(res);
	}

	private static ListNode detectCycle(ListNode head) {
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (slow == fast) {
				while (head != slow) {
					head = head.next;
					slow = slow.next;
				}
				return slow;
			}
		}
		return null;
	}

	private static ListNode detectCycle1(ListNode head) {//和上面一样的
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				while (head != fast) {
					head = head.next;
					fast = head.next;
				}
				return head;
			}
		}
		return null;
	}

}
