package review;

import java.util.Scanner;

public class 解二元一次方程 {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
//		表示ax+by=c的解
		int a=in.nextInt();
		int b=in.nextInt();
		int c=in.nextInt();
		System.out.println("a:"+a+" b:"+b+" c:"+c);
		for(int i=0;i<=10;i++){
			if((c-b*i)%a==0)	//看能不能整除
				System.out.println("x:"+(c-b*i)/a+" y:"+i);		//注意这儿的x值如何取的
		}
	}
}
