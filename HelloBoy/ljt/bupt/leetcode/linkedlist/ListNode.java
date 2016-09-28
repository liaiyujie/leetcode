package ljt.bupt.leetcode.linkedlist;

public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	public static ListNode build(int[] nums) {
		if(nums.length==0){
			return null;
		}
		ListNode node = new ListNode(nums[0]);
		ListNode node1 = node;
		for (int i = 1; i < nums.length; i++) {
			ListNode n = new ListNode(nums[i]);
			node.next = n;
			node = node.next;
		}
		return node1;
	}

	public static void printList(ListNode head) {
		StringBuilder sb = new StringBuilder();
		while (head.next != null) {
			sb.append(head.val + "-->");
			head = head.next;
		}
		sb.append(head.val + "");
		System.out.println(sb.toString());
	}
}
