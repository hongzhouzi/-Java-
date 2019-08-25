package 挑战程序设计竞赛题目;
/*
 * 有n 根棍子，棍子i 的长度为ai。想要从中选出3 根棍子组成周长尽可能长的三角形。请输出最大的周长，若无法组成三角形则输出0。
 * 限制条件： 3 ≤ n ≤ 100  1 ≤ ai ≤ 106
	输入：n = 5，a = {2, 3, 4, 5, 10}
	输出：12（选择3、4、5时）
 * */
public class Triangle {
	public static void main(String[] args) {
		int n=5,max=0;
		int[]a={2, 3, 4, 5, 10};	//设定一个数组，并初始化
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				for(int k=j+1;k<n;k++){
					int len=a[i]+a[j]+a[k];
					int max_side=Math.max(a[i], Math.max(a[j], a[k]));	//取三个数中最大的那个数
					int other_side=len-max_side;	//其他两边=三边之和减去最大的那一边
					if(max_side<other_side)
						max=Math.max(max, len);		// 可以组成三角形，如果可以更新答案则更新
				}
			}
		}
		System.out.println(max);
	}
}
