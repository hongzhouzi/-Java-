package ецЬт;

import java.util.Scanner;

public class Main8 {
	static int count=0;
	static void f(int x){
		if(x<3) return;
		int a=x/3;
		int b=x%3;
		count+=a;
		f(a+b);
		return;
	}
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		f(n);
		System.out.println(count+n);
	}
	
}
