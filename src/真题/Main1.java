package ецЬт;

import java.util.Scanner;

public class Main1 {
	static void f(int n){
		if(n==10){
			return;
		}
		for(int i=1;i<10;i++){
			if(!mark[i]){
				mark[i]=true;
				box[n]=i;
				mark[i]=false;
			}
		}
	}
	static int box[]=new int[10];
	static boolean mark[]=new boolean[10];
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		
	}
}
