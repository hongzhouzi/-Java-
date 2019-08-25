package ������ϰ;

import java.math.BigInteger;
/*һ��21λ�������ĸ���λ����21�η�֮�͵������21λ�������ҳ����21λ����
 * ˼·��һ��21λ�������Ĵ���ֵ�����ܿ���ֱ�ӱ����ƽ⣬��ô���ǾͿɴ����ĸ���λ���֣�
 * ����һ��������Щ������ɣ���Щ���ֵ�21�η���������Щ���ֵ�λ�����޹صģ���ô���ǾͿ��Գ������Ǹ�21λ����0-9����Щ������ɣ���Щ���ָ��ж���
 * �����������ǿ����ȴ���Щ���ָ��ж������֣�Ȼ��ȥ��̽������ж��Ƿ����
 * �ڸù����л��漰������õ�0-9��21�η��������ǿ����Ȱ�������������Ķ�����ȥ��̽������Ͽ��ܻ����㣬���õݹ飬����ж�
 * �жϹ��̣��ɸ���λ���͸������ֵĸ������жϡ�
 * */
public class ������ {
	private static BigInteger[] base=new BigInteger[10]; //���δ�0-9��21�η���ֵ
	
	//��������������ֵ�21�η������ؼ����Ľ��
	private static BigInteger calcu_21(int n) {
		BigInteger a=BigInteger.ONE;	//??��a��ʼ��Ϊ1
		for(int i=0;i<21;i++)
			a=a.multiply(BigInteger.valueOf(n));
		return a;
	}
	
	//a�����¼ĳЩ�����ֹ����ٴΣ���a������׼�������k����k�±���0-9�е����֣������д��ֵ�Ǹ����ֳ��ֵĴ�������ʱ��ʣsum������
	
	private static void f(int[]a,int k,int sum){
		if(sum==0){	//�ݹ���ڣ� ��21λ��ʱ�͸�ȥ���Ը����Ƿ��
			text(a);
			return;
		}
		if(k==a.length-1){	//���ʣһ��ʱ����Ҫ��sumȫ�������a[k] 
			a[k]=sum;
			//f(a,k+1,0);
			
			text(a); 
			return;
		}
		for(int i=0;i<=sum;i++){	//������̽�Ĺ���
			a[k]=i;
			f(a,k+1,sum-i);		//��ѭ������̽
			a[k]=0;				//����
		}
	}
	
	//�������Ƿ��������
	private static void text(int[]a){	
		BigInteger bi=BigInteger.ZERO;	//?���Ѹ�����ʼ��Ϊ0
		
		for(int i=0;i<a.length;i++){	//�Ǹ�����21�η�*�Ǹ������ֵĴ���
			bi=bi.add(base[i].multiply(BigInteger.valueOf(a[i])));	
			//ѭ��������bi=��Щ���ֵ�21�η�֮�ͣ���Ψһ�ģ���������ж��Ƿ����ֱ�ӿ����Ⱥ͸������ֳ��ִ���������
		}
		String s=bi.toString();
		if(s.length()!=21) return;	//�������21λ�����򲻷���������ֱ�ӷ���
		
		int[] b=new int[10];	//�Ը���Ϊ�±꣬��������ֵĴ���
		for(int i=0;i<s.length();i++){
			b[s.charAt(i)-'0']++;
		}
		for(int i=0;i<10;i++){	//�����������ԭʼ�����ֳ��ִ�������ȣ��򲻷���������ֱ�ӷ���
			if(a[i]!=b[i]) return;
		}
		System.out.println(bi);
	}
	
	public static void main(String[] args) {
		
		for(int i=0;i<base.length;i++)	//��ʼ��base
			base[i]=calcu_21(i);
		
		int []a=new int[10];	//��¼0-9��ÿ�����ֳ��ּ��Σ���Ϊ�������ܺ�ֻ��ÿ�����ֳ��ֵĴ����йأ������ǵĴ���û��
		f(a,0,21);		//��a��0��21λ������̽
	}
}
