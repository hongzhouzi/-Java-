package review;

import java.util.Scanner;

public class ·ÖÇÉ¿ËÁ¦_8 {
	static boolean judge(int m){
		int res=0,h1,w1;
		for(int i=0;i<n;i++){
			 h1=h[i]/m;
			 w1=w[i]/m;
			res+=h1*w1;
		}
		if(res>=k) return true;
		else return false;
	}
	static int n,k;
	static int h[]=new int[100010];
	static int w[]=new int[100010];
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		n=in.nextInt();
		k=in.nextInt();
		for(int i=0;i<n;i++){
			h[i]=in.nextInt();
			w[i]=in.nextInt();
		}
		int low=0,high=10000;
		while(low<high){
			int mid=(high-low)/2;
			if(judge(mid)){
				System.out.println(mid);
				return;
			}
			else{
				high=mid;
			}
		}
	}
}
