package com.foo.linkedlist;

public class ReverseList<T> {
	
	private Node<T> head = null;
	
	public static class Node<T>{
		
		protected T data = null;
		
		private Node<T> next = null;
		
		
		public Node(T data) {
			super();
			this.data = data;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}		
		
	}
	
	
	
	
	public Node<T> getHead() {
		return head;
	}


	public void setHead(Node<T> head) {
		this.head = head;
	}


	public void print(){
		
		Node<T> node = head;
		
		do{
		
			System.out.println( node.getData() );
			node = node.getNext();
		}
		while( node!=null );
		
	}
	
	public void reverse(){
		
		Node<T> it = head.getNext();
		Node<T> prev = head;
		
		do {
			Node<T> next = it.getNext();
			it.setNext( prev );
			prev = it;
			it = next;
		}
		while( it.getNext()!= null );
		
		it.setNext( prev );
		head.setNext( null );
		head = it;
		
		//it.setNext( null );
		
	}
	
	
	public static Node<Integer> makeList(){
		Node<Integer> head = new Node<Integer>( 5 );
		
		Node<Integer> it = head;
		
		for(int i = 2; i<=10; i++){
			Node<Integer> newItem = new Node<Integer>( 5 * i );
			it.setNext( newItem );
			it = newItem;			
		}
		
		it = null;	
		
		return head;
	}
	
    public static void main(String[] args) {
    	
    	ReverseList<Integer> list = new ReverseList<Integer>();
    	
    	list.setHead( makeList() );
    	list.print();
    	
    	list.reverse();
    	list.print();
    	
    }
	

}
