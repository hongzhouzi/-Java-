package review;

public class _8_ֽ�������� {
	static int box[]=new int[10]; 
	static boolean mark[]=new boolean[10]; 
	static int sum=0;
	static void f(int n){
		if(n==10){
			if(box[1]+box[2]+box[4]+box[6]==box[1]+box[3]+box[5]+box[9]&&box[6]+box[7]+box[8]+box[9]==box[1]+box[3]+box[5]+box[9]){
				sum++;
				return;
			}
		}
		for(int i=1;i<10;i++){	//�����ƽ�ʱ���г�[1,9]֮�以����ͬ����
			if(!mark[i]){	//mark������i�±������ȡ��ȡ��ȡ�˾ͱ��Ϊtrue
				mark[i]=true;
				box[n]=i;	//�ѵ�ǰ�����װ��������
				f(n+1);		//���¼�����
				mark[i]=false;	//����
			}
		}
	}
	public static void main(String[] args) {
		f(1);
		System.out.println(sum/2/3);
	}
}
