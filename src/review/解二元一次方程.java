package review;

import java.util.Scanner;

public class ���Ԫһ�η��� {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
//		��ʾax+by=c�Ľ�
		int a=in.nextInt();
		int b=in.nextInt();
		int c=in.nextInt();
		System.out.println("a:"+a+" b:"+b+" c:"+c);
		for(int i=0;i<=10;i++){
			if((c-b*i)%a==0)	//���ܲ�������
				System.out.println("x:"+(c-b*i)/a+" y:"+i);		//ע�������xֵ���ȡ��
		}
	}
}
