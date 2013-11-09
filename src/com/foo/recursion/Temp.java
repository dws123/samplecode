package com.foo.recursion;


public class Temp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		
		String in = "Hi there. My name is freddy.";
		  
		String out = reverse( in );
		
		System.out.println( out );
		
		System.out.println ( countCaps(in) );
		
		for ( int i =0; i < 65; i++){
			
			System.out.println( i + " : " + isPowerOf2(i) );
			
		}
		
	}
	
	
	public static String reverse(String str) {
        if ((null == str) || (str.length()  <= 1)) {
            return str;
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }
	
	
	public static int countCaps( String in ){
		
		int num = 0;
		
		for( int i = 0; i < in.length(); i++ ) {
			if( in.charAt( i ) >= 'A' && in.charAt( i ) < 'a' ){
				num++;
			}
		}
		
		return num;
		
	}
	
	public static Boolean isPowerOf2( int num ){
		
		return (num & (num-1)) == 0 ? true : false;
		
	}

}
