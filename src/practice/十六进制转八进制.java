package practice;

import java.util.Scanner;

public class 十六进制转八进制 {

	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		int num=in.nextInt();
		String [] arr=new String[10];
		for(int i=0;i<num;i++){
			arr[i]=in.next();	//输入字符串用next();
			if (arr[i].length() < 100000) {  
                arr[i] = Integer  
                        .toOctalString(Integer.valueOf(arr[i], 16));  
            }  
		}
		 for (int i = 0; i < num; i++) {  
             System.out.println(arr[i]);  
         }  
	}
}
