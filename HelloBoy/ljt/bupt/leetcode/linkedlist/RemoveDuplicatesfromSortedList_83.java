package ljt.bupt.leetcode.linkedlist;

public class RemoveDuplicatesfromSortedList_83 {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 8, 9, 9 };
		ListNode head = ListNode.build(nums);
		long start = System.currentTimeMillis();
		ListNode res = deleteDuplicates(head);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		System.out.println(res);
	}

	private static ListNode deleteDuplicates(ListNode head) {
		ListNode root = head;
		while (head!=null&&head.next != null) {
			if (head.next.val == head.val) {
				head.next = head.next.next;
			} else {
				head = head.next;
			}
		}
		ListNode.printList(root);
		return root;
	}

}
