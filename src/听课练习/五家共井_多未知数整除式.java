package ������ϰ;

public class ��ҹ���_��δ֪������ʽ {
	public static void main(String[] args) {
		int len[]=new int[6];
		for(len[5]=4;len[5]<1000;len[5]+=4){	//��δ֪��len[5]��4��ʼ������4�ı���
			for(len[4]=3;len[4]<1000;len[4]+=3){	//��δ֪��len[4]��3��ʼ������3�ı���
				len[3]=len[4]+len[5]/4;	//����֪�ı�ʾδ֪��
				//���ڲ�֪��len[3]�����Ƿ���3�ı������������ڲ���������ʾlen[1]��
				if(len[3]%2!=0) continue;
				len[2]=len[3]+len[4]/3;	//����֪�ı�ʾδ֪��
				len[1]=len[2]+len[3]/2;
				if(len[1]%5!=0) continue;
				if(len[4]==len[5]+len[1]/5){
					len[0]=len[1]*2+len[2];
					System.out.println("len1="+len[1]+" len2="+len[2]+" len3="+len[3]+" len4="+len[4]+" len5="+len[5]);
					System.out.println(len[0]);
//					return;
				}
			}
		}
	}
}
