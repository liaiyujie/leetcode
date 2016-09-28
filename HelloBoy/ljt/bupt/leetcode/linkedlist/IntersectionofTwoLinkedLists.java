package ljt.bupt.leetcode.linkedlist;

public class IntersectionofTwoLinkedLists {

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
		int[] nums2 = { 14 };
		ListNode headA = ListNode.build(nums1);
		ListNode headB = ListNode.build(nums2);
		long start = System.currentTimeMillis();
		ListNode res = getIntersectionNode(headA, headB);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		ListNode.printList(res);

	}

	private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode lenCountA = headA;
		ListNode lenCountB = headB;
		int lenA = 0;
		int lenB = 0;
		while (lenCountA != null || lenCountB != null) {
			if (lenCountA != null) {
				lenA++;
				lenCountA = lenCountA.next;
			}
			if (lenCountB != null) {
				lenB++;
				lenCountB = lenCountB.next;
			}
		}
		// System.out.println(lenA+":::"+lenB);
		int abs = Math.abs(lenA - lenB);
		if (lenA >= lenB) {
			while (abs-- > 0) {
				headA = headA.next;
			}
		}
		if (lenA < lenB) {
			while (abs-- > 0) {
				headB = headB.next;
			}
		}
		while (headA != null && headB != null) {
			if (headA.val == headB.val) {
				return headA;
			} else {
				headA = headA.next;
				headB = headB.next;
			}

		}
		ListNode.printList(headA);
		return null;
	}

}
