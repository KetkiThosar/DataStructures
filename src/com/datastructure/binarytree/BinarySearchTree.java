package com.datastructure.binarytree;

import java.util.*;


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

	

	void print(Node<E> node) {
		if (node == null)
			return;
		System.out.println(" " + node.getData());

	}

	void traverseLevelWise(Node<E> node) {
		
		Deque<Node<E>>pq=new java.util.LinkedList<Node<E>>();
		if (node == null)
			return;
		pq.add(node);
		while (!pq.isEmpty()) {
			Node <E>temp = pq.poll();
			System.out.print(" " + temp.getData());
			if (((Node<E>) temp).getLeft() != null) {
				pq.add(temp.getLeft());
			}
			if (temp.getRight() != null) {
				pq.add(temp.getRight());
			}
		}

	}
	
	public int kthSmallest(Node<E> root, int k) {
        
        List<Integer> arrayList = new ArrayList<>();
        getSortedElems(root,k,arrayList);  
        System.out.println("ArrayList "+arrayList.toString());
        return 0;
    }
    
    public void getSortedElems(Node<E> root,int k , List<Integer> arrayList){
        
        if(root==null){
            return;
        }
        getSortedElems(root.getLeft(),k,arrayList);
        arrayList.add(root.getData());
        getSortedElems(root.getRight(),k,arrayList);
    }

	void printNode(Node<E> node) {
		if (node == null)
			return;
		if (node.getLeft() != null) {
			System.out.print(" " + node.getLeft().getData());
		} else if (node.getRight() != null) {
			System.out.print(" " + node.getRight().getData());
		}
	}

	Integer findHeight(Node<E> root) {

		if (root == null)
			return 0;
		return Integer.max(findHeight(root.getLeft()),
				findHeight(root.getRight())) +1;
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
				//return temp;
			}
			// if it has only right child
			else if (root.getLeft() == null) {
				Node<E> temp = root;
				root = root.getRight();
				temp = null;
				//return root;

				// if it has only left child
			} else if (root.getRight() == null) {
				Node<E> temp = root;
				root = root.getLeft();
				temp = null;
				//return root;
			}
			// node with 2 children
			else {
				Node<E> temp = findMin(root.getRight());
				System.out.println(" find min "+temp.getData());
				root.setData(temp.getData());
				root.setRight(deleteNode(root.getRight(), temp.getData()));
			}
		}

		return root;

	}

	void preorderTraverse(Node<E> root) {
		if (root == null)
			return;
		System.out.print(" " + root.getData());
		preorderTraverse(root.getLeft());
		postorderTraverse(root.getRight());
	}

	//inorder traverse prints node sorted in ascending order .
	void inorderTraverse(Node<E> root) {
		if (root == null)
			return;
		inorderTraverse(root.getLeft());
		System.out.print(" " + root.getData());
		inorderTraverse(root.getRight());
	}

	void postorderTraverse(Node<E> root) {
		if (root == null)
			return;
		postorderTraverse(root.getLeft());
		postorderTraverse(root.getRight());
		System.out.print(" " + root.getData());
	}
	
	
	/**
	 * What is inorder successor prints the next highest number 
	 * 
	 * @param root
	 * @return
	 */
	
	Node<E> inorderSuccessor(Node<E> root,int data) {
		if (root == null)
			return null;
		
		Node<E> node = getNode(root,data);
		if (node!=null&&node.getRight() != null) {
			node = node.getRight();
			while (node.getLeft() != null) {
				node = node.getLeft();
			} // end of while loop
		} // end of if block
		return node;
	}
	
	Node<E> getNode(Node<E> node, Integer data) {
		if (node == null)
			return null;
		if (node.getData() == data)
			return node;
		else if (data < node.getData()) {
			return getNode(node.getLeft(), data);
		} else if (data > node.getData()) {
			return getNode(node.getRight(), data);
		}
		return null;
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
		
		bst.kthSmallest(bst.getRoot(), 8);
		bst.inorderTraverse(bst.getRoot());
		System.out.println();
		System.out.println(bst.isPresent(bst.getRoot(), 15));
		System.out.println(bst.isPresent(bst.getRoot(), 10));
		System.out.println(bst.isPresent(bst.getRoot(), 8));
		System.out.println(bst.isPresent(bst.getRoot(), 4));
		System.out.println(bst.isPresent(bst.getRoot(), 25));
		System.out.println(bst.isPresent(bst.getRoot(), 26));
		
		System.out.println("Inorder successor: " +bst.inorderSuccessor(bst.root,10).getData());
		
		System.out.println("min:   " + bst.findMin(bst.getRoot()).getData());
		System.out.println("max:   " + bst.findMax(bst.getRoot()).getData());

		System.out.println("Elements in Tree");
		bst.inorderTraverse(bst.getRoot());
		System.out.println();
		
		bst.deleteNode(bst.getRoot(), 25);
		System.out.println("Elements in Tree after removal");
		bst.inorderTraverse(bst.getRoot());
		
		System.out.println();
		System.out.println("find height  :  " + bst.findHeight(bst.root));

		bst.preorderTraverse(bst.getRoot());
		System.out.println();
		bst.inorderTraverse(bst.getRoot());
		System.out.println();
		bst.postorderTraverse(bst.getRoot());
		System.out.println();
		System.out.println("Level wise traverse ");
		bst.traverseLevelWise(bst.getRoot());
		System.out.println();
		
	}

}
