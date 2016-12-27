package ljt.bupt.leetcode.linkedlist;

public class PartitionList_86 {

	public static void main(String[] args) {
		int[] nums = {};
		ListNode head  = ListNode.build(nums);
		int x = 3;
		ListNode res = partition(head,x);
		ListNode.printList(res);
	}

	private static ListNode partition(ListNode head, int x) {
		//建立两个dummy节点，节点小于x的链在dummy1 大于等于x的链在dummy2上面
		if(head == null||head.next==null){
			return head;
		}
		ListNode dummy1 = new ListNode(0);
		ListNode root = dummy1;
		ListNode dummy2 = new ListNode(0);
		ListNode mid = dummy2;
		while(head!=null){
			if(head.val<x){
				ListNode tmp = new ListNode(head.val);
				dummy1.next = tmp;
				dummy1 = dummy1.next;
				head = head.next;
			}else{
				ListNode tmp = new ListNode(head.val);
				dummy2.next = tmp;
				dummy2 = dummy2.next;
				head = head.next;
			}
		}
		dummy1.next = mid.next;
		return root.next;
	}

}
