package com.foo.prodcon;

import java.util.Random;

public class Consumer implements Runnable {
	
	private MyQueue<Integer> q = null;
	
	

	public Consumer(MyQueue<Integer> q) {
		super();
		this.q = q;
	}



	@Override
	public void run() {
	
		while( true ){
			
			try {
				Thread.sleep( 3000 );
			} catch ( InterruptedException e ) { e.printStackTrace();	}
			
			Random generator = new Random();
			int num = generator.nextInt(6) + 1;
			
			for( int i=0; i< num; i++){
			
				System.out.println( "Consumed " + q.remove() );
				try {
					Thread.sleep( 100 );
				} catch ( InterruptedException e ) { e.printStackTrace();	}
				
			}
			
			
			
		}

	}

}
