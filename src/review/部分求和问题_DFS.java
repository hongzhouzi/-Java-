package review;

public class 部分求和问题_DFS {
	static int n=4;
	static int a[]={5,6,7,8};
	static int b=12;
	static boolean f(int k,int sum){
		if(k==a.length) return b==sum;
		if(f(k+1,sum+a[k])) return true;
		if(f(k+1,sum)) return true;
		return false;
	}
	public static void main(String[] args) {
		if(f(0,0)) System.out.println("YES");
		else System.out.println("NO");
	}
}
