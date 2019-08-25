package 挑战程序设计竞赛题目;

import java.util.Scanner;

public class 硬币问题 {
	public static void main(String[] args) {
		int []V={1,5,10,50,100,500};	//硬币面值
		Scanner in=new Scanner(System.in);
		int num[]=new int[V.length];
		for(int i=0;i<V.length;i++){
			num[i]=in.nextInt();
		}
		int sum=in.nextInt();
		int count=0;
		for(int i=V.length-1;i>=0;i--){
			int t=Math.min(sum/V[i], num[i]);	//使用硬币的数量
			sum-=V[i]*t;	//总金额数减去已使用硬币数的金额
			count++;
		}
		System.out.println(count);
	}
}
