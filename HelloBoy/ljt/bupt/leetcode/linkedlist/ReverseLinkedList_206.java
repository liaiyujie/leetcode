package ljt.bupt.leetcode.linkedlist;

public class ReverseLinkedList_206 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5};
		ListNode head = ListNode.build(nums);
		long start = System.currentTimeMillis();
		ListNode res = reverseList(head);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		ListNode.printList(res);
	}

	private static ListNode reverseList(ListNode head) {
		ListNode tmp1 = null;
		ListNode tmp2 = null;
		while(head!=null){
			tmp1 = head;
			head = head.next;
			tmp1.next = tmp2;
			tmp2 = tmp1;
			
		}
//		ListNode.printList(tmp2);
		return tmp2;
	}

}
