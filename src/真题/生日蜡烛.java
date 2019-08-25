package 真题;

public class 生日蜡烛 {
	public static void main(String[] args) {
		int sum=0;
		for(int i=1;i<100;i++){		//用程序思想解决，该题用数学思想还会更加复杂
			for(int j=i;j<100;j++){
				sum+=j;
				if(sum==236){
					System.out.println(i);
					return;
				}
//				if(sum>236)		//一定一定要考虑到，当它大于这个数的时候会怎么样
//					break;
			}
			sum=0;	//把之前累加的sum清零
		}
		
	}
}
/*某君从某年开始每年都举办一次生日party，并且每次都要吹熄与年龄相同根数的蜡烛。

现在算起来，他一共吹熄了236根蜡烛。

请问，他从多少岁开始过生日party的？

请填写他开始过生日party的年龄数。
注意：你提交的应该是一个整数，不要填写任何多余的内容或说明性文字。*/