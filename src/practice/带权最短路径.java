package practice;

import java.util.Scanner;

public class ��Ȩ���·�� {
	public static void main(String[] args) {
		final int inf=9999;
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int m=in.nextInt();//�����
		int a[][]=new int[n+1][n+1];
		
		for(int i=1;i<=n;i++){	//��ʼ������
			for(int j=1;j<=n;j++){
				if(i==j) a[i][j]=0;
				else a[i][j]=inf;
			}
		}
		
		for(int i=1;i<=m;i++){	//����ߵ�����
			int x=in.nextInt();
			int y=in.nextInt();
			int z=in.nextInt();
			a[x][y]=z;
		}
		
		for(int k=1;k<=n;k++){	//��Ҫ�㷨��������������㣬��ÿ�����㶼��Ϊ��������������һ��
			for(int i=1;i<=n;i++){
				for(int j=1;j<=n;j++){
					if(a[i][j]>a[i][k]+a[k][j])
						a[i][j]=a[i][k]+a[k][j];
				}
			}
		}
		for(int i=1;i<=n;i++){	//�������
			for(int j=1;j<=n;j++)
				System.out.print(a[i][j]+"  ");
			System.out.println();
		}
	}
}
/*
 ���룺
 4 8
1 2 2
1 3 6
1 4 4
2 3 3
3 1 7
3 4 1
4 1 5
4 3 12
 * */
