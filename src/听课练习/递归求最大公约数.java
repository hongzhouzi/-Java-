package ������ϰ;

import java.math.BigDecimal;
import java.math.MathContext;
public class �ݹ������Լ�� {
	
	
	public static int f(int a,int b){
		if(a<0) return -a;	//���и����Ǿ�ȡ�����෴��
		if(b<0) return -b;
		if(b==0) return a;	//����ʱ
		
		/*շת�����
		 * 
		 * */
		return f(b,a%b);
	}
	
	public static void main(String[] args) {
		System.out.println(f(-1,2));
		
		double a=1.0/0;		//���������
		double b=0.0/0.0;	//NaN Not a Number
		//����������������֮��������õ�����NaN
		
		//���⾫��С����MathContext(10)�е���ֵ�Ǿ�ȷ��λ��
		BigDecimal c=BigDecimal.valueOf(1).divide(BigDecimal.valueOf(6),new MathContext(10));
		System.out.println(c);
	}
}
