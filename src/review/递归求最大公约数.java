package review;

public class �ݹ������Լ�� {
	static int f(int a,int b){
		if(b==0) return a;
		if(a<0) return -a;
		if(b<0) return -b;
		return f(b,a%b);
	}
	public static void main(String[] args) {
		System.out.println(f(15,-3));;
	}
}
