package 真题;

import java.util.HashSet;  
/*思路：先遍历所有可能的情况，然后在判断是否在同行或者同列满足那种要求*/
public class 剪邮票{  
    public static int count = 0;    
    public static int [] a = new int[5];    
    public static HashSet<String> hashset = new HashSet<String>();  
//HashSet中添加数据时，如果有相同的数据那么将不会添加进去，会返回false
    private static boolean check() {    
        boolean flag[] = new boolean[5];    
        dfs(flag,0);    
        return flag[0]&&flag[1]&&flag[2]&&flag[3]&&flag[4];    
    }    

    private static void dfs(boolean[] flag,int n) {    
        flag[n] = true;    
        for(int i = 0; i < 5; i++){    
            //加一减一要在同一行、加四减四要在同一列    
        	 //避开已存入的+++++++保证在同一行+++++++++++++++向左相邻+++++++++++向右相邻+++++++++
            if(!flag[i] && (a[i]/4 == a[n]/4) && (a[i] == a[n] - 1 || a[i] == a[n] + 1)){ //保证在同一行   
                dfs(flag,i);    
            }//避开已存入的+++++++保证在同一列+++++++++++++++向上相邻+++++++++++向下相邻+++++++++
            if(!flag[i] && (a[i]%4 == a[n]%4) && (a[i] == a[n] - 4 || a[i] == a[n] + 4)){ 
                dfs(flag,i); 
            }    
        }       
    }  

    public static void main(String[] args){    
        for(a[0] = 0; a[0] < 12; ++a[0]){  
            for(a[1] = a[0]+1; a[1] < 12; ++a[1]){  
                for(a[2] = a[1]+1; a[2] < 12; ++a[2]){    
                    for(a[3] = a[2]+1; a[3] < 12; ++a[3]){    
                        for(a[4] = a[3]+1; a[4] < 12; ++a[4]){    
                            if(check()){    
                                hashset.add(""+a[0]+a[1]+a[2]+a[3]+a[4]);    
                            }  
                        }  
                    }  
                }  
            }  
        }  
        System.out.println(hashset.size());    
    }  
} 
/*
剪邮票
如【图1.jpg】, 有12张连在一起的12生肖的邮票。
现在你要从中剪下5张来，要求必须是连着的。
（仅仅连接一个角不算相连）
比如，【图2.jpg】，【图3.jpg】中，粉红色所示部分就是合格的剪取。

请你计算，一共有多少种不同的剪取方法。

请填写表示方案数目的整数。
注意：你提交的应该是一个整数，不要填写任何多余的内容或说明性文字。
*/