package ����;

public class Main3 {
	static void f(int n){
		if(n==10){
			/*ֻ�õ���box[0]��box[7]�����ݣ����Դ�ӡ���ʱ������������ݣ�����Ҫ���������box[8]��box[9]�����ݿ��Ի���
			 eg��9 5 6 7 1 0 8 2 [3] [4] �� 9 5 6 7 1 0 8 2 [4] [3]
			 �������ֵʱ�������л������ַ��������ַ�����������ֻᱻ�����ַ�������
			 ��������ַ���������ô�Ὣ�ַ���ascll��ת�����ֺͳ��ֵ�������ӡ�
			*/
			if(box[0]!=0&&box[4]!=0&&box[0]*1000+box[1]*100+box[2]*10+box[3]+box[4]*1000+box[5]*100+box[6]*10+box[1]==box[4]*10000+box[5]*1000+box[2]*100+box[1]*10+box[7]){
					System.out.println(box[0]*1000+box[1]*100+box[2]*10+box[3]+"+"+box[4]*1000+box[5]*100+box[6]*10+box[1]+"="+box[4]*10000+box[5]*1000+box[2]*100+box[1]*10+box[7]);
					System.out.println(box[0]*1000+box[1]*100+box[2]*10+box[3]);
					System.out.println(box[4]*1000+box[5]*100+box[6]*10+box[1]);
					System.out.println(box[4]*10000+box[5]*1000+box[2]*100+box[1]*10+box[7]);
					System.out.println('a'+box[4]+box[5]+box[6]+box[1]);
					System.out.println(box[4]+box[5]+box[6]+box[1]);
					System.out.println("+"+box[4]*1000+box[5]*100+box[6]*10+box[1]);
					
			}
			return;
		}
		for(int i=0;i<10;i++){
			if(!mark[i]){
				mark[i]=true;
				box[n]=i;
				f(n+1);		//ע��ע��ע�⣡������������������������������������������1
				mark[i]=false;
			}
		}
	}
	static int box[]=new int[10];
	static boolean mark[]=new boolean[10];
	public static void main(String[] args) {
			f(0);
	}
}
