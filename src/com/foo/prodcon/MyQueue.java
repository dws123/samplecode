package com.foo.prodcon;

import java.util.LinkedList;

public class MyQueue<T> {
	
	private LinkedList<T> list = new LinkedList<T>();
	private Semaphore sem = new Semaphore(5);
	
	private Object emptyMonitor = new Object();
	
	public void add(T data){
		sem.aquire();
		
		synchronized(list){
		list.addLast( data );
		}
		
	}
	
	
	public T remove(){
		
		synchronized( emptyMonitor ){
			while(list.isEmpty())
				try {
					emptyMonitor.wait();
				} catch (InterruptedException e) { e.printStackTrace(); }
			
		}
		
		T data = list.removeFirst();
		sem.release();
		return data;
	}
	
	
	 public static void main(String[] args) {
		 
		 MyQueue<Integer> q = new MyQueue<Integer>();
		 
		 Thread p = new Thread ( new Producer(q) );
		 
		 Thread c = new Thread( new Consumer(q) );
		 
		 p.start();
		 
		 c.start();
		 
		/* q.add( 5 );
		 q.add( 10 );
		 q.add( 15 );
		 
		 System.out.println( q.remove() );
		 System.out.println( q.remove() );
		 System.out.println( q.remove() );*/
		 
		 
	 }
	

}
