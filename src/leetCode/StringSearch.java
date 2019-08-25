package leetCode;

public class StringSearch {
	public static void main(String[] args) {
		String search="z";
		String buf="whz";
//		System.out.println(search(search, buf));
		System.out.println(search_KMP(search, buf));
	}
	
	/*KMP算法的关键是利用匹配失败后的信息，尽量减少模式串与主串的匹配次数以达到快速匹配的目的。
	具体实现就是实现一个next()函数，函数本身包含了模式串的局部匹配信息。*/
	   /** 
	 * param search 查找的字符串 
	 * param buf 被查找的字符串 
	 */  
	public static int search_KMP(String search, String buf){  
	    int[] next = new int[search.length()];  
	    kmpNext(search, next);  
	    int i = 0;  
	    int j = 0;  
	    while(i < search.length() && j < buf.length()){  
	        if(i == -1 || search.charAt(i) == buf.charAt(j)){  
	            i++;  
	            j++;  
	        } else {  
	            i = next[i];  
	        }  
	    }  
	    if(i == search.length()){  
	        return j - i;  
	    } else {  
	        return -1;  
	    }  
	}  
	  
	private static void kmpNext(String buf, int next[]){  
	    int m = 0;  
	    int n = -1;  
	    next[0] = -1;  
	    while(m < buf.length() - 1){  
	          
	        if(n == -1 || buf.charAt(m) == buf.charAt(n)){  
	            m++;  
	            n++;  
	            next[m] = n;  
	              
	        } else {  
	              
	            n = next[n];//如果不匹配，从不断缩小前缀范围进行匹配  
	        }  
	    }  
	}  
	
	
	
	
	/*Sunday算法是Daniel M.Sunday于1990年提出的字符串模式匹配。
	其核心思想是：在匹配过程中，模式串发现不匹配时，算法能跳过尽可能多的字符以进行下一步的匹配，从而提高了匹配效率。*/
	 /** 
	 * param search 查找的字符串 
	 * param buf 被查找的字符串 
	 */  
	public static int search(String search, String buf){  
	    int index = -1;  
	    int length = search.length();  
	    int begin = 0;  
	    _FOR:while((begin + length - 1) < buf.length()){//未超出边界一直循环  
	        //逐字匹配  
	        for(int i = 0; i < length; i++){  
	            if(search.charAt(i) == buf.charAt(begin + i)){  
	                if(i == length - 1){  
	                    index = begin;  
	                    break _FOR;  
	                }  
	            } else {  
	                //未匹配，位移处理  
	                int compare = begin + length + 1;  
	                if(compare < buf.length()){//未超出边界  
	                    if(!search.contains(String.valueOf(buf.charAt(compare)))){  
	                        //位移模式串长度+1  
	                        begin += length + 1;  
	                          
	                    } else {  
	                        //位移匹配字符到模式串末尾的距离+1  
	                        begin += length - search.indexOf(buf.charAt(compare)) + 1;  
	                    }  
	                    break;  
	                }  
	                break _FOR;  
	            }  
	        }  
	    }  
	    return index;  
	}  
}
