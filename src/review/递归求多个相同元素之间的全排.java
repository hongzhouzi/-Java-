package review;

//����m��A��n��B����A��B֮���ȫ����
//�뵽������ȫ����ʱ�����ֻ��һ��������ô��ֻ��һ�����з�ʽ��������õ��õݹ��˼��������β��

public class �ݹ�������ͬԪ��֮���ȫ�� {
	static int f(int m,int n){
		if(m==0||n==0) return 1;
		return f(m-1,n)+f(m,n-1);
	}
	static int f(int m,int n,int t){
		if(m==0&&n==0&&t!=0) return 1;
		if(m==0&&n!=0&&t==0) return 1;
		if(m!=0&&n==0&&t==0) return 1;
		
		if(m==0&&n!=0&&t!=0) return f(0,n-1,t)+f(0,n,t-1);
		if(m!=0&&n==0&&t!=0) return f(m-1,0,t)+f(m,0,t-1);
		if(m!=0&&n!=0&&t==0) return f(m-1,n,0)+f(m,n-1,0);
		
		return f(m-1,n,t)+f(m,n-1,t)+f(m,n,t-1);	
 	}
	public static void main(String[] args) {
		System.out.println(f(3,2));
		System.out.println(f(3,2,1));
	}
}
