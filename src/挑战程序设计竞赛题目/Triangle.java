package ��ս������ƾ�����Ŀ;
/*
 * ��n �����ӣ�����i �ĳ���Ϊai����Ҫ����ѡ��3 ����������ܳ������ܳ��������Ρ�����������ܳ������޷���������������0��
 * ���������� 3 �� n �� 100  1 �� ai �� 106
	���룺n = 5��a = {2, 3, 4, 5, 10}
	�����12��ѡ��3��4��5ʱ��
 * */
public class Triangle {
	public static void main(String[] args) {
		int n=5,max=0;
		int[]a={2, 3, 4, 5, 10};	//�趨һ�����飬����ʼ��
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				for(int k=j+1;k<n;k++){
					int len=a[i]+a[j]+a[k];
					int max_side=Math.max(a[i], Math.max(a[j], a[k]));	//ȡ�������������Ǹ���
					int other_side=len-max_side;	//��������=����֮�ͼ�ȥ������һ��
					if(max_side<other_side)
						max=Math.max(max, len);		// ������������Σ�������Ը��´������
				}
			}
		}
		System.out.println(max);
	}
}
