package 听课练习;

public class 用递归对数字进行加法划分 {
	
	//n是进行划分的那个数，a[]是存储划分后的一些数据，k是存入数组中的个数
	public static void f(int n,int []a,int k){
		
		if(n<=0){			//递归出口，当分解的数<=0时不符合条件了，此时就到出口了，就该对分解时放在数组中的数输出了
			for(int i=0;i<k;i++){
				if(i<k-1)
					System.out.print(a[i]+"+");
				else
					System.out.print(a[i]);
			}
			System.out.println();
		}
		
		/*分析：要进行划分，且顺序是划分的数之差逐渐减小，划分好的前面的数与后面的数都是>=关系。
		 * 在划分过程中那些数值都在不断的减小，数字也越来越多，且每次划分的数都不是确定的，所以要用一个数组来存储那些划分的数值
		 * 用递归的过程有数组涉足，一般还需要一个标记变量
		 * 在划分过程中会有多次划分，而且划分次数还不是确定的，所以还要考虑到用循环
		 * */
		
		int i=n;
		while(i>0){
			if(k>0 && i>a[k-1])		{
				i--;
				continue;//划分的一些条件
			}
			else{
				a[k]=i;	//存储分解后符合条件的数
				f(n-i,a,k+1);	
				i--;
			}
		}
		/*
		for(int i=n;i>0;i--){
			if(k>0 && i>a[k-1]) continue;	//要满足后面的数都要比前面的数小，k>0是为了防止输入有误的漏洞
			a[k]=i;		//把符合条件的那个数存入数组中
			f(n-i,a,k+1);	////递归，继续分解。进行加法划分，写成n-i做差的形式。看到n-i应该考虑出口了，只有正数才符合条件
		}
		*/
	}
	public static void main(String[] args) {
		int a[]=new int[10];
		f(6,a,0);
	}
}
