package ��ս������ƾ�����Ŀ;

import java.util.Scanner;

public class BestCowLine {
	public static void main(String[] args) {
		Scanner inScanner=new Scanner(System.in);
		int n=inScanner.nextInt();
		String s=inScanner.next();
		String T="";
		int l=0,r=n-1;
		//̰���㷨��ÿ��ȡ��ǰ���Ž�
		while(l<=r){	//�Ⱥ���Ҫȡ��
			boolean left=false;
			for(int i=0;l+i<=r/2;i++){	//����Ⱥ���ȡ��
				if(s.charAt(l+i)<s.charAt(r-i)){
					left=true;
					break;
				}else if(s.charAt(l+i)>s.charAt(r-i)){
					left=false;
					break;
				}
			}
			if(left){
				T+=s.charAt(l++);
			}else{
				T+=s.charAt(r--);
			}
		}
		
		System.out.println(T);
	}
	
}
