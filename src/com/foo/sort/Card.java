package com.foo.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Card implements Comparable<Card> {
	
	int suit = 0;
	int rank = 0;
	
	
	public Card(int suit, int rank) {
		super();
		this.suit = suit;
		this.rank = rank;
	}

	

	@Override
	public String toString() {
		return suit + "|" + rank;
	}



	public int getSuit() {
		return suit;
	}
	public int getRank() {
		return rank;
	}



	@Override
	public int compareTo(Card o) {
		
		int s = this.suit - o.getSuit();
		if( s != 0){
			return s;
		}
		else return ( this.rank - o.getRank() );
				
	}
	
	 public static void main(String[] args) {
		 
		 
		 Random gen = new Random();
		 
		 ArrayList<Card> list = new ArrayList<Card>();
		 
		 for(int s=1;s<=4;s++) {
			 for( int r=1; r<=13; r++){
				Card c = new Card( s, r );
				list.add( c );
			 }
		 }
		 
		System.out.println( list.toString() );
		 
		Collections.shuffle( list );
		
		System.out.println( list.toString() );
		
		Collections.sort( list );
		
		System.out.println( list.toString() );
		
		 
	 }
	
	

}
