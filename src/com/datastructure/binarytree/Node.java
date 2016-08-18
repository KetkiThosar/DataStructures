package com.datastructure.binarytree;

public class Node<E> {

	private Node<E> left;
	private Node<E> right;
	private Integer data;

	public Node<E> getLeft() {
		return left;
	}

	public void setLeft(Node<E> left) {
		this.left = left;
	}

	public Node<E> getRight() {
		return right;
	}

	public void setRight(Node<E> right) {
		this.right = right;
	}

	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

	void insertNode(Integer data) {
		Node<E> newNode = new Node<E>();
		newNode.setData(data);
		if (data <= this.data) {
			if (this.left == null) {
				this.setLeft(newNode);
			} else {
				this.left.insertNode(data);
			}// else
		}// end of if

		else {
			if (this.right == null) {
				this.setRight(newNode);
			} else {
				this.right.insertNode(data);
			}

		}
	}

}
