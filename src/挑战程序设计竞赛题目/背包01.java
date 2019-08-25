package 挑战程序设计竞赛题目;

public class 背包01 {
	static int n=4;
	static int w[]={2,1,3,2};
	static int v[]={3,2,4,2};
	public static void main(String[] args) {
		int W=5;
		System.out.println(rec(0,W));
	}
	static int rec(int i,int j){
		int res;
		if(i==n){	//没有剩余物品
			res=0;
		}else if(j<w[i]){	//无法挑选该物品
			res=rec(i+1,j);
		}else{		//选与不选取大的
			res=Math.max(rec(i+1,j),rec(i+1,j-w[i])+v[i]);
		}
		return res;
	}
}
