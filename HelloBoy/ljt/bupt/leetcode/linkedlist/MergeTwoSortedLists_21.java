package ljt.bupt.leetcode.linkedlist;

public class MergeTwoSortedLists_21 {

	public static void main(String[] args) {
		int[] nums1 = { 5 };
		int[] nums2 = { 2, 4, 6, 8, 10 };
		ListNode l1 = ListNode.build(nums1);
		ListNode l2 = ListNode.build(nums2);
		long start = System.currentTimeMillis();
		ListNode res = mergeTwoLists(l1, l2);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		ListNode.printList(res);
	}

	private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode root = new ListNode(Integer.MIN_VALUE);
		ListNode root1 = root;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				root.next = l1;
				l1 = l1.next;
				root = root.next;
				root.next = null;
			} else {
				root.next = l2;
				l2 = l2.next;
				root = root.next;
				root.next = null;
			}
		}
		if (l1 != null) {
			root.next = l1;
		}
		if (l2 != null) {
			root.next = l2;
		}
		ListNode.printList(root1.next);
		return root1.next;
	}

}
