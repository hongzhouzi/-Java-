package 啊哈算法_学习笔记;

import java.util.Scanner;

public class 火柴棍等式 {
	static int f(int n){
		int num=0;
		int a[]={6,2,5,5,4,5,6,3,7,6};
		while(n/10!=0){		//不是0到9之间的一位数时
			num+=a[n%10];	//依次取位
			n/=10;	//别忘了更新变量
		}
		num+=a[n];	//加上那个一位数
		return num;
	}
	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		int num=in.nextInt();
		int sum=0;
		for(int i=0;i<=1111;i++){
			for(int j=0;j<=1111;j++){
				int k=i+j;
				if(f(i)+f(j)+f(k)==num-4){
					System.out.printf("%d+%d=%d\n", i,j,k);
					sum++;
				}
			}
		}
		System.out.println("共有"+sum+"个数");
	}
}
