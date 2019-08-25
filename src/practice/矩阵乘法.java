package practice;
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class 矩阵乘法 {
	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		in.nextToken();
		int n=(int)in.nval;
		long [] a= new long[n+2];
		long dp[][] = new long[n+2][n+2];
		for(int i=1;i<=n+1;i++){
			in.nextToken();
			a[i]=(int)in.nval;
		}

		for(int i=2;i<=n+1;i++){
			for(int j=1;j<=n+1-i;j++){
				dp[j][j+i]=Long.MAX_VALUE;
				for(int k=0;k<i-1;k++){
					long temp=a[j]*a[j+1+k]*a[j+i]+dp[j][j+1+k]+dp[j+1+k][j+i];
					dp[j][j+i]=Math.min(dp[j][j+i],temp);
				}
			}
		}
		
		System.out.println(dp[1][n+1]);
	}//main
}*/

import java.util.Scanner;
public class 矩阵乘法 {
	public static void main(String[] args) {  
        Scanner in = new Scanner(System.in);  
        int n = in.nextInt();  
        int a[] = new int[1010];  
        for (int i = 0; i < n + 1; i++) {  
            a[i] =in.nextInt();  
        }  
        if (n == 1)  
            System.out.println(a[0] * a[1]);  
        long dp[][] = new long[1010][1010];  
        long sum;  
        for (int i = 0; i <= n; i++)  
            for (int j = 0; j <= n; j++)  
                dp[i][j] = 1000000000;  //初始化数组
        
        for (int j = 2; j <= n; j++) {  //依次计算n个矩阵相乘的最小结果，即dp[1][n]
            for (int i = j - 1; i > 0; i--) {  
                dp[i][i] = dp[j][j] = 0;  //对角线那儿开始计数，做初始化操作
                for (int k = i; k < j; k++) {  //此层循环，用于找到dp[i][j]的最小值
                    sum = dp[i][k] + dp[k + 1][j] + a[i - 1] * a[k] * a[j];  
                    if (sum < dp[i][j])  
                        dp[i][j] = sum;  
                }  
            }  
        }  
        System.out.println(dp[1][n]);  
    }  
}