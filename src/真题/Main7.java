package ����;
//˼·��ѭ������ÿ��������ѡ���������ÿ������������ѡ4�ţ����ٿ���ѡ0�ż���ѡ��ÿ���������ﵽ13�������
public class Main7 {
	static int count=0;		//��������
	static void f(int type,int sum){	//type��ʾ����������sum��ʾȡ���Ƶ���Ŀ
		if(sum>13) return;
		if(type==13){
			if(sum==13) count++;
			return;
		}
		for(int i=0;i<=4;i++){	//i��ʾȡtype������ȡ�����ţ�0��ʾ��ȡ��4��ʾȡ4�ţ�ȫȡ��
			f(type+1,sum+i);	//�ӵ�һ�����Ϳ�ʼȡ����������
		}
	}
	public static void main(String[] args) {
		f(0,0);
//		    for(int a=0; a<=4; a++)  //�����ƽ�
//		        for(int b=0; b<=4; b++)  
//		            for(int c=0; c<=4; c++)  
//		                for(int d=0; d<=4; d++)  
//		                    for(int e=0; e<=4; e++)  
//		                        for(int f=0; f<=4; f++)  
//		                            for(int g=0; g<=4; g++)  
//		                                for(int h=0; h<=4; h++)  
//		                                    for(int i=0; i<=4; i++)  
//		                                        for(int j=0; j<=4; j++)  
//		                                            for(int k=0; k<=4; k++)  
//		                                                for(int l=0; l<=4; l++)  
//		                                                    for(int m=0; m<=4; m++){  
//		                                                        if(a+b+c+d+e+f+g+h+i+j+k+l+m==13)  
//		                                                            count++;  
//		                                                    }  
		    System.out.println(count);
	}
}
