package review;

import java.util.Scanner;

public class ��ƽ����_���� {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int m=in.nextInt();
		int sqrt_m=(int) Math.sqrt(m);
		for(int a=0;a<=sqrt_m;a++){
			for(int  b=a;b<=sqrt_m;b++){
				for(int c=b;c<=sqrt_m;c++){
					int d=(int) Math.sqrt(m-a*a-b*b-c*c);//����֪�ı�������һ���Ĺ�ϵ��������ֵ���������Ҫ��֤��������
					if( d>=c && a*a+b*b+c*c+d*d==m){
						System.out.println("a="+a+" b="+b+" c="+c+" d="+d);
					}
				}
			}
		}
	}
}
