package review;

//n��������ȡm�������Żأ������ж�����ȡ��
public class �ݹ�ȡ�� {
	//����m���������������򣬰�����Ϊȡ������Ͳ�ȡ�����������֣�ȡ��m�����ͽ����ݹ�
	static int f(int n,int m){
		if(m==0||n==0) return 1;
		if(n<m) return 0;		//���������ȡ�򣬷�ֹ��������
		if(n==m) return 1;		//��m��n���ʱ��ֻ��һ��ȡ�����
		
		return f(n-1,m-1)+f(n-1,m);		//ÿ�ζ�ȡ�򣬷ֲ�ȡ�������ȡ������
	}
	public static void main(String[] args) {
		System.out.println(f(10,3));
	}
}
