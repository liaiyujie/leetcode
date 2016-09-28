package ljt.bupt.leetcode.linkedlist;

public class RemoveNthNodeFromEndofList_19 {

	public static void main(String[] args) {
		int[] nums = { 6, 1, 2, 6, 9, 6, 10, 6, 3, 4, 5, 6 };
		ListNode head = ListNode.build(nums);
		long start = System.currentTimeMillis();
		int val = 12;
		ListNode res = removeNthFromEnd(head, val);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		ListNode.printList(res);

	}

	private static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode fast = head;
		ListNode slow = head;
		while(n-->0){
			fast = fast.next;
		}
		if(fast == null){
			return head.next;
		}
		while(fast.next!=null){
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
//		ListNode.printList(head);
		return head;
	}

}
