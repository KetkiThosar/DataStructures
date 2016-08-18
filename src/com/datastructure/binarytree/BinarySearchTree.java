package com.datastructure.binarytree;

public class BinarySearchTree<E> {

	Node<E> root;

	public Node<E> getRoot() {
		return root;
	}

	public void setRoot(Node<E> root) {
		this.root = root;
	}

	void insertNode(Integer data) {
		if (root == null) {
			Node<E> newNode = new Node<E>();
			newNode.setData(data);
			setRoot(newNode);
		} else {
			this.root.insertNode(data);
		}
	}

	boolean isPresent(Node<E> node, Integer data) {
		if (node == null)
			return false;
		if (node.getData() == data)
			return true;
		if (data < node.getData()) {
			return isPresent(node.getLeft(), data);
		} else if (data > node.getData()) {
			return isPresent(node.getRight(), data);
		}
		return false;
	}

	Node<E> findMin(Node<E> root) {
		if (root == null)
			System.out.println("Tree is empty.");
		Node<E> temp = root;
		while (temp.getLeft() != null) {
			temp = temp.getLeft();

		}
		return temp;
	}

	Node<E> findMax(Node<E> root) {
		if (root == null) {
			System.out.println("Tree is empty.");
		}
		Node<E> temp = root;
		while (temp.getRight() != null) {
			temp = temp.getRight();

		}
		return temp;
	}

	void traverseInOrder(Node<E> node) {
		if (node == null) {
			System.out.println("Tree is empty");
			return;
		}

		Node<E> temp = getRoot();
		print(temp);

		while (temp != null) {
			temp = temp.getLeft();
			print(temp);
		}

		temp = getRoot();
		while (temp != null) {
			temp = temp.getRight();
			print(temp);
		}

	}

	void print(Node<E> node) {
		if (node == null)
			return;
		System.out.println(" " + node.getData());

	}

	Node<E> deleteNode(Node<E> root, Integer data) {
		if (root == null) {
			return root;
		} else if (data > root.getData()) {
			root.setRight(deleteNode(root.getRight(), data));
		} else if (data < root.getData()) {
			root.setLeft(deleteNode(root.getLeft(), data));

			// enter if you have found the element.
		} else {
			// if its a leaf node
			if (root.getLeft() == null && root.getRight() == null) {
				Node<E> temp = root;
				temp = null;
				return temp;
			}
			// if it has only right child
			else if (root.getLeft() == null) {
				Node<E> temp = root;
				root = root.getRight();
				temp=null;
				
				// if it has only left child
			} else if (root.getRight() == null) {
				Node<E> temp = root;
				root= root.getLeft();
				temp = null;
				
			}
			// node with 2 children
			else {
				Node<E> temp = findMin(root.getLeft());
				root.setData(temp.getData());
				return deleteNode(root.getRight(), temp.getData());
			}
		}

		return root;

	}

	public static void main(String[] args) {

		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		bst.insertNode(10);
		bst.insertNode(8);
		bst.insertNode(15);
		bst.insertNode(4);
		bst.insertNode(25);
		bst.insertNode(40);
		bst.insertNode(24);
		bst.insertNode(41);
		

		System.out.println(bst.isPresent(bst.getRoot(), 15));
		System.out.println(bst.isPresent(bst.getRoot(), 10));
		System.out.println(bst.isPresent(bst.getRoot(), 8));
		System.out.println(bst.isPresent(bst.getRoot(), 4));
		System.out.println(bst.isPresent(bst.getRoot(), 25));
		System.out.println(bst.isPresent(bst.getRoot(), 26));
		System.out.println("min:   " + bst.findMin(bst.getRoot()).getData());
		System.out.println("max:   " + bst.findMax(bst.getRoot()).getData());

		System.out.println("Elements in Tree");
		bst.traverseInOrder(bst.getRoot());
		
		bst.deleteNode(bst.getRoot(), 25);
		System.out.println("Elements in Tree after removal");
		bst.traverseInOrder(bst.getRoot());

	}

}