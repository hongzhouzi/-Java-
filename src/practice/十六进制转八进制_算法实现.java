package practice;
import java.util.Scanner;
public class 十六进制转八进制_算法实现 {
	
	    public static void main(String[] args)  
	    {  
	             Scanner sc=new Scanner(System.in);  
	             int n=sc.nextInt();  
	             String[] st=new String[n];  
	             for(int i=0;i<n;i++)  
	             {  
	             st[i] =sc.next();  
	             }  
	             sc.close();  
	             for(int i=0;i<n;i++)  
	             {  
	                       String str1=ttos(st[i]);  
	                  
	                 int len_str1=str1.length();  
	                 if(len_str1%3==1)str1="00"+str1;   
	                 else if(len_str1%3==2)str1="0"+str1;  
	                 ttoe(str1);  
	                 System.out.println();  
	             }  
	              
	              
	    }  
	     
	         public static String ttos(String  str)  
	    {  
	             int len_str=str.length();  
	             StringBuilder str2=new StringBuilder();  
	             for(int i=0;i<len_str;++i)   
	    {   
	             switch(str.charAt(i))   
	             {   
	             case '0':str2.append("0000");break;   
	             case '1':str2.append("0001");break;   
	             case '2':str2.append("0010");break;   
	             case '3':str2.append("0011");break;   
	             case '4':str2.append("0100");break;   
	             case '5':str2.append("0101");break;   
	             case '6':str2.append("0110");break;   
	             case '7':str2.append("0111");break;   
	             case '8':str2.append("1000");break;   
	             case '9':str2.append("1001");break;   
	             case 'A':str2.append("1010");break;   
	             case 'B':str2.append("1011");break;   
	             case 'C':str2.append("1100");break;   
	             case 'D':str2.append("1101");break;   
	             case 'E':str2.append("1110");break;   
	             case 'F':str2.append("1111");break;   
	             default:break;   
	             }   
	    } return str2.toString();  
	    }  
	  public static void ttoe(String str2)  
	  {  
	           int len=str2.length();  
	           int a;  
	           a=(str2.charAt(0)-'0')*4+(str2.charAt(1)-'0')*2+(str2.charAt(2)-'0');  
	           if(a!=0)System.out.print(a);  
	           for(int i=3;i<=len-2;i+=3)   
	           {   
	           a=(str2.charAt(i)-'0')*4+(str2.charAt(i+1)-'0')*2+(str2.charAt(i+2)-'0');   
	           System.out.print(a);  
	           }   
	              
	            
	  }  
	

}
