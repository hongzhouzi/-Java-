package 真题;

import java.util.Scanner;
/*在不知道分成那种比较合适时，就从大的开始二分法缩小，依次判断分成哪种是满足题目要求的，
 在检测时可以直接用宽和高除以需要检测的数据，再看是否满足那个大小*/
public class _8_分巧克力 {
	static int n;  
    static int k;  
    static int h[] = new int [100010];  
    static int w[] = new int [100010];    
    public static boolean solve(int n)    //二分法拆分过程，需要一个记录记录加上的结果，用来和开始输入的k比较
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
        high=10000;    //用二分法拆开看
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
/*儿童节那天有K位小朋友到小明家做客。小明拿出了珍藏的巧克力招待小朋友们。
    小明一共有N块巧克力，其中第i块是Hi x Wi的方格组成的长方形。

    为了公平起见，小明需要从这 N 块巧克力中切出K块巧克力分给小朋友们。切出的巧克力需要满足：

    1. 形状是正方形，边长是整数  
    2. 大小相同  

例如一块6x5的巧克力可以切出6块2x2的巧克力或者2块3x3的巧克力。

当然小朋友们都希望得到的巧克力尽可能大，你能帮小Hi计算出最大的边长是多少么？

输入
第一行包含两个整数N和K。(1 <= N, K <= 100000)  
以下N行每行包含两个整数Hi和Wi。(1 <= Hi, Wi <= 100000)
输入保证每位小朋友至少能获得一块1x1的巧克力。   

输出
输出切出的正方形巧克力最大可能的边长。

样例输入：
2 10  
6 5  
5 6  
样例输出：
2
*/