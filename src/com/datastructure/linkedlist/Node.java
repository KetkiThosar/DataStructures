package com.datastructure.linkedlist;

public class Node<E> {
	E data;
	
	Node<E> next;

	
	
	
	void insert(Node<E>node){
		if(null==this.next){
			setNext(node);
		}else{
		this.next.insert(node);	
		}
	}
	
	
	void remove(Node<E>node){
		
	}
		
	 @Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}


	void setNext(Node<E> next) {
		this.next=next;
		
	}

	void setData(E data){
		this.data=data;
	}
	
	E getData(){
		return data;
	}
	
	

}
