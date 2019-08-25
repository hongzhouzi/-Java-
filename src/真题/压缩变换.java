package 真题;

import java.util.HashSet;  
import java.util.Scanner;  

public class 压缩变换{  
    static int cnt = -1;  
    static int[] a,b;  
    public static void main(String [] args){  
        Scanner sca = new Scanner(System.in);  
        while(sca.hasNext()){  
            int n = sca.nextInt();  
            a = new int[n+5];  
            b = new int[n+5];  
            for(int i = 0; i < n; ++i){  
                a[i] = sca.nextInt();  
                b[i] = a[i];  
            }  
            int cnt = -1;  
            for(int i = 0; i < n; ++i)  
                b[i] = solve(i);  
            for(int i = 0; i < n-1; ++i)  
                System.out.print(b[i]+" ");  
            System.out.println(b[n-1]);  
        }  
    }  
    static int solve(int n){  
        int tmp = a[n];  
        HashSet<Integer> hashset = new HashSet<Integer>();  
        for(int i = n-1; i >= 0; --i){  
            if(a[i] == tmp){  
                return hashset.size();  
            }  
            hashset.add(a[i]);  
        }  
        return cnt--;  
    }  
}  
/*小明最近在研究压缩算法。
        他知道，压缩的时候如果能够使得数值很小，就能通过熵编码得到较高的压缩比。
        然而，要使数值很小是一个挑战。
        最近，小明需要压缩一些正整数的序列，这些序列的特点是，后面出现的数字很大可能是刚出现过不久的数字。对于这种特殊的序列，小明准备对序列做一个变换来减小数字的值。
        变换的过程如下：
        从左到右枚举序列，每枚举到一个数字，如果这个数字没有出现过，刚将数字变换成它的相反数，如果数字出现过，则看它在原序列中最后的一次出现后面（且在当前数前面）出现了几种数字，用这个种类数替换原来的数字。
        比如，序列(a1, a2, a3, a4, a5)=(1, 2, 2, 1, 2)在变换过程为：
        a1: 1未出现过，所以a1变为-1；
        a2: 2未出现过，所以a2变为-2；
        a3: 2出现过，最后一次为原序列的a2，在a2后、a3前有0种数字，所以a3变为0；
        a4: 1出现过，最后一次为原序列的a1，在a1后、a4前有1种数字，所以a4变为1；
        a5: 2出现过，最后一次为原序列的a3，在a3后、a5前有1种数字，所以a5变为1。
        现在，给出原序列，请问，按这种变换规则变换后的序列是什么。

        输入格式：
        输入第一行包含一个整数n，表示序列的长度。
        第二行包含n个正整数，表示输入序列。

        输出格式：
        输出一行，包含n个数，表示变换后的序列。

        例如，输入：
        5
        1 2 2 1 2

        程序应该输出：
        -1 -2 0 1 1

        再例如，输入：
        12
        1 1 2 3 2 3 1 2 2 2 3 1

        程序应该输出：
        -1 0 -2 -3 1 1 2 2 0 0 2 2

        数据规模与约定
        对于30%的数据，n<=1000；
        对于50%的数据，n<=30000；
        对于100%的数据，1 <=n<=100000，1<=ai<=10^9*/