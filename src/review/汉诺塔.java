package review;

import java.util.Scanner;

public class ��ŵ�� {
	static int f(int n,char a,char b,char c){
		count++;
		if(n==1) 
			System.out.println("��"+a+"�ƶ���"+c);
		else{
			f(n-1,a,c,b);	//�������n-1����aͨ��c��ת�ƶ���b
			System.out.println("��"+a+"�ƶ���"+c);	//�ѵ�n����a�ƶ���c
			f(n-1,b,a,c);	//���ƶ���b�����ͨ��a��ת�ƶ���c��
		}
		return count;
	}
	static int count=0;
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int m=in.nextInt();
		f(m,'a','b','c');
		System.out.println("�ƶ�����Ϊ��"+count);
	}
}
