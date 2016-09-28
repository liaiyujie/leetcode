package ljt.bupt.leetcode.linkedlist;

public class AddTwoNumbers_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = { 5,6,7,9,9,9,9,9 };
		int[] nums2 = { 5,6,7 };
		ListNode l1 = ListNode.build(nums1);
		ListNode l2 = ListNode.build(nums2);
		long start = System.currentTimeMillis();
		ListNode res = addTwoNumbers(l1, l2);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		ListNode.printList(res);
	}

	private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;

		ListNode newHead = new ListNode(0);
		ListNode p1 = l1, p2 = l2, p3 = newHead;

		while (p1 != null || p2 != null) {
			if (p1 != null) {
				carry += p1.val;
				p1 = p1.next;
			}

			if (p2 != null) {
				carry += p2.val;
				p2 = p2.next;
			}

			p3.next = new ListNode(carry % 10);
			p3 = p3.next;
			carry /= 10;
		}

		if (carry == 1)
			p3.next = new ListNode(1);

		return newHead.next;
	}
//我自己写的函数，效率和上面别人写的函数差不多
	private static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode root = new ListNode(Integer.MIN_VALUE);
		ListNode root1 = root;
		boolean array = false;// 记住进位消息
		while (l1 != null && l2 != null) {
			int val = l1.val + l2.val;
			if (array == true) {
				val++;
				array = false;
			}
			if (val >= 10) {
				array = true;
			}
			ListNode tmp = new ListNode(val % 10);
			root.next = tmp;
			root = root.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		if (l1 == null && l2 == null && array == true) {
			root.next = new ListNode(1);
		}
		while (l1 != null) {
			if (array == true) {
				int val = l1.val + 1;
				array = false;
				if (val >= 10) {
					array = true;
				}
				ListNode tmp = new ListNode(val % 10);
				root.next = tmp;
				root = root.next;
				l1 = l1.next;
			} else {
				root.next = l1;
				break;
				// l1 = l1.next;
			}

		}
		while (l2 != null) {
			if (array == true) {
				int val = l2.val + 1;
				array = false;
				if (val >= 10) {
					array = true;
				}
				ListNode tmp = new ListNode(val % 10);
				root.next = tmp;
				root = root.next;
				l2 = l2.next;
			} else {
				root.next = l2;
				break;
				// l2 = l2.next;
			}
		}
		if (array == true)
			root.next = new ListNode(1);
		// ListNode.printList(root1.next);
		return root1.next;
	}

}
