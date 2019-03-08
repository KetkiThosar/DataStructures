/**
 * 
 */
package com.datastructure.linkedlist;

/**
 * @author keth0416
 * 
 */
public class LinkedList<E> {

	private Node<E> head;

	public Node<E> getHead() {
		return head;
	}

	public void setHead(Node<E> head) {
		this.head = head;
	}

	public void add(E data) {
		if (null == head) {
			head = new Node<E>();
			head.setData(data);
		} else {
			Node<E> newNode = new Node<E>();
			newNode.setData(data);
			head.insert(newNode);
		}
	}

	int getSize() {
		int len = 0;
		Node<E> temp = head;
		while (temp != null) {
			len++;
			temp = temp.next;
		}
		return len;

	}

	public void moveFirst() {
		if (head != null)
			if (head == null) {
				System.out.println("Linked List is empty");
			}
	}

	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}

	public void traverse() {

		Node<E> temp = head;
		while (temp != null) {
			System.out.print(" " + temp.getData());
			temp = temp.next;

		}
		System.out.println();
	}

	// find middle element in one pass
	public Node<E> findMiddleElement() {
		Node<E> slowPointer = head;
		Node<E> fastPointer = head;
		while (fastPointer.next != null && fastPointer.next.next != null) {
			fastPointer = fastPointer.next.next;
			slowPointer = slowPointer.next;
		}

		return slowPointer;

	}

	// position is one based
	E deleteNode(int position) {
		if (position <= 0)
			return null;
		Node<E> temp = head;
		E data = null;
		if (position == 1) {
			data = head.data;
			setHead(head.next);
		} else {
			temp = getElement(position - 1);
			data = temp.next.data;
			temp.setNext(temp.next.next);
		}
		System.out.println("Deleting node at position  : " + position
				+ " and with value " + data);
		return data;

	}

	Node<E> getElement(int position) {
		if (head == null || position == 0)
			return null;
		if (position < 0 || position > getSize())
			return null;
		if (position == 1)
			return head;
		Node<E> temp = head;
		for (int i = 1; i < position && temp != null; i++) {
			temp = temp.next;
		}
		return temp;
	}

	public E getElementFromTail(int tailIndex) {
		Node<E> fastPointer = head;
		Node<E> slowPointer = head;
		int counter = 0;
		while (fastPointer.next != null) {
			fastPointer = fastPointer.next;
			counter++;
			if (counter >= tailIndex) {
				slowPointer = slowPointer.next;
			}
		}
		if (counter < tailIndex) {
			return null;
		}
		return slowPointer.getData();
	}

	void deleteFirst() {
		deleteNode(1);

	}

	void deleteLast() {
		deleteNode(getSize());

	}

	void insertAt(int position, E data) {
		System.out.println("Inserting Node  " + data + "   at position " + position);

		if (position <= 0)
			return;
		Node<E> temp = null;
		Node<E> temp1 = null;
		Node<E> newNode = new Node<E>();
		if (position == 1) {
			temp1 = head;
			newNode.setData(data);
			newNode.setNext(head);
			setHead(newNode);
		} else {
			newNode.setData(data);
			temp = getElement(position - 1);
			temp1 = temp.next.next;
			temp.next = newNode;
			newNode.setNext(temp1);

		}

	}

	void swap(Node<E> n1, Node<E> n2) {
		Node<E> temp = null;
		temp = n1.next;
		n1.next = n2.next;
		n2.next = temp;
	}

	public LinkedList<Integer> mergeList(LinkedList<Integer> l1, LinkedList<Integer> l2) {
		LinkedList<Integer> l3 = new LinkedList<Integer>();
		return merge(l1.head, l2.head, l3);
	}

	private LinkedList<Integer> merge(Node<Integer> l1, Node<Integer> l2, LinkedList<Integer> l3) {
		if (l2 != null && l1 != null) {
			if (l1.data <= l2.data) {
				l3.add(l1.data);
				l1=l1.next;
			} else {
				l3.add(l2.data);
				l2=l2.next;
			}

		}
		if(l1==null || l2==null){
		while (l2 != null) {
			l3.add(l2.data);
			l2=l2.next;
		}
		while (l1 != null) {
			l3.add(l1.data);
			l1=l1.next;
		}
		return l3;
		}
		
		return merge(l1,l2,l3);

	}

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		list.traverse();
		System.out.println("Size  is :   " + list.getSize());
		System.out.println("is Empty " + list.isEmpty());
		System.out.println("find middle element :  " + list.findMiddleElement().getData());
		list.deleteNode(3);
		list.traverse();
		list.deleteFirst();
		list.traverse();
		list.deleteLast();
		list.traverse();
		System.out.println("get element from tail :  " + list.getElementFromTail(3));
		list.insertAt(1, 500);
		list.traverse();
		list.traverse();
		
		LinkedList<Integer> l1 = new LinkedList<>();
		LinkedList<Integer> l2 = new LinkedList<>();
		l1.add(0);
		l1.add(10);
		
		l2.add(2);
	
		
		LinkedList<Integer> l3 =list.mergeList(l1, l2);
		l3.traverse();
		
		
		
	}

}
