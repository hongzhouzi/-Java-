package ����;

public class ú����Ŀ {
	public static void main(String[] args) {
//		int a[]=new int [150];
//		a[1]=1;
//		int sum=a[1];
//		for(int i=2;i<=100;i++){
//			a[i]=a[i-1]+i;
//			sum+=a[i];
//		}
//		System.out.println(a[3]);
//		System.out.println(a[4]);
//		System.out.println(a[100]);
//		System.out.println(sum);4
		
//		�õĽⷨ�����Ǹ�����ͨ�����⣬���ҿ������������ͨ��
		int ans = 0;  
        for(int i = 1; i <= 100; ++i)  
            ans += (1+i)*i/2;  
        System.out.println(ans); 
	}
}
/*��һ��ú�򣬶ѳ�������׶�Ρ����壺
��һ���1����
�ڶ���3�������г������Σ���
������6�������г������Σ���
���Ĳ�10�������г������Σ���
....
���һ����100�㣬���ж��ٸ�ú��
�����ʾú������Ŀ�����֡�
ע�⣺���ύ��Ӧ����һ����������Ҫ��д�κζ�������ݻ�˵�������֡�
*/