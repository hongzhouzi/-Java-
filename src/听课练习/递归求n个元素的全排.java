package ������ϰ;

public class �ݹ���n��Ԫ�ص�ȫ�� {
	
	public static int count=0;
	//data����Ҫȫ���е����飬k��������ȫ���еĹ�ע�㣬��k�ͺ����λ�ý���˳��
	public static void f(char[]data,int k){
		
		if(k==data.length){								//�ݹ����
			for(int i=0;i<data.length;i++){
				System.out.print(data[i]);
			}
			count++;
			System.out.println();
		}
		
		for(int i=k;i<data.length;i++){
			{char t=data[k]; data[k]=data[i];data[i]=t;}//��̽
			f(data,k+1);								//�ݹ�
			{char t=data[k]; data[k]=data[i];data[i]=t;}//����
		}
	}
	
	public static void main(String[] args) {
		char[] data="ABCD".toCharArray();
		f(data,0);
		System.out.println(count);
	}
}
