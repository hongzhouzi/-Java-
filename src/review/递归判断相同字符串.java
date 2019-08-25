package review;

import java.util.Scanner;

public class 递归判断相同字符串 {
	static boolean isEqual(String s1,String s2){
		if(s1.length()!=s2.length()) return false;	//长度不相等
		//注意这儿要先检查字符串的长度，不然当字符串为空串时，检测首字母就会报错
		if (s1.length()==0) return true;				//挨个检测完之后，没有返回false则相同返回true
		if(s1.charAt(0)!=s2.charAt(0)) return false;	//首字母不相等
		return isEqual(s1.substring(1),s2.substring(1));	//依次往后面看
		 
	}
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String s1=in.next();
		String s2=in.next();
		System.out.println(isEqual(s1,s2));
	}
}
