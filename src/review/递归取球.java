package review;

//n个球任意取m个（不放回），求有多少种取法
public class 递归取球 {
	//把那m个球想象成特殊的球，把它分为取特殊球和不取特殊球来划分，取了m个球后就结束递归
	static int f(int n,int m){
		if(m==0||n==0) return 1;
		if(n<m) return 0;		//此情况不能取球，防止错误输入
		if(n==m) return 1;		//当m和n相等时，只有一种取球情况
		
		return f(n-1,m-1)+f(n-1,m);		//每次都取球，分不取特殊球和取特殊球
	}
	public static void main(String[] args) {
		System.out.println(f(10,3));
	}
}
