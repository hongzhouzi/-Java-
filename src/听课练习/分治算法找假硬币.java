package ������ϰ;

import java.util.Scanner;

public class �����㷨�Ҽ�Ӳ�� {
	static final int MAXNUM=30;
	static int FalseCoin(int coin[],int low,int high){
		int i,sum1,sum2,sum3;
		int re=0;
		sum1=sum2=sum3=0;
		if(low+1==high){	//��������ʱ
			if(coin[low]<coin[high]){
				re=low+1;
				return re;
			}else{
				re=high+1;
				return re;
			}
		}
		if((high-low+1)%2==0){			//Ϊż��ʱ
			for(i=low;i<=low+(high-low)/2;i++)	//ǰ��κ�
				sum1+=coin[i];
			for(i=low+(high-low)/2+1;i<=high;i++)	//���κ�
				sum2+=coin[i];
			if(sum1>sum2){
				re=FalseCoin(coin,low+(high-low)/2+1,high);
				return re;
			}else if(sum1<sum2){
				re=FalseCoin(coin,low,low+(high-low)/2);
				return re;
			}
		}else{							//Ϊ����ʱ
			for(i=low;i<=low+(high-low)/2-1;i++)
				sum1+=coin[i];
			for(i=low+(high-low)/2+1;i<=high;i++)
				sum2+=coin[i];
			sum3=coin[low+(high-low)/2];
			if(sum1>sum2){
				re=FalseCoin(coin,low+(high-low)/2+1,high);
				return re;
			}else if(sum1<sum2){
				re=FalseCoin(coin,low,low+(high-low)/2-1);
				return re;
			}
			if(sum1+sum3==sum2+sum3){
				re=low+(high-low)/2+1;
				return re;
			}
		}
		return re;
	}
	public static void main(String[] args) {
		int []coin=new int [MAXNUM];
		int post;
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		for(int i=0;i<n;i++)
			coin[i]=in.nextInt();
		post=FalseCoin(coin,0,n-1);
		System.out.println("��Ӳ�ҵ�����λ����"+post);
	}
	
}
