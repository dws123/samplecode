package com.foo.datastructures;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class BinaryTree< T extends Comparable<? super T> > {

	private Node<T> root = null;

	public Node<T> getRoot() {
		return root;
	}

	public BinaryTree() {
		super();
	}

	public void inOrder() {
		inOrder( root );
	}

	public void inOrder(Node<T> n) {

		if( n == null) return;

		inOrder( n.getLeft() );

		System.out.print( n.getData() + ", " );

		inOrder( n.getRight() );	
	}

	public void insert( T data ){
		root = insert( data, root);
	}

	public Node<T> insert( T data, Node<T> node ){

		if( node==null ){
			node = new Node<T>( data );
		}
		else if( data.compareTo( node.getData() ) >= 0 ){
			node.setRight( insert( data, node.getRight() ) );			
		}
		else {
			node.setLeft( insert( data, node.getLeft() ) );		
		}
		return node;
	}

	public void breadthFirstSearch(){
		Queue<Node<T>> queue = new LinkedList<Node<T>>();
		queue.add( root );
		breadthFirstSearch( queue );
	}

	private void breadthFirstSearch (Queue<Node<T>> queue){

		if (queue.isEmpty() ) return;

		Node<T> node = queue.poll();

		System.out.println (node.getData() + ", ");

		if (node.getLeft() !=null) queue.offer( node.getLeft() );
		if (node.getRight() !=null) queue.offer( node.getRight() );

		breadthFirstSearch ( queue );
	}

	public void displayTree()
	{
		Stack<Node<T>> globalStack = new Stack<Node<T>>();
		globalStack.push(root);	
		int emptyLeaf = 32;
		boolean isRowEmpty = false;
		System.out.println("****......................................................****");
		while(isRowEmpty==false)
		{

			Stack<Node<T>> localStack = new Stack<Node<T>>();
			isRowEmpty = true;
			for(int j=0; j<emptyLeaf; j++)
				System.out.print(' ');
			while(globalStack.isEmpty()==false)
			{
				Node<T> temp = globalStack.pop();
				if(temp != null)
				{
					System.out.print(temp.getData());
					localStack.push(temp.getLeft());
					localStack.push(temp.getRight());
					if(temp.getLeft() != null ||temp.getRight() != null)
						isRowEmpty = false;
				}
				else
				{
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for(int j=0; j<emptyLeaf*2-2; j++)
					System.out.print(' ');
			}
			System.out.println();
			emptyLeaf /= 2;
			while(localStack.isEmpty()==false)
				globalStack.push( localStack.pop() );
		}
		System.out.println("****......................................................****");
		System.out.println();
	} 

	public static void main(String[] args) {

		BinaryTree<Integer> t = new BinaryTree<Integer>();

		t.insert( 10 );
		t.insert( 5 );
		t.insert( 15 );
		t.displayTree();
		t.insert( 20 );
		t.insert( 12 );
		t.insert( 3 );
		t.displayTree();


		t.breadthFirstSearch();

		t.inOrder();


		BinaryTree<String> s = new BinaryTree<String>();

		s.insert( "Mike");
		s.insert( "Bob");
		s.insert( "Billy");
		s.insert( "Sally");
		s.insert( "Mike" );
		s.insert( "Tom" );
		s.displayTree();
		s.insert( "Jackie");
		s.insert( "Wilson");
		s.insert( "Albert");
		s.insert( "Cathy");
		s.displayTree();
		s.breadthFirstSearch();
		s.inOrder();


	}


	public static class Node<T extends Comparable<? super T> > {

		protected T data = null;

		private Node<T> left = null;
		private Node<T> right = null;


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



		public Node<T> getLeft() {
			return left;
		}

		public void setLeft(Node<T> left) {
			this.left = left;
		}

		public Node<T> getRight() {
			return right;
		}

		public void setRight(Node<T> right) {
			this.right = right;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}


	}

}
