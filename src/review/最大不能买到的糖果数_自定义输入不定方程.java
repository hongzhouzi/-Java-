package review;

import java.util.Scanner;
//��û����
public class ������򵽵��ǹ���_�Զ������벻������ {
	static void f(int a[],int sum){
		
		if(sum>=N) return;
		
		for(int i=0;i<a.length;i++){
			{
				box[sum]=true;
			    f(a,sum+a[i]);
			    box[sum]=false;
			}
			/*{
				box[sum]=false;
			    f(a,sum);
			    box[sum]=true;
			}*/
		}
		for(int i=0;i<N;i++){
			if(box[i]==true)
				count++;
			else
				count=0;
			if(count==getArrayMin(a)){
				System.out.println(i-getArrayMin(a));
				break;
			}
		}
	}
	static int getArrayMin(int a[]){
		int min=0;
		for(int i=0;i<a.length;i++){
			if(a[i]<min)
				min=a[i];
		}
		return min;
	}
	static final int N=100;
	static boolean box[]=new boolean[N];
	static int count=0;
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		
		int n=in.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++)
			a[i]=in.nextInt();
		f(a,0);
		
	}
}
