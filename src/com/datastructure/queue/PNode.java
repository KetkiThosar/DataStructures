package com.datastructure.queue;

public class PNode<E> {

	E data;
	PNode<E> head;
	PNode<E> next;

	public PNode() {

	}

	public PNode<E> getHead() {
		return head;
	}

	public void setHead(PNode<E> head) {
		this.head = head;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public PNode<E> getNext() {
		return next;
	}

	public void setNext(PNode<E> next) {
		this.next = next;
	}

	void insert(E data) {
		if (this.next == null) {
			PNode<E> nd = new PNode<E>();
			nd.setData(data);
			this.next = nd;
		} else {
			this.next.insert(data);
		}
	}

	PNode<E> remove() {
		if (head == null)
			return null;
		else {
			PNode<E> node = getHead();
			setHead(node.next);
			return node;
		}
	}

	public boolean isEmpty() {
		if (head == null)
			return true;
		else
			return false;
	}

}
