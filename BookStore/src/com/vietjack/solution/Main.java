package com.vietjack.solution;

public class Main {
	public static void main(String[] args) {
		BookStore fahasa=new BookStore("Fahasa");
		fahasa.getTopSoldCategory();
		System.out.println("********************");
		fahasa.getTopSoldAuthor();
		System.out.println("***************REVENUE CATEGORY*****");
		fahasa.getTopRevenueCategory();
		System.out.println("********************");
		fahasa.sortAuthorRevenue();
		System.out.println("*********************");
		System.out.println(fahasa.getTotalRenenue4070Age());
		//breakpoint
	//F5: chay vao ham
		//F6 chay tung dong F7 ra khoi ham F8 chuyen sang diem breakpoint moi.
	}
}
