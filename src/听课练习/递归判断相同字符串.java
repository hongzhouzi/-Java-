package 听课练习;

import java.util.Scanner;

public class 递归判断相同字符串 {
	
	public static boolean isEqual(String s1,String s2) {
		if(s1.length()!=s2.length()) return false;		//字符串长度不相等时
		//注意这儿要先检查字符串的长度，不然当字符串为空串时，检测首字母就会报错
		if(s1.length()==0) return true;					//递归出口，字符串全部字符检测完且相同时后返回true
		if(s1.charAt(0)!=s2.charAt(0)) return false;	//字符串第一个字符不相等时
		return isEqual(s1.substring(1),s2.substring(1));//递归过程，检测下一个字符
	}
	
	
	public static void main(String[] args) {
		String s1,s2;
		Scanner in =new Scanner(System.in);
		s1=in.next();
		s2=in.next();
		System.out.println(isEqual(s1,s2));;
	}
}
