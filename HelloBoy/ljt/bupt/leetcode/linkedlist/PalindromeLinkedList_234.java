package ljt.bupt.leetcode.linkedlist;

public class PalindromeLinkedList_234 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5,6,7};
//		int[] nums = { 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2,
//				3, 1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 1, 2, 3, 1,
//				2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 5, 6,
//				7, 8, 9, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2,
//				3, 1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 1, 2, 3, 1,
//				2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 5, 6,
//				7, 8, 9, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2,
//				3, 1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 1, 2, 3, 1,
//				2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 5, 6,
//				7, 8, 9, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2,
//				3, 1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 1, 2, 3, 1,
//				2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 5, 6,
//				7, 8, 9, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2,
//				3, 1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 1, 2, 3, 1,
//				2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 5, 6,
//				7, 8, 9, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2,
//				3, 1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 1, 2, 3, 1,
//				2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 5, 6,
//				7, 8, 9, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2,
//				3, 1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 1, 2, 3, 1,
//				2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 5, 6,
//				7, 8, 9, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2,
//				3, 1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 1, 2, 3, 1,
//				2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 5, 6,
//				7, 8, 9, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2,
//				3, 1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 8, 7, 6, 5, 4, 3,
//				2, 1, 3, 2, 1, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 3, 2, 1, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 3, 2, 1,
//				3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 3, 2, 1, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 3, 2, 1, 3, 2, 1, 9, 8,
//				7, 6, 5, 4, 3, 2, 1, 3, 2, 1, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 3, 2, 1, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3,
//				2, 1, 3, 2, 1, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 3, 2, 1, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 3, 2, 1,
//				3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 3, 2, 1, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 3, 2, 1, 3, 2, 1, 9, 8,
//				7, 6, 5, 4, 3, 2, 1, 3, 2, 1, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 3, 2, 1, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3,
//				2, 1, 3, 2, 1, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 3, 2, 1, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 3, 2, 1,
//				3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 3, 2, 1, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 3, 2, 1, 3, 2, 1, 9, 8,
//				7, 6, 5, 4, 3, 2, 1, 3, 2, 1, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 3, 2, 1, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3,
//				2, 1, 3, 2, 1, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 3, 2, 1, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 3, 2, 1,
//				3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 3, 2, 1, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 3, 2, 1, 3, 2, 1, 9, 8,
//				7, 6, 5, 4, 3, 2, 1, 3, 2, 1, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 3, 2, 1, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3,
//				2, 1, 3, 2, 1, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 3, 2, 1, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 3, 2, 1,
//				3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 3, 2, 1, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 3, 2, 1, 3, 2, 1, 9, 8,
//				7, 6, 5, 4, 3, 2, 1, 3, 2, 1, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 3, 2, 1, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3,
//				2, 1, 3, 2, 1, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 3, 2, 1, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 3, 2, 1,
//				3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 3, 2, 1, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 3, 2, 1, 3, 2, 1, 9, 8,
//				7, 6, 5, 4, 3, 2, 1, 3, 2, 1, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 3, 2, 1, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3,
//				2, 1, 3, 2, 1, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 3, 2, 1, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 3, 2, 1,
//				3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 3, 2, 1, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 3, 2, 1, 3, 2, 1, 9, 8,
//				7, 6, 5, 4, 3, 2, 1, 3, 2, 1, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 3, 2, 1, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3,
//				2, 1, 3, 2, 1, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 3, 2, 1, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 3, 2, 1,
//				3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 3, 2, 1, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 3, 2, 1, 3, 2, 1, 9, 8,
//				7, 6, 5, 4, 3, 2, 1, 3, 2, 1, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 3, 2, 1, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3,
//				2, 1, 3, 2, 1, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 3, 2, 1, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 3, 2, 1,
//				3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 3, 2, 1, 3, 2, 1 };
		ListNode node = ListNode.build(nums);
		long start = System.currentTimeMillis();
		boolean res = isPalindrome(node);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		System.out.println(res);
	}

	private static boolean isPalindrome(ListNode head) {
		if (head == null) {
			return true;
		}
		//先计算这个链表的长度
		ListNode lenCount = head;
		int len = 1;
		while (lenCount.next != null) {
			len++;
			lenCount = lenCount.next;
		}
		
		//找到中间的节点，然后将中间之后的节点逆置
		ListNode midNode = head;
		int halflen = len / 2;
		int half = halflen;
		int half2 = halflen;
		while (--halflen > -1) {
			midNode = midNode.next;
		}
//		ListNode.printList(midNode);
		ListNode tmp1 = null;
		ListNode tmp2 = midNode;
		while(half-- > 0){
			tmp1 = head;
			head = head.next;
			tmp1.next = null;
			tmp1.next = tmp2;
			tmp2 = tmp1;
		}
//		ListNode.printList(tmp1);
//		ListNode.printList(midNode);
		
		ListNode fast = midNode;
		ListNode slow = tmp1;
		if( len%2 == 1){
			fast = fast.next ;
		}
		while(half2-- >0){
			if(slow.val != fast.val){
				return false;
			}else{
				slow = slow.next;
				fast = fast.next;
			}
		}
		
		return true;
	}

	private static boolean isPalindrome3(ListNode head) {
		if (head == null) {
			return true;
		}
		//先计算这个链表的长度
		ListNode lenCount = head;
		int len = 1;
		while (lenCount.next != null) {
			len++;
			lenCount = lenCount.next;
		}
//		System.out.println(len);
//		ListNode.printList(lenCount); //lenCount 刚好指向了List的尾巴
		//找到中间的节点，然后将中间之后的节点逆置
		ListNode midNode = head;
		int halflen = len /2;
		int half = halflen;
		while(--halflen>0){
			midNode = midNode.next ;
		}
		if(len%2==1){
			midNode = midNode.next ;
		}
//		ListNode.printList(midNode);
		//然后依次将midNode后面的元素摘下来放到末尾，循环len/2次
		while(--half>-1){
			ListNode tmp = midNode.next;
			midNode.next = midNode.next.next;
			tmp.next = null;
			lenCount.next = tmp;
			lenCount = lenCount.next;
		}
		ListNode.printList(head);
		return false;
	}

	private static boolean isPalindrome2(ListNode head) {// 超时,当数量很大时,效率很低
		if (head == null) {
			return true;
		}
		ListNode lenCount = head;
		int len = 1;
		while (lenCount.next != null) {
			len++;
			lenCount = lenCount.next;
		}
		// System.out.println(len);
		lenCount.next = head;// 组成了一个环
		int loop = len / 2;
		while (loop-- > 0) {
			if (head.val != lenCount.val) {
				return false;
			} else {
				head = head.next;
				for (int i = 0; i < len - 1; i++) {
					lenCount = lenCount.next;
				}
			}
		}
		return true;
	}

	private static boolean isPalindrome1(ListNode head) {
		if (head == null)
			return true;
		ListNode fast = head, slow = head;

		/** find middle element */
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		/** when the length is odd */
		if (fast != null)
			slow = slow.next;

		/** reverse the second half */
		ListNode prev = null;
		while (slow != null) {
			ListNode temp = slow.next;
			slow.next = prev;
			prev = slow;
			slow = temp;
		}

		/** compare the first and second half */
		slow = prev;
		while (slow != null) {
			if (head.val != slow.val)
				return false;
			head = head.next;
			slow = slow.next;
		}
		return true;
	}

}
