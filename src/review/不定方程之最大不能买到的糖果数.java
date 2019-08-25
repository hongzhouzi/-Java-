package review;

import java.util.Scanner;

public class 不定方程之最大不能买到的糖果数 {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int a=in.nextInt();
		int b=in.nextInt();
		final int N=100;
		int count=0;
		boolean box[]=new boolean[N];
		
		for(int i=0;i<N/a;i++){		//试验不定方程的解
			for(int j=0;j<N-(N/a);j++){
				if(a*i+b*j<N)
					box[a*i+b*j]=true;
			}
		}
		for(int i=0;i<N;i++){		//检测盒子里面中的情况，当连续能取到的数超过两个数中较小的那个数时就是所求数
			if(box[i]==true) count++;
			else count=0;
			if(count==(a<b?a:b)) {	//一定要注意这儿的出口顺序，在每次计数之后检测，不然所得数会大1
				System.out.println(i-(a<b?a:b));
				break;
			}
		}
		
	}
}
/*
 问题描述 
小明开了一家糖果店。他别出心裁：把水果糖包成4颗一包和7颗一包的两种。糖果不能拆包卖。 
小朋友来买糖的时候，他就用这两种包装来组合。当然有些糖果数目是无法组合出来的，比如要买 10 颗糖。 
你可以用计算机测试一下，在这种包装情况下，最大不能买到的数量是17。大于17的任何数字都可以用4和7组合出来。 
本题的要求就是在已知两个包装的数量时，求最大不能组合出的数字。 
输入格式 
两个正整数，表示每种包装中糖的颗数(都不多于1000) 
输出格式 
一个正整数，表示最大不能买到的糖数 
样例输入1 
4 7 
样例输出1 
17 
样例输入2 
3 5 
样例输出2 
7 
 */