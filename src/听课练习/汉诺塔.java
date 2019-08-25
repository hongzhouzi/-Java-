package 听课练习;

import java.util.Scanner;

public class 汉诺塔 {
	static int f(int n,int p1,int p2,int p3){
		count++;
		if(n==1){
			System.out.println("盘子从"+p1+"移动到 "+p3);	//本质都是从1到3，即从起点到终点
		}
		else{
			f(n-1,p1,p3,p2);	//把1上的n-1个移动到2上缓冲，起点上的不动，转移中转的放中间过度，终点的放后面
			System.out.println("盘子从"+p1+"移动到 "+p3);	//把最下面那个从起点转移到终点
			f(n-1,p2,p1,p3);	//把2上面的移动到3上，起点上的不动，转移中转的放中间过度，终点的放后面
		}
		return count;
	}
	static int count = 0;
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int m=in.nextInt();
		f(m,1,2,3);
		System.out.println(count);
	}
}
/*
 首先当只有1个盘子在A上的时候，就移动1次，从A 移动C。
那有两个盘子在A上的时候，肯定先将小盘子移动到B，然后大盘子由A移动到C。小盘子由 B移动到C。
分析两个盘子的情况，两个盘子比1个盘子的情况多了一步，把小盘子移动到B的过程，另外两步的本质都可以看出由A移动到C。
那么当有N个盘子在A上的时候，我们是怎么样来做的？我们的解决办法是否可以理解成有两个盘子的状态。
N个盘子，       A,B,C 三个柱子 
第一步，   将n-1个盘子移动到B，即  f(n-1, A,C,B)      这里的意思是 N-1的盘子，通过C为中间，移动到B盘
第二步，    将最底下的大盘子， 由 A移动C move(A,C)
第三步，    此时经过前两步骤，A：0个盘子 ，  B：N-1个盘子， C：1个最大的盘子
那么接下来，就是将B 移动到 C  ， 即  f(n-1,B,A,C)    这里的意思是 n-1的盘子，通过A为中间，移动到C盘  
 * */
 