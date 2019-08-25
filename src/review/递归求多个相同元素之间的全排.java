package review;

//若有m个A和n个B，求A和B之间的全排列
//想到，在求全排列时，如果只有一种类型那么就只有一种排列方式，所以想得到用递归的思想把它依次拆分

public class 递归求多个相同元素之间的全排 {
	static int f(int m,int n){
		if(m==0||n==0) return 1;
		return f(m-1,n)+f(m,n-1);
	}
	static int f(int m,int n,int t){
		if(m==0&&n==0&&t!=0) return 1;
		if(m==0&&n!=0&&t==0) return 1;
		if(m!=0&&n==0&&t==0) return 1;
		
		if(m==0&&n!=0&&t!=0) return f(0,n-1,t)+f(0,n,t-1);
		if(m!=0&&n==0&&t!=0) return f(m-1,0,t)+f(m,0,t-1);
		if(m!=0&&n!=0&&t==0) return f(m-1,n,0)+f(m,n-1,0);
		
		return f(m-1,n,t)+f(m,n-1,t)+f(m,n,t-1);	
 	}
	public static void main(String[] args) {
		System.out.println(f(3,2));
		System.out.println(f(3,2,1));
	}
}
