package ������ϰ;

import java.util.Scanner;

public class �ݹ����©���Ľ����� {
	
	public static int sumMoney,sumNum,NumMoney[]={5,2,3,2,5};
	public static boolean a[]={false,false,false,false,false};
	public static void f(int cur_sum,int cur,boolean [] a){
		
		/*���ڣ�������ĺ�������̽���ĵ�ǰ�����ʱ�Ϳ�������
		 * */
		if(sumMoney==cur_sum&&cur==sumNum){	//����Ҫ����ȫ������̽һ��ſ���
			for(int i=0;i<cur;i++){
				if(a[i]==false){
					System.out.print("����λ�ã�"+i+"");
					System.out.print(" ����"+NumMoney[i]+"@@     ");
				}
			}
			System.out.println();
		}
		if(cur>=sumNum) return;	//ע������
		if(cur_sum>sumMoney) return;
		
		/*
		 * ������֪��������˵��ͺ��ܵ��˵���ϸ����ôҪ��ÿ���˵���ϸ��������̽������Զ�ÿ�����Ƿ�ȡ�����
		 * */
		{
			a[cur] =false;		//��ѡ��ǰ����
			f(cur_sum,cur+1,a); //�ݹ������̽
			a[cur]=true;		//���ݣ�����������a[cur]=true;���Դ˴��Ŀ���ʡ��
		}
		{
			a[cur]=true;				//ѡ��ǰ����
			cur_sum +=NumMoney[cur];	//�Ѹ�������ܺ���������̽
			f(cur_sum,cur+1,a);			//�ݹ������̽
			a[cur]=false;				//����
		}
	}
	
	public static void main(String[] args) {
		/*Scanner in=new Scanner(System.in);
		sumMoney=in.nextInt();	//�����ܽ����
		sumNum=in.nextInt();	//�����˵�������
		NumMoney=new int[10];	//���������˵�������
		a=new boolean[10];
		for(int i=0;i<sumNum;i++){	//�����˵���������
			NumMoney[i]=in.nextInt();
		}*/
		sumMoney=10;
		sumNum=5;
		f(0,0,a);
	}
}
