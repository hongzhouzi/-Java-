package 听课练习;

public class 递归求n个元素的全排 {
	
	public static int count=0;
	//data是需要全排列的数组，k是数组中全排列的关注点，让k和后面的位置交换顺序
	public static void f(char[]data,int k){
		
		if(k==data.length){								//递归出口
			for(int i=0;i<data.length;i++){
				System.out.print(data[i]);
			}
			count++;
			System.out.println();
		}
		
		for(int i=k;i<data.length;i++){
			{char t=data[k]; data[k]=data[i];data[i]=t;}//试探
			f(data,k+1);								//递归
			{char t=data[k]; data[k]=data[i];data[i]=t;}//回溯
		}
	}
	
	public static void main(String[] args) {
		char[] data="ABCD".toCharArray();
		f(data,0);
		System.out.println(count);
	}
}
