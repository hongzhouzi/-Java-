package ��ս������ƾ�����Ŀ;

import java.util.Scanner;

public class Ӳ������ {
	public static void main(String[] args) {
		int []V={1,5,10,50,100,500};	//Ӳ����ֵ
		Scanner in=new Scanner(System.in);
		int num[]=new int[V.length];
		for(int i=0;i<V.length;i++){
			num[i]=in.nextInt();
		}
		int sum=in.nextInt();
		int count=0;
		for(int i=V.length-1;i>=0;i--){
			int t=Math.min(sum/V[i], num[i]);	//ʹ��Ӳ�ҵ�����
			sum-=V[i]*t;	//�ܽ������ȥ��ʹ��Ӳ�����Ľ��
			count++;
		}
		System.out.println(count);
	}
}
