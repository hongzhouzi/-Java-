package review;

import java.util.Scanner;

public class �ݹ��ж���ͬ�ַ��� {
	static boolean isEqual(String s1,String s2){
		if(s1.length()!=s2.length()) return false;	//���Ȳ����
		//ע�����Ҫ�ȼ���ַ����ĳ��ȣ���Ȼ���ַ���Ϊ�մ�ʱ���������ĸ�ͻᱨ��
		if (s1.length()==0) return true;				//���������֮��û�з���false����ͬ����true
		if(s1.charAt(0)!=s2.charAt(0)) return false;	//����ĸ�����
		return isEqual(s1.substring(1),s2.substring(1));	//���������濴
		 
	}
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String s1=in.next();
		String s2=in.next();
		System.out.println(isEqual(s1,s2));
	}
}
