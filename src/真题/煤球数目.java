package 真题;

public class 煤球数目 {
	public static void main(String[] args) {
//		int a[]=new int [150];
//		a[1]=1;
//		int sum=a[1];
//		for(int i=2;i<=100;i++){
//			a[i]=a[i-1]+i;
//			sum+=a[i];
//		}
//		System.out.println(a[3]);
//		System.out.println(a[4]);
//		System.out.println(a[100]);
//		System.out.println(sum);4
		
//		好的解法，用那个数的通项来解，但我看不出来这个的通项
		int ans = 0;  
        for(int i = 1; i <= 100; ++i)  
            ans += (1+i)*i/2;  
        System.out.println(ans); 
	}
}
/*有一堆煤球，堆成三角棱锥形。具体：
第一层放1个，
第二层3个（排列成三角形），
第三层6个（排列成三角形），
第四层10个（排列成三角形），
....
如果一共有100层，共有多少个煤球？
请填表示煤球总数目的数字。
注意：你提交的应该是一个整数，不要填写任何多余的内容或说明性文字。
*/