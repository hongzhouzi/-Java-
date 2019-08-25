package 真题;

import java.util.Scanner;

public class 四平方和 {
	//a中是有装有下标数的平方的数组，n是输入需要求其四平方和的数，tail是n开方后向上取整的数，cur是标记box数组的标记变量，k是标记a数组的标记变量
	/*static void f(int a[],int n,int tail,int cur,int k){
		if(k>tail) return;	//检测超过a数组长度的数据后就表示探测完了，结束
		if(n<0) return;		
		if(cur==N-1&&n==0){
			for(int j=0;j<N;j++)
				System.out.print(box[j]+" ");
		}
		
		{
			box[cur]=a[k];	//试探当前这个，取当前的数
			f(a,n-a[k],tail,cur+1,k+1);
			box[cur]=0;		//回溯
		}
		{
			f(a,n,tail,cur,k+1);	//不取当前这个
		}
		
		
	}
	static final int N=4;
	static int box[]=new int[N];*/
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int tail=(int)Math.floor(Math.sqrt(n));	//注意这个返回的是浮点形式，需要做类型转换
		/*int arr[]=new int[tail+1];	//把输入的数开方并向下取整后，对0到这个数范围内的数求其平方，存入该数组中
		for(int i=0;i<=tail;i++){	//求平方过程
			arr[i]=i*i;
		}
		f(arr,n,tail,0,0);*/
		boolean flag=true;	//标记变量，用于跳出循环
		for(int a=0;a<=tail&&flag;a++){
			for(int b=a;b<=tail&&flag;b++){
				for(int c=b;c<=tail&&flag;c++){
					int d=(int)Math.sqrt(n-a*a-b*b-c*c);
					if(n==a*a+b*b+c*c+d*d){
						System.out.println(a+" "+b+" "+c+" "+d);
						flag=false;
					}
				}
			}
		}
		
	}
}
/*
四平方和

四平方和定理，又称为拉格朗日定理：
每个正整数都可以表示为至多4个正整数的平方和。
如果把0包括进去，就正好可以表示为4个数的平方和。

比如：
5 = 0^2 + 0^2 + 1^2 + 2^2
7 = 1^2 + 1^2 + 1^2 + 2^2
（^符号表示乘方的意思）

对于一个给定的正整数，可能存在多种平方和的表示法。
要求你对4个数排序：
0 <= a <= b <= c <= d
并对所有的可能表示法按 a,b,c,d 为联合主键升序排列，最后输出第一个表示法

程序输入为一个正整数N (N<5000000)
要求输出4个非负整数，按从小到大排序，中间用空格分开

例如，输入：
5
则程序应该输出：
0 0 1 2

再例如，输入：
12
则程序应该输出：
0 2 2 2

再例如，输入：
773535
则程序应该输出：
1 1 267 838

资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 3000ms
请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。
所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
注意：不要使用package语句。不要使用jdk1.7及以上版本的特性。
注意：主类的名字必须是：Main，否则按无效代码处理。
*/