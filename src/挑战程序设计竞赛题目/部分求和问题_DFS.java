package 挑战程序设计竞赛题目;

public class 部分求和问题_DFS {
	static int n=4;
	static int a[]={5,6,7,8};
	static int b=12;
	static boolean dfs(int i,int sum){
		if(n==i) return b==sum;				//出口之一：数列中的数遍历完后
		if(dfs(i+1,sum+a[i])) return true;	//加上当前这个数
		if(dfs(i+1,sum)) return true;		//不加当前这个数
		return false;
	}
	public static void main(String[] args) {
		if(dfs(0,0)) System.out.println("YES");
		else System.out.println("NO");
	}
}
