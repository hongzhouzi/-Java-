package 听课练习;

import java.math.BigInteger;
/*一个21位数，它的各个位数的21次方之和等于这个21位数，请找出这个21位数？
 * 思路：一个21位数这样的大数值，不能考虑直接暴力破解，那么我们就可从它的各个位入手，
 * 比如一个数由哪些数字组成，那些数字的21次方和是与那些数字的位置是无关的，那么我们就可以尝试找那个21位数由0-9中哪些数字组成，那些数字各有多少
 * 反过来，我们可以先从那些数字各有多少入手，然后去试探，最后判断是否符合
 * 在该过程中会涉及到多次用到0-9的21次方，那我们可以先把他算出来存在哪儿。再去试探那种组合可能会满足，可用递归，最后判断
 * 判断过程，可根据位数和各个数字的个数来判断。
 * */
public class 花朵数 {
	private static BigInteger[] base=new BigInteger[10]; //依次存0-9的21次方的值
	
	//计算该数各个数字的21次方，返回计算后的结果
	private static BigInteger calcu_21(int n) {
		BigInteger a=BigInteger.ONE;	//??把a初始化为1
		for(int i=0;i<21;i++)
			a=a.multiply(BigInteger.valueOf(n));
		return a;
	}
	
	//a数组记录某些数出现过多少次，在a数组中准备处理第k个，k下标是0-9中的数字，数组中存的值是该数字出现的次数，此时还剩sum个长度
	
	private static void f(int[]a,int k,int sum){
		if(sum==0){	//递归出口， 有21位数时就该去测试该数是否符
			text(a);
			return;
		}
		if(k==a.length-1){	//最后还剩一个时，就要把sum全部分配给a[k] 
			a[k]=sum;
			//f(a,k+1,0);
			
			text(a); 
			return;
		}
		for(int i=0;i<=sum;i++){	//向下试探的过程
			a[k]=i;
			f(a,k+1,sum-i);		//在循环中试探
			a[k]=0;				//回溯
		}
	}
	
	//检测该数是否符合条件
	private static void text(int[]a){	
		BigInteger bi=BigInteger.ZERO;	//?？把该数初始化为0
		
		for(int i=0;i<a.length;i++){	//那个数的21次方*那个数出现的次数
			bi=bi.add(base[i].multiply(BigInteger.valueOf(a[i])));	
			//循环结束后，bi=那些数字的21次方之和，是唯一的，所以最后判读是否相等直接看长度和各个数字出现次数就行了
		}
		String s=bi.toString();
		if(s.length()!=21) return;	//如果不是21位数，则不符合条件，直接返回
		
		int[] b=new int[10];	//以该数为下标，存该数出现的次数
		for(int i=0;i<s.length();i++){
			b[s.charAt(i)-'0']++;
		}
		for(int i=0;i<10;i++){	//如果该数据与原始的数字出现次数不相等，则不符合条件，直接返回
			if(a[i]!=b[i]) return;
		}
		System.out.println(bi);
	}
	
	public static void main(String[] args) {
		
		for(int i=0;i<base.length;i++)	//初始化base
			base[i]=calcu_21(i);
		
		int []a=new int[10];	//记录0-9中每个数字出现几次，因为最后求的总和只与每个数字出现的次数有关，与它们的次序没管
		f(a,0,21);		//对a从0到21位进行试探
	}
}
