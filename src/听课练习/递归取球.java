package 听课练习;

//n个球任意取m个（不放回），求有多少种取法
public class 递归取球 {
	
	public static int f(int n,int m){
		if(n<m) return 0;	//此种情况无法取球，返回0。还能防止输入错误
		if(n==m) return 1;	//n==m时只有一种取法，是一个递归出口，返回1
		if(0==m) return 1;	//m==0，只有不取这一种方式，返回1
		
		/*对所取的球中想象成有m个特殊的球存在，以取那个特殊球和不取那个特殊球来划分，从而进行递归求解
		 * f(n-1,m-1):取那个特殊球，对下一次的影响是：总球数减少一个，特殊球减少一个。考虑出口m==0
		 * f(n-1,m):不取那个特殊球，对下一次的影响是：总球数减少一个，特殊球没有减少。考虑出口n==m，n<m
		 * */
		return f(n-1,m-1)+f(n-1,m);
	}
	
	public static void main(String[] args) {
		System.out.println(f(10,3));
	}
}
