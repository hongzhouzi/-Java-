package 真题;

import java.util.Scanner;

public class _8_包子凑数 {
	static int f(int a,int b){
		if(b==0) return a;
		return f(b,a%b);
	}
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int a[]=new int[n];
		final int N=1000;
		boolean box[]=new boolean[N];
		for(int i=0;i<n;i++){
			a[i]=in.nextInt();
		}
		int temp=a[0];
		for(int i=1;i<n;i++){
			temp=f(a[i],temp);
		}
		if(temp!=1){
			System.out.println("INF");
		}
		else{
			//+++++++关键算法++++++++++++
			box[0]=true;	//一定要把这个初始化为true，
			for(int i=0;i<n;i++){	
				for(int j=0;j+a[i]<N;j++){	//试探每个数据的倍数及下个和它组合的数
					if(box[j]){
						box[j+a[i]]=true;
					}
				}
			}
			//+++++++++++++++++++++++++++++++
			int count=0;
			for(int i=0;i<N;i++){
				if(box[i]==false)
					count++;
			}
			System.out.println(count);
		}
	}
}
/*小明几乎每天早晨都会在一家包子铺吃早餐。他发现这家包子铺有N种蒸笼，其中第i种蒸笼恰好能放Ai个包子。每种蒸笼都有非常多笼，可以认为是无限笼
每当有顾客想买X个包子，卖包子的大叔就会迅速选出若干笼包子来，使得这若干笼中恰好一共有X个包子。比如一共有3种蒸笼，分别能放3、4和5个包子。
当顾客想买11个包子时，大叔就会选2笼3个的再加1笼5个的（也可能选出1笼3个的再加2笼4个的）。
当然有时包子大叔无论如何也凑不出顾客想买的数量。比如一共有3种蒸笼，分别能放4、5和6个包子。而顾客想买7个包子时，大叔就凑不出来了。
小明想知道一共有多少种数目是包子大叔凑不出来的。

输入
----
第一行包含一个整数N。(1 <= N <= 100)
以下N行每行包含一个整数Ai。(1 <= Ai <= 100)  

输出
----
一个整数代表答案。如果凑不出的数目有无限多个，输出INF。

例如，
输入：
2  
4  
5   

程序应该输出：
6  

再例如，
输入：
2  
4  
6    

程序应该输出：
INF

样例解释：
对于样例1，凑不出的数目包括：1, 2, 3, 6, 7, 11。  
对于样例2，所有奇数都凑不出来，所以有无限多个。*/