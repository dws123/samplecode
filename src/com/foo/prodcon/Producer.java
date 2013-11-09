package com.foo.prodcon;

public class Producer implements Runnable {
	
	
	private MyQueue<Integer> q = null;
	
	

	public Producer(MyQueue<Integer> q) {
		super();
		this.q = q;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		Integer i = 0;
		
		while( true ){
			
			i++;
			
			System.out.println( "Adding " + i);
			q.add( i );
			
			try {
				Thread.sleep( 600 );
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		

	}

}
