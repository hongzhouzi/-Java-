package practice;

import java.util.Scanner;

public class text {
	//�ݹ����������Ҫ�㣺f(k,n-1)+f(k-1,n-1);
	static int f(int k,int n)
	{
		if(k==n||k==0)//ע��������� 
		return 1;
		else
		return f(k,n-1)+f(k-1,n-1);
	}
	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		int k=in.nextInt();
		int n=in.nextInt();
		if(k==n||0==k){
			System.out.println(1);
			return;
		}
		System.out.println(f(k,n));
	}
}
