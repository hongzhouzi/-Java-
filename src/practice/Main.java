package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in) ;
        int L = 0;
        String S = "" ;
        if(scanner.hasNext()){  //输入数字l与字符串s
            L = scanner.nextInt() ;
            S = scanner.next() ;
        }
        Map<String,Integer> map = new HashMap<String,Integer>() ;   //使用map中key保存字符串 value保存字符串出现的次数
        int maxValue = 0 ;  //保存字符串的出现次数的最大值
        String maxStr = "" ;    //保存出现次数最多的字符串
        for(int i = 0 ; i < S.length() - L + 1 ; i ++){
            for(int j = i + L ; j < S.length() ; j ++){
                String str = S.substring(i,j) ; //枚举截取长度大于等于l的字符串
                if(map.containsKey(str)){   //若该字符串之前出现过则map(key,value)中value值+1
                    int value = map.get(str) ;	//get该键来获取该键对应的值
                    value ++ ;
                    if(value > maxValue){
                        maxValue = value ;
                        maxStr = str ;
                    }
                    else if(value == maxValue){    //若该字符串出现的次数与当前出现次数最多的字符串相等，则比较两个字符串的长度，取字符串长的
                        if(maxStr.length() < str.length()){
                            maxStr = str ;
                        }
                    }
                    map.put(str, value) ;	//给map赋值
                }
                else{  //若该字符串之前并未出现过则添加，并初始化value值为0
                    map.put(str, 0) ;   
                }
            }
        }
        System.out.println(maxStr); //输出出现次数最多的字符串
    }

}

/*import java.util.Scanner;
public class Main {
	static int L;
	static String s;
	static String[] arr=new String[100];	//记录取出来的相同字符串
	static int[] num=new int[100];	//记录数据
	static String[] NUM=new String[100];	//记录取出来的相同字符串
	static void f(int n){
		int[] a=new int[100];	//记录相同字符串的数量
		for(int i=0;i<s.length()-n;i++){
			arr[i]=s.substring(i, n+i);
			for(int j=0;j<i;j++){
				if(a[i]==a[j])
					a[i]++;
			}
		}
		int max=0;
		for(int i=0;i<s.length();i++){
			if(a[i]>max)
				max=i;
		}
		num[n-L]=max;
		NUM[n-L]= s.substring(max,max+n);
	}
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		L=in.nextInt();
		s=in.next();
		for(int i=L;i<s.length();i++){
			f(i);
		}
		int Max=0;
		for(int i=0;i<s.length();i++){
			if(num[i]>Max)
				Max=i;
		}
		System.out.println(NUM[Max]);
	}
}*/
