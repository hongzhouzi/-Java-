package 听课练习;

import java.util.Scanner;

public class 递归计算漏掉的金额组合 {
	
	public static int sumMoney,sumNum,NumMoney[]={5,2,3,2,5};
	public static boolean a[]={false,false,false,false,false};
	public static void f(int cur_sum,int cur,boolean [] a){
		
		/*出口，当错误的和与所试探到的当前和相对时就可输出结果
		 * */
		if(sumMoney==cur_sum&&cur==sumNum){	//必须要让它全部都试探一遍才可以
			for(int i=0;i<cur;i++){
				if(a[i]==false){
					System.out.print("所在位置："+i+"");
					System.out.print(" 数："+NumMoney[i]+"@@     ");
				}
			}
			System.out.println();
		}
		if(cur>=sumNum) return;	//注意条件
		if(cur_sum>sumMoney) return;
		
		/*
		 * 分析：知道错误的账单和和总的账单明细，那么要对每个账单明细都进行试探，则可以对每笔帐是否取做标记
		 * */
		{
			a[cur] =false;		//不选择当前这项
			f(cur_sum,cur+1,a); //递归进行试探
			a[cur]=true;		//回溯，但下面又是a[cur]=true;所以此处的可以省略
		}
		{
			a[cur]=true;				//选择当前这项
			cur_sum +=NumMoney[cur];	//把该项加入总和再向下试探
			f(cur_sum,cur+1,a);			//递归进行试探
			a[cur]=false;				//回溯
		}
	}
	
	public static void main(String[] args) {
		/*Scanner in=new Scanner(System.in);
		sumMoney=in.nextInt();	//输入总金额数
		sumNum=in.nextInt();	//输入账单总条数
		NumMoney=new int[10];	//声明各条账单的数组
		a=new boolean[10];
		for(int i=0;i<sumNum;i++){	//输入账单各个条数
			NumMoney[i]=in.nextInt();
		}*/
		sumMoney=10;
		sumNum=5;
		f(0,0,a);
	}
}
