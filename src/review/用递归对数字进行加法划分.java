package review;

public class �õݹ�����ֽ��мӷ����� {
	static void f(int a[],int n,int k){
		
		int i=n;
		if(n<=0) {
			for(int j=0;j<k;j++){
				System.out.print(a[j]+" ");
			}
			System.out.println();
		}
		
		while(i>0){		//��ֵĹؼ�
			if(k>0&&i>a[k-1]){		//�޶�k>0�Ƿ�ֹa[k-1]Խ�磬ע�������ȡk-1����ǰ�±��ǰһ����
				i--;
				continue;
			}
			else{		//�ѷ���Ҫ�������ӵ������У���������̽
				a[k]=i;
				f(a,n-i,k+1);
				i--;
			}
				
		}
	}
	
	public static void main(String[] args) {
		int a[]=new int[10];
		f(a,6,0);
	}
}
