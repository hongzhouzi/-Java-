package practice;

import java.util.Scanner;

public class ����ѵ��_Fibonacci���� {
	
	//���仯������������������ݴ���������Ҫ��ʱ���ã��Կռ任ʱ��
	static int []memory=new int[100000];
	static int fib(int n){
		if (n <= 1) return n;
		if (memory[n] != 0) return memory[n];
		return memory[n]=fib(n-1)+fib(n-2);
	}
	
	
		public static void main(String[] args) {
			
			System.out.println(fib(10));
			
			
			
			/*Scanner in=new Scanner(System.in);
			long[] a=new long[1000001];
			int n=in.nextInt();
			a[2]=1;a[1]=1;
			for(int i=3;i<=n;i++){
				a[i]=a[i-1]+a[i-2];	
			}
			System.out.println(a[n]);*/
			
			
		}
}
