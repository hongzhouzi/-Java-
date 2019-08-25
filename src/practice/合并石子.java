package practice;
import java.util.Scanner;
public class 合并石子 {
    public long getSum(long[] A, int a, int b) {
        long sum = 0;
        for(int i = a;i <= b;i++)
            sum += A[i];
        return sum;
    }
    public void printResult(long[] A) {
        if(A.length == 1) {
            System.out.println(A[0]);
            return;
        }
        long[][] dp = new long[A.length + 1][A.length + 1];
        for(int len = 2;len <= A.length;len++) {
            for(int i = 1, j = len;j <= A.length;i++,j++) {
                long min = Long.MAX_VALUE;
                for(int k = i;k < j;k++) {
                    if(min > dp[i][k] + dp[k + 1][j] + getSum(A, i - 1, j - 1))
                        min = dp[i][k] + dp[k + 1][j] + getSum(A, i - 1, j - 1);
                }
                dp[i][j] = min;
            }
        }
        System.out.println(dp[1][A.length]);
        return;
    }
    public static void main(String[] args) {
    	合并石子 test = new 合并石子();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n < 1 || n > 1000)
            return;
        long[] A = new long[n];
        for(int i = 0;i < n;i++) {
            A[i] = in.nextLong();
        }
        test.printResult(A);
    }
}