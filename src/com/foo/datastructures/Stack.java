package com.foo.datastructures;

public class Stack<T> {
	
	private Node<T> top = null;
	
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
	}
	
	
	public void push( T data ){
		
		Node<T> node = new Node<T>( data );
		node.setNext( top );
		top = node;
		
	}
	
	public T pop(){
		
		T data = top.getData();
		
		top= top.next;
		
		return data;
		
	}
	
	public void print(){
		
		Node<T> node = top;
		
		do{
		
			System.out.println( node.getData() );
			node = node.getNext();
		}
		while( node!=null );
		
	}
	
	
    public static void main(String[] args) {
    	
    	Stack<Integer> s = new Stack<Integer>();
    	
    	s.push( 10 );
    	s.push( 15 );
    	s.push( 20 );
    	
    	s.print();
    	
    	
    	System.out.println( "pop=" + s.pop() );
    	System.out.println( "pop=" + s.pop() );
    	System.out.println( "pop=" + s.pop() );
    	
    	s.push( 66 );
    	s.push( 77 );
    	System.out.println( "pop=" + s.pop() );
    	s.push( 88 );
    	
    	s.print();
    	
    	System.out.println( "pop=" + s.pop() );
    	System.out.println( "pop=" + s.pop() );
    	System.out.println( "pop=" + s.pop() );
    	
    	
    }
	

}
