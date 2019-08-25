package 真题;
/*思路：用一个数组把可填入方格中的数装起来，在装入之前做排除相等和相邻的检测。
 排除相等可以用一个循环遍历已装入数组的元素，对于相邻的检测可以结合图形位置和数组检测数组中的数
 * */
public class 方格填数 {
	
	 static int m = 0;

	    static boolean judge(int x, int y)
	    {
	        if (x  == y - 1 || x == y + 1) return true;
	        return false;//判断并返回 
	    }

	    static void find(int num[], int n)
	    {
	        int i, j, flag;
	        if (n >= 10)
	            m++;

	        for (i = 0; i <= 9; i++)//对每个数字进行判断 
	        {
	            //先排除相等的情况 
	            flag = 0;
	            for (j = 0; j < n; j++)
	            {
	                if (num[j] == i)
	                {
	                    flag = 1;
	                    break;
	                }
	            }
	            if (1 == flag) continue;
	            //再排除相邻的情况
	            switch (n)
	            {
	                case 0:
	                    break;
	                case 1:
	                    if (judge(num[0],i)) flag = 1;
	                    break;
	                case 2:             
	                    if (judge(num[1],i)) flag = 1;
	                    break;
	                case 3:
	                    if (judge(num[0],i)) flag = 1;
	                    break;
	                case 4:
	                    if (judge(num[0], i) || judge(num[1],i)|| judge(num[3],i)) flag = 1;
	                    break;
	                case 5:
	                    if (judge(num[0], i) || judge(num[1],i) || judge(num[2],i)|| judge(num[4],i)) flag = 1;
	                    break;
	                case 6:
	                    if (judge(num[1], i) || judge(num[2], i)|| judge(num[5], i)) flag = 1;
	                    break;
	                case 7:
	                    if (judge(num[3], i) || judge(num[4], i)) flag = 1;
	                    break;          
	                case 8:
	                    if (judge(num[3], i) || judge(num[4], i) || judge(num[5], i)|| judge(num[7], i)) flag = 1;
	                    break;
	                case 9:
	                    if (judge(num[4], i) || judge(num[5], i) || judge(num[6], i)|| judge(num[8], i)) flag = 1;
	                    break;
	            }
	            if (flag == 1) continue; 
	            num[n] = i;
	            find(num, n + 1);
	        }
	    }

	    public static void main(String[] args) {
	        int num[] = new int[10];
	        find(num, 0);   
	        System.out.println(m);

	    }

	
	
	
	/*static int count = 0;  

    static void swap(char array[], int a, int b) {    
        char temp = array[a];    
        array[a] = array[b];    
        array[b] = temp;    
    }    

    static boolean check(char [] str) {    
        if(check2(str[0], str[1]) && check2(str[0], str[3]) && check2(str[0], str[4]) && check2(str[0], str[5])     
                 && check2(str[1], str[2]) && check2(str[1], str[4]) && check2(str[1], str[5]) && check2(str[1], str[6])    
                 && check2(str[2], str[5]) && check2(str[2], str[6])    
                 && check2(str[3], str[4]) && check2(str[3], str[7]) && check2(str[3], str[8])    
                 && check2(str[4], str[5]) && check2(str[4], str[7]) && check2(str[4], str[8]) && check2(str[4], str[9])    
                 && check2(str[5], str[6]) && check2(str[5], str[8]) && check2(str[5], str[9])    
                 && check2(str[6], str[9]) && check2(str[7], str[8]) && check2(str[8], str[9]))    
            return true;    
        return false;    
    }  

    static boolean check2(char c, char d) {    
        // TODO Auto-generated method stub    
        if(c == (d+1) || c == (d-1))    
            return false;    
        return true;    
    }  

    static void permutation(char[] str, int a, int length){    
        if(a == length){    
            if(check(str)){    
                count++;    
                System.out.println(String.valueOf(str));    
            }    
        }else{    
            for(int i = a; i <= length; ++i){    
                swap(str, i, a);    
                permutation(str, a + 1, length);  
                swap(str, i, a);    
            }    
        }    
    }  

    public static void main(String[] args) {    
        char[] str = "0123456789".toCharArray();    
        permutation(str, 0, 9);    
        System.out.println(count);    
    }    */
}
/*
方格填数
如下的10个格子
   +--+--+--+
   |  |  |  |
+--+--+--+--+
|  |  |  |  |
+--+--+--+--+
|  |  |  |
+--+--+--+

填入0~9的数字。要求：连续的两个数字不能相邻。
（左右、上下、对角都算相邻）

一共有多少种可能的填数方案？

请填写表示方案数目的整数。
注意：你提交的应该是一个整数，不要填写任何多余的内容或说明性文字。*/