package review;

import java.util.Scanner;

public class 汉诺塔 {
	static int f(int n,char a,char b,char c){
		count++;
		if(n==1) 
			System.out.println("从"+a+"移动到"+c);
		else{
			f(n-1,a,c,b);	//把上面的n-1个从a通过c中转移动到b
			System.out.println("从"+a+"移动到"+c);	//把第n个从a移动的c
			f(n-1,b,a,c);	//把移动到b上面的通过a中转移动到c上
		}
		return count;
	}
	static int count=0;
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int m=in.nextInt();
		f(m,'a','b','c');
		System.out.println("移动次数为："+count);
	}
}
