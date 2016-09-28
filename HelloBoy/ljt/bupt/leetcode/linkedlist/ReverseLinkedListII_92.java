package ljt.bupt.leetcode.linkedlist;

public class ReverseLinkedListII_92 {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		int m = 3;
		int n = 8;
		ListNode head = ListNode.build(nums);
		long start = System.currentTimeMillis();
		ListNode res = reverseBetween(head,m,n);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		ListNode.printList(res);
	}

	private static ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode root = new ListNode(Integer.MAX_VALUE);
		root.next = head;
		ListNode root1 = root;
		int t = m;
		while(t-- > 1){
			root = root.next;
		}
		//head.next现在为子链表的头，找到子链表的尾巴
		ListNode tmp = root.next;
		int r = n-m;
		while(r-->0){
			tmp = tmp.next;
		}
		//记下尾巴后面的节点，等会连接起来
		ListNode tmp1 = tmp.next;
		tmp.next = null;
		ListNode h = reverseList(root.next);
		root.next = h;
		while(h.next!=null){
			h = h.next;
		}
		h.next = tmp1;
		return root1.next;
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
