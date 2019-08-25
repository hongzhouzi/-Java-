package 听课练习;

import java.util.Scanner;

public class 分治算法找假硬币 {
	static final int MAXNUM=30;
	static int FalseCoin(int coin[],int low,int high){
		int i,sum1,sum2,sum3;
		int re=0;
		sum1=sum2=sum3=0;
		if(low+1==high){	//两个相邻时
			if(coin[low]<coin[high]){
				re=low+1;
				return re;
			}else{
				re=high+1;
				return re;
			}
		}
		if((high-low+1)%2==0){			//为偶数时
			for(i=low;i<=low+(high-low)/2;i++)	//前半段和
				sum1+=coin[i];
			for(i=low+(high-low)/2+1;i<=high;i++)	//后半段和
				sum2+=coin[i];
			if(sum1>sum2){
				re=FalseCoin(coin,low+(high-low)/2+1,high);
				return re;
			}else if(sum1<sum2){
				re=FalseCoin(coin,low,low+(high-low)/2);
				return re;
			}
		}else{							//为奇数时
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
		System.out.println("假硬币的所在位置是"+post);
	}
	
}
