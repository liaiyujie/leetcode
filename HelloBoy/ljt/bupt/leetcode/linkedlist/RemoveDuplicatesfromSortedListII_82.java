package ljt.bupt.leetcode.linkedlist;

public class RemoveDuplicatesfromSortedListII_82 {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 8, 9, 9 };
		ListNode head = ListNode.build(nums);
		long start = System.currentTimeMillis();
		ListNode res = deleteDuplicates(head);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		System.out.println(res);
	}
//  现在要删除重复的所有元素
	private static ListNode deleteDuplicates(ListNode head) {
		if(head == null ||head.next == null)
			return head;
		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		dummy.next = head;
		
		
		
		ListNode.printList(dummy.next);
		return dummy.next;
	}

}
