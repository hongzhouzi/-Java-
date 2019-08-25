package 真题;

import java.util.Scanner;

public class _8_k倍区间 {
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
/*给定一个长度为N的数列，A1, A2, ... AN，如果其中一段连续的子序列Ai, Ai+1, ... Aj(i <= j)之和是K的倍数，我们就称这个区间[i, j]是K倍区间。  
你能求出数列中总共有多少个K倍区间吗？  

输入
-----
第一行包含两个整数N和K。(1 <= N, K <= 100000)  
以下N行每行包含一个整数Ai。(1 <= Ai <= 100000)  

输出
-----
输出一个整数，代表K倍区间的数目。  


例如，
输入：
5 2
1  
2  
3  
4  
5  

程序应该输出：
6*/