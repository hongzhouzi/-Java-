package ����;

import java.util.Scanner;

public class _8_k������ {
	static int Sum(int a[],int i,int j){
		int sum=0;
		for(;i<=j;i++){
			sum+=a[i];
		}
		return sum;
	}
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int k=in.nextInt();
		int a[]=new int[n+1];
		int m[][]=new int[n+1][n+1];
		for(int i=1;i<n+1;i++)
			a[i]=in.nextInt();
		for(int i=1;i<n+1;i++){
			for(int j=i;j<n+1;j++){
				m[i][j]=Sum(a,i,j);
			}
		}
		int count=0;
		for(int i=1;i<n+1;i++){
			for(int j=i;j<n+1;j++){
				if(m[i][j]%k==0)
					count++;
			}
		}
		System.out.println(count);
	}
}
/*����һ������ΪN�����У�A1, A2, ... AN���������һ��������������Ai, Ai+1, ... Aj(i <= j)֮����K�ı��������Ǿͳ��������[i, j]��K�����䡣  
��������������ܹ��ж��ٸ�K��������  

����
-----
��һ�а�����������N��K��(1 <= N, K <= 100000)  
����N��ÿ�а���һ������Ai��(1 <= Ai <= 100000)  

���
-----
���һ������������K���������Ŀ��  


���磬
���룺
5 2
1  
2  
3  
4  
5  

����Ӧ�������
6*/