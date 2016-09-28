package ljt.bupt.leetcode.linkedlist;

public class RemoveLinkedListElements_203 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 6, 1, 2, 6, 6, 6, 6, 6, 3, 4, 5, 6 };
		ListNode head = ListNode.build(nums);
		long start = System.currentTimeMillis();
		int val = 6;
		ListNode res = removeElements1(head, val);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		ListNode.printList(res);
	}

	private static ListNode removeElements(ListNode head, int val) {
		ListNode root = new ListNode(Integer.MIN_VALUE);
		root.next = head;
		ListNode temp = root;
		while (temp.next != null) {
			if (temp.next.val != val) {
				temp = temp.next;
			} else {
				temp.next = temp.next.next;
			}
		}
		ListNode.printList(root.next);
		return root.next;
	}

	private static ListNode removeElements1(ListNode head, int val) {
		//自己写的算法，1ms 击败百分子84，上面的2ms
		if(head==null){
			return null;
		}
		ListNode tmp = head;
		while (tmp.next != null) {
			if (tmp.next.val == val) {
				tmp.next = tmp.next.next;
//				tmp = tmp.next;
			} else {
				tmp = tmp.next;
			}
		}
		if (head.val == val) {
			head = head.next;
		}
		// ListNode.printList(head);
		return head;
	}
}
