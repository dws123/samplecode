package com.foo.bits;

public class BitCounter {
	
	
	public static int numBits( byte in ){
		
		int numBits = 0;
		
		byte val = in;
		
		for(int i= 0; i< 8; i++){
									
			if( (val & 1) ==1){
				numBits++;
			}
			val = (byte) (val>>1);			
		}
		
		return numBits;		
	}
	
	public static void main(String [] args){
				
		for( int i = -128; i<=127; i++) {
			System.out.println( i + ":" +  numBits((byte)i) ) ;
		}
			
		
	}

}
