package ������ϰ;

import java.util.Scanner;

public class �ݹ��ж���ͬ�ַ��� {
	
	public static boolean isEqual(String s1,String s2) {
		if(s1.length()!=s2.length()) return false;		//�ַ������Ȳ����ʱ
		//ע�����Ҫ�ȼ���ַ����ĳ��ȣ���Ȼ���ַ���Ϊ�մ�ʱ���������ĸ�ͻᱨ��
		if(s1.length()==0) return true;					//�ݹ���ڣ��ַ���ȫ���ַ����������ͬʱ�󷵻�true
		if(s1.charAt(0)!=s2.charAt(0)) return false;	//�ַ�����һ���ַ������ʱ
		return isEqual(s1.substring(1),s2.substring(1));//�ݹ���̣������һ���ַ�
	}
	
	
	public static void main(String[] args) {
		String s1,s2;
		Scanner in =new Scanner(System.in);
		s1=in.next();
		s2=in.next();
		System.out.println(isEqual(s1,s2));;
	}
}
