package review;

public class �ݹ���n��Ԫ�ص�ȫ�� {
	static void f(char a[],int k){
		if(k==a.length){
			for(int i=0;i<a.length;i++){
				System.out.print(a[i]+" ");
			}
			System.out.println();
			count++;
		}
		for(int i=k;i<a.length;i++){
			{						//��̽
				char temp=a[k];
				a[k]=a[i];
				a[i]=temp;		//ÿ����Ҫ������Ԫ�ؽ���
			}
			f(a,k+1);	//�ѽ���������ݽ�������Ĵ���
			{						//����
				char temp=a[k];
				a[k]=a[i];
				a[i]=temp;		//ÿ����Ҫ������Ԫ�ؽ���
			}
			
		}
	}
	static int count=0;
	public static void main(String[] args) {
		char []a="ABC".toCharArray();
		f(a,0);
		System.out.println(count);
	}
}
