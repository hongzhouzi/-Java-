package ��ս������ƾ�����Ŀ;

public class �����������_DFS {
	static int n=4;
	static int a[]={5,6,7,8};
	static int b=12;
	static boolean dfs(int i,int sum){
		if(n==i) return b==sum;				//����֮һ�������е����������
		if(dfs(i+1,sum+a[i])) return true;	//���ϵ�ǰ�����
		if(dfs(i+1,sum)) return true;		//���ӵ�ǰ�����
		return false;
	}
	public static void main(String[] args) {
		if(dfs(0,0)) System.out.println("YES");
		else System.out.println("NO");
	}
}
