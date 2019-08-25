package 听课练习;

public class 不定方程之最大不能买到的糖果数 {
	
	/*分析该题，应该使用不定方程来解决，但难点在于后面的那个值是不确定的。比如：4x+7y=?
	 * 另外就是注意那个最大不能买到的数，在能买到的数值中，若连续了且连续的数值能够=二元一次方程中最小的那个元的参数。那么之后的数都能买到
	 * 理解：在那之后的值可以和向前间隔二元一次方程中最小的那个元的参数之间关联。之前那个数都能买到，那么再加上元一次方程中最小的那个元的参数也就可以买到后面的了
	 * 
	 * 
	 * eg：
	 * */
	/*public static int a=4,b=7,count=0;
	public static void  f(int x,int y,int cur) {//错了，因为在递归过程，x和y取值影响cur基本不会遇到连续的，所以不能用该方法
		if(count==a){		//如果连续的数值等于二元一次方程中最小的那个元的参数，就结束，该值是当前的值减去二元一次方程中最小的那个元的参数
			System.out.println(cur-a);
			return;
		}
		if(cur>1000) return;
		if(cur==a*x+b*y-1){	//如果当前的数比下一个数小1，就让count计数，若不是就把count清零，因为要连续的
			count++;
		}
		else{
			count=0;
		}
		f(x+1,y,a*(x+1)+b*y);
		f(x,y+1,a*x+b*(y+1));
	}*/
	
	static final int N=1000;		//盒子数组的长度
	static int box[]=new int[N];	//创建盒子数组
	static void f(int a,int b){
		if(a==1||b==1){
			System.out.println("此数据都能买到");
			return;
		}
		if(a<=0||b<=0){
			System.out.println("数据不能小于等于0");
			return;
		}
		for(int i=0;i<=N/a;i++){	//注意这儿i与j的取值范围
			for(int j=0;j<=(N-i*a)/b;j++){
				if(i*a+b*j<N)		//需要判断一下再操作数组
					box[i*a+j*b]=1;
			}
		}
		int count=0;	//对盒子中的数是否连续进行计数，当盒子里的数为1就累加，不为1就清零
		for(int i=0;i<N;i++){
			if(box[i]==1)	//为1，累加
				count++;
			else			//不为1，清零
				count=0;
			if(count==(a<b?a:b)){	//当计数到与a、b之间较小是哪个数相等时就是出口了
				System.out.println(i-(a<b?a:b));	//该值是当前哪个值再减a、b之间较小数
				return;	//结束程序
			}
		}
	}
	
	public static void main(String[] args) {
		f(3,7);
	}
}
