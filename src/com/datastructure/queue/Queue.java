package com.datastructure.queue;

public class Queue<E> {

	PNode<E> rootNode;

	public PNode<E> getNode() {
		return rootNode;
	}

	public void setNode(PNode<E> node) {
		this.rootNode = node;
	}

	void push(E data) {
		if (rootNode == null) {
			rootNode = new PNode<E>();
			rootNode.setData(data);
			rootNode.setHead(rootNode);
		} else
			rootNode.insert(data);
	}

	PNode<E> pop() {
		PNode<E> node = null;
		if (null != rootNode) {
			node = rootNode.remove();
		}
		return node;
	}

	boolean isEmpty() {
		return rootNode.isEmpty();
	}

	public static void main(String[] args) {
		Queue<Integer> q = new Queue<Integer>();
		q.push(10);
		q.push(20);
		q.push(30);
		q.push(40);
		q.push(50);
		q.push(60);
		q.push(70);
		q.push(80);
		System.out.println(" pop " + q.pop().getData());
		System.out.println(" pop " + q.pop().getData());
		System.out.println(" pop " + q.pop().getData());
		System.out.println(" pop " + q.pop().getData());
		System.out.println(" pop " + q.pop().getData());
		System.out.println(" pop " + q.pop().getData());
		System.out.println(" pop " + q.pop().getData());
	}

}
