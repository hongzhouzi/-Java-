package 听课练习;

import java.math.BigDecimal;
import java.math.MathContext;
public class 递归求最大公约数 {
	
	
	public static int f(int a,int b){
		if(a<0) return -a;	//若有负数那就取它的相反数
		if(b<0) return -b;
		if(b==0) return a;	//除尽时
		
		/*辗转相除法
		 * 
		 * */
		return f(b,a%b);
	}
	
	public static void main(String[] args) {
		System.out.println(f(-1,2));
		
		double a=1.0/0;		//无穷大大的数
		double b=0.0/0.0;	//NaN Not a Number
		//穷大的数与无穷大的数之间做运算得到的是NaN
		
		//任意精度小数，MathContext(10)中的数值是精确的位数
		BigDecimal c=BigDecimal.valueOf(1).divide(BigDecimal.valueOf(6),new MathContext(10));
		System.out.println(c);
	}
}
