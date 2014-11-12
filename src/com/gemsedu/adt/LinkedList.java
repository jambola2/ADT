package com.gemsedu.adt;

public class LinkedList {
	public LinkedListItem head;
	
	public LinkedList() {}
	
	public boolean isEmpty() {
		return (head == null);
	}
	
	public void add(LinkedListItem currentLL, LinkedListItem newLL) {
		// if we have an empty LL
		if (isEmpty()) {
			this.head = newLL;
		}
		// if the next item is empty, set it
		else if (currentLL.next == null) {
			currentLL.next = newLL;
		}
		// otherwise, go to the next item
		else {
			add(currentLL.next, newLL);
		}
	}
	
	public void print(LinkedListItem head) {
		// if we have an empty LL
		if (isEmpty()) {
			System.out.println("empty");
		}
		// if the next item is empty, just print this
		else if (head.next == null) {
			System.out.println(head.value);
		}
		// otherwise, go to the next item
		else {
			System.out.println(head.value);
			print(head.next);
		}
	}
	
	public boolean search(LinkedListItem head, LinkedListItem search) {
		if (isEmpty() || head == null) {
			return false;
		}
		else {
			if (head.value != search.value) {
				return search(head.next, search);
			}
			else {
				return true;
			}
		}
		
	}
	
	public void delete(LinkedListItem head, LinkedListItem remove){
		if (!search(head, remove)){
			// Checks if the item doesn't exist in the list
			System.out.println("This LinkedListItem does not exist in this LinkedList");
		}
		else{
			if (head.value == remove.value){
				// If the head itself is the value we want to remove
				head = head.next ;
				// Replace the head with the next item, skipping over this item
			}
			else{
				//If the head is not the item we want to remove
				delete(head.next, remove);
			}
		}
	}
	
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		LinkedListItem llItem = new LinkedListItem(2);
		ll.add(ll.head, llItem);
		LinkedListItem llItem2 = new LinkedListItem(4);
		ll.add(ll.head, llItem2);
		LinkedListItem llItem3 = new LinkedListItem(4);
		ll.add(ll.head, llItem3);
		LinkedListItem llItem4 = new LinkedListItem(5);
		ll.add(ll.head, llItem4);
		ll.print(ll.head);
		System.out.println(ll.search(ll.head, llItem2));
	}
}
