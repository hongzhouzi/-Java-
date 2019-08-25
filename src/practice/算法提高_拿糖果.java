package practice;

import java.util.Scanner;

/*
 * ���ö�̬�滮���������һ���������������ȥд���ǹ�������
 * */
public class �㷨���_���ǹ� {
	static int[]prime=new int[50000];
	static int[]dp=new int[100000];
	static boolean[]book=new boolean[100000];
	static int count=0;
	static void Prime(){
		for(int i=2;i<=Math.sqrt(dp.length);i++){
			if(book[i]==false){
				prime[count++]=i;
				for(int j=i*i;j<=Math.sqrt(dp.length);j=j+i)
					book[j]=true;
			}
		}
	}
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		Prime();
		int n=in.nextInt();
		for(int i=1;i<=n;i++){
			for(int j=0;j<count;j++){
				if(prime[j]>Math.sqrt(i))
					break;
				if(i%prime[j]==0)
					dp[i]=Math.max(dp[i], dp[i-2*prime[j]]+prime[j]);
			}
		}
		System.out.println(dp[n]);
	}
}
