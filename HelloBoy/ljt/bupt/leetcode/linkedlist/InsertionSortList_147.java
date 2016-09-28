package ljt.bupt.leetcode.linkedlist;

public class InsertionSortList_147 {

	public static void main(String[] args) {
		int[] nums = {4,2,1,3};
		ListNode head = ListNode.build(nums);
		long start = System.currentTimeMillis();
		ListNode res = insertionSortList(head);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		System.out.println(res);
	}

	private static ListNode insertionSortList(ListNode head) {
		if( head == null ){
			return head;
		}
		
		ListNode helper = new ListNode(0); //new starter of the sorted list
		ListNode cur = head; //the node will be inserted
		ListNode pre = helper; //insert node between pre and pre.next
		ListNode next = null; //the next node will be inserted
		//not the end of input list
		while( cur != null ){
			next = cur.next;
			//find the right place to insert
			while( pre.next != null && pre.next.val < cur.val ){
				pre = pre.next;
			}
			//insert between pre and pre.next
			cur.next = pre.next;
			pre.next = cur;
			pre = helper;
			cur = next;
		}
		
		return helper.next;
	}

	private static ListNode insertionSortList1(ListNode head) {
		if(head == null){
			return null;
		}
		ListNode root = new ListNode(head.val);
		ListNode tmp = head.next;
		while(tmp!=null){
			int val = tmp.val;
			if(root.val>=val){
				ListNode t = new ListNode(val);
				t.next = root;
				root = t;
				tmp = tmp.next;
				continue;
			}
			ListNode rootTmp = root;
			while(rootTmp.next!=null){
				if(rootTmp.next.val <= val){
					rootTmp = rootTmp.next;
				}else{
					ListNode t = new ListNode(val);
					t.next = rootTmp.next;
					rootTmp.next = t;
					tmp = tmp.next;
					break;
				}
			}
			if(rootTmp.next== null){
				ListNode t = new ListNode(val);
				rootTmp.next = t;
				tmp = tmp.next;
			}
		}
		ListNode.printList(root);
		return root;
	}

}
