package �����㷨_ѧϰ�ʼ�;

import java.util.Scanner;

public class ������ʽ {
	static int f(int n){
		int num=0;
		int a[]={6,2,5,5,4,5,6,3,7,6};
		while(n/10!=0){		//����0��9֮���һλ��ʱ
			num+=a[n%10];	//����ȡλ
			n/=10;	//�����˸��±���
		}
		num+=a[n];	//�����Ǹ�һλ��
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
		System.out.println("����"+sum+"����");
	}
}
