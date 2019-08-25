package practice;

import java.util.Scanner;

public class 带权最短路径 {
	public static void main(String[] args) {
		final int inf=9999;
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int m=in.nextInt();//读入边
		int a[][]=new int[n+1][n+1];
		
		for(int i=1;i<=n;i++){	//初始化矩阵
			for(int j=1;j<=n;j++){
				if(i==j) a[i][j]=0;
				else a[i][j]=inf;
			}
		}
		
		for(int i=1;i<=m;i++){	//存入边的数据
			int x=in.nextInt();
			int y=in.nextInt();
			int z=in.nextInt();
			a[x][y]=z;
		}
		
		for(int k=1;k<=n;k++){	//主要算法：引入第三个顶点，把每个顶点都作为第三个顶点引入一下
			for(int i=1;i<=n;i++){
				for(int j=1;j<=n;j++){
					if(a[i][j]>a[i][k]+a[k][j])
						a[i][j]=a[i][k]+a[k][j];
				}
			}
		}
		for(int i=1;i<=n;i++){	//输出数据
			for(int j=1;j<=n;j++)
				System.out.print(a[i][j]+"  ");
			System.out.println();
		}
	}
}
/*
 输入：
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
