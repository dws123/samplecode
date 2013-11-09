package com.foo.sudoku;

public class Checker {
	
	
	/*
	 * 
	 * 
	 * *  -----------------------
	 * | 1 8 7 | 4 9 2 | 5 6 3 |
	 * | 5 3 4 | 6 7 8 | 9 1 2 |
	 * | 9 6 2 | 1 3 5 | 7 8 4 |
	 *  -----------------------
	 * | 4 5 8 | 2 1 6 | 3 9 7 |
	 * | 2 7 3 | 8 4 9 | 6 5 1 |
	 * | 6 1 9 | 3 5 7 | 4 2 8 |
	 *  -----------------------
	 * | 8 4 1 | 9 6 3 | 2 7 5 |
	 * | 7 2 6 | 5 8 4 | 1 3 9 |
	 * | 3 9 5 | 7 2 1 | 8 4 6 |
	 *  -----------------------
	 */
	
	private static int m[][] = {
		{ 1, 8, 7, 4, 9, 2, 5, 6, 3 },
		{ 5, 3, 4, 6, 7, 8, 9, 1, 2 },
		{ 9, 6, 2, 1, 3, 5, 7, 8, 4 },
		{ 4, 5, 8, 2, 1, 6, 3, 9, 7 },
		{ 2, 7, 3, 8, 4, 9, 6, 5, 1 },
		{ 6, 1, 9, 3, 5, 7, 4, 2, 8 },
		{ 8, 4, 1, 9, 6, 3, 2, 7, 5 },
		{ 7, 2, 6, 5, 8, 4, 1, 3, 9 },
		{ 3, 9, 5, 7, 2, 1, 8, 4, 6 }
	};
	
	private static int[] counter = new int[9];
	
	private static void init(){
		for(int i=0;i<9;i++)
			counter[i]=0;
	}
	
	public static void main( String args[] ){
		
		/*for(int i=0; i<9; i++) {
		      for(int j=0; j<9; j++)
		        System.out.print(m[i][j] + " ");
		      System.out.println();
		    }*/
		
		System.out.println( check(m) );
		
	}
	
	public static Boolean check( int[][] m ){
		
		init();
		
		for(int i=0; i<9; i++) {
		      for(int j=0; j<9; j++){
		        int val = m[i][j];
		        if( ++counter[val-1] > 1)
		        	return false;
		    
		      }
		      init();
		    }
		
		
		return true;
		
	}
	

}
