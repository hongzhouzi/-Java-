package 真题;

/*public class 凑算式 {
	public static void main(String[] args) {
		boolean mark[]=new boolean[10];
		int count=0;
		int a[]=new int[10];
		for(a[1]=1;a[1]<10;a[1]++){
			for(a[2]=1;a[2]<10;a[2]++){
				for(a[3]=1;a[3]<10;a[3]++){
					for(a[4]=1;a[4]<10;a[4]++){
						for(a[5]=1;a[5]<10;a[5]++){
							for(a[6]=1;a[6]<10;a[6]++){
								for(a[7]=1;a[7]<10;a[7]++){
									for(a[8]=1;a[8]<10;a[8]++){
										for(a[9]=1;a[9]<10;a[9]++){
											for(a[0]=1;a[0]<10;a[0]++){		//初始化为false
												mark[a[0]]=false;
											}
											for(int i=1;i<10;i++){
												mark[a[i]]=true;
											}
											int i;
											for( i=1;i<10;i++){
												if(mark[i]==false)
													break;
											}
											if(i==10){
//											注意要把分数形式相加的也考虑到，这儿可以转化成double类型来计算
//												if(a[2]%a[3]==0&&(a[4]*100+a[5]*10+a[6])%(a[7]*100+a[8]*10+a[9])==0){
//													if(a[1]+a[2]/a[3]+(a[4]*100+a[5]*10+a[6])/(a[7]*100+a[8]*10+a[9])==10){
//														System.out.println(a[1]+"+"+a[2]+"/"+a[3]+"+"+(a[4]*100+a[5]*10+a[6])/(a[7]*100+a[8]*10+a[9])+"=10");
//														count++;
//													}
//												}
												
											double num = a[1] + a[2]*1.0/a[3] + (100*a[4]+10*a[5]+a[6])*1.0/(100*a[7]+10*a[8]+a[9])-10;
											if(num==0){
												count++;
											}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(count);
		
		
		
		
		
		/*
//		 实现 元素都不相同的全排列 简单的方法可以用暴力破解的方法 只要把循环中有重复数字的结果剔除就可以，用continue的方式效率会高很多
		          int a, b, c, d, e, f, g, h, i, s=0;
		          for(a=1;a<10;a++){
		          for(b=1;b<10;b++){
		          if(b==a) continue;
		          for(c=1;c<10;c++){
		          if(c==a||c==b) continue;
		         for(d=1;d<10;d++){
		         if(d==a||d==b||d==c) continue;
		         for(e=1;e<10;e++) {
		         if(e==a||e==b||e==c||e==d) continue;
		         for(f=1;f<10;f++){
		         if(f==a||f==b||f==c||f==d||f==e) continue;
		         for(g=1;g<10;g++){
		         if(g==a||g==b||g==c||g==d||g==e||g==f) continue;
		         for(h=1;h<10;h++){
		         if(h==a||h==b||h==c||h==d||h==e||h==f||h==g) continue;
		         for(i=1;i<10;i++){
		             if(i==a||i==b||i==c||i==d||i==e||i==f||i==g||i==h) continue;
		             //其中要注意的是，两个整数相除得到的还是整数，所以要把其中一个整数先乘以 1.0 转化成浮点数 （建议乘在分子上，因为计算顺序不容易出错）
		             double num = a + b*1.0/c + (100*d+10*e+f)*1.0/(100*g+10*h+i)-10;
		             if(num==0) {
		                 s++; 
		                 //下面会显示结果项 
		                 System.out.println("     "+b+"      "+d+""+e+""+f+"");
		                 System.out.println(""+a+" + --- + ------- = 10");
		                 System.out.println("     "+c+"      "+g+""+h+""+i+"");
		                 System.out.println(a+"   "+b*1.0/c+"     "+(100*d+10*e+f)*1.0/(100*g+10*h+i));
		                 System.out.println();
		                 System.out.println();
		             }
		         }
		         }
		         }
		         }
		         }
		         }
		         }
		         }
		         }
		         System.out.println(s);
		
		
	}
}*/

public class 凑算式{  
    static int count = 0;  

    static void swap(char array[], int a, int b) {    
        char temp = array[a];    
        array[a] = array[b];    
        array[b] = temp;    
    }  

    static boolean check(char[] str){  
        double[] num = new double[10];  
        for(int i = 0; i < 9; ++i)  
            num[i] = str[i]-'0';  
        if(num[0]+num[1]*1.0/num[2]+(num[3]*100+num[4]*10+num[5])*1.0/(num[6]*100+num[7]*10+num[8]) == 10)  
            return true;  
        return false;  
    }  

    static void permutation(char[] str, int a, int length){    
        if(a == length){  
            if(check(str)){  
                ++count;  
                System.out.println(String.valueOf(str));    
            }    
        }else{    
            for(int i = a; i <= length; ++i){    
                swap(str, i, a);    
                permutation(str, a + 1, length);  
                swap(str, i, a);    
            }    
        }    
    }  

    public static void main(String[] args) {    
        char[] str = "123456789".toCharArray();    
        permutation(str, 0, 8);    
        System.out.println(count);    
    }  
}  





/* 
     B      DEF
A + --- + ------- = 10
     C      GHI
这个算式中A~I代表1~9的数字，不同的字母代表不同的数字。

比如：
6+8/3+952/714 就是一种解法，
5+3/1+972/486 是另一种解法。

这个算式一共有多少种解法？

注意：你提交应该是个整数，不要填写任何多余的内容或说明性文字。
*/