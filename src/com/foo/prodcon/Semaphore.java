package com.foo.prodcon;

public class Semaphore {
	
	
	private int numPermits = 0;
	
	private int permitsUsed = 0;
	
	private Object lock = new Object();
	
	
	

	public Semaphore(int numPermits) {
		super();
		this.numPermits = numPermits;
	}

	public void aquire() {
		
		try {
			
			synchronized(this) {
				permitsUsed++;
			}
		
			while( permitsUsed >= numPermits ){
				synchronized(lock){
					lock.wait();
				}
			}
		
		}
		catch( InterruptedException e){
			
		}
		
	}
	
	public void release(){
		
		synchronized(this) {
			permitsUsed--;
		}
		
		synchronized(lock){
			lock.notifyAll();
		}
		
		
	}
	
	
	
	
	

}
