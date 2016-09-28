package ljt.bupt.leetcode.linkedlist;

public class DeleteNodeinaLinkedList_237 {

	public static void main(String[] args) {
		// int[] nums = {3,4,5,1,2,7,8};
		// ListNode node = ListNode.build(nums);
		// ListNode.printList(node);
		int[] nums = { 3, 4, 5, 1 };
		ListNode node = ListNode.build(nums);
		node = deleteNode(node);
		ListNode.printList(node);
		deleteNodeWithReturn(node);
		ListNode.printList(node);
		node = deleteNode(node);
		ListNode.printList(node);
	}

	private static void deleteNodeWithReturn(ListNode node) {
		if (node == null) {
			return;
		}
		if (node.next == null) {
			node = null;
			return;
		}
		node.val = node.next.val;
		node.next = node.next.next;
	}

	private static ListNode deleteNode(ListNode node) {
		if (node == null) {
			return null;
		}
		if (node.next == null) {
			node = null;
			return null;
		}
		node = node.next;
		return node;
	}

}
