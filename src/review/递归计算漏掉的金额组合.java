package review;

import java.util.Scanner;
//ctrl+shift+o：自动引入包和删除无用包
public class 递归计算漏掉的金额组合 {
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
某财务部门结账时发现总金额不对头。很可能是从明细上漏掉了某一笔或几笔。如果已知明细账目清单，能通过编程找到漏掉的是哪一笔或几笔吗？
如果有种可能，则输出所有可能的情况。我们规定，用户输入的第一行是：有错的总金额。接下来是一个整数n，表示下面将要输入的明细账目的条数。
再接下来是n行整数，分别表示每笔账目的金额。要求程序输出：所有可能漏掉的金额组合。每个情况一行。金额按照从小到大排列，中间用空格分开。
比如，用户输入：6 5 3 2 4 3 1
	则输出:  1 3 3
			1 2 4
			3 4 
 */