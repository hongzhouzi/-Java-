package review;

public class 用递归对数字进行加法划分 {
	static void f(int a[],int n,int k){
		
		int i=n;
		if(n<=0) {
			for(int j=0;j<k;j++){
				System.out.print(a[j]+" ");
			}
			System.out.println();
		}
		
		while(i>0){		//拆分的关键
			if(k>0&&i>a[k-1]){		//限定k>0是防止a[k-1]越界，注意这儿是取k-1（当前下标的前一个）
				i--;
				continue;
			}
			else{		//把符合要求的数添加到数组中，再向下试探
				a[k]=i;
				f(a,n-i,k+1);
				i--;
			}
				
		}
	}
	
	public static void main(String[] args) {
		int a[]=new int[10];
		f(a,6,0);
	}
}
