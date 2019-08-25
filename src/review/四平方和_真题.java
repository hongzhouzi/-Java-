package review;

import java.util.Scanner;

public class 四平方和_真题 {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int m=in.nextInt();
		int sqrt_m=(int) Math.sqrt(m);
		for(int a=0;a<=sqrt_m;a++){
			for(int  b=a;b<=sqrt_m;b++){
				for(int c=b;c<=sqrt_m;c++){
					int d=(int) Math.sqrt(m-a*a-b*b-c*c);//由已知的变量根据一定的关系计算出这个值，计算后需要验证符合题意
					if( d>=c && a*a+b*b+c*c+d*d==m){
						System.out.println("a="+a+" b="+b+" c="+c+" d="+d);
					}
				}
			}
		}
	}
}
