package 真题;

public class Main3 {
	static void f(int n){
		if(n==10){
			/*只用到了box[0]到box[7]的数据，所以打印结果时会出现两行数据，符合要求的数据中box[8]和box[9]的数据可以互换
			 eg：9 5 6 7 1 0 8 2 [3] [4] 和 9 5 6 7 1 0 8 2 [4] [3]
			 在输出数值时，若其中还含有字符串，那字符串后面的数字会被当成字符串处理。
			 如果含有字符和数字那么会将字符的ascll码转成数字和出现的数字相加。
			*/
			if(box[0]!=0&&box[4]!=0&&box[0]*1000+box[1]*100+box[2]*10+box[3]+box[4]*1000+box[5]*100+box[6]*10+box[1]==box[4]*10000+box[5]*1000+box[2]*100+box[1]*10+box[7]){
					System.out.println(box[0]*1000+box[1]*100+box[2]*10+box[3]+"+"+box[4]*1000+box[5]*100+box[6]*10+box[1]+"="+box[4]*10000+box[5]*1000+box[2]*100+box[1]*10+box[7]);
					System.out.println(box[0]*1000+box[1]*100+box[2]*10+box[3]);
					System.out.println(box[4]*1000+box[5]*100+box[6]*10+box[1]);
					System.out.println(box[4]*10000+box[5]*1000+box[2]*100+box[1]*10+box[7]);
					System.out.println('a'+box[4]+box[5]+box[6]+box[1]);
					System.out.println(box[4]+box[5]+box[6]+box[1]);
					System.out.println("+"+box[4]*1000+box[5]*100+box[6]*10+box[1]);
					
			}
			return;
		}
		for(int i=0;i<10;i++){
			if(!mark[i]){
				mark[i]=true;
				box[n]=i;
				f(n+1);		//注意注意注意！！！！！！！！！！！！！！！！！！！！！！1
				mark[i]=false;
			}
		}
	}
	static int box[]=new int[10];
	static boolean mark[]=new boolean[10];
	public static void main(String[] args) {
			f(0);
	}
}
