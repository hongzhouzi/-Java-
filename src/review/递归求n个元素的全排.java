package review;

public class 递归求n个元素的全排 {
	static void f(char a[],int k){
		if(k==a.length){
			for(int i=0;i<a.length;i++){
				System.out.print(a[i]+" ");
			}
			System.out.println();
			count++;
		}
		for(int i=k;i<a.length;i++){
			{						//试探
				char temp=a[k];
				a[k]=a[i];
				a[i]=temp;		//每个都要与后面的元素交换
			}
			f(a,k+1);	//把交换后的数据交个后面的处理
			{						//回溯
				char temp=a[k];
				a[k]=a[i];
				a[i]=temp;		//每个都要与后面的元素交换
			}
			
		}
	}
	static int count=0;
	public static void main(String[] args) {
		char []a="ABC".toCharArray();
		f(a,0);
		System.out.println(count);
	}
}
