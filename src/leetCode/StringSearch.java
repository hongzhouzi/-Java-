package leetCode;

public class StringSearch {
	public static void main(String[] args) {
		String search="z";
		String buf="whz";
//		System.out.println(search(search, buf));
		System.out.println(search_KMP(search, buf));
	}
	
	/*KMP�㷨�Ĺؼ�������ƥ��ʧ�ܺ����Ϣ����������ģʽ����������ƥ������Դﵽ����ƥ���Ŀ�ġ�
	����ʵ�־���ʵ��һ��next()�������������������ģʽ���ľֲ�ƥ����Ϣ��*/
	   /** 
	 * param search ���ҵ��ַ��� 
	 * param buf �����ҵ��ַ��� 
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
	              
	            n = next[n];//�����ƥ�䣬�Ӳ�����Сǰ׺��Χ����ƥ��  
	        }  
	    }  
	}  
	
	
	
	
	/*Sunday�㷨��Daniel M.Sunday��1990��������ַ���ģʽƥ�䡣
	�����˼���ǣ���ƥ������У�ģʽ�����ֲ�ƥ��ʱ���㷨�����������ܶ���ַ��Խ�����һ����ƥ�䣬�Ӷ������ƥ��Ч�ʡ�*/
	 /** 
	 * param search ���ҵ��ַ��� 
	 * param buf �����ҵ��ַ��� 
	 */  
	public static int search(String search, String buf){  
	    int index = -1;  
	    int length = search.length();  
	    int begin = 0;  
	    _FOR:while((begin + length - 1) < buf.length()){//δ�����߽�һֱѭ��  
	        //����ƥ��  
	        for(int i = 0; i < length; i++){  
	            if(search.charAt(i) == buf.charAt(begin + i)){  
	                if(i == length - 1){  
	                    index = begin;  
	                    break _FOR;  
	                }  
	            } else {  
	                //δƥ�䣬λ�ƴ���  
	                int compare = begin + length + 1;  
	                if(compare < buf.length()){//δ�����߽�  
	                    if(!search.contains(String.valueOf(buf.charAt(compare)))){  
	                        //λ��ģʽ������+1  
	                        begin += length + 1;  
	                          
	                    } else {  
	                        //λ��ƥ���ַ���ģʽ��ĩβ�ľ���+1  
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
