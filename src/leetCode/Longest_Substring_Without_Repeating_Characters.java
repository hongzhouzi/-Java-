package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Longest_Substring_Without_Repeating_Characters {
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring2("abcabccc"));
	}
	
	//������
	static public int lengthOfLongestSubstring_baoli(String s) {
        int max=0,n=s.length();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=n;j++){
                if(judge(s,i,j))
                    max=Math.max(max,j-i);      //��Ҫȡ�����Ǹ�
            }
        }
        return max;
    }
	
	static boolean judge(String s,int start,int end){
        Set<Character> ch=new HashSet<Character>();
        for(int i=start;i<end;i++){     
            if(ch.contains(s.charAt(i)))    //ch.contains(s.charAt(i))ע��д��
               return false;
            ch.add(s.charAt(i));            //��⵱ǰ֮����Ҫ�ѵ�ǰ���뼯����
        }
        return true;
    }
	
	
	
	//��������
	 static public int lengthOfLongestSubstring1(String s) {
	        int i=0,j=0,max=0,n=s.length();
	        Set<Character> set=new HashSet<Character>();
	        while(i < n && j < n){
	            if(!set.contains(s.charAt(j))){
	                set.add(s.charAt(j++));		//���󻬶����ڣ�������߽��
	                max=Math.max(max,j-i);
	            }else{
	                set.remove(s.charAt(i++));	//���ظ��򻬶��ұ߽�Ĵ���
	            }
	        }
	        return max;
	  }
	 
	 //�Ż���������
	 static int lengthOfLongestSubstring2(String s){
		 Map<Character, Integer> map=new HashMap<Character, Integer>();
		 int len=s.length(),max=0;
		 for(int i=0,j=0;j<len;j++){
			 if(map.containsKey(s.charAt(j))){//ͨ���ƶ�j��̽���������ͬ���ͷ�����ͬԪ�ص��±꣬�Ǹ��±�Ϊi
				 i=Math.max(i, map.get(s.charAt(j)));
			 }
			 max=Math.max(max,j-i+1);
			 map.put(s.charAt(j), j+1);
		 }
		 return max;
	 }
}