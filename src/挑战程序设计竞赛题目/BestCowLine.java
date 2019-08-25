package 挑战程序设计竞赛题目;

import java.util.Scanner;

public class BestCowLine {
	public static void main(String[] args) {
		Scanner inScanner=new Scanner(System.in);
		int n=inScanner.nextInt();
		String s=inScanner.next();
		String T="";
		int l=0,r=n-1;
		//贪心算法，每次取当前最优解
		while(l<=r){	//等号需要取到
			boolean left=false;
			for(int i=0;l+i<=r/2;i++){	//这儿等号许取到
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
