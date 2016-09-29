package ljt.bupt.leetcode.linkedlist;

public class RotateList_61 {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5 };
		ListNode head = ListNode.build(nums);
		int k = 10;
		ListNode node = rotateRight(head, k);
		ListNode.printList(node);
	}

	private static ListNode rotateRight(ListNode head, int k) {
		ListNode first = head;
		ListNode second = head;
		if (k <= 0 || head == null || head.next == null)
			return head;
		// 计算列表的长度
		int count = 0;
		while (first.next != null) {
			count++;
			first = first.next;
		}
		count++;
		if (k >= count) {
			k = k % count;
		}
		if (k == 0) {
			return head;
		}
		first = head;
		// first 先向前走K个节点
		while (k-- > 0) {
			first = first.next;
		}
		while (first.next != null) {
			first = first.next;
			second = second.next;
		}

		ListNode headd = second.next;
		second.next = null;
		first.next = head;
		return headd;
	}

}
