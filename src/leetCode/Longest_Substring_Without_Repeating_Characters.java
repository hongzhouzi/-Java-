package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Longest_Substring_Without_Repeating_Characters {
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring2("abcabccc"));
	}
	
	//暴力法
	static public int lengthOfLongestSubstring_baoli(String s) {
        int max=0,n=s.length();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=n;j++){
                if(judge(s,i,j))
                    max=Math.max(max,j-i);      //需要取最大的那个
            }
        }
        return max;
    }
	
	static boolean judge(String s,int start,int end){
        Set<Character> ch=new HashSet<Character>();
        for(int i=start;i<end;i++){     
            if(ch.contains(s.charAt(i)))    //ch.contains(s.charAt(i))注意写法
               return false;
            ch.add(s.charAt(i));            //检测当前之后还需要把当前加入集合中
        }
        return true;
    }
	
	
	
	//滑动窗口
	 static public int lengthOfLongestSubstring1(String s) {
	        int i=0,j=0,max=0,n=s.length();
	        Set<Character> set=new HashSet<Character>();
	        while(i < n && j < n){
	            if(!set.contains(s.charAt(j))){
	                set.add(s.charAt(j++));		//向左滑动窗口，滑动左边界的
	                max=Math.max(max,j-i);
	            }else{
	                set.remove(s.charAt(i++));	//有重复则滑动右边界的窗口
	            }
	        }
	        return max;
	  }
	 
	 //优化滑动窗口
	 static int lengthOfLongestSubstring2(String s){
		 Map<Character, Integer> map=new HashMap<Character, Integer>();
		 int len=s.length(),max=0;
		 for(int i=0,j=0;j<len;j++){
			 if(map.containsKey(s.charAt(j))){//通过移动j试探，如果有相同，就返回相同元素的下标，记该下标为i
				 i=Math.max(i, map.get(s.charAt(j)));
			 }
			 max=Math.max(max,j-i+1);
			 map.put(s.charAt(j), j+1);
		 }
		 return max;
	 }
}