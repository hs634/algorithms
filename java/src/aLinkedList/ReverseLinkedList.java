package aLinkedList;

public class ReverseLinkedList {
	
	static ListNode head = null;
	
	public static void reverse(ListNode node){
		if(node == null)
			return;
		if(node.next==null){
			head = node;
			return;
		}
		ListNode cur = node;
		ListNode rest = node.next;
		reverse(rest);
		rest.next = cur;
		cur.next = null;
		
	}
	
	public static void main(String[] args){
		
		head = createList();
		System.out.println("Before");
		printList();
		
		reverse(head);
		
		System.out.println("After");
		printList();
		
	}

	private static void printList() {
		ListNode node = head;
		while(node!=null){
			System.out.print(node.getValue() + "\t");
			node = node.next;
		}
		System.out.println();
	}

	private static ListNode createList() {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		head = node1;
		return head;
	}
			
}
