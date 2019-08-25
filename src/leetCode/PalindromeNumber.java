package leetCode;

public class PalindromeNumber {
	public static void main(String[] args) {
		System.out.println(judge(100));
	}
	static boolean judge(int x){
		if(x==0) return true;
		else if(x<0 || x%10==0) return false;	//因为以0结尾的取模后还是0，需要单独计算
		else{
			int revertedNum=0;
			while(x > revertedNum){
				revertedNum = revertedNum * 10 +x%10;
				x/=10;
			}
			return x==revertedNum || x==revertedNum/10;	//分别对应偶数位和奇数位
		}
	}
}
