package ljt.bupt.leetcode.linkedlist;

public class SwapNodesinPairs_24 {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		ListNode head = ListNode.build(nums);
		long start = System.currentTimeMillis();
		ListNode res = swapPairs(head);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		System.out.println(res);

	}

	private static ListNode swapPairs(ListNode head) {
		ListNode root = new ListNode(Integer.MIN_VALUE);// 用来记录返回的根节点
		root.next = head;
		ListNode root1 = root;// 用来遍历的节点，即每次遍历之后都用来指向剩下还没遍历的链表的头结点
		ListNode tmp = head;// 用来记录每次遍历之后都用来指向剩下还没遍历的链表的头结点
		while (head != null && head.next != null) {
			tmp = head.next.next;
			root1.next = head.next;
			head.next.next = head;
			head.next = tmp;
			root1 = head;
			head = tmp;
		}
		ListNode.printList(root.next);
		return root.next;
	}

}
