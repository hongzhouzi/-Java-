package ����;
public class _8_ȡ��λ  {  
    static int len(int x){  
    	int n=0;
        while(x>0){
        	x/=10;
        	n++;
        }
        return n;
    }  
  
    // ȡx�ĵ�kλ����  
    static int f(int x, int k){  
        if(len(x)-k==0) return x%10;  
        return f(x/10,k);  //���  
    }  
  
    public static void main(String[] args)  
    {  
        int x = 23513;  
        //System.out.println(len(x));  
        System.out.println(f(x,2));  
    }  
}  
/*���⣺ȡ��λ
��1�������ĵ�kλ�����кܶ��ַ�����
���µķ�������һ�֡�

������Ŀ�еĲ������ݣ�Ӧ�ô�ӡ5��

����ϸ����Դ�룬�����仮�߲�����ȱ�ٵĴ��롣

ע�⣺ֻ�ύȱʧ�Ĵ��룬��Ҫ��д�κ��������ݻ�˵���Ե����֡��� */
