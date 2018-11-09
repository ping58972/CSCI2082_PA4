package edu.century.pa4;

public class Recursion {
	public static int C(int n, int r) {
		if ( n<r|| (n<=0 || r<=0)) {
			System.out.print("Please input the correct Number! ");
			return 0;
		}else
		return  (factory(n) / (factory(r) * factory(n-r)));
	}
	private static int factory(int n) {
		if(n==1) return 1;
		else return n * factory(n-1);
	}
	
	public static void displayPin(int n) {
		if(n==1) System.out.print("*");
		else {
			System.out.print(pinRow(n));
			displayPin(n-1);
		}
	}
	private static String pinRow(int n) {
		if(n==1) return "*\n";
		else return ("*" + pinRow(n-1));
	}
	
	public static void main(String[] agrs) {
		System.out.println(C(12, 4));
		System.out.println(C(3, 4));
		displayPin(5);
	}
	
}
