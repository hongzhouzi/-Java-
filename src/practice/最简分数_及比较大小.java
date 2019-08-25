package practice;

import java.util.Scanner;

public class 最简分数_及比较大小 {
	static int gcd(int a,int b){
		if(b==0) return a;
		return gcd(b,a%b);
	}
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int a=in.nextInt();
		int b=in.nextInt();
		int c=in.nextInt();
		int d=in.nextInt();
		String x="",y="";
		if(gcd(a,b)!=1){	//a b有最大公约数
			if(a*b>0)
				x=a+"/"+b;
			else if(a*b<0)
				x=-a+"/"+b;
		}
		else{
			a=a/gcd(a,b);
			b=b/gcd(a,b);
			if(a*b>0)
				x=a+"/"+b;
			else if(a*b<0)
				x=-a+"/"+b;
		}
		if(gcd(c,d)!=1){	//c d有最大公约数
			if(c*d>0)
				y=c+"/"+d;
			else if(c*d<0)
				y=-c+"/"+d;
		}
		else{
			c=c/gcd(c,d);
			d=d/gcd(c,d);
			if(c*d>0)
				y=c+"/"+d;
			else if(c*d<0)
				y=-c+"/"+d;
		}
		System.out.println("zrf is:"+x+"; ssh is:"+y);
		if(x==y){
			System.out.println("(zrf==ssh) is:1; (zrf<ssh) is:0");
			return;
		}
		else{
			System.out.print("(zrf==ssh) is:0; ");
			if(( (a*d-b*c) / (b*d) )>0)
				System.out.println("(zrf==ssh) is:1;");
			else if(( (a*d-b*c) / (b*d) )<0)
				System.out.println("(zrf==ssh) is:0;");
			else
				System.out.println("(zrf==ssh) is:1;");
		}
	}
}
