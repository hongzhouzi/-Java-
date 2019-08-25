package 挑战程序设计竞赛题目;

import java.util.Arrays;

/*
 * 抽 签
你的朋友提议玩一个游戏：将写有数字的n 个纸片放入口袋中，你可以从口袋中抽取4 次纸
片，每次记下纸片上的数字后都将其放回口袋中。如果这4 个数字的和是m，就是你赢，否
则就是你的朋友赢。你挑战了好几回，结果一次也没赢过，于是怒而撕破口袋，取出所有纸
片，检查自己是否真的有赢的可能性。请你编写一个程序，判断当纸片上所写的数字是k1,
k2, …, kn 时，是否存在抽取4 次和为m 的方案。如果存在，输出Yes；否则，输出No。
限制条件
 1 ≤ n ≤ 1000
 1 ≤ m ≤ 108
 1 ≤ ki ≤ 108
输入
n = 3
m = 10
k = {1, 3, 5}
输出
Yes（例如4次抽取的结果是1、1、3、5，和就是10）
 * 
 * 思路：。
 * 写成四个循环，最内侧关于d的循环所做的事就是检查是否有d使得ka+kb+kc+kd=m
 * 检查是否有c和d使得kc+kd=m-ka-kb。
 * 快速的检查方法。这里要介绍的是名为二分搜索的算法。
 * 预先枚举出kc+kd所得的n2个数字并排好序，便可以利用二分搜索了
 * 排序O(n2logn)时间
 循环O(n2logn)时间
总的也是O(n2logn)时间
 * */
public class 抽签 {
	static int n=3,m=10;		//3个卡片，和为10
	static int[]k={1,3,5};		//各张卡片各个数
	static int[]kk=new int[n*n];		// 保存2个数的和的数列
	//二分法搜索
	static boolean binary_search(int x){
		int head=0,rear=n*n;	//二分搜索的头和尾
		while(rear>head){
			int i=(head+rear)/2;
			if(kk[i]==x) return true;	//查找到了，返回true
			else if(x>kk[i]){
				head=i+1;	//从i+1处开始下一次搜索了，因为i处与x已经做过比较了
			}else if(x<kk[i]){
				rear=i-1;	//从i-1处开始下一次搜索了，因为i处与x已经做过比较了
			}
		}
		return false;	//循环完成都没查找到，那么就查找不到了，返回false
	}
	// 枚举k[c]+k[d]的和
	static void enum_sum(){
		for(int c=0;c<n;c++){
			for(int d=0;d<n;d++){
				kk[c*n+d]=k[c]+k[d];	//注意这儿的写法	
			}
		}
	}
	public static void main(String[] args) {
		/*// 排序以便进行二分搜索
		enum_sum();			//枚举k[c]+k[d]的和
		Arrays.sort(kk);	//对该数组排序
		boolean f=false;
		for(int a=0;a<n;a++){
			for(int b=0;b<n;b++){
				if(binary_search(m - k[a] - k[b])){
					f=true;
				}
			}
		}
		if(f)
			System.out.println("YES");
		else
			System.out.println("NO");*/
		
		enum_sum();			//枚举k[c]+k[d]的和
		Arrays.sort(kk);	//对该数组排序
		boolean f=false;
		for(int a=0;a<n;a++){
			for(int b=0;b<n;b++){
				if(0<Arrays.binarySearch(kk, (m - k[a] - k[b]))){
					f=true;
				}
			}
		}
		if(f)
			System.out.println("YES");
		else
			System.out.println("NO");
		
	}

}
