package review;

import java.util.Scanner;
//ctrl+shift+o���Զ��������ɾ�����ð�
public class �ݹ����©���Ľ����� {
	static void f(int sum,int m,boolean book[]){
		if(sum==error_sum&&n==m){
			for(int i=0;i<n;i++){
				if(book[i]==false)
					System.out.print(a[i]+" ");
			}System.out.println();
		}
		if(sum>error_sum) return;
		if(m>n) return;
		
		{
			book[m]=false;
			f(sum,m+1,book);
			book[m]=true;
		}
		{
			book[m]=true;
			f(sum+a[m],m+1,book);
			book[m]=false;
		}
	}
	static boolean []book=new boolean[10]; 
	static int []a=new int[10]; 
	static int error_sum,n;
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		error_sum=in.nextInt();
		n=in.nextInt();
		for(int i=0;i<n;i++)
			a[i]=in.nextInt();
		
		f(0,0,book);
	}
}
/*
ĳ�����Ž���ʱ�����ܽ���ͷ���ܿ����Ǵ���ϸ��©����ĳһ�ʻ򼸱ʡ������֪��ϸ��Ŀ�嵥����ͨ������ҵ�©��������һ�ʻ򼸱���
������ֿ��ܣ���������п��ܵ���������ǹ涨���û�����ĵ�һ���ǣ��д���ܽ���������һ������n����ʾ���潫Ҫ�������ϸ��Ŀ��������
�ٽ�������n���������ֱ��ʾÿ����Ŀ�Ľ�Ҫ�������������п���©���Ľ����ϡ�ÿ�����һ�С����մ�С�������У��м��ÿո�ֿ���
���磬�û����룺6 5 3 2 4 3 1
	�����:  1 3 3
			1 2 4
			3 4 
 */