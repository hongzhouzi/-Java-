package �����㷨_ѧϰ�ʼ�;
/*
 1��9֮���������ÿ����ֻ��һ����ƴ��һ����ʽ���磺124+659=783    659+124=783
 * */
public class ������� {
	static int []a=new int[10];
	static int []book=new int[10];
	static int total=0;		//��¼���н⣬ע��124+659=783    659+124=783��һ�����н⣬���ۼӺ���Ҫ��2
	static void dfs(int step){
		
		if(step==10){
			if(a[1]*100+a[2]*10+a[3]+a[4]*100+a[5]*10+a[6]==a[7]*100+a[8]*10+a[9]){
				total++;		//����Ҫ����ô���н�+1
				System.out.printf("%d%d%d+%d%d%d=%d%d%d\n",a[1],a[2],a[3],a[4],a[5],a[6],a[7],a[8],a[9]);
			}
			return;		//���ص�֮ǰ��һ�������һ�ε���dfs�ĵط���
		}
		
		for(int i=1;i<=9;i++){
			if(book[i]==0){		//i�������û���þͳ��Ը�����������˾����³���
				a[step]=i;	//���Թ���
				book[i]=1;	//��ǣ���book[i]��ֵ��Ϊ1��ʾi���Ѿ�����
				dfs(step+1);	//��ǰ�ⲽ���˺������һ��
				book[i]=0;	//����֮��Ҫ��ԭ�����״̬
			}
		}
		
		return;		//����һ��
	}
	public static void main(String[] args) {
		dfs(1);
		System.out.println(total/2);
	}
}