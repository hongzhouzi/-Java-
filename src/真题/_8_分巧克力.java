package ����;

import java.util.Scanner;
/*�ڲ�֪���ֳ����ֱȽϺ���ʱ���ʹӴ�Ŀ�ʼ���ַ���С�������жϷֳ�������������ĿҪ��ģ�
 �ڼ��ʱ����ֱ���ÿ�͸߳�����Ҫ�������ݣ��ٿ��Ƿ������Ǹ���С*/
public class _8_���ɿ��� {
	static int n;  
    static int k;  
    static int h[] = new int [100010];  
    static int w[] = new int [100010];    
    public static boolean solve(int n)    //���ַ���ֹ��̣���Ҫһ����¼��¼���ϵĽ���������Ϳ�ʼ�����k�Ƚ�
    {    
        int res=0,a,b,i;    
        for(i=0;i<n;i++)    
        {    
            a=h[i]/n;    
            b=w[i]/n;    
            res+=a*b;    
        }    
        if(res>=k)    
            return true;    
        return false;    
    }    
  
    public static void main(String[] args) {  
         int i,low,high;    
         Scanner sc = new Scanner(System.in);  
         n = sc.nextInt();  
         k = sc.nextInt();  
                
        low=1;    
        high=10000;    //�ö��ַ��𿪿�
        for(i=0;i<n;i++) {   
            h[i] = sc.nextInt();   
            w[i] = sc.nextInt();  
        }  
        while(low<high-1)    
        {    
            int mid=(low+high)/2;    
            if(!solve(mid))    
                high=mid;    
            else    
                low=mid;    
        }    
        System.out.println(low);    
    }  
}
/*��ͯ��������KλС���ѵ�С�������͡�С���ó�����ص��ɿ����д�С�����ǡ�
    С��һ����N���ɿ��������е�i����Hi x Wi�ķ�����ɵĳ����Ρ�

    Ϊ�˹�ƽ�����С����Ҫ���� N ���ɿ������г�K���ɿ����ָ�С�����ǡ��г����ɿ�����Ҫ���㣺

    1. ��״�������Σ��߳�������  
    2. ��С��ͬ  

����һ��6x5���ɿ��������г�6��2x2���ɿ�������2��3x3���ɿ�����

��ȻС�����Ƕ�ϣ���õ����ɿ��������ܴ����ܰ�СHi��������ı߳��Ƕ���ô��

����
��һ�а�����������N��K��(1 <= N, K <= 100000)  
����N��ÿ�а�����������Hi��Wi��(1 <= Hi, Wi <= 100000)
���뱣֤ÿλС���������ܻ��һ��1x1���ɿ�����   

���
����г����������ɿ��������ܵı߳���

�������룺
2 10  
6 5  
5 6  
���������
2
*/