package ��ս������ƾ�����Ŀ;

public class ����01 {
	static int n=4;
	static int w[]={2,1,3,2};
	static int v[]={3,2,4,2};
	public static void main(String[] args) {
		int W=5;
		System.out.println(rec(0,W));
	}
	static int rec(int i,int j){
		int res;
		if(i==n){	//û��ʣ����Ʒ
			res=0;
		}else if(j<w[i]){	//�޷���ѡ����Ʒ
			res=rec(i+1,j);
		}else{		//ѡ�벻ѡȡ���
			res=Math.max(rec(i+1,j),rec(i+1,j-w[i])+v[i]);
		}
		return res;
	}
}
