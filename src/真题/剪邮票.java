package ����;

import java.util.HashSet;  
/*˼·���ȱ������п��ܵ������Ȼ�����ж��Ƿ���ͬ�л���ͬ����������Ҫ��*/
public class ����Ʊ{  
    public static int count = 0;    
    public static int [] a = new int[5];    
    public static HashSet<String> hashset = new HashSet<String>();  
//HashSet���������ʱ���������ͬ��������ô��������ӽ�ȥ���᷵��false
    private static boolean check() {    
        boolean flag[] = new boolean[5];    
        dfs(flag,0);    
        return flag[0]&&flag[1]&&flag[2]&&flag[3]&&flag[4];    
    }    

    private static void dfs(boolean[] flag,int n) {    
        flag[n] = true;    
        for(int i = 0; i < 5; i++){    
            //��һ��һҪ��ͬһ�С����ļ���Ҫ��ͬһ��    
        	 //�ܿ��Ѵ����+++++++��֤��ͬһ��+++++++++++++++��������+++++++++++��������+++++++++
            if(!flag[i] && (a[i]/4 == a[n]/4) && (a[i] == a[n] - 1 || a[i] == a[n] + 1)){ //��֤��ͬһ��   
                dfs(flag,i);    
            }//�ܿ��Ѵ����+++++++��֤��ͬһ��+++++++++++++++��������+++++++++++��������+++++++++
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
����Ʊ
�硾ͼ1.jpg��, ��12������һ���12��Ф����Ʊ��
������Ҫ���м���5������Ҫ����������ŵġ�
����������һ���ǲ���������
���磬��ͼ2.jpg������ͼ3.jpg���У��ۺ�ɫ��ʾ���־��Ǻϸ�ļ�ȡ��

������㣬һ���ж����ֲ�ͬ�ļ�ȡ������

����д��ʾ������Ŀ��������
ע�⣺���ύ��Ӧ����һ����������Ҫ��д�κζ�������ݻ�˵�������֡�
*/