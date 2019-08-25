package leetCode;

public class PalindromeNumber {
	public static void main(String[] args) {
		System.out.println(judge(100));
	}
	static boolean judge(int x){
		if(x==0) return true;
		else if(x<0 || x%10==0) return false;	//��Ϊ��0��β��ȡģ����0����Ҫ��������
		else{
			int revertedNum=0;
			while(x > revertedNum){
				revertedNum = revertedNum * 10 +x%10;
				x/=10;
			}
			return x==revertedNum || x==revertedNum/10;	//�ֱ��Ӧż��λ������λ
		}
	}
}
