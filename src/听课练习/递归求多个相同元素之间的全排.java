package 听课练习;

public class 递归求多个相同元素之间的全排 {
	
	//若有m个A和n个B，求A和B之间的全排列
	public static int f(int m,int n){
		if(m==0||n==0) return 1;	//当m或者n为0时，此时就只有一种类型的，则只有一种排列方式
		/*取一个m拿去排列。+  取一个n拿去全排列。
		 * 排列好后相当于那个位置就固定了，就不在考虑它的位置变动了，所以就有减一
		 * 当只有一种类型就只有一种排列方式了，就要考虑出口了
	     */
		return f(m-1,n)+f(m,n-1);	
		
	}
	
	//若有m个A、n个B、z个C，求A、B、C之间的全排列
	public static int f(int m,int n,int z){
		/*
		 * 当有一项为 0时就让另几项之间进行排列了
		 * */
		if(m!=0&&n!=0&&z==0) 
			return f(m-1,n)+f(m,n-1); 
		if(m!=0&&n==0&&z!=0) 
			return f(m-1,z)+f(m,z-1); 
		if(m==0&&n!=0&&z!=0) 
			return f(n-1,z)+f(n,z-1);
		/*
		 * 只有一种类型就只有一种排列方式了，就到递归的出口了
		 * */		
		if(m==0&&n==0&&z!=0) return 1;
		if(m==0&&n!=0&&z==0) return 1;
		if(m!=0&&n==0&&z==0) return 1;
		
		/*取一个A拿去排列。+  取一个B拿去全排列。+ 取一个C拿去全排列。
		 * 排列好后相当于那个位置就固定了，就不在考虑它的位置变动了，所以就有减一
		 * 当只有一种类型就只有一种排列方式了，就要考虑出口了
	     */
		return f(m-1,n,z)+f(m,n-1,z)+f(m,n,z-1);	
	}
	
	public static void main(String[] args) {
		System.out.println(f(3,2));
		System.out.println(f(3,2,1));
	}
}
