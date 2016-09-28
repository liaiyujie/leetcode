package ljt.bupt.leetcode.linkedlist;

public class OddEvenLinkedList_328 {

	public static void main(String[] args) {
		int[] nums = { 1 };
		ListNode head = ListNode.build(nums);
		long start = System.currentTimeMillis();
		int val = 12;
		ListNode res = oddEvenList(head);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		ListNode.printList(res);
	}
//	Simple O(N) time, O(1), space Java solution.
	private static ListNode oddEvenList(ListNode head) {
		if (head != null) {

			ListNode odd = head, even = head.next, evenHead = even;

			while (even != null && even.next != null) {
				odd.next = odd.next.next;
				even.next = even.next.next;
				odd = odd.next;
				even = even.next;
			}
			odd.next = evenHead;
		}
		return head;
	}

	
	
	// You should try to do it in place.
	// The program should run in O(1) space complexity and O(nodes) time
	// complexity.
	private static ListNode oddEvenList1(ListNode head) {// 这个代码的空间复杂度为O（n），不合题意
		if (head == null) {
			return null;
		}

		ListNode root = new ListNode(head.val);
		ListNode tmp = root;
		ListNode headtmp = head;
		// 将奇数的节点连接上，操作headtmp
		while (headtmp.next != null) {
			if (headtmp.next.next != null) {
				ListNode l = new ListNode(headtmp.next.next.val);
				tmp.next = l;
				tmp = tmp.next;
				headtmp = headtmp.next.next;

			} else {
				tmp.next = null;
				break;
			}
		}

		// 将偶数的节点连接上，现在直接操作head
		head = head.next;
		if (head == null)
			return root;
		tmp.next = new ListNode(head.val);
		tmp = tmp.next;
		while (head.next != null) {
			if (head.next.next != null) {
				ListNode l = new ListNode(head.next.next.val);
				tmp.next = l;
				tmp = tmp.next;
				head = head.next.next;

			} else {
				tmp.next = null;
				break;
			}
		}
		ListNode.printList(root);
		return root;
	}

}
