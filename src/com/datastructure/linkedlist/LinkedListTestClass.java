package com.datastructure.linkedlist;

public class LinkedListTestClass {
	public static void main(String[] args) {
		LinkedList<Integer>list=new LinkedList<>();
		list.add(30);
		list.add(300);
		list.add(3000);
		list.add(30000);
		list.add(300000);
		list.add(3000000);
		list.traverse();
		System.out.println( list.getSize());
		
	}
}
